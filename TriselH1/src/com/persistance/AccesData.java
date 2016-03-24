package com.persistance;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metier.*;

public class AccesData {
	private static Session s = HibernateSession.getSession();
	private static Transaction trans = null;
	public static List<Habitation> getLesHabitations(){
		return s.createQuery("from Habitation").list();
	}
	public static Habitation getHabitation(String idHabitation){
		return (Habitation) s.get(Habitation.class, idHabitation);
	}
	public static boolean ajoutLevee(Levee uneLevee){
		boolean ok = false;
		try {
			trans = s.beginTransaction();
			s.save(uneLevee);
			trans.commit();
			ok = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ok;
	}
	public static boolean ajoutFacture(Facture uneFacture){
		boolean ok = false;
		try {
			trans = s.beginTransaction();
			s.save(uneFacture);
			trans.commit();
			ok = true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}
	public static Utilisateur getUtilisateur(String login, String mdp) {
		Utilisateur u = null;
		String hql = "from Utilisateur u where u.login='"+login+"' and u.mdp='"+mdp+"'";
		return (Utilisateur) s.createQuery(hql).uniqueResult();
	}
	public static List<Usager> getLesUsagers(){
		return s.createQuery("from Usager").list();
	}
	public static List<Habitation> getHabUsager (String idUsager){
		Habitation h;
		String hql = "from Habitation h where h.usager='"+idUsager+"'";
		return s.createQuery(hql).list();
	}
	public static boolean ajoutTypeDechet(TypeDechet unTypeDechet){
		boolean ok = false;
		try {
			trans = s.beginTransaction();
			s.save(unTypeDechet);
			trans.commit();
			ok = true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}
	public static List<TypeDechet> getLesTypesDechet(){
		return s.createQuery("from TypeDechet").list();
	}
	public static boolean modifTypeDechet(String code, Double tarif){
		boolean ok = false;
		try {
			trans = s.beginTransaction();
			String hql = "update TypeDechet t set t.tarif = :tarif where t.code = :oldCode";
			int updatedEntities = s.createQuery(hql).setDouble("tarif", tarif).setString("oldCode", code).executeUpdate();
			trans.commit();
			ok = true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}
	public static Usager getUsager(String user, String mdp) {
		Usager u = null;
		String hql = "from Usager where nomUser='"+user+"' and motDePasse='"+mdp+";'";
		return (Usager) s.createQuery(hql).uniqueResult();
	}
}