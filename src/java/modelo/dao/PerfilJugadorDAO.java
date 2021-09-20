/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import modelo.crud.MetodosModelo;
import modelo.dto.PerfilJugador;

/**
 * 
 * @author Jorge
 */

public class PerfilJugadorDAO extends MetodosModelo<PerfilJugador>{

    @Override
    public String getNombreModelo() {
        return "PerfilJugador";
    }
    
}
