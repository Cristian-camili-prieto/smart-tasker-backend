package smart.tasker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smart.tasker.entity.Categoria;
import smart.tasker.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/obtener")
    public ResponseEntity<List<Categoria>>obtenerCategoria(){
        List<Categoria> list = categoriaService.obtenerCategoria();
        return ResponseEntity.ok().body(list);
    }
}
