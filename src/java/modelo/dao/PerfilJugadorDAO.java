/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import modelo.crud.MetodosModelo;
import modelo.dto.PerfilJugador;
import modelo.dto.TipoJugador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * 
 * @author Jorge
 */

public class PerfilJugadorDAO extends MetodosModelo<PerfilJugador>{

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
    public PerfilJugador buscarPorNombreUsuario(String nombreUsuario){
        PerfilJugador perfilJugador = null;
        try {
            conectar();
            String consulta = "from PerfilJugador where usuario = :nombreUsuario";
            Query query = session.createQuery(consulta);
            // Variable de sustitución
            query.setString("nombreUsuario", nombreUsuario);
            perfilJugador = (PerfilJugador) query.list().get(0);
        } catch (Exception e) {
            System.out.println("Error al buscar " + e.getMessage());
        }finally{
            desconectar();
        }
        return perfilJugador;
    }
    
    public PerfilJugador buscarIdUsuario(String nombreUsuario){
        PerfilJugador perfilJugador = null;
        try {
            conectar();
            String consulta = "from PerfilJugador where id_usuario = :nombreUsuario";
            Query query = session.createQuery(consulta);
            // Variable de sustitución
            query.setString("nombreUsuario", nombreUsuario);
            perfilJugador = (PerfilJugador) query.list().get(0);
        } catch (Exception e) {
            System.out.println("Error al buscar " + e.getMessage());
        }finally{
            desconectar();
        }
        return perfilJugador;
    }
    
    public boolean Modificar(String nombreUsuario, String nombre, String correo, String habilidad){
        boolean valida = false;
        try {
            PerfilJugador p=buscarPorNombreUsuario(nombreUsuario);
            conectar();
            p.setNombre(nombre);
            p.setCorreo(correo);
            p.setHabilidad(habilidad);
            session.update(p);
            confirmarCambios();
            valida = true;
        } catch (Exception ex) {
            System.out.println("ERROR AL MODIFICAR" + ex.getMessage());
        }finally{
            desconectar();
        }
        return valida;
    }
    
    
}
