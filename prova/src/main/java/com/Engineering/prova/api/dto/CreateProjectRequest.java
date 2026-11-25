/*
    Anche qui inseriamo il package e le librerie necessarie al funzionamento.
    In particolare, importiamo le annotazioni di Bean Validation per verificare che
    i dati inviati dall'utente (codice e nome) non siano vuoti e rispettino i vincoli di lunghezza.
    Con questo record definiamo il contratto dei dati in ingresso consentiti.
 */
/*
    Anche qui inseriamo il package e le librerie necessarie al funzionamento.
    In particolare, importiamo le annotazioni di Bean Validation per verificare che
    i dati inviati dall'utente (codice e nome) non siano vuoti e rispettino i vincoli di lunghezza.
    Con questa classe definiamo il contratto dei dati in ingresso consentiti.
 */
package com.Engineering.prova.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateProjectRequest {

        @NotBlank(message = "Il codice è obbligatorio!")
        @Size(min = 3, max = 20, message = "Il codice deve essere tra 3 e 20 caratteri!")
        private String codiceP;

        @NotBlank(message = "Il nome è obbligatorio!")
        private String nome;

        // Costruttori utilizzati per inizializzare la richiesta dall'utente.
        // In questo caso, l'utente inserisce codice e nome.
        // La richiesta viene inviata al Service Request.
        // I costruttori sono pubblici, l'utente può accederci.
        public CreateProjectRequest() {
        }

        public CreateProjectRequest(String codiceP, String nome) {
                this.codiceP = codiceP;
                this.nome = nome;
        }

        // Metodi per leggere e scrivere i nomi e i codici dei progetti

        public String getCodiceP() {
                return this.codiceP;
        }

        public void setCodiceP(String codiceP) {
                this.codiceP = codiceP;
        }

        public String getNome() {
                return this.nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }


}