/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.dao.InscripcionDAO;
import modelo.dto.EstadoSolicitud;
import modelo.dto.Incripcion;
import modelo.dto.PerfilJugador;
import modelo.dto.TipoJugador;
import modelo.dto.TipoUsuario;
import modelo.dto.Usuario;

/**
 * 
 * @author Jorge
 */

public class TestInscripcionDAO {

    public static void main(String[] args) {
        
        //////////////////////////////////////////////////
        //
        //           OK!
        //
        /////////////////////////////////////////////////
        
        
        EstadoSolicitud estadoSolicitud = new EstadoSolicitud(2);
        TipoUsuario tipoUsuario = new TipoUsuario(2);
        Usuario usuario = new Usuario("Jorge", tipoUsuario,"Ricardo Milos 69");
        TipoJugador tipoJugador = new TipoJugador(1);
        PerfilJugador perfilJugador = new PerfilJugador(1, tipoJugador, usuario, "Jorge", "lolero.promedio@hotmail.com","Experto en trolearla");
        Incripcion inscripcion = new Incripcion(2, estadoSolicitud, perfilJugador);
        InscripcionDAO dao = new InscripcionDAO();

        // Agregar Inscripción
        // OK
        
//        if (dao.agregar(inscripcion)) {
//            JOptionPane.showMessageDialog(null, "AGREGÓ!");
//        } else {
//            JOptionPane.showMessageDialog(null, "NO AGREGÓ!");
//        }

        // Modificar Inscripción
        // OK
        
//        if (dao.modificar(inscripcion)) {
//            JOptionPane.showMessageDialog(null, "Modificó!");
//        } else {
//            JOptionPane.showMessageDialog(null, "No Modificó!");
//        }

        // Buscar Inscripción
        // OK
//        Incripcion solicitud = dao.buscar(2);
//        System.out.println(solicitud.getEstadoSolicitud().getDescripcion());

        // Listar Inscripción 
        // OK
//        List<Incripcion> listaInscripciones = dao.listar();
//        for(Incripcion x : listaInscripciones){
//            System.out.println(x.getEstadoSolicitud().getDescripcion());
//            
//        }

        // Eliminar Inscripción
        // OK
        
//        if (dao.eliminar(inscripcion.getId())) {
//            JOptionPane.showMessageDialog(null, "Eliminó!");
//        } else {
//            JOptionPane.showMessageDialog(null, "NO Eliminó!");
//        }

    }
}
