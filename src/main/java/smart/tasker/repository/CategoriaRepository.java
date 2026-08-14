package smart.tasker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.tasker.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
