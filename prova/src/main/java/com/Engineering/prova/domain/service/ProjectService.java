/* Includiamo i package e le librerie necessarie.
   Questa classe gestisce la logica dei progetti: riceve i dati dal controller,
   li salva in modo permanente su PostgreSQL tramite l'archivio progetti
   e li restituisce in formato JSON tramite ProjectResponse. */

package com.Engineering.prova.domain.service;

import com.Engineering.prova.api.dto.CreateProjectRequest;
import com.Engineering.prova.api.dto.ProjectResponse;
import com.Engineering.prova.persistence.ProjectEntity;
import com.Engineering.prova.persistence.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@SuppressWarnings("all") // evita falsi avvisi del compilatore
public class ProjectService {

    //Creiamo un'archivio che contenga tutti i progetti del DB
    //da notare che l'archivio non è direttamente accessibile ed è immutabile una volta creato
    private final ProjectRepository archivioProgetti;

    // Costruttore: consente di inizializzare l'archivio appena creato con i progetti del DB
    public ProjectService(ProjectRepository archivioProgetti) {
        this.archivioProgetti = archivioProgetti;
    }

    // Questo metodo ci permette di creare un nuovo progetto da mettere nel DB
    // la scritta Transactional ci dice inoltre che il progetto dev'essere creato per intero, e trasferito dal programma al DB
    @Transactional
    public ProjectResponse createProject(CreateProjectRequest datiInIngresso) {
        ProjectEntity nuovoProgetto = new ProjectEntity();
        nuovoProgetto.setNome(datiInIngresso.getNome());
        nuovoProgetto.setDescrizione(datiInIngresso.getCodiceP());

        ProjectEntity progettoSalvato = this.archivioProgetti.save(nuovoProgetto);
// Restituisce al DB il progetto inserito nel programma
        return new ProjectResponse(
                progettoSalvato.getId(),
                progettoSalvato.getDescrizione(),
                progettoSalvato.getNome(),
                progettoSalvato.getCreatoIl()
        );
    }

    // Legge tutti i progetti dal database e li trasforma nella lista di risposta
    @Transactional(readOnly = true)
    //contenitore temporaneo che contine i progetti letti nel DB
    public List<ProjectResponse> getAllProjects() {
        List<ProjectResponse> listaRisposte = new ArrayList<>();
        // consente di leggere i parametri del progetto
        for (ProjectEntity progetto : this.archivioProgetti.findAll()) {
            ProjectResponse risposta = new ProjectResponse(
                    progetto.getId(),
                    progetto.getDescrizione(),
                    progetto.getNome(),
                    progetto.getCreatoIl()
            );
            //dopo aver letto tutti i parametri del progetto, il progetto viene aggiunto alla lista
            listaRisposte.add(risposta);
        }
//lista completa dei progetti letti nel db
        return listaRisposte;
    }
}