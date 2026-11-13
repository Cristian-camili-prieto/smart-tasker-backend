package smart.tasker.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import smart.tasker.enums.EstadoTarea;

@JsonPropertyOrder({ "idTarea", "estado" })
public record TareaEstado(Long idTarea, EstadoTarea estado) {}
