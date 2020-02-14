package models;

import javax.persistence.EntityManager;

public class NoteDAO {

  public static Note retrieveById(int id) {

    // Creation de l'entity manager
    EntityManager em = GestionFactory.factory.createEntityManager();

    Note note = em.find(Note.class, id);

    // Close the entity manager
    em.close();

    return note;
  }

  public static Note create(Etudiant etudiant, float montant) {

    // Creation de l'entity manager
    EntityManager em = GestionFactory.factory.createEntityManager();

    em.getTransaction().begin();

    // create new etudiant
    Note note = new Note();
    note.setEtudiant(etudiant);
    note.setAmount(montant);
    em.persist(note);

    // Commit
    em.getTransaction().commit();

    // Close the entity manager
    em.close();

    return note;
  }
}
