/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.dao.PerfilJugadorDAO;
import modelo.dto.PerfilJugador;
import modelo.dto.TipoJugador;
import modelo.dto.TipoUsuario;
import modelo.dto.Usuario;

/**
 * 
 * @author Jorge
 */

public class TestPerfilJugadorDAO {

    public static void main(String[] args) {

        //////////////////////////////////////////////////
        //
        //           OK!
        //
        /////////////////////////////////////////////////
        
        /*
            OJO
            El método modificar del dao es necesario incluir el ID al instanciar la entidad
        
         */
        TipoUsuario tipoUsuario = new TipoUsuario(2);
        Usuario usuario = new Usuario("Jorge",tipoUsuario, "Ricardo Milos 69");
        TipoJugador tipoJugador = new TipoJugador(1);
        PerfilJugador perfilJugador = new PerfilJugador(2, tipoJugador, usuario, "Jorge", "lolero.promedio@hotmail.com","Experto en trolearla");
        PerfilJugadorDAO dao = new PerfilJugadorDAO();

        //Agregar Perfil
        //OK
//        if(dao.agregar(perfilJugador)){
//            JOptionPane.showMessageDialog(null, "Agregó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "NO se agregó");
//        }

        //Buscar Perfil
        //OK
        
//        PerfilJugador perfil = new PerfilJugador();
//        perfil = dao.buscar(2);
//        System.out.println(perfil.getNombre());

        //Listar Perfiles
        //Ok
        
//    List<PerfilJugador> listaPerfil = dao.listar();
//    for(PerfilJugador x:listaPerfil){
//        System.out.println(x.getCorreo());
//    }

        //Modificar perfil
        //OK
        
//        if(dao.modificar(perfilJugador)){
//            JOptionPane.showMessageDialog(null, "Modificó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "No se modificó");
//        }

        //Eliminar Perfil
        //OK
        
//        if(dao.eliminar(perfilJugador.getId())){
//            JOptionPane.showMessageDialog(null, "Eliminó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "No se eliminó");
//        }
    }
}
