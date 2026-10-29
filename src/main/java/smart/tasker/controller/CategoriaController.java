package smart.tasker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tasker.dtos.CategoriaRecord;
import smart.tasker.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {


    final private CategoriaService categoriaService;

    @GetMapping("/obtener")
    public ResponseEntity<List<CategoriaRecord>> obtenerCategoria() {
        List<CategoriaRecord> list = categoriaService.obtenerCategoria();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/newCategoria")
    public ResponseEntity<CategoriaRecord> crearCategoria(@RequestBody CategoriaRecord categoriaRecord) {
        CategoriaRecord categoriaRecord1 = categoriaService.crearCategoria(categoriaRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRecord1);
    }

    @PutMapping("actualizarCategoria/{id}")
    public ResponseEntity<CategoriaRecord> actualizarCategoria(@RequestBody CategoriaRecord categoriaRecord, @PathVariable Long id) {
        CategoriaRecord categoriaRecordUpdate = categoriaService.actualizarCategoria(categoriaRecord, id);
        return categoriaRecord != null ? ResponseEntity.ok().body(categoriaRecordUpdate) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void>eliminar(@PathVariable Long id){
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
