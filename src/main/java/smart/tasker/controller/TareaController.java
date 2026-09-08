package smart.tasker.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tasker.dtos.TareaPendiente;
import smart.tasker.dtos.TareaConCategoriaRecord;
import smart.tasker.dtos.TareaRecord;
import smart.tasker.service.TareaService;

import java.util.List;

@RestController
@RequestMapping("/tarea")
@RequiredArgsConstructor
public class TareaController {


    private final TareaService tareaService;

    @GetMapping("/allContainerTarea")
    public ResponseEntity<List<TareaRecord>>obtenerContenedorTarea(){
        List<TareaRecord> list = tareaService.allCategoria();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/pendientes")
    public ResponseEntity<List<TareaPendiente>>obtenerEstado(){
        List<TareaPendiente> listPendiente = tareaService.findAllPendiente();
        return ResponseEntity.ok().body(listPendiente);
    }

    @GetMapping("/tareaCategoria")
    public ResponseEntity<List<TareaConCategoriaRecord>>obtenerTareaCategoria(){
        List<TareaConCategoriaRecord> listTareaCategoria = tareaService.findAllTarea();
        return ResponseEntity.ok().body(listTareaCategoria);
    }

    @PostMapping("/nuevaTarea")
    public ResponseEntity<TareaRecord>crearTarea(@Valid @RequestBody TareaRecord tareaRecord){
        TareaRecord record = tareaService.crearTarea(tareaRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(record);
    }

}
