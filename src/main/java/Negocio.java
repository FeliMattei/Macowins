import java.time.LocalDate;
import java.util.ArrayList;

public class Negocio {
    ArrayList<Venta> ventas;

    public Negocio(){
        this.ventas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta){
        this.ventas.add(venta);
    }

    public double gananciasDe(LocalDate dia) {
        return ventas.stream()
                .filter(venta -> venta.getFecha().equals(dia))
                .mapToDouble(venta -> venta.importe())
                .sum();

    }
}
