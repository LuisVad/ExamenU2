package mx.edu.utez.ExamenU2.models.usuarios;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenU2.models.transacciones.Transacciones;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String fullName_user;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 500)
    private String wish_list;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Transacciones transacciones;

    public Usuarios(Long id, String fullName_user, String email, String password, String wish_list, Transacciones transacciones) {
        this.id = id;
        this.fullName_user = fullName_user;
        this.email = email;
        this.password = password;
        this.wish_list = wish_list;
        this.transacciones = transacciones;
    }
}
