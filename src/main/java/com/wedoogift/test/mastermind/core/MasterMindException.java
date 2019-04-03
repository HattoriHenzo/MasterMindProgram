package com.wedoogift.test.mastermind.core;

/**
 * Classe de gestion des exceptions du MasterMind
 *
 * @author SOMBUGMA Emmanuel
 *
 */
public class MasterMindException extends Exception {

    private static final long serialVersionUID = 1L;

    public MasterMindException() {
        super();
    }

    public MasterMindException(String message) {
        super(message);
    }

    public MasterMindException(String message, Exception exception) {
        super(message, exception);
    }
}
