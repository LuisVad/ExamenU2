package mx.edu.utez.ExamenU2.services.productos;

import mx.edu.utez.ExamenU2.models.productos.Productos;
import mx.edu.utez.ExamenU2.models.productos.ProductosRepository;
import mx.edu.utez.ExamenU2.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ProductosService {
    @Autowired
    private ProductosRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Productos>> getAll() {
        return new CustomResponse<>(this.repository.findAll(), false, 200, "Done");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Productos> getOne(Long id) {
        return new CustomResponse<>(this.repository.findById(id).get(), false, 200, "Done");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Productos> insert(Productos productos) {
        if (this.repository.existsByName(productos.getName_product()))
            return new CustomResponse<>(null, true, 400, "Este Producto ya se ha registrado");
        return new CustomResponse<>(this.repository.saveAndFlush(productos), false, 400, "Producto registrado correctamente");
    }

    @Transactional()
    public CustomResponse<Productos> update(Productos productos) {
        if (!this.repository.existsById(productos.getId()))
            return new CustomResponse<>(null, true, 400, "Este Producto no existe");
        return new CustomResponse<>(this.repository.saveAndFlush(productos), false, 400, "Producto registrado correctamente");
    }
}
