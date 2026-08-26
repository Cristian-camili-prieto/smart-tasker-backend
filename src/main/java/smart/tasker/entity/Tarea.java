package smart.tasker.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tareas")
public class Tarea {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tarea")
    private Long idTarea;

    private String titulo;

    private String descripcion;

    private String estado;

    @Column(name = "fecha_limite")
    private LocalDate fechaLimite;

    @Column(name = "id_categoria")
    private Long idCategoria;
}
