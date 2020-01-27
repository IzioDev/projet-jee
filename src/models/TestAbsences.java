package models;


public class TestAbsences {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
		//
		GestionFactory.open();
		
		// Initialisation
		// Creation des groupes
		Groupe MIAM = GroupeDAO.create("miam");
		Groupe SIMO = GroupeDAO.create("SIMO");
		Groupe MESSI = GroupeDAO.create("MESSI");
		
		// Initialisation
		// Creation des étudiants
		Etudiant FBM = EtudiantDAO.create("Francis", "Brunet-Manquat", MIAM);
		int idFBM = FBM.getId();
		EtudiantDAO.create("Philippe", "Martin", MIAM);
		EtudiantDAO.create("Mario", "Cortes-Cornax", MIAM);
		EtudiantDAO.create("Françoise", "Coat", SIMO);
		EtudiantDAO.create("Laurent", "Bonnaud", MESSI);
		EtudiantDAO.create("Sébastien", "Bourdon", MESSI);
		Etudiant MG = EtudiantDAO.create("Mathieu", "Gatumel", SIMO);
		
		// Retrouver un etudiant par son id
		Etudiant etudiant_TMP = EtudiantDAO.retrieveById(idFBM);
		
		// Modification : ajout d'absences
		etudiant_TMP.setNbAbsences(4);
		EtudiantDAO.update(etudiant_TMP);
		// ou
		EtudiantDAO.addAbsences(idFBM, 4);
		
		// Suppression d'un étudiant
		//EtudiantDAO.remove(MG);
		EtudiantDAO.remove(MG.getId());
		
		// Liste des groupes
		System.out.println("Liste des groupes :");
		for (Groupe groupe : GroupeDAO.getAll()) {
			System.out.println(groupe.getId() + " : " + groupe.getNom() + " (" + groupe.getEtudiants().size() + " étudiant(s)");
		}
		
		// Liste des étudiants
		System.out.println("\nListe des étudiants :");
		for (Etudiant etu : EtudiantDAO.getAll()) {
			System.out.println(etu.getId() + " : " + etu.getPrenom() + " " + etu.getNom() + " " + etu.getGroupe().getNom() + " " + etu.getNbAbsences());
		}
		
		
		// Liste des étudiants par groupe
		for (Groupe groupe : GroupeDAO.getAll()) {
			
			System.out.println("\nListe des étudiants " + groupe.getNom() + " :");
			for (Etudiant etu : groupe.getEtudiants()) {
				System.out.println(etu.getId() + " : " + etu.getPrenom() + " " + etu.getNom() + " " + etu.getGroupe().getNom() + " " + etu.getNbAbsences());
			}
		}
		
		// Liste des étudiants ayant des absences
		System.out.println("\nListe des étudiants ayant des absences :");
		for (Etudiant etu : EtudiantDAO.getAllByAbsences()) {
			System.out.println(etu.getId() + " : " + etu.getPrenom() + " " + etu.getNom() + " " + etu.getGroupe().getNom() + " " + etu.getNbAbsences());
		}
		
		// Destroy entities
		EtudiantDAO.removeAll();
		GroupeDAO.removeAll();
		
		//
		GestionFactory.close();
	}

}
