package com.vue;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.metier.Habitation;
import com.persistance.AccesData;

public class ModelData extends AbstractTableModel {

	private String entete[] = {"id habitation", "adresse rue", "ville", "nb poubelles"};
	private List <Habitation> listeHab;
	public ModelData(String idHabitation) {
		listeHab = AccesData.getHabUsager(idHabitation);
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entete.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeHab.size();
	}

	@Override
	public String getColumnName(int columnIndex){
		return entete[columnIndex];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex){
		case 0 : 
			return listeHab.get(rowIndex).getIdHabitation();
		case 1 :
			return listeHab.get(rowIndex).getAdresseRue();
		case 2 :
			return listeHab.get(rowIndex).getAdresseVille();
		case 3 :
			return listeHab.get(rowIndex).getLesPoubelles().size();
		default :
			throw new IllegalArgumentException();
		}
	}

}
