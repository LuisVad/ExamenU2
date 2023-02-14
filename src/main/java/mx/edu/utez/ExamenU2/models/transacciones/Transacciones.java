package mx.edu.utez.ExamenU2.models.transacciones;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenU2.models.productos.Productos;
import mx.edu.utez.ExamenU2.models.usuarios.Usuarios;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Transacciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transactions;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    @JsonIgnore
    private Usuarios usuarios;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", unique = true)
    @JsonIgnore
    private Productos productos;
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private String date_purchase;

}
