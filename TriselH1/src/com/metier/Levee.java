package com.metier;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author moulin-t
 * @version 1.0
 */
@Entity
@Table(name="levee")
public class Levee {
	//Propriétés
	@Id
	@Column(name="idLevee")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idLevee;
	@Column(name="laDate")
	private Date laDate;
	@Column(name="poids")
	private double poids;
	@Column(name="idPoubelle")
	private String idPoubelle;
	//Constructeur
	public Levee(){
		super();
	}
	/**
	 * Retourne la levée
	 * @param idLevee
	 * @param laDate
	 * @param poids
	 * @param idPoubelle
	 */
	public Levee(int idLevee, Date laDate, double poids, String idPoubelle)  {
		super();
		this.idLevee = idLevee;
		this.laDate = laDate;
		this.poids = poids;
		this.idPoubelle = idPoubelle;
	}
	/**
	 * Retourne la levée sans l'identifiant
	 * @param laDate
	 * @param poids
	 * @param idPoubelle
	 */
	public Levee(Date laDate, double poids, String idPoubelle) {
		super();
		this.laDate = laDate;
		this.poids = poids;
		this.idPoubelle = idPoubelle;
	}
	//Acesseurs modificateurs
	/**
	 * Retourne l'identifiant de la levée
	 * @return idLevee
	 */
	public int getIdLevee() {
		return idLevee;
	}
	/**
	 * Modifie l'identifiant de la levée
	 * @param idLevee
	 */
	public void setIdLevee(int idLevee) {
		this.idLevee = idLevee;
	}
	/**
	 * Retourne la date de la levée
	 * @return laDate
	 */
	public Date getLaDate() {
		return laDate;
	}
	/**
	 * Modifie la date de la levée
	 * @param laDate
	 */
	public void setLaDate(Date laDate) {
		this.laDate = laDate;
	}
	/**
	 * Retourne le poids de la levée
	 * @return poids
	 */
	public double getPoids() {
		return poids;
	}
	/**
	 * Modifie le poids de la levée
	 * @param poids
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}
	/**
	 * Retourne l'identifiant de la poubelle
	 * @return
	 */
	public String getIdPoubelle() {
		return idPoubelle;
	}
	/**
	 * Modifie l'identifiant de la poubelle
	 * @param idPoubelle
	 */
	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}
	//ToString
	@Override
	/**
	 * Retourne la chaine de caractère contenant les informations de la levée
	 */
	public String toString() {
		return "Levee [idLevee=" + idLevee + ", laDate=" + laDate + ", poids=" + poids + ", idPoubelle=" + idPoubelle
				+ "]";
	}
}
