package smart.tasker.dtos;

import smart.tasker.enums.EstadoTarea;
import java.time.LocalDate;

public record TareaConCategoriaRecord(
        Long idTarea,
        String titulo,
        String descripcion,
        EstadoTarea estado,
        LocalDate fechaLimite,
        CategoriaRecord categoriaRecord
) {
}

