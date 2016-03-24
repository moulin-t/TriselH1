package com.vue;

import javax.swing.JPanel;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.metier.Usager;
import com.persistance.AccesData;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelConsultation extends JPanel {
	private JComboBox comboBoxUsager;
	private JScrollPane scrollPane;
	private JTable table;
	private ModelData model;

	/**
	 * Create the panel.
	 */
	public PanelConsultation() {
		setLayout(null);
		add(getComboBoxUsager());
		add(getScrollPane());

	}
	private JComboBox getComboBoxUsager() {
		if (comboBoxUsager == null) {
			comboBoxUsager = new JComboBox();
			comboBoxUsager.setBounds(154, 22, 160, 20);
			comboBoxUsager.addItem("Selectionner");
			List<Usager> lesUsagers = AccesData.getLesUsagers();
			for(Usager u : lesUsagers){
				comboBoxUsager.addItem(u.getIdUsager()+" "+u.getNom()+" "+u.getPrenom());
			}
			comboBoxUsager.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBoxUsager.getSelectedIndex() != 0){
						String idUsager	= lesUsagers.get(comboBoxUsager.getSelectedIndex() -1).getIdUsager();
						model = new ModelData(idUsager);
						table.setModel(model);
					}
				}
			});
		}
		return comboBoxUsager;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
			scrollPane.setBounds(57, 65, 340, 168);
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(51, 108, 349, 154);
		}
		return table;
	}
}
