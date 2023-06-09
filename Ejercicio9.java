package com.ejerciciosTemas7_8_9;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio9 {

    public static void main(String[] args) {

        //9.Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream, excepciones,
        // un HashMap y un ArrayList, LinkedList o array.

        String palabras[] = null;
        String linea = "";

        Map<String, String> mapa = new HashMap<>();

        try {
            FileReader in = new FileReader("C:\\Users\\juanc\\Desktop\\Cursos\\capitales.txt");
            BufferedReader ficheroBuffer = new BufferedReader(in);

            do {
                linea = ficheroBuffer.readLine();
                if (linea != null) {
                    palabras = linea.split(":");
                }
                for (int i = 0; i < palabras.length; i++) {
                    mapa.put(palabras[0], palabras[1]);
                }
            } while (linea != null);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el fichero: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al cargar el fichero: "+e.getMessage());
        }
        for (Map.Entry elemento : mapa.entrySet()) {
            System.out.println("La clave es: " + elemento.getKey());
            System.out.println("El valor es: " + elemento.getValue()
            );
        }

        List<String> arrayList=new ArrayList<>();

        for (Map.Entry elemento : mapa.entrySet()) {
            arrayList.add((String)elemento.getKey());
            arrayList.add((String) elemento.getValue());
        }

        PrintStream out= null;
        try {
            out = new PrintStream("C:\\Users\\juanc\\Desktop\\Cursos\\destinoCapitales.txt");
            for (String elemto:arrayList){
                byte temp[]=elemto.getBytes();
                out.write(temp);
                byte temp2[]="\n".getBytes();
                out.write(temp2);
            }
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: "+e.getMessage());
        }


    }
}
