import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VentaTest {
    @Test
    @DisplayName("Generar venta de 2 prendas nuevas con efectivo")
    public void generarVentaEfectivo(){
        MetodoPago efectivo = new Efectivo();
        Venta venta = new Venta(efectivo);
        Nueva nueva = new Nueva();
        Prenda pantalon = new Prenda(500, nueva);
        Item item = new Item(pantalon, 2);

        venta.agregarItem(item);

        assertEquals(1000, venta.importe(), 0);
    }

    @Test
    @DisplayName("Generar venta de 2 prendas nuevas con tarjeta")
    public void generarVentaTarjeta(){
        MetodoPago tarjetaCredito = new TarjetaCredito(10, 6);
        Venta venta = new Venta(tarjetaCredito);
        Nueva nueva = new Nueva();
        Prenda pantalon = new Prenda(500, nueva);
        Item item = new Item(pantalon, 2);

        venta.agregarItem(item);

        assertEquals(1070, venta.importe(), 0);
    }

    @Test
    @DisplayName("Registrar venta en un negocio")
    public void registrarVenta(){
        MetodoPago efectivo = new Efectivo();
        Venta venta = new Venta(efectivo);
        Nueva nueva = new Nueva();
        Prenda pantalon = new Prenda(500, nueva);
        Item item = new Item(pantalon, 1);

        venta.agregarItem(item);

        assertEquals(500, venta.importe(), 0);

        Negocio negocio = new Negocio();
        negocio.agregarVenta(venta);
        assertEquals(500, negocio.gananciasDe(LocalDate.now()), 0);
    }

    @Test
    @DisplayName("Venta en estado liquidación con tarjeta")
    public void generarVentaTarjetaLiquidacion(){
        MetodoPago tarjetaCredito = new TarjetaCredito(10, 6);
        Venta venta = new Venta(tarjetaCredito);
        Estado liquidacion = new Liquidacion();
        Prenda pantalon = new Prenda(500, liquidacion);
        Item item = new Item(pantalon, 2);

        venta.agregarItem(item);

        assertEquals(565, venta.importe(), 0);
    }

    @Test
    @DisplayName("Venta en estado nueva con tarjeta")
    public void generarVentaTarjetaNueva(){
        MetodoPago tarjetaCredito = new TarjetaCredito(10, 6);
        Venta venta = new Venta(tarjetaCredito);
        Estado nueva = new Nueva();
        Prenda pantalon = new Prenda(500, nueva);
        Item item = new Item(pantalon, 2);

        venta.agregarItem(item);

        assertEquals(1070, venta.importe(), 0);
    }

    @Test
    @DisplayName("Pague en tarjeta y luego en efectivo")
    public void cambioMetodoPago(){
        MetodoPago tarjetaCredito = new TarjetaCredito(10, 6);
        Venta venta = new Venta(tarjetaCredito);
        Estado nueva = new Nueva();
        Prenda pantalon = new Prenda(500, nueva);
        Item item = new Item(pantalon, 2);

        venta.agregarItem(item);

        assertEquals(1070, venta.importe(), 0);

        MetodoPago efectivo = new Efectivo();
        venta.setMetodoPago(efectivo);
        assertEquals(1000, venta.importe(), 0);
    }
}
