import java.util.ArrayList;
import java.util.Scanner;

class ActivoFinanciero {
    private String ticker;
    private int cantidad;
    private double precioCompra;

    public ActivoFinanciero(String ticker, int cantidad, double precioCompra) {
        this.ticker = ticker;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
    }

    public double calcularValorActual(double precioActual) {
        return cantidad * precioActual;
    }

    public double calcularGanancia(double precioActual) {
        return (precioActual - precioCompra) * cantidad;
    }

    public String getTicker() {
        return ticker;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }
}

class Portafolio {
    private ArrayList<ActivoFinanciero> activos = new ArrayList<>();

    public void añadirActivo(ActivoFinanciero activo) {
        activos.add(activo);
    }

    public void mostrarResumen(Scanner scanner) {
        System.out.println("--- Resumen del Portafolio ---");
        for (ActivoFinanciero a : activos) {
            System.out.print("Ingrese el precio actual de " + a.getTicker() + ": ");
            double precioActual = scanner.nextDouble();
            double valorActual = a.calcularValorActual(precioActual);
            double ganancia = a.calcularGanancia(precioActual);

            System.out.printf("%s: %d acciones\n", a.getTicker(), a.getCantidad());
            System.out.printf("Valor actual: %.2f, Ganancia: %.2f\n", valorActual, ganancia);
        }
    }
}

class Usuario {
    private String nombre;
    private Portafolio portafolio = new Portafolio();

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void comprarActivo(String ticker, int cantidad, double precioCompra) {
        ActivoFinanciero nuevo = new ActivoFinanciero(ticker, cantidad, precioCompra);
        portafolio.añadirActivo(nuevo);
    }

    public void verResumenPortafolio(Scanner scanner) {
        portafolio.mostrarResumen(scanner);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        Usuario usuario = new Usuario(nombre);

        int opcion;
        do {
            System.out.println("\n1. Añadir activo\n2. Ver resumen\n3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ticker del activo: ");
                    String ticker = scanner.next();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Precio de compra: ");
                    double precioCompra = scanner.nextDouble();
                    usuario.comprarActivo(ticker, cantidad, precioCompra);
                    break;
                case 2:
                    usuario.verResumenPortafolio(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema. Hasta luego.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
