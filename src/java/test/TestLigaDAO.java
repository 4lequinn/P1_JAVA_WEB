/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.dao.LigaDAO;
import modelo.dto.Liga;
import modelo.dto.VideoJuego;

/**
 * 
 * @author Jorge
 */

public class TestLigaDAO {
    public static void main(String[] args) {
        VideoJuego videoJuego = new VideoJuego(1);
        Liga liga = new Liga(2, videoJuego, "Liga campeones", 5);
        LigaDAO dao = new LigaDAO();
        
       
        // AGREGAR LIGA
        // OK
//        if(dao.agregar(liga)){
//            JOptionPane.showMessageDialog(null, "AGREGÓ!");
//        }else{
//            JOptionPane.showMessageDialog(null, "NO AGREGÓ!");
//        }

        // MODIFICAR LIGA
        // OK
        
//        if(dao.modificar(liga)){
//            JOptionPane.showMessageDialog(null, "Modificó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "NO Modificó!");
//        }

        // LISTAR LIGA
        // OK
        
//        List<Liga> listaLigas = dao.listar();
//        for(Liga x : listaLigas){
//            System.out.println("Descripciones : " + x.getDescripcion());
//        }

        // BUSCAR LIGA
        // OK 
//        Liga liga2 = dao.buscar(1);
//        JOptionPane.showMessageDialog(null, "La descripción es : " + liga2.getDescripcion());
  
        // ELIMINAR LIGA
        // OK
//        if(dao.eliminar(2)){
//            JOptionPane.showMessageDialog(null, "Eliminó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "NO Eliminó!");
//        }




    }
}
