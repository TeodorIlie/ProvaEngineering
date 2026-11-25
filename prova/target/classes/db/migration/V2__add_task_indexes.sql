-- Quando si fanno delle ricerche, spesso è necessario dover cercare dei valori precisi
-- Non è quindi necessario caricare tutti i valori di un progetto
-- Per rendere le ricerche più veloci, si usano delle etichette, che prendono il nome di indici
-- In questo caso, creiamo se non esistono, gli indici dei parametri dei task più ricercati
-- Questo ci consente di velocizzare la ricerca
CREATE INDEX IF NOT EXISTS idx_tasks_project_id ON tasks (id_progetto);
CREATE INDEX IF NOT EXISTS idx_tasks_stato ON tasks (stato);
CREATE INDEX IF NOT EXISTS idx_tasks_priorita ON tasks (priorita);
CREATE INDEX IF NOT EXISTS idx_tasks_scadenza ON tasks (scadenza);