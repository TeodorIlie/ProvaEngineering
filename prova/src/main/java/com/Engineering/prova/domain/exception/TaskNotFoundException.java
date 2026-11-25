/*Questa classe è stata creata per generare un'eccezione.
Un'eccezione è una routine eseguita dopo che il sistema rileva un'anomalia.
Nel nostro caso, vogliamo che il PC ci restituisca errore qualora inserissimo un ID non valido*/
package com.Engineering.prova.domain.exception;
@SuppressWarnings("all")//Per evitare falsi positivi da parte del compilatore
/*Dato che stiamo creando un'eccezione, dobbiamo ereditare i metodi dalla superclasse.
in questo caso, RuntimeException.
In questo caso, l'errore viene rilevato durante la fase di esecuzione.*/
public class TaskNotFoundException extends RuntimeException {
/*L'eccezione riceve in ingresso un identificativo.
 Qualora l'id non venisse rilevato, richiamiamo il metodo della superclasse.
 Questo restituisce un errore con la frase sottostante*/
    public TaskNotFoundException(Long id) {
        super("Task con id " + id + " non trovato");
    }
}