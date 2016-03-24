package com.vue;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.pdf.FacturePdf;
import com.persistance.HibernateSession;

/*import java.util.Date;

import java.util.Calendar;

import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.persistance.AccesBd;
import com.persistance.HabitationDAO;
import com.persistance.LeveeDAO;
import com.persistance.PoubelleDAO;
import com.persistance.TypeDechetDAO;
import com.persistance.UsagerDAO;
import com.util.InsertionLevee;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.util.Parametres;*/
public class Traitement {

	public static void main(String[] args) {
		Session s = HibernateSession.getSession();
		Usager res = (Usager)s.get(Usager.class, "usag2");
		System.out.println(res.getPrenom());
//		List<TypeDechet> listeDechet = s.createQuery("from TypeDechet").list();
//		for(TypeDechet t  : listeDechet){
//			System.out.println(t.toString());
//		}
//		TypeDechet td1 = new TypeDechet("pap", "papier", 0.422);
//		Transaction t = s.beginTransaction();
//		s.save(td1);
//		t.commit();
//		Levee l = (Levee)s.get(Levee.class, 5);
//		System.out.println(l.getLaDate());
		/*InsertionLevee.traitementFichierTexte("pesee.txt");
		InsertionLevee.traitementFichierXml("pesee.xml");
		System.out.println(Parametres.getCheminBd());
		System.out.println(Parametres.getCheminFacturePdf());
		System.out.println(Parametres.getCheminLeveeATraiter());
		System.out.println(Parametres.getCheminLeveeLog());
		System.out.println(Parametres.getCheminLeveeTraites());
		System.out.println(Parametres.getChemin(4));
		System.out.println(Parametres.getExtensionFichier("arbres.txt"));
		InsertionLevee.traitementLevee();
		Connection cnx = AccesBd.getInstance();
		try{
			// création d'un objet statement
			Statement requete = cnx.createStatement();
			// texte de la requête
			String sql = "select nom, prenom from usager";
			// exécution de la requête, résultat dans un jeu d'enregistrement de type resulset
			ResultSet rsUsager = requete.executeQuery(sql);
			// parcours 
			while (rsUsager.next()) {
				// accès aux champs du rs en fonction du type et du nom
				System.out.println(rsUsager.getString("nom") + "  " + rsUsager.getString("prenom"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		java.util.Date date = null;
		SimpleDateFormat dateFormat = null;
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		try{
			// instanciation date de lev�e au format fran�ais
			date = dateFormat.parse("15/05/2015");
			// instanciation objet Lev�e avec les deux constructeurs
			Levee le1 = new Levee(date, 5, "pb1");
			LeveeDAO ldao = new LeveeDAO();
			if(ldao.create(le1)) System.out.println("Ok!");
			else System.out.println("Ko!");
		} 
		catch (ParseException e){
			e.printStackTrace();
		} 
		InsertionLevee.traitementFichierTexte("pesee.txt");
		UsagerDAO usagerD = new UsagerDAO();
		Usager u = usagerD.find("usag1");
		if(u != null) System.out.println(u.toString());
		u = usagerD.find("ussag1");
		if(u == null) System.out.println("usager inexistant");
		TypeDechetDAO typeD = new TypeDechetDAO();
		TypeDechet t = typeD.find("pla");
		if(t != null) System.out.println(t.toString());
		t = typeD.find("plakk");
		if(t == null) System.out.println("Type inexistant");
		LeveeDAO leveeD = new LeveeDAO();
		Levee laLevee = leveeD.find("12");
		if(laLevee != null) System.out.println(laLevee.toString());
		if(laLevee == null) System.out.println("Identifiant inexistant");
		laLevee = leveeD.find("798");
		if(laLevee == null) System.out.println("Identifiant inexistant");
		PoubelleDAO pbDAO = new PoubelleDAO();
		Poubelle pb = pbDAO.find("pb1");
		if(pb != null) System.out.println(pb.toString());
		else System.out.println("Identifiant inexistant");
		HabitationDAO habD = new HabitationDAO();
		Habitation hab = habD.find("hab1");
		if(hab != null) System.out.println(hab.toString());
		else System.out.println("Identifiant inexistant");
		hab = habD.find("hab1");
		if(hab != null) System.out.println(hab.toString());
		else System.out.println("Identifiant inexistant");
		FacturePdf fac = new FacturePdf();
		fac.GenerePdf("hab1", 2015, 07);*/
	}
}