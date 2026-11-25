/*Questa classe serve per generare una richiesta da parte dell'utente
Ovviamente, per poter generare la richiesta, è necessario avere a disposizione dei dati.
Verranno affrontati qui sotto i dettagli dell'implementazione.
Come al solito, vengono inclusi i package e le librerie necessarie all'esecuzione*/
package com.Engineering.prova.api.dto;
import com.Engineering.prova.domain.model.Priority;
import com.Engineering.prova.domain.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

    @SuppressWarnings("all")//per evitare falsi positivi durante la compilazione
    public class CreateTaskRequest {
        /* Qui sotto vengono definiti i parametri principali per creare un task.
        * nel caso dell'id e dek titolo, è obbligatorio l'inserimento.
        In questo caso, il titolo dev'essere di almeno 3 caratteri,e di non più 120 caratteri*/
        @NotNull(message = "L'id del progetto è obbligatorio")
        private Long idProgetto;

        @NotBlank(message = "Il titolo è obbligatorio")
        @Size(min = 3, max = 120, message = "Il titolo deve essere tra 3 e 120 caratteri")
        private String titolo;
// qui sotto vengono definite tutte le altre variabili ausiliarie
// anche in questo caso le variabili non sono direttamente acessibili dall'utente
        private String descrizione;
        private TaskStatus stato;
        private Priority priorita;
        private LocalDate scadenza;
// qui viene definito il costruttore
        public CreateTaskRequest() {
        }
/* Qui sotto abbiamo i soliti metodi get e set.
 Questi metodi sono neccessari in quanto, senza di essi, l'utente non potrebbe modificare o inserire i parametri per creare il task*/
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
    }

