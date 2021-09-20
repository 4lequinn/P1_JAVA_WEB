/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import modelo.crud.MetodosModelo;
import modelo.dto.Equipo;

/**
 * 
 * @author Jorge
 */

public class EquipoDAO extends MetodosModelo<Equipo> {

    @Override
    public String getNombreModelo() {
        return "Equipo";
    }
    
}
