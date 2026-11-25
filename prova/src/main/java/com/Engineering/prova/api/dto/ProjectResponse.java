/*
   Questa classe rappresenta i dati restituiti all'utente tramite i metodi get.
   La libreria Jackson traduce automaticamente l'oggetto Java ProjectResponse (creato dal ProjectService
   e restituito dal Controller) in formato JSON nella risposta HTTP.
   Il formato JSON permette al client di ricevere e leggere i dati indipendentemente dal linguaggio
   di programmazione o dal sistema operativo utilizzato.
 */
package com.Engineering.prova.api.dto;

import java.time.Instant;

public class ProjectResponse {
    private final Long id;
    private final String CodiceOrdine;
    private final String NomeUtente;
    private final Instant timestamp;

    public ProjectResponse(Long id, String codiceOrdine, String nomeUtente, Instant timestamp) {
        this.id = id;
        this.CodiceOrdine = codiceOrdine;
        this.NomeUtente = nomeUtente;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return this.id;
    }

    public String getCodiceOrdine() {
        return this.CodiceOrdine;
    }

    public String getNomeUtente() {
        return this.NomeUtente;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }
}