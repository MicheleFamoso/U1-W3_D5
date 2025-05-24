package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "elementi_catalogo")
public abstract class ElementiCatalogo {
    @Id
    @GeneratedValue
    private int codiceISBN;
    private String titolo;
    @Column(name="anno_pubblicazione")
    private LocalDate annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;

    @OneToMany(mappedBy = "elementoPrestato")
    private List<Prestito> prestiti;


//Costruttori

    public ElementiCatalogo( String titolo, LocalDate annoPubblicazione, int numeroPagine) {

        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public ElementiCatalogo() {
    }

    //Get Set


    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(int codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    //ToString

    @Override
    public String toString() {
        return "ElementiCatalogo{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
