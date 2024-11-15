public class Transferencia {
    private Cuenta c1;
    private Cuenta c2;

    public Transferencia(Cuenta c1, Cuenta c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public static boolean transferencia(Cuenta c1, Cuenta c2, double cantidad) {
        synchronized (c1) {

        

            if (c1.sacarCantidad(cantidad)) {
                synchronized (c2) {
                    c2.ingresaCantidad(cantidad);
                }
                return true;
            }
        }
        return false;
    }
}
