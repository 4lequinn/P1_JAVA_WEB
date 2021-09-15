/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import modelo.crud.MetodosModelo;
import modelo.dto.Incripcion;

/**
 * 
 * @author Jorge
 */

public class InscripcionDAO extends MetodosModelo<Incripcion>{

    @Override
    public String getNombreModelo() {
        return "Incripcion";
    }
    
        
    // Métodos Custom
    
    // Listar según ESTADO DE INSCRIPCIÓN
    // WHERE ID = 1,2 OR 3
    // ACEPTADA - RECHAZADA - PENDIENTE
   
}
