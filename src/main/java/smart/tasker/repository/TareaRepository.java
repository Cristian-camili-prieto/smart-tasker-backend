package smart.tasker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import smart.tasker.dtos.TareaPendiente;
import smart.tasker.entity.Tarea;
import smart.tasker.dtos.TareaConCategoriaRecord;
import smart.tasker.dtos.TareaRecord;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    @Query("SELECT t FROM Tarea t ")
    List<TareaRecord> findAllContainerTarea();

    @Query("SELECT  t.idTarea AS idTarea, t.estado AS estado FROM Tarea t WHERE t.estado='PENDIENTE'")
    List<TareaPendiente> findPendiente();

    @Query("""
            SELECT new smart.tasker.dtos.TareaConCategoriaRecord(
            t.idTarea,t.titulo,t.descripcion,t.estado,t.fechaLimite,
                     new smart.tasker.dtos.CategoriaRecord(
                              c.idCategoria,
                              c.nombreCategoria,
                              c.colorHex
                              )
                    )
            FROM Tarea t INNER JOIN Categoria c ON t.idCategoria = c.idCategoria
           """)
    List<TareaConCategoriaRecord>findAllTareaAndCategoria();
}
