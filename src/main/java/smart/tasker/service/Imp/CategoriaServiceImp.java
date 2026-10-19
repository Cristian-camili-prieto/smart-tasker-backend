package smart.tasker.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smart.tasker.dtos.CategoriaRecord;
import smart.tasker.repository.CategoriaRepository;
import smart.tasker.service.CategoriaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImp implements CategoriaService {


    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaRecord> obtenerCategoria() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoria -> new CategoriaRecord(
                        categoria.getIdCategoria(),
                        categoria.getNombreCategoria(),
                        categoria.getColorHex()
                )).toList();
    }
}
