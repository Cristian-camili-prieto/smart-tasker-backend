package smart.tasker.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import smart.tasker.entity.Tarea;
import smart.tasker.enums.EstadoTarea;

import java.time.LocalDate;

public record TareaRecord(

        Long idTarea,
        @Size(max = 100, message = "El titulo no puede ser mayores de 100 caracteres")
        @NotBlank(message = "El titulo debe tener como minimo un caracter sin espacios")
        String titulo,
        @Size(max = 100, message = "La descripcion no pueden ser mayores de 100 caracteres")
        @NotBlank(message = "La descripcion debe tener como minimo un caracter sin espacios")
        String descripcion,

        @NotNull(message = "El estado es obligatorio")
        EstadoTarea estado,

        @NotNull(message = "La fecha es obligatoria")
        LocalDate fechaLimite,
        Long idCategoria
){

    public static TareaRecord fromEntity(Tarea tarea) {
       return new TareaRecord(
              tarea.getIdTarea(),
                      tarea.getTitulo(),
                      tarea.getDescripcion(),
                      tarea.getEstado(),
                      tarea.getFechaLimite(),
                      tarea.getIdCategoria()

       );


    }
}

