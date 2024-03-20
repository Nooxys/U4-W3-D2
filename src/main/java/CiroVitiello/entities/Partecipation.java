package CiroVitiello.entities;

import CiroVitiello.enums.StatoPartecipazione;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipation")
public class Partecipation {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "name")
    private Persona persona;
    @OneToOne
    @JoinColumn(name = "event", nullable = false, unique = true)
    private Evento evento;
    @Column(name = "state_of_partecipation")
    @Enumerated(EnumType.STRING)
    private StatoPartecipazione statoPartecipazione;


    public Partecipation() {

    }

    public Partecipation(Persona persona, Evento evento, StatoPartecipazione statoPartecipazione) {
        this.persona = persona;
        this.evento = evento;
        this.statoPartecipazione = statoPartecipazione;
    }

    public UUID getId() {
        return id;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStatoPartecipazione() {
        return statoPartecipazione;
    }

    public void setStatoPartecipazione(StatoPartecipazione statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }

    @Override
    public String toString() {
        return "Partecipation{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", statoPartecipazione=" + statoPartecipazione +
                '}';
    }
}
