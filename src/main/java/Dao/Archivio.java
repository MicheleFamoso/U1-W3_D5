package Dao;

import entities.ElementiCatalogo;
import entities.Libro;
import entities.Prestito;
import entities.Utente;

import java.util.List;

public class Archivio {

    private  ElementiCatalogoDao elementiDao = new ElementiCatalogoDao();
    private  PrestitoDao prestitoDao = new PrestitoDao();
    private  UtenteDao utenteDao = new UtenteDao();

    public Archivio() {
    }

    // Aggiunta elemento
    public void aggiungiElemento(ElementiCatalogo elemento) {
        elementiDao.salvaElemento(elemento);
    }

    //  Rimozione per ISBN
    public void rimuoviElemento(int codiceISBN) {
        elementiDao.rimuoviElemento(codiceISBN);
    }

    //  Ricerca per ISBN
    public ElementiCatalogo cercaPerISBN(int codiceISBN) {
        return elementiDao.getByISBN(codiceISBN);
    }

    // Ricerca per anno pubblicazione
    public List<ElementiCatalogo> cercaPerAnno(int anno) {
        return elementiDao.getByAnno(anno);
    }

    //  Ricerca per autore
    public List<Libro> cercaPerAutore(String autore) {
        return elementiDao.getByAutore(autore);
    }

    //   Ricerca per titolo
    public List<ElementiCatalogo> cercaPerTitolo(String titolo) {
        return elementiDao.getByTitoloParziale(titolo);
    }

    //  Prestiti attivi di un utente
    public List<ElementiCatalogo> getPrestitiAttiviUtente(int numeroTessera) {
        return prestitoDao.getPrestitiAttiviByUtente(numeroTessera);
    }

    //  Prestiti scaduti e non restituiti
    public List<Prestito> getPrestitiScaduti() {
        return prestitoDao.getPrestitiScadutiNonRestituiti();
    }

    //  Aggiungi utente
    public void aggiungiUtente(Utente utente) {
        utenteDao.salvaUtente(utente);
    }

    //  utente per numero tessera
    public Utente getUtente(int numeroTessera) {
        return utenteDao.getByNumeroTessera(numeroTessera);
    }

    //  Aggiungi prestito
    public void aggiungiPrestito(Prestito prestito) {
        prestitoDao.salvaPrestito(prestito);
    }
}
