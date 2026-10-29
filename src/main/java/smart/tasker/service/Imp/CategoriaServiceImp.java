package smart.tasker.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smart.tasker.dtos.CategoriaRecord;
import smart.tasker.entity.Categoria;
import smart.tasker.repository.CategoriaRepository;
import smart.tasker.service.CategoriaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImp implements CategoriaService {


    private final CategoriaRepository categoriaRepository;


    @Override
    public List<CategoriaRecord> obtenerCategoria() {
        return categoriaRepository.obtenerCategoria();
    }

    @Override
    public CategoriaRecord crearCategoria(CategoriaRecord categoriaRecord) {
        Categoria nuevaCategoria = new Categoria();

        nuevaCategoria.setNombreCategoria(categoriaRecord.nombreCategoria());
        nuevaCategoria.setColorHex(categoriaRecord.colorHex());

        Categoria guardarCategoria = categoriaRepository.save(nuevaCategoria);

        return CategoriaRecord.fromEntityCategoria(guardarCategoria);
    }

    @Override
    public CategoriaRecord actualizarCategoria(CategoriaRecord categoriaRecord, Long id) {
        Categoria  categoriaExistente = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el id " + id));

        categoriaExistente.setNombreCategoria(categoriaRecord.nombreCategoria());
        categoriaExistente.setColorHex(categoriaRecord.colorHex());

        Categoria categoriaUpdate = categoriaRepository.save(categoriaExistente);

        return CategoriaRecord.fromEntityCategoria(categoriaUpdate);
    }

    @Override
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
