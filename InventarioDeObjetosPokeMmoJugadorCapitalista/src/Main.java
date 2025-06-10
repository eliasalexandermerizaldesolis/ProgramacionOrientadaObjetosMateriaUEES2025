import java.util.Scanner;
/*
 * Libreria para leer los datos de entrada del usuario.
 */

// Enums deben ir antes de las clases (por orden y visibilidad)
enum Estado {
    EN_ESPERA,
    VENDIDO,
    DADO_DE_BAJA
}

enum GananciaPerdida {
    GANANCIA_ESPERADA,
    GANANCIA_INFERIOR,
    PERDIDA
}

public class Main {
    public static void main(String[] args) {
        Scanner entradaPorTeclado = new Scanner(System.in);

        // Ingreso de datos por parte del usuario
        System.out.print("Ingrese el nombre del Pokémon: ");
        String nombreIngresadoPorUsuario = entradaPorTeclado.nextLine();

        System.out.print("IV HP: ");
        byte ivHpIngresadoPorUsuario = entradaPorTeclado.nextByte();

        System.out.print("IV Ataque: ");
        byte ivAtaqueIngresadoPorUsuario = entradaPorTeclado.nextByte();

        System.out.print("IV Defensa: ");
        byte ivDefensaIngresadoPorUsuario = entradaPorTeclado.nextByte();

        System.out.print("IV Ataque Especial: ");
        byte ivAtaqueEspecialIngresadoPorUsuario = entradaPorTeclado.nextByte();

        System.out.print("IV Defensa Especial: ");
        byte ivDefensaEspecialIngresadoPorUsuario = entradaPorTeclado.nextByte();

        System.out.print("IV Velocidad: ");
        byte ivVelocidadIngresadoPorUsuario = entradaPorTeclado.nextByte();

        System.out.print("Horas de juego invertidas: ");
        int horasDeJuegoIngresadoPorUsuario = entradaPorTeclado.nextInt();

        System.out.print("Dinero invertido (pokédólares): ");
        long dineroInvertidoIngresadoPorUsuario = entradaPorTeclado.nextLong();

        System.out.print("Nivel del Pokémon: ");
        byte nivelIngresadoPorUsuario = entradaPorTeclado.nextByte();

        System.out.print("Precio de venta listado: ");
        long precioVentaIngresadoPorUsuario = entradaPorTeclado.nextLong();

        // Crear el objeto Pokémon con los datos
        PokemonAlfaShiny shiny = new PokemonAlfaShiny(
                nombreIngresadoPorUsuario, ivHpIngresadoPorUsuario, ivAtaqueIngresadoPorUsuario, ivDefensaIngresadoPorUsuario,
                ivAtaqueEspecialIngresadoPorUsuario, ivDefensaEspecialIngresadoPorUsuario, ivVelocidadIngresadoPorUsuario,
                horasDeJuegoIngresadoPorUsuario, dineroInvertidoIngresadoPorUsuario, nivelIngresadoPorUsuario,
                precioVentaIngresadoPorUsuario, Estado.EN_ESPERA
        );

        // --- ACTUALIZACIÓN POSTERIOR ---
        System.out.print("¿Desea actualizar el estado y precio real de venta? (s/n): ");
        entradaPorTeclado.nextLine(); // limpiar buffer
        String opcion = entradaPorTeclado.nextLine();

        if (opcion.equalsIgnoreCase("s")) {
            System.out.println("Seleccione el nuevo estado:\n1. VENDIDO\n2. EN_ESPERA\n3. DADO_DE_BAJA");
            int estadoSeleccionado = entradaPorTeclado.nextInt();
            Estado nuevoEstado = Estado.EN_ESPERA;

            switch (estadoSeleccionado) {
                case 1: nuevoEstado = Estado.VENDIDO; break;
                case 2: nuevoEstado = Estado.EN_ESPERA; break;
                case 3: nuevoEstado = Estado.DADO_DE_BAJA; break;
            }

            shiny.setEstado(nuevoEstado);

            System.out.print("Ingrese el precio real de venta (si no se vendió, ponga 0): ");
            long precioReal = entradaPorTeclado.nextLong();
            shiny.setPrecioVentaReal(precioReal);
        }

        // Mostrar resultados finales
        System.out.println("\n--- INVENTARIO ---");
        shiny.imprimirResumen();

        entradaPorTeclado.close();
    }
}

