package com.eqinov.recrutement.data;

import java.util.Collection;
import java.util.List;

/**
 * Bean contenant l'historique de consommation d'un site
 */
public class Historique {
    private String site;
    private String unit;
    private List<ValeurHistorique> values;

    public Historique() {
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Collection<ValeurHistorique> getValues() {
        return values;
    }

    public void setValues(List<ValeurHistorique> values) {
        this.values = values;
    }

    public void addValue(ValeurHistorique value){
        values.add(value);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


}
