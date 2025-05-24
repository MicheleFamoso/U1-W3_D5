package entities;

import Enumeration.Periodicita;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "riviste")
public class Rivista extends ElementiCatalogo{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    //Costruttori


    public Rivista(String titolo, LocalDate annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Rivista() {

    }

    //Get e Set

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    //ToString

    @Override
    public String toString() {
        return "Rivista{" +
                super.toString()+
                "periodicita=" + periodicita +
                '}';
    }
}
