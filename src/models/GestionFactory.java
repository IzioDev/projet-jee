package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GestionFactory {

	private static final HashMap<Integer, Etudiant> listEtudiants = intializeListEtudiants();
	private static final HashMap<Integer, Integer> listEtudiantAbsence = intializelistEtudiantAbsence();
	private static final HashMap<Integer, Integer> listEtudiantNote = intializelistEtudiantNotes();

	// Initialisation des étudiants
	private static HashMap<Integer, Etudiant> intializeListEtudiants() {

		// Création des étudiants
		Etudiant etu1 = new Etudiant(0, "Francis", "Brunet-Manquat");
		Etudiant etu2 = new Etudiant(1, "Philippe", "Martin");

		HashMap<Integer, Etudiant> listEtudiantsTemp = new HashMap<>();
		listEtudiantsTemp.put(etu1.getId(), etu1);
		listEtudiantsTemp.put(etu2.getId(), etu2);

		return listEtudiantsTemp;
	}

	// Initialisation des absences
	private static final HashMap<Integer, Integer> intializelistEtudiantAbsence() {

		// Association etudiant id -> absences
		HashMap<Integer, Integer> listEtudiantAbsenceTemp = new HashMap<>();
		listEtudiantAbsenceTemp.put(listEtudiants.get(0).getId(), 0);
		listEtudiantAbsenceTemp.put(listEtudiants.get(1).getId(), 7);

		return listEtudiantAbsenceTemp;
	}
	// Initialisation des absences
	private static final HashMap<Integer, Integer> intializelistEtudiantNotes() {

		// Association etudiant id -> absences
		HashMap<Integer, Integer> listEtudiantNotesTemp = new HashMap<>();

		listEtudiantNotesTemp.put(listEtudiants.get(0).getId(), 18);

		listEtudiantNotesTemp.put(listEtudiants.get(1).getId(), 1200);

		return listEtudiantNotesTemp;
	}


	// Donne l'ensemble des etudiants
	public static Collection<Etudiant> getEtudiants() {
		HashMap<Integer, Etudiant> etudiantHashMap = new HashMap<>();
		for (Etudiant etu: listEtudiants.values()) {
			etu.setMean(getNotesByEtudiantId(etu.getId()));
			etu.setNbAbsence(getAbsencesByEtudiantId(etu.getId()));
			etudiantHashMap.put(etu.getId(), etu);
		}
		return etudiantHashMap.values();
	}

	// Donne l'ensemble des etudiants
	public static Etudiant getEtudiantById(int id) {
		Etudiant etu = listEtudiants.get(id);
		etu.setNbAbsence(getAbsencesByEtudiantId(id));
		etu.setMean(getNotesByEtudiantId(id));
		return listEtudiants.get(id);
	}

	// Donne le nombre d'absences d'un etudiant à l'aide de son id
	public static Integer getAbsencesByEtudiantId(int id) {
		return listEtudiantAbsence.get(id);
	}

	public static Integer getNotesByEtudiantId(int id) {
		return listEtudiantNote.get(id);
	}
}
