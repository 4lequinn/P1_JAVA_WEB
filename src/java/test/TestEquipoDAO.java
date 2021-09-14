/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestEquipoDAO {
    public static void main(String[] args) {
        EquipoDAO dao = new EquipoDAO();
        Liga liga = new Liga(1);
        EstadoSolicitud estadoSolicitud = new EstadoSolicitud(2);
        TipoUsuario tipoUsuario = new TipoUsuario(2);
        Usuario usuario = new Usuario(1, tipoUsuario, "Jorge", "Ricardo Milos 69");
        TipoJugador tipoJugador = new TipoJugador(1);
        PerfilJugador perfilJugador = new PerfilJugador(1, tipoJugador, usuario, "Jorge", "lolero.promedio@hotmail.com");
        Incripcion inscripcion = new Incripcion(3, estadoSolicitud, perfilJugador);
        Equipo equipo = new Equipo(inscripcion, liga, "TeaM Mukita", 3);
        
        
        //Agregar Equipo
        //OK
        if(dao.agregar(equipo)){
            JOptionPane.showMessageDialog(null, "Agregó!");
        }else{
            JOptionPane.showMessageDialog(null, "NO se agregó");
        }
    }
}
