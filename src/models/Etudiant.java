package models;

public class Etudiant {
	
	private Integer id;
	private String prenom;
	private String nom;
	private int nbAbsence;
	private int mean;
	
	public Etudiant() {
		super();
	}

	public Etudiant(Integer id, String prenom, String nom) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbAbsence() {
		return nbAbsence;
	}

	public void setNbAbsence(int nbAbsence) {
		this.nbAbsence = nbAbsence;
	}

	public int getMean() {
		return mean;
	}

	public void setMean(int mean) {
		this.mean = mean;
	}
}
