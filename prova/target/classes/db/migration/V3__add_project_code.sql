-- Permette di aggiungere alla relazione progetto l'attributo del codice del progetto stesso (3-20 caratteri)
ALTER TABLE projects
    ADD COLUMN code VARCHAR(20);

-- Modifica l'attributo della relazione progetto, aggiungendo 'PRJ-'seguito dall'id del progetto, qualora il campo fosse nullo
UPDATE projects
SET code = 'PRJ-' || id
WHERE code IS NULL;

-- Rende obbligatorio inserire il codice del progetto (il campo non può essere vuoto). Inoltre, il codice del progetto non può coincidere con quello di un altro progetto.
ALTER TABLE projects ALTER COLUMN code SET NOT NULL;
ALTER TABLE projects ADD CONSTRAINT uk_projects_code UNIQUE (code);