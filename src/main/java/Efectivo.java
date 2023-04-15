public class Efectivo extends MetodoPago {

    public Efectivo(){}

    @Override
    protected double importeAModificar(double importeSinRecargo) {
        return importeSinRecargo;
    }
}
