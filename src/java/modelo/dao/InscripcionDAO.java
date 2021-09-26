/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import java.util.List;
import modelo.crud.MetodosModelo;
import modelo.dto.Incripcion;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Jorge
 */

public class InscripcionDAO extends MetodosModelo<Incripcion>{
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
    @Override
    public String getNombreModelo() {
        return "Incripcion";
    }
    
        
    // Métodos Custom
    
    // Listar según ESTADO DE INSCRIPCIÓN
    // WHERE ID = 1,2 OR 3
    // ACEPTADA - RECHAZADA - PENDIENTE

      public List<Incripcion> buscarIncripcionPorEquipo(int idEquipo) {
        try{
        conectar();
        List<Incripcion>listado=session.createQuery("from Incripcion where id_equipo= '"+idEquipo+"'").list();
        return listado;
       }catch(Exception ex){
           throw new RuntimeException("No se ha podido almacenar");
       }
    }
   
}
