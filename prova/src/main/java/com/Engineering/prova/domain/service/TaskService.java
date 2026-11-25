/*Il task service implementa tutte le funzioni che possiamo fare su un task.
 Queste funzioni dipendono dalle classi create precedentemente e dalle entità enum.
 Classi: CreateTaskRequest, Task Response, UpdateTaskRequest
 Enum: Priority, TaskStatus*/
package com.Engineering.prova.domain.service;

import com.Engineering.prova.api.dto.CreateTaskRequest;
import com.Engineering.prova.api.dto.TaskResponse;
import com.Engineering.prova.api.dto.UpdateTaskRequest;
import com.Engineering.prova.domain.exception.TaskNotFoundException;
import com.Engineering.prova.domain.model.Priority;
import com.Engineering.prova.domain.model.TaskStatus;
import com.Engineering.prova.persistence.ProjectEntity;
import com.Engineering.prova.persistence.ProjectRepository;
import com.Engineering.prova.persistence.TaskEntity;
import com.Engineering.prova.persistence.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("all")
public class TaskService {
    //In questo caso, creiamo un archivio dei repository e dei task
    private final TaskRepository archivioTask;
    private final ProjectRepository archivioProgetti;
// Costruttore: consente di ottenere i dati dell'archivio e dei task dal DB
    public TaskService(TaskRepository archivioTask, ProjectRepository archivioProgetti) {
        this.archivioTask = archivioTask;
        this.archivioProgetti = archivioProgetti;
    }

    //Processo per creare il task
    @Transactional
    public TaskResponse creaTask(CreateTaskRequest req) {
        Optional<ProjectEntity> progettoTrovato = this.archivioProgetti.findById(req.getIdProgetto());
        if (progettoTrovato.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Progetto con id " + req.getIdProgetto() + " non trovato"
            );
        }

        TaskEntity task = new TaskEntity();// si crea l'entità
        task.setProgetto(progettoTrovato.get());//si istanzia l'id del progetto
        task.setTitolo(req.getTitolo());//si applica il titolo
        task.setDescrizione(req.getDescrizione());//si applica la descrizione
        task.setStato(req.getStato() != null ? req.getStato() : TaskStatus.TODO);//verifica se lo stato sia stato instaziato. Se lo stato esiste allora si applica il valore enume to do per avvertire che sia pronto per l'esecuzione
        task.setPriorita(req.getPriorita() != null ? req.getPriorita() : Priority.MEDIUM);//si applica la priorità. Qualora l'utente non espliciti, la priorità è medium
        task.setScadenza(req.getScadenza());// si applica la scadenza
// id, creatoIl e aggiornatoIl vengono generati automaticamente dal database
// una volta creato, va salvato sul database e restituito in risposta
        TaskEntity taskSalvato = this.archivioTask.save(task);//consente di salvare il task nel DB
        return this.inRisposta(taskSalvato);
    }

    // questa funzione restituisce la lista completa dei task in esecuzione, con i rispettivi parametri
    @Transactional(readOnly = true)
    public List<TaskResponse> trovaTutti() {
        List<TaskResponse> risposte = new ArrayList<>();
        for (TaskEntity task : this.archivioTask.findAll()) {
            risposte.add(this.inRisposta(task));
        }
        return risposte;
    }

    // questa funzione restituisce i parametri della funzione sfruttando l'id della funzione
    @Transactional(readOnly = true)
    public TaskResponse trovaPerId(Long id) {
        return this.inRisposta(this.cercaTask(id));
    }

    //usando la funzione inRisposta descritta sotto, e la funzione cercaTask, restituisce in uscita tutti i parametri aggiornati della funzione
    @Transactional
    public TaskResponse aggiornaTask(Long id, UpdateTaskRequest req) {
        TaskEntity task = this.cercaTask(id);
        task.setTitolo(req.getTitolo());
        task.setDescrizione(req.getDescrizione());
        task.setStato(req.getStato());
        task.setPriorita(req.getPriorita());
        task.setScadenza(req.getScadenza());
        TaskEntity taskAggiornato = this.archivioTask.save(task);
        return this.inRisposta(taskAggiornato);
    }

    // elimina un elemento tramite la funzione cercaTask
    @Transactional
    public void eliminaTask(Long id) {
        TaskEntity task = this.cercaTask(id);
        this.archivioTask.delete(task);
    }

    // questa fuziione cerca un task in base all'id che gli diamo in ingresso.
// semmplicemente, si usa una ricerca sul database. Quando trova un elemento con id coincidente, lo restituisce
    private TaskEntity cercaTask(Long id) {
        Optional<TaskEntity> taskTrovato = this.archivioTask.findById(id);
        if (taskTrovato.isEmpty()) {
            throw new TaskNotFoundException(id);
        }
        return taskTrovato.get();
    }

    // Questa funzione restituisce tutti i parametri di un task in ingressso.
    private TaskResponse inRisposta(TaskEntity t) {
        return new TaskResponse(
                t.getId(), t.getProgetto().getId(), t.getTitolo(), t.getDescrizione(),
                t.getStato(), t.getPriorita(), t.getScadenza(), t.getCreatoIl(), t.getAggiornatoIl()
        );
    }
}