package com.wedoogift.test.mastermind.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Classe qui implémente les règles du MasterMind
 * @author SOMBUGMA Emmanuel
 *
 */
public class Juge {
	
	// Nombre de tentatives effectuées
	public static int NOMBRE_TENTATIVE = 1;
	// Nombre de tentatives autorisées
	public static int TOTAL_TENTATIVE = 10;
	// Nombre maximum de choix à faire
	public static int NOMBRE_CHOIX = 4; 
	private Resultat resultat = new Resultat();
	
	private Choix[] ordinateur = new Choix[Juge.NOMBRE_CHOIX];
	private boolean victoire = false;
	
	// Liste des choix disponibles 
	private List<Choix> lesChoix = new ArrayList<Choix>(Arrays.asList(
			new Choix("R", "Rouge", 0),
			new Choix("J", "Jaune", 0),
			new Choix("B", "Bleu", 0),
			new Choix("O", "Orange", 0),
			new Choix("V", "Vert", 0),
			new Choix("N", "Noir", 0)
			));
	
	public Choix[] getOrdinateur() {
		return ordinateur;
	}
	
	public void setOrdinateur(Choix[] choixOrdinateur) {
		this.ordinateur = choixOrdinateur;
	}
	
	private Choix[] joueur = new Choix[NOMBRE_CHOIX];
	
	public Choix[] getJoueur() {
		return joueur;
	}
	
	public void setJoueur(Choix[] joueur) {
		this.joueur = joueur;
	}	
	
	public Juge() {
		
	}
	
	public List<Choix> getChoix() {
		return lesChoix;
	}
	
	/**
	 * Renvoi le choix effectué par l'odinateur
	 * @return
	 */
	public Choix[] getChoixOrdinateur() {		
		for(int i=0; i<NOMBRE_CHOIX; i++) {
			Choix choix = lesChoix.get(new Random().nextInt(6));
			choix.setPosition(i);
			ordinateur[i] = choix;
		}		
		return ordinateur;
	}	
	
	/**
	 * Fonction principale qui évalue les données de l'ordinateur et du joueur
	 * @param ordinateur Choix de l'ordinateur
	 * @param joueur Choix du joueur
	 * @return Résultat de l'évaluation
	 * @throws MasterMindException
	 */
	public Resultat evaluer(Choix[] ordinateur, Choix[] joueur) throws MasterMindException {	
		NOMBRE_TENTATIVE++;
		int couleurJuste = 0;
		resultat.setChoix(joueur);
		for(int i=0; i<ordinateur.length; i++) {			
			if((ordinateur[i].getId().equals(joueur[i].getId()))
					&& (ordinateur[i].getPosition() == joueur[i].getPosition())) {
				// Le choix du joueur match
				couleurJuste++;
				resultat.setJuste(couleurJuste);
			}
								
			for(int j=i; j<joueur.length; j++) {
				int couleurPeuJuste = 0;
				if((ordinateur[i].getId().equals(joueur[j].getId()))
						&& (ordinateur[i].getPosition() != joueur[j].getPosition())) {
					// Le choix du joueur match mais pas avec la position
					couleurPeuJuste++;
					resultat.setPeuJuste(couleurPeuJuste);
				}
			}			
		}			
		resultat.setMise(String.valueOf(NOMBRE_TENTATIVE) + "/" + String.valueOf(TOTAL_TENTATIVE));
		// Vérifie si le joueur a tout de même gagné
		if((getChoix(ordinateur)).equals(getChoix(joueur))) {
			victoire = true;
		}
		return resultat;
	}
	
	/**
	 * Fonction qui indique si le joueur a gagné ou pas
	 * @return un booléen indiquant si le joueur a gagné ou pas
	 * @throws MasterMindException
	 */
	public boolean victoire() throws MasterMindException {
		boolean v = false;
		if(NOMBRE_TENTATIVE == TOTAL_TENTATIVE) {
			throw new MasterMindException("Vous avez atteint le nombre total de mise (10) !");
		} else {
			if((NOMBRE_TENTATIVE < 10) && (victoire == true)) {
				v = true;
			}
		}		
		return v;
	}
	
	/**
	 * Renvoi la valeur sous forme de texte du choi effectué
	 * @param choix effectué
	 * @return une chaîne de caractère
	 */
	private String getChoix(Choix[] choix) {
		return new StringBuilder().append(choix[0].getId())
				.append(choix[1].getId())
				.append(choix[2].getId())
				.append(choix[3].getId())
				.toString();
	}
		
}
