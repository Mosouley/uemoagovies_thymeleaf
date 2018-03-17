package com.moh.uemoagovies.helpers;

/**
 *
 * @author soul
 */
public enum BaseCalculs {
    REELREEL("Réel/Réel"),
    REEL360("Réel/360"),
    TRENTE360("30/360");

    private String baseCalcul;

    BaseCalculs(String baseCalcul) {
        this.baseCalcul = baseCalcul;
    }

    public String BaseCalculs() {
        return baseCalcul;
    }

    @Override
    public String toString() {
        return baseCalcul;
    }

}
