package smart.tasker.service;

import smart.tasker.dto.TareaPendiente;
import smart.tasker.entity.Tarea;
import smart.tasker.record.TareaRecord;

import java.util.List;

public interface TareaService {
    List<TareaRecord>listarConCategoria();

    List<TareaPendiente>findAllPendiente();

    TareaRecord crearTarea(TareaRecord tareaRecord);
}
