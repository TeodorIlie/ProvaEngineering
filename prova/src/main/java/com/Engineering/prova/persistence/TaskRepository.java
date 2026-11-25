/*Come nel caso di ProjectRepository, vogliamo creare un'interfaccia per i task.
 Vogliamo usare i metodi di TaskEntity senza sapere come siano fatti.*/
package com.Engineering.prova.persistence;

import com.Engineering.prova.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//L'interfaccia eredita i metodi della classe. Basterà semplicemente definire l'id del task, e potremo modificarlo con i metodi implementati, senza sapere come siano fatti
// E' stato aggiunto JpaSpecification in quanto, qualora volessimo trovare un task specifico, basterebbe richiamare un metodo di questa classe, anziché richiamare continuamente la funzione find per ogni parametro
public interface TaskRepository extends JpaRepository<TaskEntity, Long>, JpaSpecificationExecutor<Task> {
}