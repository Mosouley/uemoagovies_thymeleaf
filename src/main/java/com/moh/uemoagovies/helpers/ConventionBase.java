package com.moh.uemoagovies.helpers;



public enum ConventionBase {

        REEL_30("30/365"),
        REEL_365("Réel/365"),
        TRENTE_REEL("30/Réel"),
        REEL_REEL("Réel/Réel"),
        REEL_364("Réel/364"),
        REEL_360("Réel/360");

    private String baseCalcul;

    ConventionBase(String baseCalcul) {
        this.baseCalcul = baseCalcul;
    }

    public String getBaseCalcul() {
        return baseCalcul;
    }


}

