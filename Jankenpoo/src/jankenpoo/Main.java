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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Mpartida mpartida = new Mpartida();
        IVista vista= new VistaPrincipal();
        Presentador p = new Presentador(vista, mpartida);
        vista.setPresentador(p);
        vista.iniciar();   
    }
    
}
