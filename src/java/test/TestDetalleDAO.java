/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.dao.DetalleEquipoDAO;
import modelo.dao.EquipoDAO;
import modelo.dto.DetalleEquipo;
import modelo.dto.Equipo;
import modelo.dto.EstadoSolicitud;
import modelo.dto.Incripcion;
import modelo.dto.Liga;
import modelo.dto.PerfilJugador;
import modelo.dto.TipoJugador;
import modelo.dto.TipoUsuario;
import modelo.dto.Usuario;

/**
 * 
 * @author Jorge
 */

public class TestDetalleDAO {
    public static void main(String[] args) {
        
        //////////////////////////////////////////////////
        //
        //           OK!
        //
        /////////////////////////////////////////////////
        
        
        Liga liga = new Liga(1);
        EstadoSolicitud estadoSolicitud = new EstadoSolicitud(2);
        TipoUsuario tipoUsuario = new TipoUsuario(2);
        Usuario usuario = new Usuario("Jorge", tipoUsuario,  "Ricardo Milos 69");
        TipoJugador tipoJugador = new TipoJugador(1);
        PerfilJugador perfilJugador = new PerfilJugador(1, tipoJugador, usuario, "Jorge", "lolero.promedio@hotmail.com","Experto en trolearla");
        Incripcion inscripcion = new Incripcion(2, estadoSolicitud, perfilJugador);
        Equipo equipo = new Equipo(2, liga, perfilJugador, "Team Mukita", 1);
        DetalleEquipoDAO dao = new DetalleEquipoDAO();
        DetalleEquipo detalleEquipo = new DetalleEquipo(2,equipo, inscripcion);
        
        // AGREGAR Detalle
        // OK 
//        if(dao.agregar(detalleEquipo)){
//            JOptionPane.showMessageDialog(null, "AGREGÓ!");
//        }else{
//            JOptionPane.showMessageDialog(null, "NO AGREGÓ!");
//        }

        //Modificar Detalle
        //OK
        
//        if(dao.modificar(detalleEquipo)){
//            JOptionPane.showMessageDialog(null, "Modificó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "No se modificó");
//        }

        //Buscar Detalle
        //OK
        
//        DetalleEquipo deta = new DetalleEquipo();
//        deta = dao.buscar(2);
//        System.out.println(deta.getEquipo().getNombre());

        //Listar Detalles
        //Ok
        
//        List<DetalleEquipo> listaDetalles = dao.listar();
//        for(DetalleEquipo x:listaDetalles){
//            System.out.println(x.getEquipo().getNombre());
//        }
    
        //Eliminar Detalle
        //OK
        
//        if(dao.eliminar(detalleEquipo.getId())){
//            JOptionPane.showMessageDialog(null, "Eliminó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "No se eliminó");
//        }

    }
}
