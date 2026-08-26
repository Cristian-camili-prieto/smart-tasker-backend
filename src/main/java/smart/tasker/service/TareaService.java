package smart.tasker.service;

import smart.tasker.dto.TareaPendiente;
import smart.tasker.entity.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea>listarConCategoria();

    List<TareaPendiente>findAllPendiente();
}
