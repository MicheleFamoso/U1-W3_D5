package Dao;

import entities.ElementiCatalogo;
import entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PrestitoDao {

    private EntityManager em;

    public PrestitoDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }


    public void salvaPrestito(Prestito prestito){
        em.getTransaction().begin();

        em.persist(prestito);

        em.getTransaction().commit();
    }

    public Prestito getByID(int id){
        return em.find(Prestito.class,id);
    }

    public void rimuoviPrestito(int id){
       Prestito el = getByID(id);

        if(el!=null){
            em.getTransaction().begin();
            em.remove(el);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Prestito con id " + id+ " non trovato");
        }
    }

    public List<ElementiCatalogo> getPrestitiAttiviByUtente(int numeroTessera) {
        return em.createQuery("SELECT p.elementoPrestato FROM Prestito p WHERE p.utente.numeroTessera = :num AND p.dataRestituzioneEffettiva IS NULL", ElementiCatalogo.class)
                .setParameter("num", numeroTessera)
                .getResultList();
    }

    public List<Prestito> getPrestitiScadutiNonRestituiti() {
        return em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista < CURRENT_DATE", Prestito.class)
                .getResultList();
    }




}
