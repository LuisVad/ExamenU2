package mx.edu.utez.ExamenU2.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import mx.edu.utez.ExamenU2.models.transacciones.Transacciones;
import mx.edu.utez.ExamenU2.models.usuarios.Usuarios;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuariosDto {
    private Long id;
    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 3, max = 50)
    private String name_product;
    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 3, max = 50)
    private String fullName_user;
    @NotEmpty(message = "Campo obligatorio")
    private String email;
    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 4, max = 10)
    private String password;
    private String wish_list;
    private Transacciones transacciones;

    public Usuarios getUsuarios(){
        return new Usuarios(
                getId(),
                getFullName_user(),
                getEmail(),
                getPassword(),
                getWish_list(),
                getTransacciones()
        );
    }
}
