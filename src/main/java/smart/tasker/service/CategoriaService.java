package smart.tasker.service;

import smart.tasker.dtos.CategoriaRecord;

import java.util.List;

public interface CategoriaService {
    List<CategoriaRecord>obtenerCategoria();

    CategoriaRecord crearCategoria(CategoriaRecord categoriaRecord);

    CategoriaRecord actualizarCategoria(CategoriaRecord categoriaRecord , Long id);

    void eliminar(Long id);

}
