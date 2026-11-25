/* Questa classe è progettata per restituire maggiori informazioni riguardo un errore.
 Spesso e volentieri, il server può essere inaccessibile.
 La risorsa che stiamo cercando potrebbe essere inesistente oppure inaccessibile al momento.
 Per rendere il debug più semplice, questa classe fornisce maggiori informazioni sull'errore.
 La data, l'ora, un eventuale messaggio e il tipo di errore*/
//come al solito si parte dai package necessari.
package com.Engineering.prova.api.exception;

import java.time.Instant;

@SuppressWarnings("all")// evita falsi positivi da parte del debug
public class ApiErrorResponse {
//qui sotto vengono definiti i parametri neccessari, come al solito, non direttamente accessibili da parte dell'utente
    private Instant dataOra;
    private int stato;
    private String messaggio;
    private String percorso;
//qui vengono definiti i costruttori, con cui poter inizializzare il valore delle variabili
    public ApiErrorResponse() {
    }

    public ApiErrorResponse(Instant dataOra, int stato, String messaggio, String percorso) {
        this.dataOra = dataOra;
        this.stato = stato;
        this.messaggio = messaggio;
        this.percorso = percorso;
    }
/* per fare in modo che un utente possa inserire i dati, vengono definiti anche qui i metodi get e set per ogni singola variabile.*/
    public Instant getDataOra() {
        return this.dataOra;
    }

    public void setDataOra(Instant dataOra) {
        this.dataOra = dataOra;
    }

    public int getStato() {
        return this.stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public String getMessaggio() {
        return this.messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getPercorso() {
        return this.percorso;
    }

    public void setPercorso(String percorso) {
        this.percorso = percorso;
    }
}
