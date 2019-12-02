package fr.dawan.formationjpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Formation extends DbObject {
	private String nom;
	private String code;
	
	@Column(scale=2, precision=2)
	private double prix;
	private int duree;
	
	@ManyToMany(mappedBy="competences")
	private List<Formateur> formateursCompetents = new ArrayList<>();

	//@OneToMany(mappedBy="formation", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@OneToMany(mappedBy="formation", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<SessionFormation> sessions = new ArrayList<>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public List<SessionFormation> getSessions() {
		// renvoie une copie de la collection
		return new ArrayList<SessionFormation>(sessions);
		
//		List<SessionFormation> copie = new ArrayList<SessionFormation>(); 
//		for (SessionFormation sessionFormation : sessions) {
//			copie.add(sessionFormation);
//		}
//		
//		return copie;
	}

	public void addSession(SessionFormation session) {
		if (!sessions.contains(session) && session != null) {
			this.sessions.add(session);
		}
	}

	public void removeSession(SessionFormation session) {
		this.sessions.remove(session);
	}
	
	public List<Formateur> getFormateursCompetents(){
		return new ArrayList<>(formateursCompetents);
	}
	
	public void addFormateurCompetent(Formateur f) {
		formateursCompetents.add(f);
	}
	
	public void removeFormateurCompetent(Formateur f) {
		formateursCompetents.remove(f);
	}

	@Override
	public String toString() {
		return "Formation [nom=" + nom + ", code=" + code + ", prix=" + prix + ", duree=" + duree + ", id=" + getId() + "]";
	}

	
}
