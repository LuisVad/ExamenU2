package mx.edu.utez.ExamenU2.models.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    boolean findById(long id);
    boolean existsByName(String name);
}
