package CiroVitiello.dao;

import CiroVitiello.entities.Evento;
import CiroVitiello.exceptions.NoEventsFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento event) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("The event " + event.getTitolo() + " was saved successfully");
    }

    public Evento findEventByID(UUID eventID) {
        Evento event = em.find(Evento.class, eventID);
        if (event == null) throw new NoEventsFoundException(eventID);
        return event;
    }

    public void deleteEvent(UUID eventID) {
        Evento found = this.findEventByID(eventID);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The event " + found.getId() + " was removed successfully");

    }

}
