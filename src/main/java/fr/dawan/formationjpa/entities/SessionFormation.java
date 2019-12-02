package fr.dawan.formationjpa.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SessionFormation extends DbObject {
	
	private String lieu;
	
	private LocalDate dateDebut;
	
	private int nbPlacesMaxi;
	
	private int nbPlaces;
	
//	@ManyToOne(cascade= CascadeType.PERSIST)
	@ManyToOne
	private Formation formation;
	
	@ManyToOne
	private Formateur formateur;

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate date) {
		this.dateDebut = date;
	}

	public int getNbPlacesMaxi() {
		return nbPlacesMaxi;
	}

	public void setNbPlacesMaxi(int nbPlacesMaxi) {
		this.nbPlacesMaxi = nbPlacesMaxi;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public String toString() {
		return "SessionFormation [lieu=" + lieu + ", dateDebut=" + dateDebut + ", nbPlacesMaxi=" + nbPlacesMaxi
				+ ", nbPlaces=" + nbPlaces + ", formation=" + formation + ", formateur=" + formateur + "]";
	}

	
}
