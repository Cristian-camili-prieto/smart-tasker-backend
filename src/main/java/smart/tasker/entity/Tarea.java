package smart.tasker.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import smart.tasker.enums.EstadoTarea;
import java.time.LocalDate;

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

    @Enumerated(EnumType.STRING)
    private EstadoTarea estado;

    @Column(name = "fecha_limite")
    private LocalDate fechaLimite;

    @Column(name = "id_categoria")
    private Long idCategoria;
}
