package CiroVitiello.entities;

import CiroVitiello.enums.TipoEventoE;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Evento {
    @Id
    @GeneratedValue


    private UUID id;
    @Column(name = "title")
    private String titolo;
    @Column(name = "event_date")
    private LocalDate DataEvento;
    @Column(name = "description")
    private String descrizione;
    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    private TipoEventoE tipoevento;
    @Column(name = "max_spectators")
    private int massimoPartecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    
    public Evento() {

    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEventoE tipoevento, int massimoPartecipanti) {

        this.titolo = titolo;
        this.DataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoevento = tipoevento;
        this.massimoPartecipanti = massimoPartecipanti;

    }

    public UUID getId() {
        return id;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return DataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        DataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEventoE getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(TipoEventoE tipoevento) {
        this.tipoevento = tipoevento;
    }

    public int getMassimoPartecipanti() {
        return massimoPartecipanti;
    }

    public void setMassimoPartecipanti(int massimoPartecipanti) {
        this.massimoPartecipanti = massimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", DataEvento=" + DataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoevento=" + tipoevento +
                ", massimoPartecipanti=" + massimoPartecipanti +
                ", location=" + location +
                '}';
    }
}
