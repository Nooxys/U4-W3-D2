package CiroVitiello.entities;

import CiroVitiello.enums.SessoPersona;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Persona {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String cognome;
    @Column(name = "email")
    private String email;
    @Column(name = "date_of_birth")

    private Date datadinascita;
    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private SessoPersona sesso;
    @OneToMany(mappedBy = "persona")
    @Column(name = "partecipations_list")

    private List<Partecipation> listapartecipazioni;

    public Persona() {

    }

    public Persona(String name, String cognome, String email, Date datadinascita, SessoPersona sesso, List<Partecipation> listapartecipazioni) {
        this.name = name;
        this.cognome = cognome;
        this.email = email;
        this.datadinascita = datadinascita;
        this.sesso = sesso;
        this.listapartecipazioni = listapartecipazioni;
    }

    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatadinascita() {
        return datadinascita;
    }

    public void setDatadinascita(Date datadinascita) {
        this.datadinascita = datadinascita;
    }

    public SessoPersona getSesso() {
        return sesso;
    }

    public void setSesso(SessoPersona sesso) {
        this.sesso = sesso;
    }

    public List<Partecipation> getListapartecipazioni() {
        return listapartecipazioni;
    }

    public void setListapartecipazioni(List<Partecipation> listapartecipazioni) {
        this.listapartecipazioni = listapartecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", datadinascita=" + datadinascita +
                ", sesso=" + sesso +
                ", listapartecipazioni=" + listapartecipazioni +
                '}';
    }
}
