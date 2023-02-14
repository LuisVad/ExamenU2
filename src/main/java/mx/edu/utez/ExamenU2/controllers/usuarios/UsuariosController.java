package mx.edu.utez.ExamenU2.controllers.usuarios;

import jakarta.validation.Valid;
import mx.edu.utez.ExamenU2.dto.ProductosDto;
import mx.edu.utez.ExamenU2.dto.UsuariosDto;
import mx.edu.utez.ExamenU2.models.productos.Productos;
import mx.edu.utez.ExamenU2.models.usuarios.Usuarios;
import mx.edu.utez.ExamenU2.services.usuarios.UsuariosServices;
import mx.edu.utez.ExamenU2.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-ExamenU2/usuarios")
@CrossOrigin(origins = {"*"})
public class UsuariosController {
    @Autowired
    private UsuariosServices service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Usuarios>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Usuarios>> insert(@RequestBody UsuariosDto usuariosDto, @Valid BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.service.insert(usuariosDto.getUsuarios()), HttpStatus.CREATED);
    }

    @PutMapping ("/")
    public ResponseEntity<CustomResponse> update(@RequestBody UsuariosDto usuariosDto, @Valid BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.service.update(usuariosDto.getUsuarios()), HttpStatus.CREATED);
    }
}
