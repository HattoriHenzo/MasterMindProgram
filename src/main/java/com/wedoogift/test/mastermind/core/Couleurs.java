package com.wedoogift.test.mastermind.core;

/**
 * Enumeration représentant les couleurs
 *
 * @author SOMBUGMA Emmanuel
 *
 */
public enum Couleurs {
    Rouge("R"),
    Jaune("J"),
    Bleu("B"),
    Orange("O"),
    Vert("V"),
    Noir("N");

    private String id;

    private Couleurs(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
