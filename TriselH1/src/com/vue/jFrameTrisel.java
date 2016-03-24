package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.metier.Utilisateur;
import com.persistance.AccesData;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class jFrameTrisel extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMenuFichier;
	private JMenu mnMenuLevee;
	private JMenu mnMenuFacture;
	private JMenuItem mntmMenuItemQuitter;
	private JMenuItem mntmMenuItemLevee;
	private JMenuItem mntmMenuItemFacture;
	private JPanel panel;
	private JTextField textFieldLogin;
	private JLabel lblLogin;
	private JLabel lblPwd;
	private JButton btnVadider;
	private JPasswordField passwordField;
	private JMenuItem mntmDeconnexion;
	private JMenu mnConsultation;
	private JMenuItem mntmHabParUsager;
	private JMenu mnDonnees;
	private JMenu mnTypeDechet;
	private JMenuItem mntmAjout;
	private JMenuItem mntmChanTarif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Image icone = java.awt.Toolkit.getDefaultToolkit().getImage("Trisel.jpg");
					jFrameTrisel frame = new jFrameTrisel();
					frame.setIconImage(icone);
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
	public jFrameTrisel() {
		setTitle("TRISEL - Gestion des poubelles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnMenuFichier());
			menuBar.add(getMnMenuLevee());
			menuBar.add(getMnMenuFacture());
			menuBar.add(getMnConsultation());
			menuBar.add(getMnDonnees());
		}
		return menuBar;
	}
	private JMenu getMnMenuFichier() {
		if (mnMenuFichier == null) {
			mnMenuFichier = new JMenu("Fichier");
			mnMenuFichier.add(getMntmDeconnexion());
			mnMenuFichier.add(getMntmMenuItemQuitter());
		}
		return mnMenuFichier;
	}
	private JMenu getMnMenuLevee() {
		if (mnMenuLevee == null) {
			mnMenuLevee = new JMenu("Levee");
			mnMenuLevee.add(getMntmMenuItemLevee());
			mnMenuLevee.setEnabled(false);
		}
		return mnMenuLevee;
	}
	private JMenu getMnMenuFacture() {
		if (mnMenuFacture == null) {
			mnMenuFacture = new JMenu("Facture");
			mnMenuFacture.add(getMntmMenuItemFacture());
			mnMenuFacture.setEnabled(false);
		}
		return mnMenuFacture;
	}
	private JMenuItem getMntmMenuItemQuitter() {
		if (mntmMenuItemQuitter == null) {
			mntmMenuItemQuitter = new JMenuItem("Quitter");
			mntmMenuItemQuitter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmMenuItemQuitter;
	}
	private JMenuItem getMntmMenuItemLevee() {
		if (mntmMenuItemLevee == null) {
			mntmMenuItemLevee = new JMenuItem("Ajouter levee");
			mntmMenuItemLevee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					insertionLevee();
				}
			});
		}
		return mntmMenuItemLevee;
	}
	private JMenuItem getMntmMenuItemFacture() {
		if (mntmMenuItemFacture == null) {
			mntmMenuItemFacture = new JMenuItem("Editer facture");
			mntmMenuItemFacture.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editionFacture();
				}
			});
		}
		return mntmMenuItemFacture;
	}
	private void insertionLevee() { 
		// on affecte le panel de la fenêtre 
		// avec une instance de PanelLevee 
		this.setContentPane(new PanelLevee());
		// mets à jour le formulaire 
		this.revalidate();
	}
	private void editionFacture(){
		this.setContentPane(new PanelFacture());
		this.revalidate();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(5, 5, 424, 225);
			panel.setLayout(null);
			panel.add(getLblLogin());
			panel.add(getLblPwd());
			panel.add(getTextFieldLogin());
			panel.add(getBtnVadider());
			panel.add(getPasswordField());
		}
		return panel;
	}
	private JTextField getTextFieldLogin() {
		if (textFieldLogin == null) {
			textFieldLogin = new JTextField();
			textFieldLogin.setBounds(146, 66, 86, 20);
			textFieldLogin.setColumns(10);
		}
		return textFieldLogin;
	}
	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("Login");
			lblLogin.setBounds(87, 62, 57, 30);
		}
		return lblLogin;
	}
	private JLabel getLblPwd() {
		if (lblPwd == null) {
			lblPwd = new JLabel("Password");
			lblPwd.setBounds(86, 107, 61, 30);
		}
		return lblPwd;
	}
	private JButton getBtnVadider() {
		if (btnVadider == null) {
			btnVadider = new JButton("Valider");
			btnVadider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String login = textFieldLogin.getText();
					String pwd = new String(passwordField.getPassword());
					Utilisateur u = AccesData.getUtilisateur(login, pwd);
					if (u != null){
						paramNiveau(u.getNiveau());
						welcome(u.getNomUtilisateur());
					}
					else{
						afficheMessage("Authentification erron�e");
						textFieldLogin.setText("");
						passwordField.setText("");
						textFieldLogin.requestFocus();
					}
				}
			});
			btnVadider.setBounds(227, 159, 89, 23);
		}
		return btnVadider;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(146, 112, 86, 20);
		}
		return passwordField;
	}
	private void welcome(String nomUtil){
		this.setContentPane(new PanelFondEcran(nomUtil));
		this.revalidate();
	}
	private void deconnexion () {
		this.setContentPane(getPanel());
		textFieldLogin.setText("");
		passwordField.setText("");
		textFieldLogin.requestFocus();
		this.revalidate();
	}
	private JMenuItem getMntmDeconnexion() {
		if (mntmDeconnexion == null) {
			mntmDeconnexion = new JMenuItem("Deconnexion");
			mntmDeconnexion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					deconnexion();
				}
			});
		}
		return mntmDeconnexion;
	}
	public void paramNiveau(int niveau){
		switch (niveau){
		case 1 : {
			mnMenuLevee.setEnabled(true);
			mnMenuFacture.setEnabled(true);
			mnConsultation.setEnabled(true);
			mnDonnees.setEnabled(true);
			break;
		}
		case 2 : {
			mnMenuFacture.setEnabled(true);
			mnDonnees.setEnabled(true);
			break;
		}
		case 3 : {
			mnMenuLevee.setEnabled(true);
			mnDonnees.setEnabled(true);
			break;
		}
		default : break;
		}
	}
	private void afficheMessage (String message){
		JOptionPane.showMessageDialog(null, message);
	}
	private JMenu getMnConsultation() {
		if (mnConsultation == null) {
			mnConsultation = new JMenu("Consultation");
			mnConsultation.add(getMntmHabParUsager());
			mnConsultation.setEnabled(false);
		}
		return mnConsultation;
	}
	private JMenuItem getMntmHabParUsager() {
		if (mntmHabParUsager == null) {
			mntmHabParUsager = new JMenuItem("Habitation par usager");
			mntmHabParUsager.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					consulter();
				}
			});
		}
		return mntmHabParUsager;
	}
	private void consulter(){
		this.setContentPane(new PanelConsultation());
		this.revalidate();
	}
	private JMenu getMnDonnees() {
		if (mnDonnees == null) {
			mnDonnees = new JMenu("Donnees");
			mnDonnees.setEnabled(false);
			mnDonnees.add(getMnTypeDechet());
		}
		return mnDonnees;
	}
	private JMenu getMnTypeDechet() {
		if (mnTypeDechet == null) {
			mnTypeDechet = new JMenu("Type dechet");
			mnTypeDechet.add(getMntmAjout());
			mnTypeDechet.add(getMntmChanTarif());
		}
		return mnTypeDechet;
	}
	private JMenuItem getMntmAjout() {
		if (mntmAjout == null) {
			mntmAjout = new JMenuItem("Ajout");
			mntmAjout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ajouter();
				}
			});
		}
		return mntmAjout;
	}
	private void ajouter(){
		this.setContentPane(new PanelAjoutTypeDechet());
		this.revalidate();
	}
	private JMenuItem getMntmChanTarif() {
		if (mntmChanTarif == null) {
			mntmChanTarif = new JMenuItem("Changement tarif");
			mntmChanTarif.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					modifTarif();
				}
			});
		}
		return mntmChanTarif;
	}
	public void modifTarif(){
		this.setContentPane(new PanelModifTarif());
		this.revalidate();
	}
}
