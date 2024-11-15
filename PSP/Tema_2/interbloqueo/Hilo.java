public class Hilo extends Thread {
    private String nombre;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private double cantidad;

    public Hilo(String nombre, Cuenta cuentaOrigen, Cuenta cuentaDestino, double cantidad) {
        this.nombre = nombre;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            boolean exito = Transferencia.transferencia(cuentaOrigen, cuentaDestino, cantidad);
            System.out.printf("Transferencia de cuenta %s a %s de %.2f $ %n", cuentaOrigen.getNumeroCuenta(), cuentaDestino.getNumeroCuenta(), cantidad);
            if (!exito) {
                System.out.println("[" + nombre + "] No se pudo realizar la transferencia de " +
                        cuentaOrigen.getNumeroCuenta() + " a " + cuentaDestino.getNumeroCuenta());
            }
        }
    }
}
