/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jankenpoo;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sroma
 */
public class Presentador implements ActionListener{
     private IVista vista;
    private Mpartida mpartida;
    private Logica logica = new Logica();
    List<String> filas = new ArrayList<String>();
     
    public Presentador(IVista vista, Mpartida mpartida) {
        Mpartida m = logica.getPtd();
       
        if (m.getCodigo() != null) {
            this.mpartida = m;
            vista.getIniciarJuego().setEnabled(false);
         
        } else {
            this.mpartida = mpartida;
            vista.getIniciarJuego().setEnabled(true);
            vista.getIniciarJuego().setBackground(Color.green);
        }

       this.vista = vista;
      
    }
    public void crearPartida() {
        mpartida.iniciarPartida();
        vista.getIniciarJuego().setEnabled(false);      
    }
    
    public void Partida1(){
       mpartida.ElegirTipoPartida(vista.Partida1());
       logica.eligeTipoPartida(mpartida);
       llenarTabla();
    
    }
    public void Partida2(){
        mpartida.ElegirTipoPartida(vista.Partida2());
        logica.eligeTipoPartida(mpartida);
        llenarTabla();
      
        
    }
    public void EvaluarPartida1(){
        mpartida.EvaluarPartida1(vista.getElemento1());
        logica.evaluaPartida(mpartida);
        llenarTabla();
        if(mpartida.getNumpartidas()==5){
            vista.getIniciarJuego().setEnabled(true);
            mpartida.setNumpartidas(0);
            filas.clear();
            vista.setSalida(filas);
            
            }
    }
     public void EvaluarPartida2(){
        mpartida.EvaluarPartida2(vista.getElemento1(),vista.getElemento2());
        logica.evaluaPartida(mpartida);
        llenarTabla();
        if(mpartida.getNumpartidas()==5){
            vista.getIniciarJuego().setEnabled(true);
            mpartida.setNumpartidas(0);
            filas.clear();
            vista.setSalida(filas);
            
            }
    }
    
    private void llenarTabla() {
        int ultimo = logica.getPtd().getPartidas().size() - 1;
    Modelo m = logica.getPtd().getPartidas().get(ultimo);
            Mpartida p = logica.getPtd();
                  
            filas.add("Nº Partida: " + "\t" + p.getCodigo() + "\n" 
                    + "Jugador 1: " + "\t" +  m.getNombreJ1()+ "\n" 
                    + "Jugador 2: " + "\t" +  m.getNombreJ2()+ "\n"
                    + "Tipo de Partida:" + "\t" + p.getTipo()+ "\n" 
                    + "Ganador: " + "\t" + p.getnomGanador() + "\n"+
                    "------------------------------------------------------------------------------------------------------------------------\n"+
                    "------------------------------------------------------------------------------------------------------------------------\n");
            
            vista.setSalida(filas);
        vista.Jugadores(m.getNombreJ1(),m.getNombreJ2());
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IVista.partida)) {
            crearPartida();
            
        }if(evento.getActionCommand().equals(IVista.partida1)){
            Partida1();
           
        }if(evento.getActionCommand().equals(IVista.partida2)){
            Partida2();
            
        }if(evento.getActionCommand().equals(IVista.Jugar)){
            EvaluarPartida1();
            vista.setSalida(filas);     
        }if(evento.getActionCommand().equals(IVista.jugar)){
            EvaluarPartida2();
            vista.setSalida(filas);
        }if (evento.getActionCommand().equals(IVista.finP)) {
            System.exit(0);
        }
    }
    
}
