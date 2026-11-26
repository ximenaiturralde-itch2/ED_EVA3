/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_2_ordenamientos_collections;

import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author XIMENA ALEJANDRA ITURRALDE CONTRERAS
 */
public class EVA3_2_ORDENAMIENTOS_COLLECTIONS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer> lista= new LinkedList<>();
        lista.add(500);
        lista.add(600);
        lista.add(300);
        lista.add(800);
        lista.add(100);
        lista.add(700);
        lista.add(900);
        
        //CREAMOS UN COMPARATOR
        Comparator comparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2){
                int val1 = (int)o1;
                int val2 = (int)o2;
                //el compare regresa un valor entero, que significa:
                //positivo ----> o1 es mayot
                //cero     ----> 01 y o1 son iguales
                //negativo ----> o2 es mayor
                return val2 - val1;
            }
        };
        
        lista.sort(comparator);
        System.out.println(lista);
        
        LinkedList<String> datos = new LinkedList<>();
        datos.add("Hola");
        datos.add("");
        datos.add("Mundo");
        datos.add("!!!!");
        
        Comparator comparator2 = new Comparator(){
            @Override
            public int compare(Object o1, Object o2){
                String cade1 = (String)o1;
                String cade2 = (String)o2;
                return cade2.compareTo(cade1);
        }
    };
    
    datos.sort(comparator2);
    System.out.println(datos);
  }
}
interface MiComparator {
    public int compare(Object o1, Object o2);
}

class Prueba implements MiComparator {
    @Override
    public int compare(Object o1, Object o2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
