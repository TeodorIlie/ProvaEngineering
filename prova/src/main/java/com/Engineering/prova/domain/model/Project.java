// Includiamo i package e le librerie necessarie all'esecuzione.
//java.time.Instant include la funzione per rilevare il tempo di inserimento dei dati (timestamp)
package com.Engineering.prova.domain.model;
import java.time.Instant;

/*
   Rappresenta il modello interno di un Project.
   Include l'id generato dal sistema, il codice, il nome e il timestamp di creazione.
   I campi sono private per garantire l'incapsulamento (nessun accesso diretto dall'esterno).
   Il modificatore final rende l'oggetto immutabile: una volta valorizzati nel costruttore,
   i campi non possono più essere modificati.
 */
public class Project {
    private final Long id;
    private final String Codiceordine;
    private final String NomeUtente;
    private final Instant timestamp;
    /*
     * Qui abbiamo il costruttore. Una volta che l'utente invia codice e nome (tramite CreateProjectRequest),
     * il ProjectService genera id e timestamp e chiama questo costruttore per creare l'istanza di Project.
     * Infine, i dati vengono copiati in ProjectResponse per restituirli al client.
     */
    public Project(Long id, String Codiceordine, String NomeUtente, Instant timestamp) {
        this.id = id;
        this.Codiceordine = Codiceordine;
        this.NomeUtente = NomeUtente;
        this.timestamp = timestamp;
    }
    /* Qui abbiamo il metodi get, in quanto, come specificato prima, l'utente non deve avere accesso diretto alle variabili.
    * Questi metodi servono per leggere i dati che abbiamo inserito tramite costruttore*/
    public Long getId() {
        return this.id;
    }

    public String getCode() {
        return this.Codiceordine;
    }

    public String getNomeUtente() {
        return this.NomeUtente;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }
}