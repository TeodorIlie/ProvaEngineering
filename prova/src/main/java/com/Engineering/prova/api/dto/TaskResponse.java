/*La classe TaskRespons è impiegato per restituire all'utente i dati sul task creato
*/
package com.Engineering.prova.api.dto;

import com.Engineering.prova.domain.model.Priority;
import com.Engineering.prova.domain.model.TaskStatus;

import java.time.Instant;
import java.time.LocalDate;

@SuppressWarnings("all")
public class TaskResponse {
//vengono definite le variabili del progetto.
//tutte queste variabili sono di tipo private, quindi, anche in questo caso serviranno i metodi get e set
    private Long id;
    private Long idProgetto;
    private String titolo;
    private String descrizione;
    private TaskStatus stato;
    private Priority priorita;
    private LocalDate scadenza;
    private Instant creatoIl;
    private Instant aggiornatoIl;
//costruttori per inizializzare la classe
    public TaskResponse() {
    }

    public TaskResponse(Long id, Long idProgetto, String titolo, String descrizione,
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
//metodi get e set per restituire o accedere ad una variabile
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