/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jankenpoo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sroma
 */
public class Mpartida {
    public String codigo;
    public String nomGanador;
    public String tipo;
    private ArrayList<Modelo> partidas = new ArrayList();
    private int[][] tabla;
    int numpartidas=0;
    int numganadas1=0;
    int numganadas2=0;
     Modelo partida=new Modelo();
    public Mpartida(){
        this.tabla();
        
    }
    private void tabla(){
        int[][] tab={{0, -1, 1},
                    {1, 0, -1},
                    {-1, 1, 0}};
       this.tabla=tab;        
    }
    
    
    public void agregar(Modelo partida){
        this.partidas.add(partida);
    }
    
    public int ganador(int j1,int j2){
        return this.tabla[j1][j2];
    }
    
    public void ElegirTipoPartida(String tipo){
        this.tipo=tipo;
        setTipo(tipo);
       if(tipo.equals("Jugador 1 VS Compu")){
           String j1=JOptionPane.showInputDialog(null,"Ingrese su Nombre");
           partida.setNombreJ1(j1);
          partida.setNombreJ2("COMPU");
           agregar(partida);
        }
      if(tipo.equals("Jugador 1 VS Jugador 2")){
           String j1=JOptionPane.showInputDialog(null,"Ingrese Nombre de Jugador 1");
           partida.setNombreJ1(j1);
           String j2=JOptionPane.showInputDialog(null,"Ingrese Nombre de Jugador 2");
           partida.setNombreJ2(j2);
            agregar(partida);
       }
       
    }
    public void EvaluarPartida2(String j1,String j2){
        int J1=0,J2=0;
     if(j1.equals("PIEDRA")&& j2.equals("PIEDRA")){
          J1=0;J2=0;
     }if(j1.equals("PIEDRA")&& j2.equals("PAPEL")){
          J1=0;J2=1;
     }if(j1.equals("PIEDRA")&& j2.equals("TIJERA")){
         J1=0;J2=2;
     }if(j1.equals("PAPEL")&& j2.equals("PIEDRA")){
         J1=1;J2=0;
     }if(j1.equals("PAPEL")&& j2.equals("PAPEL")){
         J1=1;J2=1;
     }if(j1.equals("PAPEL")&& j2.equals("TIJERA")){
         J1=1;J2=2;
     }if(j1.equals("TIJERA")&& j2.equals("PIEDRA")){
         J1=2;J2=0;
     }if(j1.equals("TIJERA")&& j2.equals("PAPEL")){
         J1=2;J2=1;
     }if(j1.equals("TIJERA")&& j2.equals("TIJERA")){
         J1=2;J2=2;
     }
     int ganador=ganador(J1,J2);
     
            
            switch(ganador){
                case 0:
                    JOptionPane.showMessageDialog(null,"EMPATE");
                    setnomGanador("No hay ganador");
                    numpartidas++;
                    break;
                case 1:                    
                    setnomGanador(partida.getNombreJ1());                    
                    JOptionPane.showMessageDialog(null,"JUGADOR "+getnomGanador()+ " GANA");
                    numpartidas++;
                    numganadas1++;
                    break;
                case -1:                 
                    setnomGanador(partida.getNombreJ2());
                    JOptionPane.showMessageDialog(null,"JUGADOR "+getnomGanador()+" GANA");
                    numpartidas++;
                    numganadas2++;
                    break;
            }
        if(numpartidas==5){
            if(numganadas1>numganadas2){
                JOptionPane.showMessageDialog(null,"JUGADOR "+partida.getNombreJ1()+ " GANA LA PARTIDA");
                numganadas1=0; numganadas2=0;
               
            }else if(numganadas1<numganadas2){
                JOptionPane.showMessageDialog(null,"JUGADOR "+partida.getNombreJ2()+ " GANA LA PARTIDA");
                numganadas1=0; numganadas2=0;
                
            }else{
                 JOptionPane.showMessageDialog(null,"LA PARTIDA ES UN EMPATE");
                numganadas1=0; numganadas2=0;
                
            }
            limpiarDatos();
        }
    }
    public void EvaluarPartida1(String j1){
        int J1=0,J2=0;
     if(j1.equals("PIEDRA")){
          J1=0;J2=ElementoAleatorio(0,2);
     }if(j1.equals("PAPEL")){
         J1=1;J2=ElementoAleatorio(0,2);
     }if(j1.equals("TIJERA")){
         J1=2;J2=ElementoAleatorio(0,2);
     
     }
     int ganador=ganador(J1,J2);
     switch(ganador){
                case 0:
                    JOptionPane.showMessageDialog(null,"EMPATE");
                    setnomGanador("No hay ganador");
                    numpartidas++;
                    break;
                case 1:                    
                    setnomGanador(partida.getNombreJ1());                    
                    JOptionPane.showMessageDialog(null,"JUGADOR "+getnomGanador()+ " GANA");
                    numpartidas++;
                    numganadas1++;
                    break;
                case -1:                 
                    setnomGanador(partida.getNombreJ2());
                    JOptionPane.showMessageDialog(null,"JUGADOR "+getnomGanador()+" GANA");
                    numpartidas++;
                    numganadas2++;
                    break;
            }
     if(numpartidas==5){
            if(numganadas1>numganadas2){
                JOptionPane.showMessageDialog(null,"JUGADOR "+partida.getNombreJ1()+ " GANA LA PARTIDA");
                numganadas1=0; numganadas2=0;
            }else if(numganadas1<numganadas2){
                JOptionPane.showMessageDialog(null,"JUGADOR "+partida.getNombreJ2()+ " GANA LA PARTIDA");
                numganadas1=0; numganadas2=0;
            }else{
                 JOptionPane.showMessageDialog(null,"LA PARTIDA ES UN EMPATE");
                numganadas1=0; numganadas2=0;
            }
            limpiarDatos();
            
        }
    
    }
    
    public void iniciarPartida() {
        String code=JOptionPane.showInputDialog(null,"Ingrese codigo de Partida");
        setCodigo(code);
                
    }
    
    private int ElementoAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }
    private void limpiarDatos(){
        partida.setNombreJ1("");
        partida.setNombreJ2("");
        partida.setNumPartidas(0);
    }
    public String getCodigo() {
        return codigo;
    }

    public String getnomGanador() {
        return nomGanador;
    }

    public String getTipo() {
        return tipo;
    }

    public ArrayList<Modelo> getPartidas() {
        return partidas;
    }

    public int[][] getTabla() {
        return tabla;
    }

    public int getNumpartidas() {
        return numpartidas;
    }

    public void setNumpartidas(int numpartidas) {
        this.numpartidas = numpartidas;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setnomGanador(String nombre) {
        this.nomGanador = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPartidas(ArrayList<Modelo> partidas) {
        this.partidas = partidas;
    }

    public void setTabla(int[][] tabla) {
        this.tabla = tabla;
    }
    
    
}
