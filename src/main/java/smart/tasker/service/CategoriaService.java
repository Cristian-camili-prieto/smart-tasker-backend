package smart.tasker.service;

import smart.tasker.entity.Categoria;
import smart.tasker.record.CategoriaRecord;

import java.util.List;

public interface CategoriaService {
    List<CategoriaRecord>obtenerCategoria();
}
