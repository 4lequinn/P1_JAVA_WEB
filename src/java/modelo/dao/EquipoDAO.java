/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import java.util.List;
import modelo.crud.MetodosModelo;
import modelo.dto.Equipo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Jorge
 */

public class EquipoDAO extends MetodosModelo<Equipo> {
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
        return "Equipo";
    }
      public List<Equipo> buscarEquipoPorPerfil(int idPerfil) {
        try{
        conectar();
        List<Equipo>listado=session.createQuery("from Equipo where perfilJugador= '"+idPerfil+"'").list();
        return listado;
       }catch(Exception ex){
           throw new RuntimeException("No se ha podido almacenar");
       }
    }

    
}
