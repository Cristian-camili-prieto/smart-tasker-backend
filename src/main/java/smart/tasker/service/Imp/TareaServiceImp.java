package smart.tasker.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.tasker.dtos.CategoriaRecord;
import smart.tasker.dtos.TareaPendiente;
import smart.tasker.entity.Tarea;
import smart.tasker.dtos.TareaConCategoriaRecord;
import smart.tasker.dtos.TareaRecord;
import smart.tasker.repository.TareaRepository;
import smart.tasker.service.TareaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaServiceImp implements TareaService {

    private final TareaRepository tareaRepository;


    @Override
    public List<TareaRecord> allTarea() {
        return tareaRepository.findAllContainerTarea();
    }

    @Override
    public List<TareaPendiente> findAllPendiente() {
        return tareaRepository.findPendiente();
    }

    @Override
    public TareaRecord crearTarea(TareaRecord tareaRecord) {
        Tarea nuevaTarea = new Tarea();

        nuevaTarea.setEstado(tareaRecord.estado());
        nuevaTarea.setDescripcion(tareaRecord.descripcion());
        nuevaTarea.setTitulo(tareaRecord.titulo());
        nuevaTarea.setFechaLimite(tareaRecord.fechaLimite());
        nuevaTarea.setIdCategoria(tareaRecord.idCategoria());

        Tarea tareaGuardada = tareaRepository.save(nuevaTarea);

        return  TareaRecord.fromEntity(tareaGuardada);
    }

    @Override
    public TareaRecord actualizarTarea(TareaRecord tareaRecord, Long id) {
      Tarea tareaExistente = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el id " + id));

      tareaExistente.setTitulo(tareaRecord.titulo());
      tareaExistente.setDescripcion(tareaRecord.descripcion());
      tareaExistente.setEstado(tareaRecord.estado());
      tareaExistente.setIdCategoria(tareaRecord.idCategoria());

      Tarea tareaActualizada = tareaRepository.save(tareaExistente);

      return TareaRecord.fromEntity(tareaActualizada);
    }

    @Override
    public List<TareaConCategoriaRecord> findAllTarea() {
        return tareaRepository.findAllTareaAndCategoria();
    }

    @Override
    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }

}
