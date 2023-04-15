public abstract class MetodoPago {

    protected double recargo() {
        return 0;
    }

    protected double importeAModificar(double importeSinRecargo) {
        return 0;
    }
}
