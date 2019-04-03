package com.wedoogift.test.mastermind.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.wedoogift.test.mastermind.core.Resultat;

public class ResultatTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private String[] entetes = {"JOUEUR", "JUSTE", "PEU JUSTE", "MISE"};
    private List<Resultat> resultats = null;

    public ResultatTableModel(List<Resultat> resultats) {
        super();
        this.resultats = resultats;
    }

    @Override
    public int getRowCount() {
        return resultats.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Resultat value = resultats.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return value.getChoixJoueur();
            case 1:
                return value.getJuste();
            case 2:
                return value.getPeuJuste();
            case 3:
                return value.getMise();
            default:
                return null;
        }
    }

    public void ajouterResultat(Resultat resultat) {
        resultats.add(resultat);
        this.fireTableRowsInserted(resultats.size() - 1, resultats.size() - 1);
    }

    public void supprimer(int rowIndex) {
        resultats.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void supprimerTout() {
        int rows = resultats.size();
        resultats.clear();
        this.fireTableRowsDeleted(0, rows - 1);
    }
}
