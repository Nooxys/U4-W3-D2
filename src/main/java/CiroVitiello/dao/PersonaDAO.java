package CiroVitiello.dao;

import CiroVitiello.entities.Persona;
import CiroVitiello.exceptions.NoEventsFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {

    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println(persona.getName() + " was saved successfully");
    }

    public Persona findEventByID(UUID personaid) {
        Persona persona = em.find(Persona.class, personaid);
        if (persona == null) throw new NoEventsFoundException(personaid);
        return persona;
    }

    public void delete(UUID personaid) {
        Persona found = this.findEventByID(personaid);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The person " + found.getId() + " was removed successfully");

    }
}
