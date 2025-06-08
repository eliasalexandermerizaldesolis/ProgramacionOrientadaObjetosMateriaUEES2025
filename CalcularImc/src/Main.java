public class Main {
    public static double calcularIMC(int pesoEnKilos, int estaturaEnCentimetros) {
         /*
        Calcula el Índice de Masa Corporal (IMC) utilizando:
        pesoEnKilos - valor entero
        estaturaEnCentimetros - valor entero

        Fórmula:
        IMC = peso (kg) / (altura (m))^2

        Convertimos centímetros a metros (1 metro = 100 cm)
﻿
        Tomamos en consideracion
        ﻿la conversion de enteros a decimales.
        * */
        int exponenteCuadratico = 2;
        int tasaDeCambioCentimetrosMetros = 100;
        double estaturaEnMetros = (double) estaturaEnCentimetros / tasaDeCambioCentimetrosMetros;
        double estaturaEnMetrosAlCuadrado = Math.pow(estaturaEnMetros, exponenteCuadratico);
        double imcCalculado = pesoEnKilos / estaturaEnMetrosAlCuadrado;
        return imcCalculado;
    }
    public static void main(String[] args) {
        int peso = 80; // en kg
        int altura = 180; // en centimetros
        double imcImpreso = calcularIMC(peso, altura);

        System.out.println("El IMC es: " + imcImpreso);
    }
}