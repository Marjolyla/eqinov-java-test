package com.eqinov.recrutement.controller;

import com.eqinov.recrutement.data.DataPoint;
import com.eqinov.recrutement.data.Historique;
import com.eqinov.recrutement.data.Site;
import com.eqinov.recrutement.data.ValeurHistorique;
import com.eqinov.recrutement.repository.DataPointRepository;
import com.eqinov.recrutement.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controller permettant la récupération d'un historique
 */
@Controller
public class HistoriqueController {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private DataPointRepository dataPointRepository;

    /**
     * Récupère l'historique de consommation
     *
     * @return le fragment a retourné
     */
    @GetMapping("/historique")
    public String getHistorique(Model model) {
        Historique histo = upload();
        Optional<Site> site = siteRepository.findById(1l);
        if (site.isPresent() && histo != null //&& site.get().getName().equals(histo.getSite())
        ) {
            List<DataPoint> dataPoints = new ArrayList<>();
            for (ValeurHistorique value:histo.getValues()) {
                dataPoints.add(new DataPoint(site.get(),value.getDate(),value.getValue()));
            }
            model.addAttribute("resultatHisto","Historique récupéré avec succès");
            dataPointRepository.saveAll(dataPoints);
        } else {
            model.addAttribute("resultatHisto","Impossible de récupérer l'historique");
        }
        return "historique";
    }

    private Historique upload() {
        try{
        RestTemplate template = new RestTemplate();
        return template.getForObject("http://localhost:2345/api/conso", Historique.class);
        } catch (Exception e){
            return null;
        }
    }
}
