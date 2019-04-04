package com.practice.mastermind.core;

import com.practice.mastermind.core.Choix;
import com.practice.mastermind.core.Juge;
import com.practice.mastermind.core.Resultat;
import com.practice.mastermind.core.Couleurs;
import com.practice.mastermind.core.MasterMindException;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class JugeTest {

    private Juge juge = null;
    private Choix[] ordinateur = null;
    private Choix[] joueur = null;

    @Before
    public void beforeJugeTest() {
        juge = new Juge();
        ordinateur = new Choix[4];
        joueur = new Choix[4];
    }

    private Choix[] initChoixForSameResult() {
        Choix[] choixResult = new Choix[4];
        choixResult[0] = new Choix(Couleurs.Rouge.id(), Couleurs.Rouge.name(), 0);
        choixResult[1] = new Choix(Couleurs.Orange.id(), Couleurs.Orange.name(), 1);
        choixResult[2] = new Choix(Couleurs.Jaune.id(), Couleurs.Jaune.name(), 2);
        choixResult[3] = new Choix(Couleurs.Noir.id(), Couleurs.Noir.name(), 3);

        return choixResult;
    }

    @Test
    public void testGetChoix() {
        assertTrue(juge.getChoix().size() == 6);
    }

    @Test
    public void testEvaluer() throws MasterMindException {
        ordinateur = initChoixForSameResult();
        joueur = initChoixForSameResult();

        Resultat resultat = juge.evaluer(ordinateur, joueur);
        assertTrue(resultat.getJuste() == 4);
    }

    @Test
    public void testEvaluerJuste() throws MasterMindException {
        ordinateur = initChoixForSameResult();
        joueur = initChoixForSameResult();

        Resultat resultat = juge.evaluer(ordinateur, joueur);
        assertTrue(resultat.getJuste() == 4);
    }

    @Test
    public void testEvaluerPeuJuste() throws MasterMindException {
        ordinateur = initChoixForSameResult();

        joueur[0] = new Choix(Couleurs.Rouge.id(), Couleurs.Rouge.name(), 0);
        joueur[1] = new Choix(Couleurs.Orange.id(), Couleurs.Orange.name(), 1);
        joueur[2] = new Choix(Couleurs.Noir.id(), Couleurs.Noir.name(), 3);
        joueur[3] = new Choix(Couleurs.Noir.id(), Couleurs.Noir.name(), 4);

        Resultat resultat = juge.evaluer(ordinateur, joueur);
        assertTrue(resultat.getPeuJuste() == 1);
    }
}
