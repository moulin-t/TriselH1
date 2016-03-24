package com.util;
import com.metier.Levee;
import com.persistance.AccesData;

import java.io.*;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Element;
import org.jdom2.Document;

public class InsertionLevee {
	public static void traitementFichierTexte(String cheminLevee){
		FichierTexte fichier = new FichierTexte();
		if(fichier.openFileReader(cheminLevee)){
			//Récupération et affichage de la date
			String date = fichier.readLigne();
			System.out.println(date);
			// format de la date
			SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
			try
			{
				// instanciation date de lev�e au format français
				Date dateF = dateFormat.parse(date);
				//Récupération et affichage des levées
				String ligne = null;
				String[] data = null;
				String codeH = null;
				String codeP = null;
				Double poids = null;
				while((ligne = fichier.readLigne()) != null){
					//Récupération
					data = ligne.split(":");
					codeH = data[0];
					codeP = data[1];
					poids = Double.parseDouble(data[2]);
					//Affichage des données sur la pesée
					System.out.println(codeH + " " + codeP + " " + poids);
					Levee l = new Levee(dateF,poids,codeP );
				AccesData.ajoutLevee(l)	;		
				}
				fichier.closeFileReader();
			} 
			catch (ParseException e){
				e.printStackTrace();
			} 
		}
	}
	public static void traitementFichierXml(String cheminLevee){
		Document document = null;
		Element racine = null;
		SAXBuilder sxb = new SAXBuilder();
		
		//Nouveau document JDOM
		try {
			document = sxb.build(new File("pesee.xml"));
			//Initialisation racine
			racine = document.getRootElement();
			//R�cup�ration de la date de lev�e
			Element date = racine.getChild("Date");
			System.out.println(date.getText());
			//R�cup�ration de l'ensemble des lev�es
			List<Element> listLevee = racine.getChildren("Levee");
			//parcours des lev�es
			for(Element e : listLevee){
				//Traitement de chaque lev�e
				System.out.print("Levée : ");
				System.out.print(e.getChild("poubelle").getText()+" ");
				System.out.print(e.getChild("poids").getText()+"\n");
			}
		} catch (JDOMException e) {
			//si pb de parsage du fichier
			e.printStackTrace();
		} catch (IOException e) {
			//erreur si non existant
			e.printStackTrace();
		}	
	}
	public static void traitementLevee(){
		//On ram�ne les chemins
		String cheminTraite = Parametres.getCheminLeveeTraites();
		String cheminATraiter = Parametres.getCheminLeveeATraiter();
		String cheminLog = Parametres.getCheminLeveeLog();
		String cheminDest;
		File f = new File(cheminATraiter);
		File[] lesF = f.listFiles();
		if(lesF == null){
			System.out.println("Dossier vide!");
		}
		else{
			for(int i = 0; i < lesF.length; i++){
				if(lesF[i].isFile()){
					String ext = Parametres.getExtensionFichier(lesF[i].toString());
					switch(ext){
					case "txt":
						traitementFichierTexte(lesF[i].getAbsolutePath());
						cheminDest = cheminTraite + "\\" + lesF[i].getName();
						File dest = new File(cheminDest);
						Parametres.transfertFichier(lesF[i], dest);
						break;
					case "xml":
						traitementFichierXml(lesF[i].getAbsolutePath());
						cheminDest = cheminTraite + "\\" + lesF[i].getName();
						File dest2 = new File(cheminDest);
						Parametres.transfertFichier(lesF[i], dest2);
						break;
					default:
						cheminDest = cheminLog + "\\" + lesF[i].getName();
						File dest3 = new File(cheminDest);
						Parametres.transfertFichier(lesF[i], dest3);
					}
				}
			}
		}
	}
}
