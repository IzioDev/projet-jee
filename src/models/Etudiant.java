package models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entity implementation class for Entity: Groupe
 *
 */
@Entity
public class Etudiant implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String prenom;
	
	@Column(nullable=false)
	private String nom;

	private int nbAbsences;
	
	@ManyToOne
	private Groupe groupe;

	@OneToMany(mappedBy="etudiant", fetch= FetchType.LAZY)
	private List<Note> notes;
	
	private static final long serialVersionUID = 1L;

	public Etudiant() {
		super();
		nbAbsences = 0;
	}  
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Groupe getGroupe() {
		return this.groupe;
	}
	
	public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
        if (!groupe.getEtudiants().contains(this)) {
        	groupe.getEtudiants().add(this);
        }
    }
	
	public int getNbAbsences() {
		return nbAbsences;
	}

	public void setNbAbsences(int nbAbsences) {
		this.nbAbsences = nbAbsences;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void addNote(Note note) {
		if (!notes.contains(note)) {
			notes.add(note);
			note.setEtudiant(this);
		}
	}

	public void removeNote(Note note) {
			this.notes.remove(note);
	}

	public float getMoyenne() {

		if (this.notes.size() == 0 ) {
			return -1;
		}
		float sum = 0;

		for (Note note: this.notes) {
			sum += note.getAmount();
		}

		return (float) Math.ceil((sum / this.notes.size() ) * 100) / 100;
	}
   
	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getPrenom() + " " + this.getNom();
	}
}
