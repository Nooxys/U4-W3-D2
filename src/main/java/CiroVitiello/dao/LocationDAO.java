package CiroVitiello.dao;

import CiroVitiello.entities.Location;
import CiroVitiello.exceptions.NoEventsFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("The location " + location.getNome() + " was saved successfully");
    }

    public Location findEventByID(UUID locationID) {
        Location location = em.find(Location.class, locationID);
        if (location == null) throw new NoEventsFoundException(locationID);
        return location;
    }

    public void delete(UUID locationID) {
        Location found = this.findEventByID(locationID);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The location " + found.getId() + " was removed successfully");

    }

}
