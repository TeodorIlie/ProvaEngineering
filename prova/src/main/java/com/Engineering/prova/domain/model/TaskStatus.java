package com.Engineering.prova.domain.model;
/* La struttura qui presente descrive lo stato di una richiesta dell'utente.
La richiesta di un'utente può trovarsi in tre stati:
- il primo indica che la richiesta dev'essere ancora eseguita,
- il secondo indica che la richiesta è in stato di esecuzione,
- il terzo indica che la richiesta è stata soddisfatta.
Per questo motivo, è stata impiegata una struttura enum.
 */
public enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE
}
