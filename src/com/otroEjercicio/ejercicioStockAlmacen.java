package com.otroEjercicio;
import java.util.Scanner;

public class ejercicioStockAlmacen {
    public static void main(String[] args){
        int stock[][];
        float precios[];
        String nombrePiezas[];
        int cantidadPiezas, almacenParaCalcular;
        float precioPiezaActual, precioAlmacenActual, precioTotalTodo = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Haremos diversos cálculos de Stock para tu empresa.");

        System.out.print("Primero dime cuantos tipos de piezas almacenas: ");
        cantidadPiezas = teclado.nextInt();
        teclado.nextLine(); //Limpiar Buffer

        //Con una sola pregunta asignar tamaño a todos los Vectores
        precios = new float[cantidadPiezas];
        nombrePiezas = new String[cantidadPiezas];

        System.out.println("\nAhora vamos a guardar información para cada pieza.");

        //Como son de un mismo tamaño, con un solo bucle recorrer los dos vectores para asignarles valores
        for (int i = 0; i < precios.length; i++) {
            System.out.print("Introduce el nombre de la pieza " + (i+1) + ": ");
            nombrePiezas[i] = teclado.nextLine();

            System.out.print("Ahora introduce su precio: ");
            precios[i] = teclado.nextFloat();

            teclado.nextLine(); //Limpiar Buffer
        }

        //Preguntar una de las dimensiones de la matríz y usar la cantidad de piezas para la otra dimensión
        System.out.print("\nA continuación, dime cuántos almacenes usas para las piezas: ");
        stock = new int[teclado.nextInt()][cantidadPiezas];

        //Preguntar cantidad de piezas por almacén. El primer for recorre almacenes, el segundo recorre piezas
        for (int i = 0; i < stock.length; i++) {
            System.out.println("\n---Para el almacén " + (i+1) + "---");
            for (int j = 0; j < stock[i].length; j++) {
                System.out.print("Dime cuantas unidades de " + nombrePiezas[j] + " almacena: ");
                stock[i][j] = teclado.nextInt();
            }
        }

        //Pedir un almacén al usuario para calcular el precio total de cada tipo de pieza que almacena
        System.out.print("\nIndícame para cual almacén, entre el 1 y el "
                        +  stock.length
                        +  ", deseas conocer el precio de sus piezas: ");
        almacenParaCalcular = teclado.nextInt();

        //Realizar los cálculos para cada pieza del almacén i
        for (int i = 0; i < stock[almacenParaCalcular].length; i++) {
            precioPiezaActual = stock[almacenParaCalcular][i] * precios[i];
            System.out.println("- El precio total de " + stock[almacenParaCalcular][i]
                            +  " " + nombrePiezas[i] + "s es: " + precioPiezaActual);
        }

        System.out.println("\nAhora te mostraré el precio total de cada almacén.");
        //Calcular el precio total de todas las piezas en un almacén
        for (int i = 0; i < stock.length; i++) {
            System.out.print("- El precio sumado de todas las piezas del almacén " + (i+1) + " es: ");
            precioAlmacenActual = 0; //Cada almacen se calcula desde el principio

            for (int j = 0; j < stock[i].length; j++) {
                precioPiezaActual = stock[i][j] * precios[j]; //Calculo del precio de la pieza
                precioAlmacenActual += precioPiezaActual; //Acumulación a precio de almacen
            }

            System.out.println(precioAlmacenActual);

            precioTotalTodo += precioAlmacenActual; //Acumulación a precio total
        }

        System.out.println("\nEl precio total de todas las piezas en todos tus almacenes es: " + precioTotalTodo);

        System.out.println("\nFinalmente, te mostraré en que almacenes no tienes que piezas.");
        for (int i = 0; i < stock.length; i++) {
            for (int j = 0; j < stock[i].length; j++) {
                if(stock[i][j] < 1){
                    System.out.println("- El almacén " + (i+1) + " no tiene " + nombrePiezas[j] + "s.");
                }
            }
        }
    }
}
