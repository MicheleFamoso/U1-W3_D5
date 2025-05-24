import Dao.Archivio;
import entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        Scanner scanner = new Scanner(System.in);

        // Aggiunta utenti
        Utente utente1 = new Utente("Goku", "Son", LocalDate.of(1980, 5, 20));
        Utente utente2 = new Utente("Vegeta", "Vegeta", LocalDate.of(1995, 3, 15));
        archivio.aggiungiUtente(utente1);
        archivio.aggiungiUtente(utente2);

        // Aggiunta libri
        Libro libro1 = new Libro("Il nome di Namek", LocalDate.of(1380, 1, 1), 500, "Freezer", "Storico");
        Libro libro2 = new Libro("Il leggendario Super Sayan", LocalDate.of(1909, 6, 8), 300, "Goku", "Distopico");
        archivio.aggiungiElemento(libro1);
        archivio.aggiungiElemento(libro2);

        // Aggiunta riviste
        Rivista rivista1 = new Rivista("National Geographic", LocalDate.of(2024, 4, 1), 120, Enumeration.Periodicita.MENSILE);
        Rivista rivista2 = new Rivista("Time", LocalDate.of(2024, 5, 1), 90, Enumeration.Periodicita.SETTIMANALE);
        archivio.aggiungiElemento(rivista1);
        archivio.aggiungiElemento(rivista2);

        // Aggiunta prestiti
        Prestito prestito1 = new Prestito(utente1, libro1, LocalDate.now().minusDays(10), null);
        Prestito prestito2 = new Prestito(utente2, rivista1, LocalDate.now().minusDays(40), LocalDate.now().minusDays(5));
        archivio.aggiungiPrestito(prestito1);
        archivio.aggiungiPrestito(prestito2);

        int scelta;
        do {
            System.out.println("Scegli cosa vuoi fare:");
            System.out.println("1 - Ricerca per ISBN");
            System.out.println("2 - Ricerca per anno pubblicazione");
            System.out.println("3 - Ricerca per autore");
            System.out.println("4 - Ricerca per titolo o parte di esso");
            System.out.println("5 - Ricerca degli elementi attualmente in prestito (numero tessera)");
            System.out.println("6 - Ricerca di tutti i prestiti scaduti e non restituiti");
            System.out.println("0 - Esci");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci ISBN: ");
                    int isbn = scanner.nextInt();
                    System.out.println(archivio.cercaPerISBN(isbn));
                    break;
                case 2:
                    System.out.print("Inserisci anno di pubblicazione: ");
                    int anno = scanner.nextInt();
                    System.out.println(archivio.cercaPerAnno(anno));
                    break;
                case 3:
                    System.out.print("Inserisci autore: ");
                    String autore = scanner.nextLine();
                    System.out.println(archivio.cercaPerAutore(autore));
                    break;
                case 4:
                    System.out.print("Inserisci titolo o parte di esso: ");
                    String titolo = scanner.nextLine();
                    System.out.println(archivio.cercaPerTitolo(titolo));
                    break;
                case 5:
                    System.out.print("Inserisci numero tessera utente: ");
                    int tessera = scanner.nextInt();
                    System.out.println(archivio.getPrestitiAttiviUtente(tessera));
                    break;
                case 6:
                    System.out.println("Prestiti scaduti e non restituiti:");
                    System.out.println(archivio.getPrestitiScaduti());
                    break;
                case 0:
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }

        } while (scelta != 0);


    }
}