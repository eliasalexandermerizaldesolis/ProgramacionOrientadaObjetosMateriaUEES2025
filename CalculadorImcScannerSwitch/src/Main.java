import java.util.Scanner;
/*
Importacion de libreria Scanner
* */
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
        System.out.println("Ingresa tu peso en Kilogramos: ");
        int peso = entradaDeDatos.nextInt(); // en kg
        System.out.println("Ingresa tu altura en centimetros: ");
        int altura = entradaDeDatos.nextInt(); // en centimetros
        double imcImpreso = calcularIMC(peso, altura);
        /*
        Declarar la variable imcCategoria fuera de los bloques de condicionales
        * */
        int imcCategoria = 0;
        /*
        Uso de condicionales
        * */
        if (imcImpreso >= 18.5 && imcImpreso <= 24.9) {
            imcCategoria = 1;
        } else {
            if (imcImpreso >= 25.0 && imcImpreso <= 29.9) {
                imcCategoria = 2;
            } else {
                if (imcImpreso >= 30.0 && imcImpreso <= 34.9) {
                    imcCategoria = 3;
                } else {
                    if (imcImpreso > 34.9 && imcImpreso <= 39.9) {
                        imcCategoria = 4; // Remover 'int' aquí
                    } else {
                        if (imcImpreso > 39.9) {
                            imcCategoria = 5;
                        } else {
                            imcCategoria = 6;
                            // Cambiar a 6 para "bajo peso" y remover 'int'
                        }
                    }
                }
            }
        }
        /*
        Uso de Switch
        * */
        switch (imcCategoria) {
            case 1:
                System.out.println("Tu índice de masa corporal indica que estás en un rango normal.");
                break;
            case 2:
                System.out.println("Tu índice de masa corporal indica sobrepeso y tienes riesgo moderado de obesidad.");
                break;
            case 3:
                System.out.println("Tienes obesidad tipo I.");
                break;
            case 4:
                System.out.println("Tienes obesidad tipo II.");
                break;
            case 5:
                System.out.println("Tienes obesidad tipo III.");
                break;
            case 6:
                System.out.println("Tu peso está por debajo del rango normal.");
                break;
            default:
                System.out.println("Tu indice de masa corporal indica insuficiencia ponderal.");
                break;
        }
    }
}