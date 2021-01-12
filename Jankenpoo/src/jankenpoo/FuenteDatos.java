/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jankenpoo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author sroma
 */
public class FuenteDatos {
    public void guardar(Mpartida p) {
        try {
            BufferedWriter bw = Files.newBufferedWriter(Paths.get("E:partida.txt"), StandardOpenOption.APPEND);
            Modelo par = p.getPartidas().get(p.getPartidas().size()-1 );
            String codigo=p.getCodigo();
            String j1 = par.getNombreJ1();
            String j2= par.getNombreJ2();
            String tipo =p.getTipo();
            String nomGanador = p.getnomGanador();
            String line = codigo+", "+ j1 + ", " + j2 + ", " + tipo + ", " + nomGanador;
            bw.write(line);
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
          
        }
    }

    public Mpartida getPtd() {
        File archivo = new File("E:partida.txt");
        Scanner s=null;
        Mpartida c = new Mpartida();
        try {
           s = new Scanner(archivo);
            String[] datos = new String[6];
            while (s.hasNextLine()) {
                
                int i = 0;
                Modelo par = new Modelo();
                String linea = s.nextLine();
                StringTokenizer st = new StringTokenizer(linea, ",");
                while (st.hasMoreTokens()) {
                    datos[i] = st.nextToken();
                   i++;
                }
                par.setNombreJ1(datos[1]);
                par.setNombreJ2(datos[2]);
                c.agregar(par);
            }
            c.setCodigo(datos[0]);
            c.setTipo(datos[3]);
            c.setnomGanador(datos[4]);
            s.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Este "+ e.getMessage());
        }
        return c;
    }
}
