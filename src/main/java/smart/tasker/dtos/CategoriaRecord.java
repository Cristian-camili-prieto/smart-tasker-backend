package smart.tasker.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import smart.tasker.entity.Categoria;

public record CategoriaRecord(
        Long idCategoria,

        @Size(max = 50,message = "Maximo 50 caracteres")
        String nombreCategoria,

        @Size(min = 7,max = 7,message = "Debe tener los 7 caracteres sin espacion")
        @NotBlank
        String colorHex
) {
        public static CategoriaRecord fromEntityCategoria (Categoria categoria){
                return new CategoriaRecord(
                        categoria.getIdCategoria(),
                        categoria.getNombreCategoria(),
                        categoria.getColorHex()
                );

        }
}
