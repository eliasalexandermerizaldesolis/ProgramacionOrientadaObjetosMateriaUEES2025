import java.util.Scanner;

public class Main {
    public static double calcularIMC(int pesoEnKilos, int estaturaEnCentimetros) {
         /*
        Calcula el Índice de Masa Corporal (IMC) utilizando:
        - pesoEnKilos: peso en kilogramos (valor entero)
        - estaturaEnCentimetros: altura en centímetros (valor entero)

        Fórmula:
        IMC = peso (kg) / (altura (m))^2

        Conversión:
        Convertimos centímetros a metros (1 metro = 100 cm)
        Tomamos en consideracion la conversion de enteros a decimales.
        * */
        byte exponenteCuadratico = 2;
        byte tasaDeCambioCentimetrosMetros = 100;
        double estaturaEnMetros = (double) estaturaEnCentimetros / tasaDeCambioCentimetrosMetros;
        double estaturaEnMetrosAlCuadrado = Math.pow(estaturaEnMetros, exponenteCuadratico);
        double imcCalculado = pesoEnKilos / estaturaEnMetrosAlCuadrado;
        return imcCalculado;
    }
    public static void main(String[] args) {
        /*
        Scaner es un ytipo de dato no nativo de java perse,
        que permite importar objetos para interactura con las entradas de datos de los usuarios
        * */
        Scanner entradaDeDatos = new Scanner(System.in);
        System.out.println("Ingresa tu peso en Kilogramos, no en toneladas, gordo hijo de tu madre: ");
        int peso = entradaDeDatos.nextInt(); // en kg
        System.out.println("Ingresa tu altura, en centimetros, no en nanometros, patucho cara de verengena: ");
        int altura = entradaDeDatos.nextInt(); // en centimetros
        double imcImpreso = calcularIMC(peso, altura);
        /*
        System me permite imprimir una linea de texto
        * */
        System.out.println("Tu IMC es de: " + imcImpreso + " deberias comer menos chancho.");
    }
}