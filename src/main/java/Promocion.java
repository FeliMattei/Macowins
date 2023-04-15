public class Promocion implements Estado {
    double descuento;

    public Promocion(double descuento){
        this.descuento = descuento;
    }

    @Override
    public double precioFinal(double precioOriginal) {
        return precioOriginal - this.getDescuento();
    }

    public double getDescuento() {
        return descuento;
    }

}
