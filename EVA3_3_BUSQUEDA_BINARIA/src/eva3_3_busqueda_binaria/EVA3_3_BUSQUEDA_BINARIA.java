/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_3_busqueda_binaria;

import java.util.Scanner;

/**
 *
 * @author XIMENA ALEJANDRA ITURRALDE CONTRERAS
 */
public class EVA3_3_BUSQUEDA_BINARIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] original, selection;
        long ini, fin, tiempo;
        original = new int[10];

        llenar(original);
        System.out.println("--------------ORIGINAL--------------");
        imprimir(original);
        //ORDENAR
        selectionSort(original);
        System.out.println("--------------ORDENADO--------------");
        imprimir(original);
        //valor a buscar
        Scanner captu = new Scanner(System.in);
        System.out.print("Ingrese el valor a buscar: ");
        int valor = captu.nextInt();
        System.out.println("Valor en posicion: " + busquedaBinaria(original, valor)); // Imprime la posición del valor encontrado
    }

    public static void llenar(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random() * 100);
        }
    }

    public static void imprimir(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "] ");
        }
        System.out.println("\n");
    }

    public static void selectionSort(int[] arreglo) {
        for(int i = 0; i < arreglo.length; i++) {
            int min = i;
            for(int j = i + 1; j < arreglo.length; j++) {
                if(arreglo[min] > arreglo[j]) {
                    min = j;
                }
            }
            //INTERCAMBIO O SWAP
            int temp = arreglo[min];
            arreglo[min] = arreglo[i];
            arreglo[i] = temp;
        }
    }

    public static int busquedaBinaria(int[] arreglo, int valor) {
        return busquedaBinariaRecu(arreglo, valor, 0, arreglo.length - 1);
    }

    private static int busquedaBinariaRecu(int[] arreglo, int valor, int ini, int fin) {
        int mitad = ini + (fin - ini) / 2;//determina la posicion intermedia
        int posicion = -1;//por default --> no encontrado (-1 no es posicion valida)
        if(ini <= fin) {//si ini es menor o igual a fin --> todavia hay elementos por revisar
            if(valor > arreglo[mitad]) {//no esta --> buscar en el lado derecho
                posicion = busquedaBinariaRecu(arreglo, valor, mitad + 1, fin);
            } else if(valor < arreglo[mitad]) {//no esta --> buscar en el lado izquierdo
                posicion = busquedaBinariaRecu(arreglo, valor, ini, mitad - 1);
            } else {//lo encontre
                posicion = mitad;
            }
        }

        return posicion;//regreso la posicion del elemento
    }
}