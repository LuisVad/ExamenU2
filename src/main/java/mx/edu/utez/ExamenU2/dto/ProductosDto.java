package mx.edu.utez.ExamenU2.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenU2.models.productos.Productos;
import mx.edu.utez.ExamenU2.models.transacciones.Transacciones;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductosDto {
    private Long id;
    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 3, max = 50)
    private String name_product;
    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 3, max = 50)
    private String category_product;
    @NotEmpty(message = "Campo obligatorio")
    private Float price_product;
    @NotEmpty(message = "Campo obligatorio")
    private Boolean availability = true;
    private Transacciones transacciones;

    public Productos getProductos(){
        return new Productos(
                getId(),
                getName_product(),
                getCategory_product(),
                getPrice_product(),
                getAvailability(),
                getTransacciones()
        );
    }
}
