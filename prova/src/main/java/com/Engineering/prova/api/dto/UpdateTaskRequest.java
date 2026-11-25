/*Questa classe è utilizzata per aggiornare dati che abbiamo già inserito tramite Create TaskRequest
Come al solito si parte dall'impiego delle librerie e dei package.*/
package com.Engineering.prova.api.dto;

import com.Engineering.prova.domain.model.Priority;
import com.Engineering.prova.domain.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@SuppressWarnings("all")
public class UpdateTaskRequest {
// Similmente a quanto visto nella classe CreateTaskRequest, Si pate con l'id ed il titolo. Valgono gli stessi vincoli descritti precedentemente.
    @NotBlank(message = "Il titolo è obbligatorio")
    @Size(min = 3, max = 120, message = "Il titolo deve essere tra 3 e 120 caratteri")
    private String titolo;
/*In questo caso, dato che il processo è già stato creato
 se non fosse presente, è neccessario inserire lo stato ed la priorità.
 Tutti gli altri parametri invece sono opzionali*/
    private String descrizione;

    @NotNull(message = "Lo stato è obbligatorio")
    private TaskStatus stato;

    @NotNull(message = "La priorità è obbligatoria")
    private Priority priorita;

    private LocalDate scadenza;
/* Anche in questo caso, dato che le variabili sono private,
 è neccessario usare i metodi get e set per accedervi.
 Qui sotto inoltre troviamo il costruttore*/
    public UpdateTaskRequest() {
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
