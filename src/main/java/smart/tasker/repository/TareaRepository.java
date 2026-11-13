package smart.tasker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import smart.tasker.dtos.TareaEstado;
import smart.tasker.entity.Tarea;
import smart.tasker.dtos.TareaConCategoriaRecord;
import smart.tasker.dtos.TareaRecord;
import smart.tasker.enums.EstadoTarea;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    @Query("SELECT t FROM Tarea t ")
    List<TareaRecord> findAllContainerTarea();

    List<TareaEstado> findByEstado(EstadoTarea estado);

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
