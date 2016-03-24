package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author moulin-t
 * @version 1.0
 */
@Entity
@Table(name="habitation")
public class Habitation {
	//Propri�t�s
	@Id
	@Column(name="idHabitation")
	private String idHabitation;
	@Column(name="adresseRue")
	private String adresseRue;
	@Column(name="adresseVille")
	private String adresseVille;
	@ManyToOne
	@JoinColumn(name="idUsager")
	private Usager usager;
	@OneToMany
	@JoinColumn(name="idHabitation")
	private List<Poubelle> lesPoubelles;
	@OneToMany
	@JoinColumn(name="idHabitation")
	private List<Facture> lesFactures;
	//Constructeurs
	public Habitation(){
		super();
	}
	/**
	 * Retourne une habitation
	 * @param idHabitation
	 * @param adresseRue
	 * @param codePostal
	 * @param adresseVille
	 * @param usager
	 */
	public Habitation(String idHabitation, String adresseRue, String adresseVille, Usager usager) {
		super();
		this.idHabitation = idHabitation;
		this.adresseRue = adresseRue;
		this.adresseVille = adresseVille;
		this.usager = usager;
		lesPoubelles = new ArrayList<Poubelle>();
		lesFactures = new ArrayList<Facture>();
	}
	//Acesseurs Modificateur
	/**
	 * Retourne l'identifiant de l'habitation
	 * @return idHabitation
	 */
	public String getIdHabitation() {
		return idHabitation;
	}
	/**
	 * Modifie l'identifiant de l'habitation
	 * @param idHabitation
	 */
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	/**
	 * Retourne l'adresse de l'habitation (rue)
	 * @return adresseRue
	 */
	public String getAdresseRue() {
		return adresseRue;
	}
	/**
	 * Modifie l'adresse de l'habitation (rue)
	 * @param adresseRue
	 */
	public void setAdresseRue(String adresseRue) {
		this.adresseRue = adresseRue;
	}
	/**
	 * Retourne l'adresse de l'habitation (ville)
	 * @return adresseVille
	 */
	public String getAdresseVille() {
		return adresseVille;
	}
	/**
	 * Modifie l'adresse de l'habitation (ville)
	 * @param adresseVille
	 */
	public void setAdresseVille(String adresseVille) {
		this.adresseVille = adresseVille;
	}
	/**
	 * Retourne l'usager de l'habitation
	 * @return usager
	 */
	public Usager getUsager() {
		return usager;
	}
	/**
	 * Modifie l'usager de l'habitation
	 * @param usager
	 */
	public void setUsager(Usager usager) {
		this.usager = usager;
	}
	/**
	 * Retourne la liste des poubelles de l'habitation
	 * @return lesPoubelles
	 */
	public List<Poubelle> getLesPoubelles() {
		return lesPoubelles;
	}
	/**
	 * Modifie la liste des poubelles de l'habitation
	 * @param lesPoubelles
	 */
	public void setLesPoubelles(ArrayList<Poubelle> lesPoubelles) {
		this.lesPoubelles = lesPoubelles;
	}
	/**
	 * Ajoute une poubelle dans la liste des poubelles de l'habitation
	 * @param unePoubelle
	 */
	public void ajoutPoubelle(Poubelle unePoubelle){
		this.lesPoubelles.add(unePoubelle);
	}
	public List<Facture> getLesFactures() {
		return lesFactures;
	}
	public void setLesFactures(List<Facture> lesFactures) {
		this.lesFactures = lesFactures;
	}
	public void setLesPoubelles(List<Poubelle> lesPoubelles) {
		this.lesPoubelles = lesPoubelles;
	}
	//ToString
	@Override
	/**
	 * Retourne la chaine de caractère contenant les informations de l'habitation
	 */
	public String toString() {
		return "Habitation [idHabitation=" + idHabitation + ", adresseRue=" + adresseRue + ", adresseVille="
				+ adresseVille + ", usager=" + usager + ", lesPoubelles=" + lesPoubelles + "]";
	}
	/**
	 * Retourne le coût des déchéts pour une poubelle et un mois d'une année
	 * @param an
	 * @param mois
	 */
	public double getCout(int an, int mois){
		double cout = 0;
		for(Poubelle p : lesPoubelles){
			cout = cout + p.getCout(an, mois);
		}
		return cout;
	}
}
