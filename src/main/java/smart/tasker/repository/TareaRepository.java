package smart.tasker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import smart.tasker.dto.TareaPendiente;
import smart.tasker.entity.Tarea;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    @Query("SELECT t FROM Tarea t INNER JOIN Categoria c ON t.idCategoria = c.idCategoria")
    List<Tarea> findAllContainerJoin();

    @Query("SELECT  t.idTarea as idTarea, t.estado as estado FROM Tarea t WHERE t.estado='PENDIENTE'")
    List<TareaPendiente>findPendiente();



}
