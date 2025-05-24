package Dao;

import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UtenteDao {

    private EntityManager em;

    public UtenteDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }


    public void salvaUtente(Utente utente){
        em.getTransaction().begin(); //inizio la transazione

        em.persist(utente);

        em.getTransaction().commit();//il salvataggio effettivo avverrà solo al commit
    }


    public Utente getByNumeroTessera(int numeroTessera){
        return em.find(Utente.class,numeroTessera);
    }

    public void rimuoviUtente(int numeroTessera){
       Utente u = getByNumeroTessera(numeroTessera);

        if(u!=null){
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Utente con numero di tessera " + numeroTessera+ " non trovato");
        }
    }

}
