package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facture")
public class Facture {
	@Id
	@Column(name="idF")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idF;
	@Column(name="anF")
	private int anF;
	@Column(name="moisF")
	private int moisF;
	@Column(name="nomF")
	private String nomF;
	@Column(name="idHabitation")
	private String idHabitation;
	public Facture(){
		super();
	}
	public Facture(int idF, int anF, int moisF, String nomF, String idHabitation) {
		super();
		this.idF = idF;
		this.anF = anF;
		this.moisF = moisF;
		this.nomF = nomF;
		this.idHabitation = idHabitation;
	}
	public Facture(int anF, int moisF, String nomF, String idHabitation) {
		super();
		this.anF = anF;
		this.moisF = moisF;
		this.nomF = nomF;
		this.idHabitation = idHabitation;
	}
	public int getIdF() {
		return idF;
	}
	public void setIdF(int idF) {
		this.idF = idF;
	}
	public int getAnF() {
		return anF;
	}
	public void setAnF(int anF) {
		this.anF = anF;
	}
	public int getMoisF() {
		return moisF;
	}
	public void setMoisF(int moisF) {
		this.moisF = moisF;
	}
	public String getNomF() {
		return nomF;
	}
	public void setNomF(String nomF) {
		this.nomF = nomF;
	}
	public String getIdHabitation() {
		return idHabitation;
	}
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	@Override
	public String toString() {
		return "Facture [idF=" + idF + ", anF=" + anF + ", moisF=" + moisF + ", nomF=" + nomF + ", idHabitation="
				+ idHabitation + "]";
	}
}
