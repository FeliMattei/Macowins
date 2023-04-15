public class TarjetaCredito extends MetodoPago {
    double coeficienteTarjeta;
    double cantidadCuotas;

    public TarjetaCredito(double coeficienteTarjeta, double cantidadCuotas){
        this.coeficienteTarjeta = coeficienteTarjeta;
        this.cantidadCuotas = cantidadCuotas;
    }

    @Override
    protected double importeAModificar(double importeSinRecargo) {
        return importeSinRecargo + this.recargo() + 0.01 * importeSinRecargo;
    }

    @Override
    protected double recargo() {
        return this.coeficienteTarjeta * this.cantidadCuotas;
    }
}

