package CiroVitiello.dao;

import CiroVitiello.entities.Partecipation;
import CiroVitiello.exceptions.NoEventsFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipationDAO {
    private final EntityManager em;

    public PartecipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipation partecipazione) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("the partecipation " + partecipazione.getId() + " was saved successfully");
    }

    public Partecipation findEventByID(UUID partecipationid) {
        Partecipation partecipazione = em.find(Partecipation.class, partecipationid);
        if (partecipazione == null) throw new NoEventsFoundException(partecipationid);
        return partecipazione;
    }

    public void delete(UUID partecipazioneid) {
        Partecipation found = this.findEventByID(partecipazioneid);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The partecipation " + found.getId() + " was removed successfully");

    }
}
