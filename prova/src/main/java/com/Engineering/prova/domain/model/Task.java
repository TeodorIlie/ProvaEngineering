/*
La classe seguente racchiude i parametri di una richiesta.
In primo luogo vengono aggiunte le librerie e i package per la corretta esecuzione.
*/

package com.Engineering.prova.domain.model;

import java.time.Instant;
import java.time.LocalDate;

@SuppressWarnings("all")//per evitare falsi positivi da parte del compilatore
public class Task {
    /*Qui sotto abbiamo tutte le variabili che descrivono il processo.
    Tra queste abbiamo l'id, il timestamp, la priorità, la descrizione, lo stato...
    Tra quesdti parametri, i cui nomi sono abbastanza esplicativi, abbiamo i timestamp di creazione e aggiornamento,nonché la scadenza*/
    private Long id;
    private Long idProgetto;
    private String titolo;
    private String descrizione;
    private TaskStatus stato;
    private Priority priorita;
    private LocalDate scadenza;
    private Instant creatoIl;
    private Instant aggiornatoIl;

    //I costruttori per inizializzare i valori del task.
    //entrambi accessibili dall'utente (public).

    public Task() {
    }

    public Task(Long id, Long idProgetto, String titolo, String descrizione,
                TaskStatus stato, Priority priorita, LocalDate scadenza,
                Instant creatoIl, Instant aggiornatoIl) {
        this.id = id;
        this.idProgetto = idProgetto;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.stato = stato;
        this.priorita = priorita;
        this.scadenza = scadenza;
        this.creatoIl = creatoIl;
        this.aggiornatoIl = aggiornatoIl;
    }
/*Qui sotto troviamo i metodi get e set.
 Come abbiamo visto sopra, le variabili sono di tipo private.
 Di conseguenza, non possiamo scrivere o leggere direttamente su di esse.
 I metodi get e set consentono di leggere e scrivere su di esse senza accedervi direttamente*/
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProgetto() {
        return this.idProgetto;
    }

    public void setIdProgetto(Long idProgetto) {
        this.idProgetto = idProgetto;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TaskStatus getStato() {
        return this.stato;
    }

    public void setStato(TaskStatus stato) {
        this.stato = stato;
    }

    public Priority getPriorita() {
        return this.priorita;
    }

    public void setPriorita(Priority priorita) {
        this.priorita = priorita;
    }

    public LocalDate getScadenza() {
        return this.scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public Instant getCreatoIl() {
        return this.creatoIl;
    }

    public void setCreatoIl(Instant creatoIl) {
        this.creatoIl = creatoIl;
    }

    public Instant getAggiornatoIl() {
        return this.aggiornatoIl;
    }

    public void setAggiornatoIl(Instant aggiornatoIl) {
        this.aggiornatoIl = aggiornatoIl;
    }
}