/*Come nel caso di ProjectEntity, quest'entità consente di inserire o modificare informazioni su task, senza dover inserire query SQL nel database
Come al solito, vengono inseriti i package utili allo scopo.*/
package com.Engineering.prova.persistence;

import com.Engineering.prova.domain.model.Priority;
import com.Engineering.prova.domain.model.TaskStatus;
import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tasks") //Collega l'entità ad una relazione task del DB SQL
@SuppressWarnings("all")// per evitare falsi positivi
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id del task. Dev'essere univoco!
    private Long id;

    // Colleghiamo direttamente l'oggetto ProjectEntity tramite la chiave esterna id_progetto
    @ManyToOne(fetch = FetchType.LAZY, optional = false)/*in questo caso, stiamo dicendo che ad un progetto possono essere associati più task.*/
    @JoinColumn(name = "id_progetto", nullable = false)//dobbiamo specificare a quale progetto è associato il task tramite l'id del progeto stesso
    private ProjectEntity progetto;

    @Column(nullable = false, length = 160)// titolo del task. Non può essere nullo, massimo 160 caratteri
    private String titolo;

    @Column(columnDefinition = "TEXT")//descrizione del task
    private String descrizione;

    @Enumerated(EnumType.STRING) // descrive lo stato del task. Può essere in attesa, in esecuzione, terminato ecc...
    @Column(nullable = false, length = 30)//non può essere vuoto, massimo 30 caratteri
    private TaskStatus stato;

    @Enumerated(EnumType.STRING) // descrive la priorità del tasca(alta,bassa,media)
    @Column(nullable = false, length = 20)//non può essere vuoto, massimo 20 caratteri
    private Priority priorita;

    @Column
    private LocalDate scadenza;//scadenza del task

    @Column(name = "creato_il", nullable = false, updatable = false)
    private Instant creatoIl;//timpestamp di creazìione. Non può esssere nullo, e non è modificabile una volta ottenuto

    @Column(name = "aggiornato_il", nullable = false)
    private Instant aggiornatoIl;// timpestamp di aggiornamento. Non può essere nullo.

    // Costruttore dell'entità
    public TaskEntity() {
    }

    @PrePersist//Metodo che consente di salvare il timestamp di creazione e aggiornamento prima di salvare
    protected void primaDiSalvare() {
        Instant adesso = Instant.now();
        this.creatoIl = adesso;
        this.aggiornatoIl = adesso;
    }

    @PreUpdate//timestamp che consente di salvare il timestamp di aggiornamento prima di un'eventuale modifica
    protected void primaDiAggiornare() {
        this.aggiornatoIl = Instant.now();
    }

    /*Anche in questo caso,è neccesario definire i metodi get e set per poter modificare le variabili.
    Questo perché le variabili non sono direttamente accessibili, dato che sono di tipo private.*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectEntity getProgetto() {
        return progetto;
    }

    public void setProgetto(ProjectEntity progetto) {
        this.progetto = progetto;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TaskStatus getStato() {
        return stato;
    }

    public void setStato(TaskStatus stato) {
        this.stato = stato;
    }

    public Priority getPriorita() {
        return priorita;
    }

    public void setPriorita(Priority priorita) {
        this.priorita = priorita;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public Instant getCreatoIl() {
        return creatoIl;
    }

    public void setCreatoIl(Instant creatoIl) {
        this.creatoIl = creatoIl;
    }

    public Instant getAggiornatoIl() {
        return aggiornatoIl;
    }

    public void setAggiornatoIl(Instant aggiornatoIl) {
        this.aggiornatoIl = aggiornatoIl;
    }
}