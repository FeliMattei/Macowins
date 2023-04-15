import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
    ArrayList<Item> items;
    MetodoPago metodoPago;
    LocalDate fecha;

    public Venta(MetodoPago metodoPago){
        this.items = new ArrayList<>();
        this.setFecha(LocalDate.now());
        this.metodoPago = metodoPago;
    }

    public void agregarItem(Item item){
        this.items.add(item);
    }

    public double importe(){
        double importeSinRecargo = items.stream().mapToDouble(item -> item.importe()).sum();
        return metodoPago.importeAModificar(importeSinRecargo);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
