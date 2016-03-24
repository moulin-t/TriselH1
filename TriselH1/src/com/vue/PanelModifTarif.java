package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.metier.TypeDechet;
import com.metier.Usager;
import com.persistance.AccesData;

import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelModifTarif extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox comboBoxTD;
	private JTextField textFieldTarifActuel;
	private JTextField textFieldNouveauTarif;
	private JButton btnValider;
	private JButton btnAnnuler;
	private List<TypeDechet> lesTD;

	/**
	 * Create the panel.
	 */
	public PanelModifTarif() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getComboBoxTD());
		add(getTextFieldTarifActuel());
		add(getTextFieldNouveauTarif());
		add(getBtnValider());
		add(getBtnAnnuler());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Mise a jour tarif par type de dechet");
			lblNewLabel.setBounds(149, 11, 267, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Type dechet");
			lblNewLabel_1.setBounds(46, 69, 93, 14);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Tarif actuel");
			lblNewLabel_2.setBounds(46, 117, 93, 14);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Nouveau tarif");
			lblNewLabel_3.setBounds(46, 167, 93, 14);
		}
		return lblNewLabel_3;
	}
	private JComboBox getComboBoxTD() {
		if (comboBoxTD == null) {
			comboBoxTD = new JComboBox();
			comboBoxTD.setBounds(149, 66, 138, 20);
			comboBoxTD.addItem("Selectionner");
			lesTD = AccesData.getLesTypesDechet();
			for(TypeDechet t : lesTD){
				comboBoxTD.addItem(t.getCode()+" "+t.getLibelle());
			}
			comboBoxTD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBoxTD.getSelectedIndex() != 0) textFieldTarifActuel.setText(String.valueOf(lesTD.get(comboBoxTD.getSelectedIndex()-1).getTarif()));
				}
			});
		}
		return comboBoxTD;
	}
	private JTextField getTextFieldTarifActuel() {
		if (textFieldTarifActuel == null) {
			textFieldTarifActuel = new JTextField();
			textFieldTarifActuel.setEditable(false);
			textFieldTarifActuel.setBounds(149, 114, 86, 20);
			textFieldTarifActuel.setColumns(10);
		}
		return textFieldTarifActuel;
	}
	private JTextField getTextFieldNouveauTarif() {
		if (textFieldNouveauTarif == null) {
			textFieldNouveauTarif = new JTextField();
			textFieldNouveauTarif.setBounds(149, 164, 86, 20);
			textFieldNouveauTarif.setColumns(10);
		}
		return textFieldNouveauTarif;
	}
	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean ok = AccesData.modifTypeDechet(lesTD.get(comboBoxTD.getSelectedIndex()-1).getCode(), Double.parseDouble(textFieldNouveauTarif.getText()));
					if (ok) afficheMessage("Modification effectuee");
					else afficheMessage("Erreur de modification");
				}
			});
			btnValider.setBounds(211, 230, 89, 23);
		}
		return btnValider;
	}
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textFieldTarifActuel.setText("");
					textFieldNouveauTarif.setText("");
					comboBoxTD.setSelectedIndex(0);
				}
			});
			btnAnnuler.setBounds(351, 230, 89, 23);
		}
		return btnAnnuler;
	}
	private void afficheMessage (String message){
		JOptionPane.showMessageDialog(null, message);
	}
}
