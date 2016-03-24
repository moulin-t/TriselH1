package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author moulin-t
 * @version 1.0
 */
@Entity
@Table(name="usager")
public class Usager {
	//Propri�t�s
	@Id
	@Column(name="idUsager")
	private String idUsager;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="adresseRueUsager")
	private String adresseRueUsager;
	@Column(name="adresseVilleUsager")
	private String adresseVilleUsager;
	@Column(name="cpUsager")
	private String cpUsager;
	@Column(name="nomUser")
	private String nomUser;
	@Column(name="motDePasse")
	private String motDePasse;
	@OneToMany
	@JoinColumn(name="idUsager")
	private List<Habitation> lesHabitations;
	//Constructeur
	/**
	 * Retourne un usager
	 * @param idUsager
	 * @param nom
	 * @param prenom
	 * @param adresseRueUsager
	 * @param adresseVilleUsager
	 * @param cpUsager
	 * @param nomUser
	 * @param motDePasse
	 */
	public Usager(){
		super();
	}
	public Usager(String idUsager, String nom, String prenom, String nomUser, String motDePasse) {
		super();
		this.idUsager = idUsager;
		this.nom = nom;
		this.prenom = prenom;
		this.nomUser = nomUser;
		this.motDePasse = motDePasse;
		lesHabitations = new ArrayList<Habitation>();
	}
	//Acesseurs Modificateurs
	/**
	 * Retourne l'identifiant de l'usager
	 * @return idUsager
	 */
	public String getIdUsager() {
		return idUsager;
	}
	/**
	 * Modifie l'identifiant de l'usager
	 * @param idUsager
	 */
	public void setIdUsager(String idUsager) {
		this.idUsager = idUsager;
	}
	/**
	 * Retourne le nom de l'usager
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Modifie le nom de l'usager
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Retourne le pr�nom de l'usager
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * Modifie le pr�nom de l'usager
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * Retourne l'adresse de l'usager (rue)
	 * @return adresseRueUsager
	 */
	public String getAdresseRueUsager() {
		return adresseRueUsager;
	}
	/**
	 * Modifie l'adresse de l'usager (rue)
	 * @param adresseRueUsager
	 */
	public void setAdresseRueUsager(String adresseRueUsager) {
		this.adresseRueUsager = adresseRueUsager;
	}
	/**
	 * Retourne l'adresse de l'usager (ville)
	 * @return adresseVilleUsager
	 */
	public String getAdresseVilleUsager() {
		return adresseVilleUsager;
	}
	/**
	 * Modifie l'adresse de l'usager (ville)
	 * @param adresseVilleUsager
	 */
	public void setAdresseVilleUsager(String adresseVilleUsager) {
		this.adresseVilleUsager = adresseVilleUsager;
	}
	/**
	 * Retourne le code postal de l'usager
	 * @return cpUsager
	 */
	public String getCpUsager() {
		return cpUsager;
	}
	/**
	 * Modifie le code postal de l'usager
	 * @param cpUsager
	 */
	public void setCpUsager(String cpUsager) {
		this.cpUsager = cpUsager;
	}
	/**
	 * Retourne le nom d'utilisateur de l'usager
	 * @return nomUser
	 */
	public String getNomUser() {
		return nomUser;
	}
	/**
	 * Modifie le nom d'utilisateur de l'usager
	 * @param nomUser
	 */
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	/**
	 * Retourne le mot de passe de l'utilisateur
	 * @return
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * Modifie le mot de passe de l'utilisateur
	 * @param motDePasse
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public List<Habitation> getLesHabitations() {
		return lesHabitations;
	}
	public void setLesHabitations(List<Habitation> lesHabitations) {
		this.lesHabitations = lesHabitations;
	}
	//ToString
	@Override
	/**
	 * retourne la chaine de caract�re contenant les informations d'un usager
	 */
	public String toString() {
		return "Usager [idUsager=" + idUsager + ", nom=" + nom + ", prenom=" + prenom + ", nomUser=" + nomUser + ", motDePasse=" + motDePasse + "]";
	}
}
