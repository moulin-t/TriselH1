package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.metier.TypeDechet;
import com.persistance.AccesData;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAjoutTypeDechet extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textFieldCode;
	private JTextField textFieldLibelle;
	private JTextField textFieldTarif;
	private JButton btnValider;
	private JButton btnAnnuler;

	/**
	 * Create the panel.
	 */
	public PanelAjoutTypeDechet() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getTextFieldCode());
		add(getTextFieldLibelle());
		add(getTextFieldTarif());
		add(getBtnValider());
		add(getBtnAnnuler());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Saisie d'un nouveau type de dechet");
			lblNewLabel.setBounds(147, 22, 243, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Code type dechet");
			lblNewLabel_1.setBounds(51, 99, 91, 14);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Libelle type dechet");
			lblNewLabel_2.setBounds(51, 146, 91, 14);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Tarif (par Kg)");
			lblNewLabel_3.setBounds(51, 194, 91, 14);
		}
		return lblNewLabel_3;
	}
	private JTextField getTextFieldCode() {
		if (textFieldCode == null) {
			textFieldCode = new JTextField();
			textFieldCode.setBounds(221, 96, 140, 20);
			textFieldCode.setColumns(10);
		}
		return textFieldCode;
	}
	private JTextField getTextFieldLibelle() {
		if (textFieldLibelle == null) {
			textFieldLibelle = new JTextField();
			textFieldLibelle.setBounds(221, 143, 140, 20);
			textFieldLibelle.setColumns(10);
		}
		return textFieldLibelle;
	}
	private JTextField getTextFieldTarif() {
		if (textFieldTarif == null) {
			textFieldTarif = new JTextField();
			textFieldTarif.setBounds(221, 191, 140, 20);
			textFieldTarif.setColumns(10);
		}
		return textFieldTarif;
	}
	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						TypeDechet unTypeDechet = new TypeDechet(textFieldCode.getText(), textFieldLibelle.getText(), Double.parseDouble(textFieldTarif.getText()));
						boolean ok = AccesData.ajoutTypeDechet(unTypeDechet);
						if (ok) afficheMessage("Donnees enregistrees");
						else afficheMessage("Erreur losr de l'insersion");
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnValider.setBounds(221, 248, 89, 23);
		}
		return btnValider;
	}
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					miseNul();
				}
			});
			btnAnnuler.setBounds(351, 248, 89, 23);
		}
		return btnAnnuler;
	}
	private void miseNul(){
		textFieldCode.setText("");
		textFieldLibelle.setText("");
		textFieldTarif.setText("");
	}
	private void afficheMessage (String message){
		JOptionPane.showMessageDialog(null, message);
	}
}
