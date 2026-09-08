package smart.tasker.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRecord(
        Long idCategoria,

        @Size(max = 50,message = "Maximo 50 caracteres")
        String nombreCategoria,

        @Size(min = 7,max = 7,message = "Debe tener los 7 caracteres sin espacion")
        @NotBlank
        String colorHex
) {
}
