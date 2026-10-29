package smart.tasker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import smart.tasker.dtos.CategoriaRecord;
import smart.tasker.entity.Categoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    @Query("SELECT c FROM Categoria c")
    List<CategoriaRecord>obtenerCategoria();
}
