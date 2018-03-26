package com.wedoogift.test.mastermind.ui;

import javax.swing.DefaultComboBoxModel;

import com.wedoogift.test.mastermind.core.Choix;

public class ChoixComboBoxModel extends DefaultComboBoxModel<Choix> {
	
	private static final long serialVersionUID = 1L;

	public ChoixComboBoxModel(Choix[] choix) {
		super(choix);
	}
	
	@Override
	public Choix getSelectedItem() {
		Choix choix = (Choix)super.getSelectedItem();
		return choix;
	}
}
