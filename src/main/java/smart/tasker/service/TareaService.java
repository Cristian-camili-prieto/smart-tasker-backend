package smart.tasker.service;

import org.springframework.stereotype.Service;
import smart.tasker.dtos.TareaPendiente;
import smart.tasker.dtos.TareaConCategoriaRecord;
import smart.tasker.dtos.TareaRecord;

import java.util.List;

public interface TareaService {

    List<TareaRecord>allTarea();

    TareaRecord crearTarea(TareaRecord tareaRecord);

    TareaRecord actualizarTarea(TareaRecord tareaRecord,Long id);

    List<TareaPendiente>findAllPendiente();


    List<TareaConCategoriaRecord>findAllTarea();

    void eliminar(Long id);


}
