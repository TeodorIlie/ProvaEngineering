/* Questa entità consente di modificare i progetti del nostro DB senza impiegare query SQL
  Come al solito, usiamo le librerie e i package necessari per poter far funzionare correttamente il programma.*/
package com.Engineering.prova.persistence;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "projects") //Questa istruzione consente all'enità creata di collegarsi al progetto nel nostro DB
@SuppressWarnings("all")// per evitare falsi positivi
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //collega l'attributo id dell'entità all'id del progetto. L'ID dev'essere univoco!
    private Long id;

    @Column(nullable = false, length = 120)//Consente di scrivere il nome del progetto nel DB. Massima lunghezza: 120. Il nome va messo!
    private String nome;

    @Column(columnDefinition = "TEXT")//attributo per inserire la descrizione all'interno del progetto nel DB
    private String descrizione;

    @Column(name = "creato_il", nullable = false, updatable = false)//timestamp di creazione del progetto
    private Instant creatoIl;

    @Column(name = "aggiornato_il", nullable = false)//timestamp di aggiornamento del progetto
    private Instant aggiornatoIl;

    // Costruttore dell'entità
    public ProjectEntity() {
    }

    // Permette di salvare il timestamp di creazione e aggiornamento prima di un salvataggio
    @PrePersist
    protected void primaDiSalvare() {
        Instant adesso = Instant.now();
        this.creatoIl = adesso;
        this.aggiornatoIl = adesso;
    }

    // permette di salvare il timestamp di aggiornamento prima di una modifica
    @PreUpdate
    protected void primaDiAggiornare() {
        this.aggiornatoIl = Instant.now();
    }

    /*
    Anche in questo caso, le variabili sono di tipo private.
    Ciò significa che, non possiamo accedere direttamente alle variabili associate al Progetto nel DB
    Di conseguenza, devono essere definiti tutti i metodi get e set per poter leggere o sovrascrivere o dati all'interno del DB.
    Quindi, chiamando questi metodi possiamo modificare timestamp, nome, descrizione... del progetto
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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