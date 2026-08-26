package smart.tasker.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.tasker.dto.TareaPendiente;
import smart.tasker.entity.Tarea;
import smart.tasker.record.TareaRecord;
import smart.tasker.repository.TareaRepository;
import smart.tasker.service.TareaService;

import java.util.List;

@Service
public class TareaServiceImp implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;


    @Override
    public List<TareaRecord>listarConCategoria() {
        return tareaRepository.findAllContainerJoin();
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

        return new TareaRecord(tareaGuardada);

    }


}
