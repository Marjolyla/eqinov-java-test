package com.eqinov.recrutement.data;

/**
 * Bean contenant une moyenne mensuelle
 */
public class MoyenneConsoMensuelle {
    private String mois;
    private Double moyenne;

    public MoyenneConsoMensuelle(String mois, Double moyenne) {
        this.mois = mois;
        this.moyenne = moyenne;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }
}
