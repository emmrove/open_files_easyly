/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.*;

/**
 *
 * @author emmrove
 */
public class Files {
    public void Read(){
        File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("archivo.csv");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         
         FileWriter nuevo_archivo = new FileWriter("nuevo.csv");
         BufferedWriter escribir = new BufferedWriter(nuevo_archivo);

         // Lectura del fichero
         String linea;
         //int i = 0;
         String nueva_linea = "";
         int cont = 0;
         while((linea=br.readLine())!=null){
             nueva_linea = cont + ";";
            //linea = i + ";" + linea + "\n";
            String[] salida = linea.split(";");
            String fecha = "";
            for(int i = 0; i < salida.length; i++){
                if(i != 1 && i != 2 && i != 6){
                    nueva_linea = nueva_linea + salida[i].toString() + ";";
                }
                if(i == 1){
                    fecha = fecha + salida[6].toString() + "/";
                }
                if(i == 2){
                    fecha = fecha + salida[1].toString() + "/";
                }
                if(i == 7){
                    fecha = fecha + salida[2].toString();
                }
            }
            nueva_linea = nueva_linea + fecha + "\n";
            System.out.println(nueva_linea);
            escribir.write(nueva_linea);
            nueva_linea = "";
            cont++;
         } 
         escribir.close();
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }
}
