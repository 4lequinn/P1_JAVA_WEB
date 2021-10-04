/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import modelo.dao.VideoJuegoDAO;
import modelo.dto.VideoJuego;

/**
 *
 * @author jorge
 */
public class TestVideoJuegoDAO {
        public static void main(String[] args) {
        
        //////////////////////////////////////////////////
        //
        //           OK!
        //
        /////////////////////////////////////////////////
        
        VideoJuegoDAO dao = new VideoJuegoDAO();
        
        for(VideoJuego x:dao.listar()){
            System.out.println(x.getNombre());
        }
        
    }
}
