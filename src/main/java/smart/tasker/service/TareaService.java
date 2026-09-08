package smart.tasker.service;

import org.springframework.stereotype.Service;
import smart.tasker.dtos.TareaPendiente;
import smart.tasker.dtos.TareaConCategoriaRecord;
import smart.tasker.dtos.TareaRecord;

import java.util.List;

public interface TareaService {
    List<TareaRecord>allCategoria();

    List<TareaPendiente>findAllPendiente();

    TareaRecord crearTarea(TareaRecord tareaRecord);

    List<TareaConCategoriaRecord>findAllTarea();


}
