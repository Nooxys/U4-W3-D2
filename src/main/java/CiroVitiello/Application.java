package CiroVitiello;

import CiroVitiello.dao.EventoDAO;
import CiroVitiello.entities.Evento;
import CiroVitiello.exceptions.NoEventsFoundException;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2");


    public static void main(String[] args) {
        Faker faker = new Faker();
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);

        //          CREAZIONE EVENTI CON AGGIUNTA A DB


//        for (int i = 0; i < 25; i++) {
//            Random random = new Random();
//            int randomP = random.nextInt(100, 500);
//            eventoDAO.save(new Evento(faker.esports().event(), LocalDate.now(), faker.leagueOfLegends().quote(), TipoEventoE.randomTipoEvento(), randomP));
//        }

        //         RICERCA SU DB

        try {
            Evento prova = eventoDAO.findEventByID(4);
            System.out.println(prova);

        } catch (NoEventsFoundException exception) {
            System.out.println(exception.getMessage());
        }


        //        ELIMIAN DA DB

        try {
            eventoDAO.deleteEvent(1);
        } catch (NoEventsFoundException exception) {
            System.out.println(exception.getMessage());
        }

        em.close();
        emf.close();

    }
}
