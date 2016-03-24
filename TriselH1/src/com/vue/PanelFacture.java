package com.vue;

import javax.swing.JPanel;

import com.pdf.FacturePdf;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFacture extends JPanel implements PropertyChangeListener{
	private JMonthChooser monthChooser;
	private JYearChooser yearChooser;
	private JButton btnNewButton;
	private int an, mois;
	private Calendar calendar;
	
	public void PanelEditionFacture() {
		// récupération année et mois actuel
		calendar = Calendar.getInstance();
		an = getYear();
		mois  = getMonth() + 1;// +1 car mois de 0 à 11 et non pas de 1 = 12c
		
	}
	/**
	 * Create the panel.
	 */
	public PanelFacture() {
		setLayout(null);
		add(getMonthChooser());
		add(getYearChooser());
		add(getBtnNewButton());

	}

	private JMonthChooser getMonthChooser() {
		if (monthChooser == null) {
			monthChooser = new JMonthChooser();
			monthChooser.setBounds(103, 6, 97, 20);
			monthChooser.addPropertyChangeListener(this);
		}
		return monthChooser;
	}
	private JYearChooser getYearChooser() {
		if (yearChooser == null) {
			yearChooser = new JYearChooser();
			yearChooser.setBounds(205, 6, 47, 20);
			yearChooser.addPropertyChangeListener(this);
		}
		return yearChooser;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Editer");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FacturePdf.GenerePdf(an, mois -1);
				}
			});
			btnNewButton.setBounds(151, 128, 89, 23);
		}
		return btnNewButton;
	}
	
	// méthodes utilitaires qui ramène l'année et le mois courant
	public int getYear(){ 
		return calendar.get(Calendar.YEAR);
	}

	public int getMonth(){
		return calendar.get(Calendar.MONTH);
	}

	// procédure de tests des sources d'évènement
	public void propertyChange(PropertyChangeEvent evt) { 	
		if(evt.getPropertyName().equals("year")){
			an = (Integer)evt.getNewValue(); 
		}
		if(evt.getPropertyName().equals("month")){
			mois  = (Integer)evt.getNewValue() + 1;
		}
	}
}
