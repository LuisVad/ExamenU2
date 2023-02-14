package mx.edu.utez.ExamenU2.controllers.productos;

import jakarta.validation.Valid;
import mx.edu.utez.ExamenU2.models.productos.Productos;
import mx.edu.utez.ExamenU2.services.productos.ProductosService;
import mx.edu.utez.ExamenU2.dto.ProductosDto;
import mx.edu.utez.ExamenU2.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-ExamenU2/productos")
@CrossOrigin(origins = {"*"})
public class ProductosController {
    @Autowired
    private ProductosService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Productos>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Productos>> insert(@RequestBody ProductosDto productosDto, @Valid BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.service.insert(productosDto.getProductos()), HttpStatus.CREATED);
    }

    @PutMapping ("/")
    public ResponseEntity<CustomResponse> update(@RequestBody ProductosDto productosDto, @Valid BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.service.update(productosDto.getProductos()), HttpStatus.CREATED);
    }

}
