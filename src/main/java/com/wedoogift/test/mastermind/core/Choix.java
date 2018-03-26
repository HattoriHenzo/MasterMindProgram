package com.wedoogift.test.mastermind.core;

/**
 * Classe représentant un choix effectué par l'ordinateur ou le joueur
 * @author SOMBUGMA Emmanuel
 *
 */
public class Choix {
	private String id;
	
	public String getId() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}
	
	private String couleur;
	
	public String getCouleur() {
		return couleur;
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}	
	
	private int position;
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public Choix() {
		
	}	
	
	public Choix(String id, String couleur, int position) {
		this.id = id;
		this.couleur = couleur;
		this.position = position;
	}
	
	@Override
	public String toString() {
		return couleur + "(" + id + ")";
	}
}
