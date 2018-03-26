package com.wedoogift.test.mastermind.core;

public class Resultat {
	private Choix[] choix = new Choix[Juge.NOMBRE_CHOIX];
	
	public Choix[] getChoix() {
		return choix;
	}

	public void setChoix(Choix[] choix) {
		this.choix = choix;
	}

	public String getChoixJoueur() {
		return new StringBuilder().append(choix[0].getId())
				.append(choix[1].getId())
				.append(choix[2].getId())
				.append(choix[3].getId())
				.toString();
	}
	
	private int juste;
	
	public int getJuste() {
		return juste;
	}

	public void setJuste(int juste) {
		this.juste = juste;
	}

	private int peuJuste;
	
	public int getPeuJuste() {
		return peuJuste;
	}

	public void setPeuJuste(int peuJuste) {
		this.peuJuste = peuJuste;
	}
	
	private String mise;

	public String getMise() {
		return mise;
	}

	public void setMise(String mise) {
		this.mise = mise;
	}
	
	public Resultat() {
		
	}
	
	@Override
	public String toString() {
		return getChoixJoueur() + " " + juste + " " + peuJuste;
	}
	
}
