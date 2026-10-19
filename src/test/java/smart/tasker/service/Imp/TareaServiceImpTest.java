package smart.tasker.service.Imp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import smart.tasker.dtos.TareaRecord;
import smart.tasker.entity.Categoria;
import smart.tasker.entity.Tarea;
import smart.tasker.enums.EstadoTarea;
import smart.tasker.repository.TareaRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TareaServiceImpTest {

    @Mock
    private TareaRepository tareaRepository;

    @InjectMocks
    private TareaServiceImp tareaServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarTareaa() {
        TareaRecord tareaSimulada = new TareaRecord(
                1L,
                "Terminar",
                "Se debe ajustar y modificar el titulo",
                EstadoTarea.PENDIENTE,
                LocalDate.of(2026, 10, 30),
                1L
        );

        List<TareaRecord>listaSimuladaBD = List.of(tareaSimulada);

        when(tareaRepository.findAllContainerTarea()).thenReturn(listaSimuladaBD);

        List<TareaRecord> resultado = tareaServiceImp.allTarea();

        assertNotNull(resultado);
        assertEquals(1,resultado.size());

        assertEquals(1L,resultado.get(0).idTarea());
        assertEquals("Terminar",resultado.get(0).titulo());
        assertEquals("Se debe ajustar y modificar el titulo",resultado.get(0).descripcion());
        assertEquals(EstadoTarea.PENDIENTE,resultado.get(0).estado());
        assertEquals(LocalDate.of(2026,10,30),resultado.get(0).fechaLimite());
        assertEquals(1L,resultado.get(0).idCategoria());

        verify(tareaRepository,times(1)).findAllContainerTarea();

    }
}
