package com.util;

import java.io.File;

public class Parametres {
	//Instanciation du fichier cible
	private static String nomFichier = "paramAppli.ini";
	//Méthodes pour ramener chaque chemin 1
	private static String getChemin(int n){
		FichierTexte fichier = new FichierTexte();
		String chemin = null;
		if(fichier.openFileReader(nomFichier)){
			for(int i = 0; i<n; i++){
				chemin = fichier.readLigne();
			}
			fichier.closeFileReader();
		}
		return chemin;
	}
	public static String getExtensionFichier (String nomFichier){
		String tab[] = nomFichier.split("\\.");
		return tab[1];
	}
	public static void transfertFichier(File source, File dest){
		if(source.renameTo(dest)){
			System.out.println("Fichier déplacé avec succes.");
		}
		else{
			System.out.println("Echec lors du déplacement!");
		}
	}
	//Méthodes pour ramener chaque chemin 2
	public static String getCheminBd(){
		return getChemin(2);
	}
	public static String getCheminLeveeATraiter(){
		return getChemin(4);
	}
	public static String getCheminLeveeLog(){
		return getChemin(10);
	}
	public static String getCheminLeveeTraites(){
		return getChemin(6);
	}
	public static String getCheminFacturePdf(){
		return getChemin(8);
	}
	public static int  nbLevee() {
		String cheminLevee = getCheminLeveeATraiter();
		File f = new File(cheminLevee);
		return f.listFiles().length; 
	}
}
