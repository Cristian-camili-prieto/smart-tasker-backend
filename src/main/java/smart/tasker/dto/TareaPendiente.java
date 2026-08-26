package smart.tasker.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "idTarea", "estado" })
public interface TareaPendiente {
    Long getIdTarea();
    String getEstado();
}
