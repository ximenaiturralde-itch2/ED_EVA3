/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_1_ordenamientos;

/**
 *
 * @author XIMENA ALEJANDRA ITURRALDE CONTRERAS
 */
public class EVA3_1_ORDENAMIENTOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] original, selection,insertion, bubble, quick;
        long ini, fin, tiempo;
        original = new int[10];
        
        llenar(original);
        System.out.println("--------------Arreglo original---------------------");
        imprimir(original);
        //SELECTION SHORT
        System.out.println("\n--------------Selection sort-----------------------");
        selection = copiar(original);
        ini = System.nanoTime();
        selectionSort(selection);
        fin = System.nanoTime();
        tiempo = fin - ini;
        System.out.println("Selection Sort = " + tiempo);
        //INSERTION SHORT
        System.out.println("\n--------------------Insertion Sort------------------");
        insertion = copiar(original);
        ini = System.nanoTime();
        insertionSort(insertion);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(insertion);
        System.out.println("Insertion Sort = " + tiempo);
        //BUBBLE SORT
        System.out.println("\n--------------Bubble Sort-------------------");
        bubble = copiar(original);
        ini = System.nanoTime();
        bubbleSort(bubble);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(bubble);
        System.out.println("Bubble Sort    = " + tiempo);
        //QUICK SORT
        System.out.println("\n--------------Quick Sort--------------------");
        quick = copiar(original);
        ini = System.nanoTime();
        quickSort(quick);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(quick);
        System.out.println("Quick Sort     = " + tiempo);
    }
    public static void llenar (int[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = (int) (Math.random()*100);
        }
    }
    public static void imprimir(int[] arreglo){
        for(int i = 0; i<arreglo.length; i++){
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("\n");
    }
    public static int[] copiar(int[] arreglo){
        int resu[] = new int[arreglo.length];
        System.arraycopy(arreglo, 0, resu, 0, arreglo.length);
        return resu;
    }
    public static void selectionSort(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            int min = i;
            for(int j = i + 1; j < arreglo.length; j++){
                if(arreglo[min] > arreglo[j]){
                    min = j;
                }
            }
            //INTERCAMBIO O SWAP
            int temp= arreglo[min];
            arreglo[min] = arreglo[i];
            arreglo[i] = temp;
        }
    }
    
    //EL PEOR DE TODOS
    //O(N2)
    //TIENE LOS PEORES ATRIBUTOS DE LOS ALGORITMOS ANTERIORES:
    //COMPARA MUCHO
    //INTERCAMBIA MUCHO
    //TENTADOR: ES EL MAS SENCILLO
    public static void insertionSort(int[] arreglo) {
        for(int i = 1; i < arreglo.length; i++) {
            int insp = arreglo[i];
            int j = i - 1;
            for(; j >= 0 && insp < arreglo[j]; j--) {
                arreglo[j + 1] = arreglo[j];

            }
            arreglo[j + 1] = insp;
        }
    }

    public static void bubbleSort(int[] arreglo) {
        for(int i = 0; i < arreglo.length; i++) {
            for(int j = 0; j < arreglo.length - 1; j++) {
                if(arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arreglo) {
        quickSortRec(arreglo, 0, arreglo.length - 1);
    }
    public static void quickSortRec (int[] arreglo, int ini, int fin){
        //CONDICION PARA EVITAR RECURSIVIDAD
        //SELECCIONAR PIVOTE --> CUALQUIERA, NOSOTROS EN 1ER ELEMENTO.
        //UN CICLO QUE SE REPITE MIENTRAS LOS INDICES NO SE CRUZEN
             //UN CICLO QUE BUSQUEN LOS MAS GRANDES QUE EL PIVOTE
             //UN CICLO QUE BUSQUE LOS MAS PEQUEÑOS
             //SI NO SE HAN CRUZADO, PERO SE DETUVIERON
                  // INTERCAMBIAR
             // SI SE CRUZAN:
                   //INTERCAMBIAR SMALL CON PIVOTE--> SMALL ES NUEVO PIVOTE
                   //TERMINAR CICLO PRINCIPAL
        //LLAMADAS (2 IZQ Y DERE DE PIVOTE)  RECURSIVAS
        if(ini < fin) {
            int pivote = particion(arreglo, ini, fin);
            quickSortRec(arreglo, ini, pivote - 1);
            quickSortRec(arreglo, pivote + 1, fin);
        }
    }

    private static int particion(int[] arreglo, int ini, int fin) {
        int pivote = arreglo[ini];
        int tooBig = ini + 1;
        int tooSmall = fin;

        while(tooBig <= tooSmall) {
            while(tooBig <= fin && arreglo[tooBig] <= pivote) {
                tooBig++;
            }
            while(tooSmall > ini && arreglo[tooSmall] > pivote) {
                tooSmall--;
            }

            if(tooBig < tooSmall) {
                int temp = arreglo[tooBig];
                arreglo[tooBig] = arreglo[tooSmall];
                arreglo[tooSmall] = temp;
            }
        }
        int temp = arreglo[ini];
        arreglo[ini] = arreglo[tooSmall];
        arreglo[tooSmall] = temp;
        return tooSmall;
    }
}
