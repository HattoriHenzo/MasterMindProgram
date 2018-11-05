package com.wedoogift.test.mastermind.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wedoogift.test.mastermind.core.Choix;
import com.wedoogift.test.mastermind.core.Juge;
import com.wedoogift.test.mastermind.core.MasterMindException;
import com.wedoogift.test.mastermind.core.Resultat;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JList;

public class MasterMindUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableChoixJoueur;
	
	private Juge juge = new Juge();
	private Choix[] choixOrdinateur = new Choix[Juge.NOMBRE_CHOIX];
	private List<Resultat> resultats = new ArrayList<Resultat>();
	private ResultatTableModel resultatTableModel = new ResultatTableModel(resultats);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterMindUI frame = new MasterMindUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MasterMindUI() {
        this.resultats = new ArrayList<Resultat>();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});
		setResizable(false);
		setTitle("Jeux de MasterMind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnChoixOrdinateur = new JButton("Commencer la partie...");
		final JButton btnChoixJoueur = new JButton("Valider");
		
		final JLabel lblChoixOrdinateur = new JLabel("");
		GridBagConstraints gbc_lblChoixOrdinateur = new GridBagConstraints();
		gbc_lblChoixOrdinateur.gridwidth = 5;
		gbc_lblChoixOrdinateur.insets = new Insets(0, 0, 5, 0);
		gbc_lblChoixOrdinateur.gridx = 2;
		gbc_lblChoixOrdinateur.gridy = 0;
		contentPane.add(lblChoixOrdinateur, gbc_lblChoixOrdinateur);
		
		btnChoixOrdinateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// On récupère le choix de l'ordinateur
				choixOrdinateur = juge.getChoixOrdinateur();
				Choix[] co = choixOrdinateur;
				String choixOrdinateur = co[0].getId() + co[1].getId() + co[2].getId() + co[3].getId();
				btnChoixJoueur.setEnabled(true);
				lblChoixOrdinateur.setText("");				
				resultatTableModel.supprimerTout();
				Juge.NOMBRE_TENTATIVE = 0;
				// XXXX peut être remplacé par la valeur choixOrdinateur
				JOptionPane.showMessageDialog(getParent(), "L'ordinateur a fait son choix (" + "XXXX" +  ") ! A votre tour de jouer (vous avez "+ Juge.TOTAL_TENTATIVE + " tentatives...)");							
			}
		});
		GridBagConstraints gbc_btnChoixOrdinateur = new GridBagConstraints();
		gbc_btnChoixOrdinateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChoixOrdinateur.gridwidth = 2;
		gbc_btnChoixOrdinateur.insets = new Insets(0, 0, 5, 5);
		gbc_btnChoixOrdinateur.gridx = 0;
		gbc_btnChoixOrdinateur.gridy = 0;
		contentPane.add(btnChoixOrdinateur, gbc_btnChoixOrdinateur);		
		
		JLabel lblVotreChoix = new JLabel("Votre choix");
		lblVotreChoix.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblVotreChoix = new GridBagConstraints();
		gbc_lblVotreChoix.insets = new Insets(0, 0, 5, 5);
		gbc_lblVotreChoix.anchor = GridBagConstraints.WEST;
		gbc_lblVotreChoix.gridx = 0;
		gbc_lblVotreChoix.gridy = 2;
		contentPane.add(lblVotreChoix, gbc_lblVotreChoix);
		
		Choix[] choix = new Choix[juge.getChoix().size()];
		choix = juge.getChoix().toArray(choix);
		ChoixComboBoxModel choix1ComboBoxModel = new ChoixComboBoxModel(choix);
		ChoixComboBoxModel choix2ComboBoxModel = new ChoixComboBoxModel(choix);
		ChoixComboBoxModel choix3ComboBoxModel = new ChoixComboBoxModel(choix);
		ChoixComboBoxModel choix4ComboBoxModel = new ChoixComboBoxModel(choix);
		
		final JComboBox cbxChoix1 = new JComboBox();
		cbxChoix1.setModel(choix1ComboBoxModel);
		GridBagConstraints gbc_cbxChoix1 = new GridBagConstraints();
		gbc_cbxChoix1.insets = new Insets(0, 0, 5, 5);
		gbc_cbxChoix1.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxChoix1.gridx = 1;
		gbc_cbxChoix1.gridy = 2;
		contentPane.add(cbxChoix1, gbc_cbxChoix1);				
		
		final JComboBox cbxChoix2 = new JComboBox();
		cbxChoix2.setModel(choix2ComboBoxModel);
		GridBagConstraints gbc_cbxChoix2 = new GridBagConstraints();
		gbc_cbxChoix2.insets = new Insets(0, 0, 5, 5);
		gbc_cbxChoix2.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxChoix2.gridx = 2;
		gbc_cbxChoix2.gridy = 2;
		contentPane.add(cbxChoix2, gbc_cbxChoix2);
		
		final JComboBox cbxChoix3 = new JComboBox();
		cbxChoix3.setModel(choix3ComboBoxModel);
		GridBagConstraints gbc_cbxChoix3 = new GridBagConstraints();
		gbc_cbxChoix3.insets = new Insets(0, 0, 5, 5);
		gbc_cbxChoix3.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxChoix3.gridx = 3;
		gbc_cbxChoix3.gridy = 2;
		contentPane.add(cbxChoix3, gbc_cbxChoix3);
		
		final JComboBox cbxChoix4 = new JComboBox();
		cbxChoix4.setModel(choix4ComboBoxModel);
		GridBagConstraints gbc_cbxChoix4 = new GridBagConstraints();
		gbc_cbxChoix4.insets = new Insets(0, 0, 5, 5);
		gbc_cbxChoix4.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxChoix4.gridx = 4;
		gbc_cbxChoix4.gridy = 2;
		contentPane.add(cbxChoix4, gbc_cbxChoix4);
		
		btnChoixJoueur.setEnabled(false);
		btnChoixJoueur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// On valide les choix effectués par le joueur 
				Choix[] choixJoueur = new Choix[Juge.NOMBRE_CHOIX];
				Choix c = new Choix();
				c = (Choix)cbxChoix1.getSelectedItem();
				choixJoueur[0] = new Choix(c.getId(), c.getCouleur(), 0);
				c = (Choix)cbxChoix2.getSelectedItem();
				choixJoueur[1] = new Choix(c.getId(), c.getCouleur(), 1);
				c = (Choix)cbxChoix3.getSelectedItem();
				choixJoueur[2] = new Choix(c.getId(), c.getCouleur(), 2);
				c = (Choix)cbxChoix4.getSelectedItem();
				choixJoueur[3] = new Choix(c.getId(), c.getCouleur(), 3);
				
				try {					
					Resultat resultatJoueur = juge.evaluer(choixOrdinateur, choixJoueur);	
					tableChoixJoueur.setModel(resultatTableModel);
					resultatTableModel.ajouterResultat(resultatJoueur);	
					
					if(juge.victoire() == true) {
						JOptionPane.showMessageDialog(getParent(), "Vous avez gagné en " + Juge.NOMBRE_TENTATIVE + " tentatives !");
						Choix[] co = choixOrdinateur;
						String choixOrdinateur = co[0].getId() + co[1].getId() + co[2].getId() + co[3].getId();
						lblChoixOrdinateur.setText("L'ordinateur avait choisi : " + choixOrdinateur);
					}					
				} catch (MasterMindException ex) {
					btnChoixJoueur.setEnabled(false);										
					JOptionPane.showMessageDialog(getParent(), ex.getMessage());								
				}
				
			}
		});
		
		
		GridBagConstraints gbc_btnChoixJoueur = new GridBagConstraints();
		gbc_btnChoixJoueur.insets = new Insets(0, 0, 5, 5);
		gbc_btnChoixJoueur.gridx = 5;
		gbc_btnChoixJoueur.gridy = 2;
		contentPane.add(btnChoixJoueur, gbc_btnChoixJoueur);
		
		tableChoixJoueur = new JTable();				
		tableChoixJoueur.setRowSelectionAllowed(false);
		tableChoixJoueur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableChoixJoueur.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		GridBagConstraints gbc_tableChoixJoueur = new GridBagConstraints();
		gbc_tableChoixJoueur.gridwidth = 6;
		gbc_tableChoixJoueur.insets = new Insets(0, 0, 5, 5);
		gbc_tableChoixJoueur.fill = GridBagConstraints.BOTH;
		gbc_tableChoixJoueur.gridx = 0;
		gbc_tableChoixJoueur.gridy = 4;
		contentPane.add(tableChoixJoueur, gbc_tableChoixJoueur);		
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
			}
		});
				
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuitter.gridx = 5;
		gbc_btnQuitter.gridy = 5;
		contentPane.add(btnQuitter, gbc_btnQuitter);
	}	

}
