/*Questa classe implementa la classe ApiErrorResponse per gestire i principali problemi che si possono verificare
come al solito, vengono inclusi package e librerie utili allo scopo.
L'obiettivo è creare un sistema unificato che possa gestire le situazioni critiche più ricorrenti*/
package com.Engineering.prova.api.exception;

import com.Engineering.prova.domain.exception.TaskNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
@SuppressWarnings("all")
public class GlobalExceptionHandler {

    /*In questo caso, abbiamo la direttiva dell'exception handler TaskNotFound.
    In pratica significa che la nostra richiesta non è stata registrata correttamente, ed il sistema non la rileva.
    Si crea quindi un'entità che ricalchi la classe ApiErrorResponse.
    Questa riceve in ingresso un'entità che indichi al sistema che tipo di eccezione si è verificata.
    Dopodiché dobbiamo anche inserire la richiesta non recepita dal Servlet.
    La funzione in uscita risponde con errore 404, con il messaggio d'errore e la richiesta non andata a buon fine*/
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> taskNonTrovato(TaskNotFoundException ex, HttpServletRequest req) {
        return creaRisposta(404, ex.getMessage(), req);
    }

    /* Questa funzione risulta estremamente simile a quella vista precedentemente.
    La differenza riguarda soprattutto il tipo di errore che ci verrà restituito.
      In questo caso, l'eccezione scatta quando i dati inseriti non sono corretti, con errore pari a 400*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> datiNonValidi(MethodArgumentNotValidException ex, HttpServletRequest req) {
        String messaggio = ex.getBindingResult().getFieldError().getDefaultMessage();
        return creaRisposta(400, messaggio, req);
    }

    /* Anche in questo caso, come visto poco sopra, l'errore è di tipo 400.
    In questo caso però, l'errore è provocato da un file JSON non valido.
    Il file JSON contiene i dati e le direttive che, succesivamente, vengono convertite in classi, per esmepio, in Java.
    Qualora questo file non fosse corretto, l'esecuzione non può proseguire*/
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiErrorResponse> jsonNonValido(HttpMessageNotReadableException ex, HttpServletRequest req) {
        return creaRisposta(400, "JSON malformato o valore non valido", req);
    }

    /* Questa funzione ha lo scopo di generare un generica eccezione.
        per farlo, riceve in ingresso un intero, che rappresenta lo stato,ossia il numero che identifica l'errore.
        Inoltre contiene la richiesta al Servlet ed il messaggio di errore.
        Per stampare l'errore, viene invocato un oggetto di tipo ApiErrorResponse, il quale viene inizializzatto attraverso il costruttore.
        Infine, viene restituito il messaggio dell'eccezione, con lo stato ed il contenuto dell'errore.*/
    private ResponseEntity<ApiErrorResponse> creaRisposta(int stato, String messaggio, HttpServletRequest req) {
        ApiErrorResponse errore = new ApiErrorResponse(Instant.now(), stato, messaggio, req.getRequestURI());
        return ResponseEntity.status(stato).body(errore);
    }
}
