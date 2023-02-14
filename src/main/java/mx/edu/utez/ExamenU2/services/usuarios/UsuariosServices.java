package mx.edu.utez.ExamenU2.services.usuarios;

import mx.edu.utez.ExamenU2.models.usuarios.Usuarios;
import mx.edu.utez.ExamenU2.models.usuarios.UsuariosRepository;
import mx.edu.utez.ExamenU2.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UsuariosServices {
    @Autowired
    private UsuariosRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Usuarios>> getAll() {
        return new CustomResponse<>(this.repository.findAll(), false, 200, "Done");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Usuarios> getOne(Long id) {
        return new CustomResponse<>(this.repository.findById(id).get(), false, 200, "Done");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Usuarios> insert(Usuarios usuarios) {
        if (this.repository.existsByName(usuarios.getFullName_user()))
            return new CustomResponse<>(null, true, 400, "Este Usuario ya se ha registrado");
        return new CustomResponse<>(this.repository.saveAndFlush(usuarios), false, 400, "Usuario registrado correctamente");
    }

    @Transactional()
    public CustomResponse<Usuarios> update(Usuarios usuarios) {
        if (!this.repository.existsById(usuarios.getId()))
            return new CustomResponse<>(null, true, 400, "Este Usuario no existe");
        return new CustomResponse<>(this.repository.saveAndFlush(usuarios), false, 400, "Usuario registrado correctamente");
    }
}
