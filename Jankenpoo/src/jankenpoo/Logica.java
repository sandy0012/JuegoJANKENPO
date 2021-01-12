/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jankenpoo;

/**
 *
 * @author sroma
 */
public class Logica {
    FuenteDatos datos= new FuenteDatos();
     
    public void iniciarPartida(Mpartida c) {
         datos.guardar(c);
         System.out.println(c);
    }

   public void ganador(Mpartida c){
       datos.guardar(c);
   }
   
   public void eligeTipoPartida(Mpartida c){
       datos.guardar(c);
   }
   public void evaluaPartida(Mpartida c){
       datos.guardar(c);
   }
   public void finaliza(Mpartida c){
       datos.guardar(c);
   }
     public Mpartida getPtd() {
         return datos.getPtd();
     } 
}

