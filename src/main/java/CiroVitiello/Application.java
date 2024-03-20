package CiroVitiello;

import CiroVitiello.dao.EventoDAO;
import CiroVitiello.dao.LocationDAO;
import CiroVitiello.dao.PartecipationDAO;
import CiroVitiello.dao.PersonaDAO;
import CiroVitiello.entities.Evento;
import CiroVitiello.entities.Location;
import CiroVitiello.enums.TipoEventoE;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2");


    public static void main(String[] args) {
        Faker faker = new Faker();
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipationDAO partecipationDAO = new PartecipationDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);

        //          CREAZIONE EVENTI CON AGGIUNTA A DB

        locationDAO.save(new Location("priova", "prova"));
        eventoDAO.save(new Evento("prova titolo", LocalDate.now(), "prova descrizione", TipoEventoE.randomTipoEvento(), 500, locationDAO.findEventByID("7f5b7b6a-24f2-47fb-b51c-bade0de5d861")));

//        for (int i = 0; i < 25; i++) {
//            Random random = new Random();
//            int randomP = random.nextInt(100, 500);
//            eventoDAO.save(new Evento(faker.esports().event(), LocalDate.now(), faker.leagueOfLegends().quote(), TipoEventoE.randomTipoEvento(), randomP));
//        }

        //         RICERCA SU DB

//        try {
//            Evento prova = eventoDAO.findEventByID(UUID.fromString("0c67cdc7-359f-42c2-8198-c8404e26e50d"));
//            System.out.println(prova);
//
//        } catch (NoEventsFoundException exception) {
//            System.out.println(exception.getMessage());
//        }


        //        ELIMIAN DA DB

//        try {
//            eventoDAO.deleteEvent(UUID.fromString("0c67cdc7-359f-42c2-8198-c8404e26e50d"));
//        } catch (NoEventsFoundException exception) {
//            System.out.println(exception.getMessage());
//        }

        em.close();
        emf.close();

    }
}
