package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "libri")
public class Libro extends ElementiCatalogo{
    private String autore;
    private String genere;


    //Costruttori


    public Libro(String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro() {

    }

    //Get Set


    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    //TOString


    @Override
    public String toString() {
        return "Libro{" +
                super.toString() +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
