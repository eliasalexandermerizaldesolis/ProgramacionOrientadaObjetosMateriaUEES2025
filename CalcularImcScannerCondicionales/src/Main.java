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
        System.out.println("Tu IMC es de: " + imcImpreso);
        /*
        Inicio de la condicional
        * */
        if (imcImpreso > 18.5 && imcImpreso <= 24.9) {
            System.out.println("Tu indice de masa corporal indica que estas en un rango normal");
        }
        else {
            if(imcImpreso > 24.9 && imcImpreso <= 29.9) {
                System.out.println("Tu indice de masa corporal indica que eres un animal con sobrepeso y un preobeseo, lo mismo que decir un casi culo gordo.");
            }
            else {
                if (imcImpreso > 29.9 && imcImpreso <= 34.9) {
                    System.out.println("TIENES OBESIDAD TIPO I, gordo hijo de puta.");
                }
                else {
                    if (imcImpreso > 34.9 && imcImpreso <= 39.9) {
                        System.out.println("TIENES OBESIDAD TIPO II, obeso hijo de puta, corre todos los dias chucha.");
                    } else {
                        if (imcImpreso > 39.9) {
                            System.out.println("TIENES OBESIDAD TIPO III, deja de comer hamburguesa.");
                        }
                        else {
                            System.out.println("Come mas Chucha.");
                        }
                    }
                }
            }
        }
    }
}