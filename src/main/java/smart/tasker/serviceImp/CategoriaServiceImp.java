package smart.tasker.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.tasker.entity.Categoria;
import smart.tasker.repository.CategoriaRepository;
import smart.tasker.service.CategoriaService;

import java.util.List;

@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> obtenerCategoria() {
        return categoriaRepository.findAll();
    }
}
