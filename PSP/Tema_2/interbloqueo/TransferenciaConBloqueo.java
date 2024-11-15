public class TransferenciaConBloqueo {
    public static void main(String[] args) {
       
        Cuenta c1 = new Cuenta("ES388388433883838388484", 20500);
        Cuenta c2 = new Cuenta("ES99090499388484889399", 50000);

        System.out.println("Saldo inicial de la cuenta c1: " + c1);
        System.out.println("Saldo inicial de la cuenta c2: " + c2);

        
        Hilo h1 = new Hilo("Rafael Álvaro Palomares Linares", c1, c2, 10);
        Hilo h2 = new Hilo(" Palomares Linares Rafael Álvaro", c2, c1, 10);

        
        h1.start();
        h2.start();

        
        try {
            h1.join();
            h2.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }

        
        System.out.println("Saldo final de la cuenta c1: " + c1);
        System.out.println("Saldo final de la cuenta c2: " + c2);
    }
}
