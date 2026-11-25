-- Script SQL che contiene la struttura del DB

-- Abbiamo la tabella dei progetti
-- Questa tabella possiede un nome, che dev'essere indicato
-- Un id unico per ogni progetto che lo identifica
-- una descrizione del progetto
-- due timestamp, che indicano il momento d'inizio e di aggiornamento del progetto
CREATE TABLE projects (
                          id BIGSERIAL PRIMARY KEY,
                          nome VARCHAR(120) NOT NULL,
                          descrizione TEXT,
                          creato_il TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
                          aggiornato_il TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

-- Qui abbiamo la struttura della tabella che contiene i task collegati al progetto
-- abbiamo due id: uno collegato al task stesso, l'altro collegato al progetto di riferimento
-- qualora il progetto associato venisse eliminato, anche il task stesso verrebbe eliminato a sua volta
-- abbiamo altri parametri simili visti poc'anzi, come lo stato, la scadenza, priorità...
CREATE TABLE tasks (
                       id BIGSERIAL PRIMARY KEY,
                       id_progetto BIGINT NOT NULL REFERENCES projects(id) ON DELETE CASCADE,
                       titolo VARCHAR(160) NOT NULL,
                       descrizione TEXT,
                       stato VARCHAR(30) NOT NULL,
                       priorita VARCHAR(20) NOT NULL,
                       scadenza DATE,
                       creato_il TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
                       aggiornato_il TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

-- Qualora non volessimo esplicitare gli id, possiamo usare degli indici per velocizzare la ricerca
CREATE INDEX idx_tasks_id_progetto ON tasks(id_progetto);
CREATE INDEX idx_tasks_stato ON tasks(stato);