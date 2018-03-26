package com.wedoogift.test.mastermind.core;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestJuge {
	private Juge juge = null;
	private Choix[] ordinateur = null;
	private Choix[] joueur = null;
	
	@Before
	public void beforeJugeTest() {
		juge = new Juge();
		ordinateur = new Choix[4];
		joueur = new Choix[4];
	}
	
	@Test
	public void testGetChoix() {
		assertTrue(juge.getChoix().size() == 6);
	}	
	
	@Test
	public void testEvaluer() throws MasterMindException {
		ordinateur = juge.getChoixOrdinateur();
		
		joueur[0] = new Choix(Couleurs.Rouge.id(), Couleurs.Rouge.name(), 0);
		joueur[1] = new Choix(Couleurs.Orange.id(), Couleurs.Orange.name(), 1);
		joueur[2] = new Choix(Couleurs.Jaune.id(), Couleurs.Jaune.name(), 2);
		joueur[3] = new Choix(Couleurs.Noir.id(), Couleurs.Noir.name(), 3);
		
		Resultat resultat = juge.evaluer(ordinateur, joueur);
		assertTrue(resultat.getJuste() == 3);
	}

	
	@Test
	public void testEvaluerJuste() throws MasterMindException {
		ordinateur = juge.getChoixOrdinateur();
		
		joueur[0] = new Choix(Couleurs.Rouge.id(), Couleurs.Rouge.name(), 0);
		joueur[1] = new Choix(Couleurs.Orange.id(), Couleurs.Orange.name(), 1);
		joueur[2] = new Choix(Couleurs.Jaune.id(), Couleurs.Jaune.name(), 2);
		joueur[3] = new Choix(Couleurs.Noir.id(), Couleurs.Noir.name(), 3);
		
		Resultat resultat = juge.evaluer(ordinateur, joueur);
		assertTrue(resultat.getJuste() == 3);
	}
	
	@Test
	public void testEvaluerPeuJuste() throws MasterMindException {
		ordinateur = juge.getChoixOrdinateur();
		
		joueur[0] = new Choix(Couleurs.Rouge.id(), Couleurs.Rouge.name(), 0);
		joueur[1] = new Choix(Couleurs.Orange.id(), Couleurs.Orange.name(), 1);
		joueur[2] = new Choix(Couleurs.Noir.id(), Couleurs.Noir.name(), 3);
		joueur[3] = new Choix(Couleurs.Noir.id(), Couleurs.Noir.name(), 4);
		
		Resultat resultat = juge.evaluer(ordinateur, joueur);
		assertTrue(resultat.getPeuJuste() == 1);
	}
	
	@Test
	public void testEvaluerMise() throws MasterMindException {
		ordinateur[0] = new Choix(Couleurs.Rouge.id(), Couleurs.Rouge.name(), 0);
		ordinateur[1] = new Choix(Couleurs.Vert.id(), Couleurs.Vert.name(), 1);
		ordinateur[2] = new Choix(Couleurs.Bleu.id(), Couleurs.Bleu.name(), 2);
		ordinateur[3] = new Choix(Couleurs.Noir.id(), Couleurs.Noir.name(), 3);
		
		joueur[0] = new Choix(Couleurs.Rouge.id(), Couleurs.Rouge.name(), 0);
		joueur[1] = new Choix(Couleurs.Orange.id(), Couleurs.Orange.name(), 1);
		joueur[2] = new Choix(Couleurs.Jaune.id(), Couleurs.Jaune.name(), 2);
		joueur[3] = new Choix(Couleurs.Noir.id(), Couleurs.Noir.name(), 3);
		
		Resultat resultat = juge.evaluer(ordinateur, joueur);
		assertTrue(resultat.getMise().equals("1/10"));
	}	
	
	@Test
	public void testGetOrdinateurChoix() {
		Choix[] ordinateur = juge.getChoixOrdinateur();
		String message = "";
		for(Choix c : ordinateur) {
			message += c.toString() + "\n";
		}
		System.out.println(message);
	}
}
