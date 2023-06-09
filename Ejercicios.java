package com.ejerciciosTemas7_8_9;

import java.io.*;
import java.util.*;

public class Ejercicios {
    public static void main(String[] args) {

        String a=reverse("Hola mundo");
        System.out.println(a);

    //ejercicio 1 crea array string y recorre motrando sus valores
        String valores[]= {"Juan","Pedro","Luis"};
        for(String elem : valores){
            System.out.println(elem);
        }
        //crea array bidimensional enteros y recorrre mostrando posicion y valor en ambas dimensiones

        int arrayBidi[][]={{1,2,3},{10,20,30}};

        for(int i=0;i<arrayBidi.length;i++){
            for(int j=0;j<arrayBidi[i].length;j++){
                System.out.println("La posicion i: "+i+" La posicion j: "+j+" El valor es: "+arrayBidi[i][j]);
            }
        }
   //Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra el resultado final.

        Vector<String> vector=new Vector<>();

        vector.add("Juan");
        vector.add("Ana");
        vector.add("Luis");
        vector.add("Pedro");
        vector.add("Sandra");

        vector.remove(2);//ojo con los indices si tengo que borrar 2 o mas a la vez.
        vector.remove(1);
        for(String elem:vector) {
            System.out.println(elem);
        }
   //Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser añadidos al mismo.
   //Respuesta: por defecto es 10 elemntos por lo que cuando llega al limite, hace una copia y amplia su capacidad
   //por lo tanto dberá hacer este procwso muchas veces hasta llegar a los 1000 elemento y esto consume mucha memoria

   //5.Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList.
   // Recorre ambos mostrando únicamente el valor de cada elemento.
            System.out.println("Ejercicio 5 ////////////////////////////////////");

            List<String> lista=new ArrayList<>();

            lista.add("Juan");
            lista.add("Ana");
            lista.add("Pepe");
            lista.add("Elena");

            List<String> listaLink=new LinkedList<>();

            for (String el: lista){
                listaLink.add(el);
            }
            for (String el1: lista){
                System.out.println("ArrayList: "+el1);
            }
            for (String el2: listaLink){
                System.out.println("LinkedList: "+el2);
            }

            System.out.println("Ejercicio 6 ////////////////////////////////////");
  //6.Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10. A continuación,
  // con otro bucle, recórrelo y elimina los numeros pares. Por último, vuelve a recorrerlo y muestra el
// ArrayList final. Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.

            List<Integer>  listaNumeros=new ArrayList<>();

            for(int i=0;i<=10;i++){
                listaNumeros.add(i);
            }
            Iterator<Integer> it=listaNumeros.iterator();

            while(it.hasNext()){   //Necesito un iterador para eliminar un elemento del ArrayList
                int v=it.next().intValue();
                if(v%2==0){
                    it.remove();
                }
            }
            for (Integer el4:listaNumeros){
                System.out.println(el4);
            }

 //Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo
 // ArithmeticException que será capturada por su llamante (desde "main", por ejemplo). Si se dispara la
 // excepción, mostraremos el mensaje "Esto no puede hacerse". Finalmente, mostraremos en cualquier caso:
        // "Demo de código".

        System.out.println("Ejercicio 7 ////////////////////////////////////");
            try{
                double resultado=dividePorCero(2.0,0);
                System.out.println("El resultado de la division es  : "+ resultado);
            }catch (ArithmeticException e){
                System.out.println(e.getMessage());
            }finally {
                System.out.println("Demo codigo");
            }

//8.Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros: "fileIn" y "fileOut".
// La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en
// "fileOut".

        System.out.println("Ejercicio 8 ////////////////////////////////////");

        try {
            InputStream in = new FileInputStream("C:\\Users\\juanc\\Desktop\\Cursos\\countries.txt");
            PrintStream out=new PrintStream("C:\\Users\\juanc\\Desktop\\Cursos\\destino2.txt");

            copiaFichero( in,out);
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el fichero : "+e.getMessage());
        }
    }

    public static void copiaFichero(InputStream fileIn, PrintStream filOut){

        try {
            byte datos[] = fileIn.readAllBytes();
            fileIn.close();

            filOut.write(datos);
            filOut.close();
            System.out.println("El proceso se ha realizado correctamente");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero : "+e.getMessage());
        }




    }
    public static double dividePorCero(double a, double b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException("Esto no puede hacerse");
        }
        return a/b;


    }

    public static String reverse(String texto) {
        char res[]=new char[texto.length()];
        int a=texto.length();
        for(int i=texto.length()-1; i>=0; i--){
            res[a-i-1]=texto.charAt(i);
        }
        return String.copyValueOf(res);
    }



}
