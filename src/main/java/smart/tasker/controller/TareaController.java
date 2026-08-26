package smart.tasker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tasker.dto.TareaPendiente;
import smart.tasker.record.TareaRecord;
import smart.tasker.service.TareaService;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping("/allContainerTarea")
    public ResponseEntity<List<TareaRecord>>obtenerContenedorTarea(){
        List<TareaRecord> list = tareaService.listarConCategoria();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/pendientes")
    public ResponseEntity<List<TareaPendiente>>obtenerEstado(){
        List<TareaPendiente> listPendiente = tareaService.findAllPendiente();
        return ResponseEntity.ok().body(listPendiente);
    }

    @PostMapping("/nuevaTarea")
    public ResponseEntity<TareaRecord>crearTarea(@RequestBody TareaRecord tareaRecord){
        TareaRecord record = tareaService.crearTarea(tareaRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(record);
    }

}
