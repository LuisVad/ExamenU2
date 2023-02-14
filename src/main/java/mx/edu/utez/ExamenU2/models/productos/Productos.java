package mx.edu.utez.ExamenU2.models.productos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenU2.models.transacciones.Transacciones;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Setter
@Getter
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name_product;
    @Column(nullable = false, length = 50)
    private String category_product;
    @Column(nullable = false)
    private Float price_product;
    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean availability;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Transacciones transacciones;

    public Productos(Long id, String name_product, String category_product, Float price_product, Boolean availability, Transacciones transacciones) {
        this.id = id;
        this.name_product = name_product;
        this.category_product = category_product;
        this.price_product = price_product;
        this.availability = availability;
        this.transacciones = transacciones;
    }
}
