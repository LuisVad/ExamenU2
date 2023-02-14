package mx.edu.utez.ExamenU2.models.productos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
    boolean findById(long id);
    boolean existsByName(String name);
}
