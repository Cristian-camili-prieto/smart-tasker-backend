package smart.tasker.service;

import smart.tasker.dtos.TareaEstado;
import smart.tasker.dtos.TareaConCategoriaRecord;
import smart.tasker.dtos.TareaRecord;
import smart.tasker.enums.EstadoTarea;

import java.util.List;

public interface TareaService {

    List<TareaRecord>allTarea();

    TareaRecord crearTarea(TareaRecord tareaRecord);

    TareaRecord actualizarTarea(TareaRecord tareaRecord,Long id);

    List<TareaEstado>findByEstado(EstadoTarea estadoTarea);


    List<TareaConCategoriaRecord>findAllTarea();

    void eliminar(Long id);


}
