
package com.moh.uemoagovies.helpers;


public enum FrequenceCalcul {
    ANNUAL("Annuel"),
    SEMIANNUAL("Semestriel"),
    QUARTERLY("Trimestriel"),
    MONTHLY("Mensuel"),
    PRECOMPTE("PreCompte"),
    INFINE("In fine");
 
    private String frequence;

    FrequenceCalcul(String frequence) {
        this.frequence = frequence;
    }

    public String getFrequence() {
        return frequence;
    }

    @Override
    public String toString() {
        return frequence;
    }

}