// CLASE SECUNDARIA (no debe ser pública si está en el mismo archivo que Main)
class PokemonAlfaShiny {

    private String nombre;  // Nombre del Pokémon

    private byte ivHp, ivAtaque, ivDefensa, ivAtaqueEspecial, ivDefensaEspecial, ivVelocidad;

    private int horasDeJuego;
    private long dineroInvertido;

    private byte nivel;
    private long precioVenta;
    private long precioVentaQueRealmenteSucedio;
    private long impuesto;
    private long ganancia;
    private long gananciaEsperada;

    private Estado estado;
    private GananciaPerdida gananciaPerdida;

    private boolean esDadoDeBaja;
    private boolean buenaMalaInversion;

    public PokemonAlfaShiny(String nombre, byte ivHp, byte ivAtaque, byte ivDefensa,
                            byte ivAtaqueEspecial, byte ivDefensaEspecial, byte ivVelocidad,
                            int horasDeJuego, long dineroInvertido, byte nivel,
                            long precioVenta, Estado estado) {
        this.nombre = nombre;
        this.ivHp = ivHp;
        this.ivAtaque = ivAtaque;
        this.ivDefensa = ivDefensa;
        this.ivAtaqueEspecial = ivAtaqueEspecial;
        this.ivDefensaEspecial = ivDefensaEspecial;
        this.ivVelocidad = ivVelocidad;
        this.horasDeJuego = horasDeJuego;
        this.dineroInvertido = dineroInvertido;
        this.nivel = nivel;
        this.precioVenta = precioVenta;
        this.estado = estado;

        this.impuesto = (long) (precioVenta * 0.10); // 10%
        this.gananciaEsperada = precioVenta - dineroInvertido - impuesto;
    }

    public void setEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
        this.esDadoDeBaja = (nuevoEstado == Estado.DADO_DE_BAJA);
    }

    public void setPrecioVentaReal(long precioReal) {
        this.precioVentaQueRealmenteSucedio = precioReal;

        if (estado == Estado.DADO_DE_BAJA) {
            this.dineroInvertido += this.impuesto;
        }

        this.ganancia = precioVentaQueRealmenteSucedio - dineroInvertido;

        if (ganancia >= gananciaEsperada) {
            gananciaPerdida = GananciaPerdida.GANANCIA_ESPERADA;
        } else if (ganancia > 0) {
            gananciaPerdida = GananciaPerdida.GANANCIA_INFERIOR;
        } else {
            gananciaPerdida = GananciaPerdida.PERDIDA;
        }

        this.buenaMalaInversion = (ganancia > 0);
    }

    public void imprimirResumen() {
        System.out.println("Nombre: " + nombre);
        System.out.println("IVs -> HP:" + ivHp + " ATK:" + ivAtaque + " DEF:" + ivDefensa +
                " ATK ESP:" + ivAtaqueEspecial + " DEF ESP:" + ivDefensaEspecial + " VEL:" + ivVelocidad);
        System.out.println("Horas jugadas: " + horasDeJuego);
        System.out.println("Dinero invertido: " + dineroInvertido);
        System.out.println("Nivel: " + nivel);
        System.out.println("Precio de venta (listado): " + precioVenta);
        System.out.println("Impuesto pagado: " + impuesto);
        System.out.println("Precio real de venta: " + precioVentaQueRealmenteSucedio);
        System.out.println("Ganancia esperada: " + gananciaEsperada);
        System.out.println("Ganancia real: " + ganancia);
        System.out.println("Estado: " + estado);
        System.out.println("Resultado económico: " + gananciaPerdida);
        System.out.println("¿Fue buena inversión? " + (buenaMalaInversion ? "Sí" : "No"));
        System.out.println("¿Dado de baja? " + (esDadoDeBaja ? "Sí" : "No"));
    }
}
