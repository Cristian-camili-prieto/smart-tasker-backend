package smart.tasker.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "idTarea", "estado" })
public interface TareaPendiente {
    Long getIdTarea();
    String getEstado();
}
