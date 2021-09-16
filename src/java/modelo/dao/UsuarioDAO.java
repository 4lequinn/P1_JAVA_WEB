/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import java.util.List;
import modelo.crud.MetodosModelo;
import modelo.dto.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Jorge
 */

public class UsuarioDAO{

    // Variables para conectarse a la bd mediante Hibernate
    private static Session session;
    private static Transaction transaction;
    
    
    private void conectar(){
        // Nos conectamos a la bd
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    private void desconectar(){
        // Nos desconectamos de la bd
        session.close();
    }
    
    private void confirmarCambios(){
        transaction.commit();
    }
    
    
    public List<Usuario> listar(){
        List<Usuario> listaUsuarios = null;
        try {
            conectar();
            String consulta = "from usuario";
            Query query = session.createQuery(consulta);
            listaUsuarios = query.list();
        } catch (Exception e) {
            System.out.println("Error al listar " + e.getMessage());
        }finally{
            desconectar();
        }
        return listaUsuarios;
    }
    
    public Usuario buscar(String nombreUsuario){
        Usuario usuario = null;
        try {
            conectar();
            String consulta = "from usuario where usuario = :nombreUsuario";
            Query query = session.createQuery(consulta);
            // Variable de sustitución
            query.setString("nombreUsuario", nombreUsuario);
            usuario = (Usuario) query.list().get(0);
        } catch (Exception e) {
            System.out.println("Error al buscar " + e.getMessage());
        }finally{
            desconectar();
        }
        return usuario;
    }
    
    public boolean agregar(Usuario e){
        boolean valida = false;
        try {
            conectar();
            session.save(e);
            confirmarCambios();
            valida = true;
        } catch (Exception ex) {
            System.out.println("ERROR AL GUARDAR " + ex.getMessage());
        }finally{
            desconectar();
        }
        return valida;
    }
    
    public boolean eliminar(String nombreUsuario){
        boolean valida = false;
        try {
            Usuario usuario = buscar(nombreUsuario);
            conectar();
            session.delete(usuario);
            confirmarCambios();
            valida = true;
        } catch (Exception ex) {
            System.out.println("ERROR AL ELIMINAR " + ex.getMessage());
        }finally{
            desconectar();
        }
        return valida;
    }
    
    public boolean modificar(Usuario e){
        boolean valida = false;
        try {
            conectar();
            session.update(e);
            confirmarCambios();
            valida = true;
        } catch (Exception ex) {
            System.out.println("ERROR AL MODIFICAR" + ex.getMessage());
        }finally{
            desconectar();
        }
        return valida;
    }
    
    // Desarrollar los métodos
    
    // Login
    public Usuario Loguear(String nombreUsuario, String contrasenia) {
        Usuario usuario = null;
        try {
            conectar();
            String consulta = "from Usuario where usuario = :nombreUsuario and contrasenia = :contrasenia";
            Query query = session.createQuery(consulta);
            // Variable de sustitución
            query.setString("nombreUsuario", nombreUsuario);
            query.setString("contrasenia", contrasenia);
            usuario = (Usuario) query.list().get(0);
        } catch (Exception e) {
            System.out.println("Error al buscar " + e.getMessage());
        }finally{
            desconectar();
        }
        return usuario;
    }
}
