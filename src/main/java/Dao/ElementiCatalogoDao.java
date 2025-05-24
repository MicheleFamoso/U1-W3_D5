package Dao;

import entities.ElementiCatalogo;
import entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ElementiCatalogoDao {
private EntityManager em;

    public ElementiCatalogoDao() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void salvaElemento(ElementiCatalogo elemento){
        em.getTransaction().begin();

        em.persist(elemento);

        em.getTransaction().commit();
    }

    public ElementiCatalogo getByISBN(int codiceISBN){
        return em.find(ElementiCatalogo.class,codiceISBN);
    }

    public void rimuoviElemento(int codiceISBN){
       ElementiCatalogo el = getByISBN(codiceISBN);

        if(el!=null){
            em.getTransaction().begin();
            em.remove(el);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Elemento con isbn " + codiceISBN+ " non trovato");
        }
    }

    public List<ElementiCatalogo> getByAnno(int anno) {
        return em.createQuery("SELECT e FROM ElementiCatalogo e WHERE EXTRACT(YEAR FROM e.annoPubblicazione) = :anno", ElementiCatalogo.class)
                .setParameter("anno", anno)
                .getResultList();
    }

    public List<Libro> getByAutore(String autore) {
        return em.createQuery("SELECT l FROM Libro l WHERE LOWER(l.autore) = LOWER(:autore)", Libro.class)
                .setParameter("autore", autore)
                .getResultList();
    }

    public List<ElementiCatalogo> getByTitoloParziale(String titolo) {
        return em.createQuery("SELECT e FROM ElementiCatalogo e WHERE LOWER(e.titolo) LIKE LOWER(:titolo)", ElementiCatalogo.class)
                .setParameter("titolo", "%" + titolo + "%")
                .getResultList();
    }


}
