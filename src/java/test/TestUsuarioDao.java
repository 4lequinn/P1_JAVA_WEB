/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.dao.UsuarioDao;
import modelo.dto.TipoUsuario;
import modelo.dto.Usuario;

/**
 * 
 * @author Jorge
 */

public class TestUsuarioDao {
    public static void main(String[] args) {
        //////////////////////////////////////////////////
        //
        //           OK!
        //
        /////////////////////////////////////////////////
        
        TipoUsuario tipoUsuario = new TipoUsuario(1);
        Usuario usuario = new Usuario(1,tipoUsuario, "Jorge", "Ricardo Milos 69 uwu");
        UsuarioDao dao = new UsuarioDao();
        
        // AGREGAR USUARIO
        // OK
//        if(dao.agregar(usuario)){
//            JOptionPane.showMessageDialog(null, "AGREGÓ!");
//        }else{
//            JOptionPane.showMessageDialog(null, "NO AGREGÓ!");
//        }
        
        // BUSCAR USUARIO
        // OK 
        
//        usuario = dao.buscar(1);
//        JOptionPane.showMessageDialog(null, "La contraseña es : " + usuario.getContrasenia());
        
        // ELIMINAR USUARIO
        // OK
//        if(dao.eliminar(3)){
//            JOptionPane.showMessageDialog(null, "Eliminó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "NO Eliminó!");
//        }

        // MODIFICAR USUARIO
        // OK
        
//        if(dao.modificar(usuario)){
//            JOptionPane.showMessageDialog(null, "Modificó!");
//        }else{
//            JOptionPane.showMessageDialog(null, "NO Modificó!");
//        }

        // LISTAR USUARIOS
        // OK
        
//        List<Usuario> listaUsuarios = dao.listar();
//        for(Usuario x : listaUsuarios){
//            System.out.println("Contraseñas : " + x.getContrasenia());
//        }



    }
}
