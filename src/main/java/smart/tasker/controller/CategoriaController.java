package smart.tasker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smart.tasker.dtos.CategoriaRecord;
import smart.tasker.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {


    final private CategoriaService categoriaService;

    @GetMapping("/obtener")
    public ResponseEntity<List<CategoriaRecord>>obtenerCategoria(){
        List<CategoriaRecord> list = categoriaService.obtenerCategoria();
        return ResponseEntity.ok().body(list);
    }
}
