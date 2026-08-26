package smart.tasker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smart.tasker.dto.TareaPendiente;
import smart.tasker.entity.Tarea;
import smart.tasker.service.TareaService;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping("/allContainerTarea")
    public ResponseEntity<List<Tarea>>obtenerContenedorTarea(){
        List<Tarea> list = tareaService.listarConCategoria();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/pendientes")
    public ResponseEntity<List<TareaPendiente>>obtenerEstado(){
        List<TareaPendiente> listPendiente = tareaService.findAllPendiente();
        return ResponseEntity.ok().body(listPendiente);
    }

}
