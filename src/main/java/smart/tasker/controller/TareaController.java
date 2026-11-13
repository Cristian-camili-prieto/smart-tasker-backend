package smart.tasker.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tasker.dtos.TareaEstado;
import smart.tasker.dtos.TareaConCategoriaRecord;
import smart.tasker.dtos.TareaRecord;
import smart.tasker.enums.EstadoTarea;
import smart.tasker.service.TareaService;

import java.util.List;

@RestController
@RequestMapping("/tarea")
@RequiredArgsConstructor
public class TareaController {


    private final TareaService tareaService;

    @GetMapping("/allContainerTarea")
    public ResponseEntity<List<TareaRecord>> obtenerContenedorTarea() {
        List<TareaRecord> list = tareaService.allTarea();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/estado")
    public ResponseEntity<List<TareaEstado>> obtenerEstado(@RequestParam EstadoTarea estadoTarea) {
        List<TareaEstado> listPendiente = tareaService.findByEstado(estadoTarea);
        return ResponseEntity.ok().body(listPendiente);
    }

    @GetMapping("/tareaCategoria")
    public ResponseEntity<List<TareaConCategoriaRecord>> obtenerTareaCategoria() {
        List<TareaConCategoriaRecord> listTareaCategoria = tareaService.findAllTarea();
        return ResponseEntity.ok().body(listTareaCategoria);
    }

    @PostMapping("/nuevaTarea")
    public ResponseEntity<TareaRecord> crearTarea(@Valid @RequestBody TareaRecord tareaRecord) {
        TareaRecord record = tareaService.crearTarea(tareaRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(record);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<TareaRecord> actualizarTarea(@RequestBody TareaRecord tarea, @PathVariable Long id) {
        TareaRecord tareaRecord = tareaService.actualizarTarea(tarea,id);
        return tareaRecord != null ? ResponseEntity.ok().body(tareaRecord) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("eliminarTarea/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        tareaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
