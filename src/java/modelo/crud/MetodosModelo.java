/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.crud;

import java.util.List;
import modelo.dao.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Jorge
 */

public abstract class MetodosModelo <Entidad> {
    //Capturamos el nombre del modelo
    private String nombreModelo;
    
    // Variables para conectarse a la bd mediante Hibernate
    private static Session session;
    private static Transaction transaction;
    
    // Método get para especificar el modelo del crud
    public String getNombreModelo() {
        return nombreModelo;
    }
    
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
    
    
    
    public List<Entidad> listar(){
        List<Entidad> entidades = null;
        try {
            conectar();
            String consulta = "from " + getNombreModelo();
            Query query = session.createQuery(consulta);
            entidades = query.list();
        } catch (Exception e) {
            System.out.println("Error al listar " + e.getMessage());
        }finally{
            desconectar();
        }
        return entidades;
    }
    
    public Entidad buscar(int id){
        Entidad entidad = null;
        try {
            conectar();
            String consulta = "select x from " + getNombreModelo() + " x where x.id = :id";
            Query query = session.createQuery(consulta);
            // Variable de sustitución
            query.setInteger("id", id);
            entidad = (Entidad) query.list().get(0);
        } catch (Exception e) {
            System.out.println("Error al buscar " + e.getMessage());
        }finally{
            desconectar();
        }
        return entidad;
    }
    
    public boolean agregar(Entidad e){
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
    
    public boolean eliminar(int id){
        boolean valida = false;
        try {
            Entidad entidad = buscar(id);
            conectar();
            session.delete(entidad);
            confirmarCambios();
            valida = true;
        } catch (Exception ex) {
            System.out.println("ERROR AL ELIMINAR " + ex.getMessage());
        }finally{
            desconectar();
        }
        return valida;
    }
    
    public boolean modificar(Entidad e){
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
    
    
}
