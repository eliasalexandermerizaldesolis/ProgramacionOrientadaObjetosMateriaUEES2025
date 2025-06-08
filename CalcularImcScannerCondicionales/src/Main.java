import java.util.Scanner;
/*
Importamos la libreria Scanner
* ﻿﻿*/

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
        ﻿la conversion de enteros a decimales
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
        Scaner es un tipo de dato no nativo de java perse,
        el profesor nos dijo el termino exacto de ese tipo de
        datos que nacieron con Java, en este caso Scanner no es
        ﻿uno de ellos, creo que el termino
        ﻿es primitivos para los nativos en Java.
﻿
        Lo mas relevante es que permite importar objetos
        ﻿para interactura con las entradas
        ﻿de datos de los usuarios.

        Yo entiendo al concepto de objetos como un empaquetado
        de funcionalidades o cosas.

        Por lo que voy entendiendo de lo que es programacion
        orientada a objetos. Pero puedo estar equivocado.﻿
        * */﻿  ﻿
        Scanner entradaDeDatos = new Scanner(System.in);
        System.out.println("Ingresa tu peso en Kilogramos: ");
        int peso = entradaDeDatos.nextInt(); // en kg
        System.out.println("Ingresa tu altura en centimetros: ");
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
            System.out.println("Tu indice de masa corporal indica que estas en un rango normal.");
        }
        else {
            if(imcImpreso > 24.9 && imcImpreso <= 29.9) {
                System.out.println("Tu indice de masa corporal indica que tienes sobrepeso y tienes riesgo moderado a ser obeso.");
            }
            else {
                if (imcImpreso > 29.9 && imcImpreso <= 34.9) {
                    System.out.println("Tienes obesidad tipo I.");
                }
                else {
                    if (imcImpreso > 34.9 && imcImpreso <= 39.9) {
                        System.out.println("Tienes obesidad tipo  II.");
                    } else {
                        if (imcImpreso > 39.9) {
                            System.out.println("Tienes obesidad tipo III.");
                        }
                        else {
                            System.out.println("Sufres de insuficiencia ponderal.");
                        }
                    }
                }
            }
        }
    }
}