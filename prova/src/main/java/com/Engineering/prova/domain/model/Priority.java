package com.Engineering.prova.domain.model;
/* Le richieste hanno priorità in base all'utente che le esegue.
Di conseguenza, tale struttura serve per distinguerle in base alla priorità:
- high: priorità elevata
- medium: priorità media
- low: priorità bassa, eseguite per ultime
*/
public enum Priority {
    LOW,
    MEDIUM,
    HIGH
}
