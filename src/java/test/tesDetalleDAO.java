/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import javax.swing.JOptionPane;
import modelo.dao.DetalleDAO;
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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class tesDetalleDAO {
    public static void main(String[] args) {
        Liga liga = new Liga(1);
        EstadoSolicitud estadoSolicitud = new EstadoSolicitud(2);
        TipoUsuario tipoUsuario = new TipoUsuario(2);
        Usuario usuario = new Usuario(1, tipoUsuario, "Jorge", "Ricardo Milos 69");
        TipoJugador tipoJugador = new TipoJugador(1);
        PerfilJugador perfilJugador = new PerfilJugador(1, tipoJugador, usuario, "Jorge", "lolero.promedio@hotmail.com","Experto en trolearla");
        Incripcion inscripcion = new Incripcion(2, estadoSolicitud, perfilJugador);
        Equipo equipo = new Equipo(2, liga, perfilJugador, "Team Mukita", 1);
        DetalleDAO dao = new DetalleDAO();
        DetalleEquipo detalleEquipo = new DetalleEquipo(equipo, inscripcion);
        
        // AGREGAR 
        // OK 
        if(dao.agregar(detalleEquipo)){
            JOptionPane.showMessageDialog(null, "AGREGÓ!");
        }else{
            JOptionPane.showMessageDialog(null, "NO AGREGÓ!");
        }
    }
}
