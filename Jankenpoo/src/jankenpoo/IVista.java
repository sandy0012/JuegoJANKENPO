package jankenpoo;

import jankenpoo.Presentador;
import java.util.List;

/**
 *
 * @author sroma
 */
public interface IVista {
    void iniciar();
    String Partida1();
    String Partida2();
    void Jugadores(String J1,String J2);
    String getElemento1();
    String getElemento2();
    String codigo();
    void setPresentador(Presentador p);
    public void setSalida(List<String> partidas);
    public javax.swing.JButton getIniciarJuego();
    static final String partida= "Iniciar Juego";
    static final String partida1= "Jugador 1 VS Compu";
    static final String partida2= "Jugador 1 VS Jugador 2";
    static final String finP="Finalizar";
    static final String jugar="Jugar";
    static final String Jugar="JUGAR";
}
