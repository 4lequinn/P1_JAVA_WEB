/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.dao.EquipoDAO;
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

public class TestEquipoDAO {
    public static void main(String[] args) {
        
        
        //////////////////////////////////////////////////
        //
        //           OK!
        //
        /////////////////////////////////////////////////
        
        
        EquipoDAO dao = new EquipoDAO();
        Liga liga = new Liga(1);
        EstadoSolicitud estadoSolicitud = new EstadoSolicitud(2);
        TipoUsuario tipoUsuario = new TipoUsuario(2);
        Usuario usuario = new Usuario( "Jorge", tipoUsuario, "Ricardo Milos 69");
        TipoJugador tipoJugador = new TipoJugador(1);
        PerfilJugador perfilJugador = new PerfilJugador(1, tipoJugador, usuario, "Jorge", "lolero.promedio@hotmail.com","Experto en trolearla");
        Incripcion inscripcion = new Incripcion(2, estadoSolicitud, perfilJugador);
        Equipo equipo = new Equipo(1, liga, perfilJugador, "Team Mukita", 1);
        
        
        //Agregar Equipo
        //OK
        
        if(dao.agregar(equipo)){
            JOptionPane.showMessageDialog(null, "Agregó!");
        }else{
            JOptionPane.showMessageDialog(null, "NO se agregó");
        }
        
        //Modificar perfil
        //OK
        
//        if(dao.modificar(equipo)){
//            JOptionPane.showMessageDialog(null, "Modificó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "No se modificó");
//        }

        //Buscar Perfil
        //OK
        
//        Equipo team = new Equipo();
//        team = dao.buscar(1);
//        System.out.println(team.getNombre());

        //Listar Perfiles
        //Ok
        
//    List<Equipo> listaEquipo = dao.listar();
//    for(Equipo x:listaEquipo){
//        System.out.println(x.getLiga().getDescripcion());
//    }
    
        //Eliminar Equipo
        //OK
        
//        if(dao.eliminar(equipo.getId())){
//            JOptionPane.showMessageDialog(null, "Eliminó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "No se eliminó");
//        }

    }
}
