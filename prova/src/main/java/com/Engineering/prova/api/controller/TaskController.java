/* Una volta implementate le classi Task Response, Create Task Request e Update Task Request, possiamo utilizzare un unico controller che sfrutti le funzionalità di tutti e tre insieme.
 Task Controller è quindi l'interfaccia che si collega con le tre classi citate, e che fornisce un'implementazione diretta per l'utente*/
package com.Engineering.prova.api.controller;

import com.Engineering.prova.api.dto.CreateTaskRequest;
import com.Engineering.prova.api.dto.TaskResponse;
import com.Engineering.prova.api.dto.UpdateTaskRequest;
import com.Engineering.prova.domain.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@SuppressWarnings("all")
public class TaskController {
// Viene inizializzata un'entità TaskService
    private final TaskService service;
//costruttore del controller, riceve in ingresso un TaskService
    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping//Viene invocato un metodo POST
    @ResponseStatus(HttpStatus.CREATED)// Il seguente metodo consente di creare un Task attraverso il metodo della classe CreateTaskRequest. Il suo stato è descritto dal valore enum CREATED
    public TaskResponse crea(@Valid @RequestBody CreateTaskRequest req) {
        return this.service.creaTask(req);
    }

    @GetMapping//Viene invocato un metodo GET per leggere tutti task in esecuzione
    public List<TaskResponse> leggiTutti() {
        return this.service.trovaTutti();
    }

    @GetMapping("/{id}")//In questo caso, fornenddo all'URL un id dei task disponibili, possiamo accedere ad uno solo di questi tramite metodo GET
    public TaskResponse leggiUno(@PathVariable Long id) {
        return this.service.trovaPerId(id);
    }

    @PutMapping("/{id}")//Invocando il metodo PUT, possiamo modificare i paramentri di un processo indicato nell'URL e disponibile nella lista dei task in esecuzione
    public TaskResponse aggiorna(@PathVariable Long id, @Valid @RequestBody UpdateTaskRequest req) {
        return this.service.aggiornaTask(id, req);
    }

    @DeleteMapping("/{id}")//specificando l'id nell'URL, possiamo cancellare un task con il metodo DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void elimina(@PathVariable Long id) {
        this.service.eliminaTask(id);
    }
}