/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import modelo.dao.EstadoSolicitudDAO;
import modelo.dto.EstadoSolicitud;

/**
 *
 * @author jorge
 */
public class TestEstadoSolicitudDAO {
    public static void main(String[] args) {
        
        //////////////////////////////////////////////////
        //
        //           OK!
        //
        /////////////////////////////////////////////////
        
        EstadoSolicitudDAO dao = new EstadoSolicitudDAO();
        
        for(EstadoSolicitud x:dao.listar()){
            System.out.println(x.getDescripcion());
        }
        
    }
}
