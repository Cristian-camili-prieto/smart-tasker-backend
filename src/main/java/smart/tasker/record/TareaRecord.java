package smart.tasker.record;
import smart.tasker.entity.Tarea;

import java.time.LocalDate;

public record TareaRecord(

         Long idTarea,
         String titulo,
         String descripcion,
         String estado,
         LocalDate fechaLimite,
         Long idCategoria
) {

    public TareaRecord(Tarea tarea){
        this(
                tarea.getIdTarea(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getEstado(),
                tarea.getFechaLimite(),
                tarea.getIdCategoria()
        );
    }
}
