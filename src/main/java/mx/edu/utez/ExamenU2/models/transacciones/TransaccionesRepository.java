package mx.edu.utez.ExamenU2.models.transacciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {
    boolean findById(long id);
}
