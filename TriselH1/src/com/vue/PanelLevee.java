package com.vue;

import javax.swing.JPanel;

import com.util.InsertionLevee;
import com.util.Parametres;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLevee extends JPanel {
	private JButton btnButtonMaj;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public PanelLevee() {
		setLayout(null);
		add(getLblNewLabel());
		add(getBtnButtonMaj());

	}
	private JButton getBtnButtonMaj() {
		if (btnButtonMaj == null) {
			btnButtonMaj = new JButton("Lancer la mise à jour");
			btnButtonMaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InsertionLevee.traitementLevee();
					lblNewLabel.setText("Il y a "+Parametres.nbLevee()+" fichier(s) à traiter");
					btnButtonMaj.setEnabled(false);
					afficheMessage("Mise à jour effectuée");
				}
			});
			btnButtonMaj.setBounds(153, 143, 150, 23);
		}
		if (Parametres.nbLevee() == 0){
			btnButtonMaj.setEnabled(false);
		}
		return btnButtonMaj;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			String textLabel = "Il y a "+Parametres.nbLevee()+" fichier(s) à traiter";
			lblNewLabel = new JLabel(textLabel);
			lblNewLabel.setBounds(164, 38, 138, 14);
		}
		return lblNewLabel;
	}
	@SuppressWarnings("unused")
	private void afficheMessage(String message){
		JOptionPane.showMessageDialog(null, message);
	}
}
