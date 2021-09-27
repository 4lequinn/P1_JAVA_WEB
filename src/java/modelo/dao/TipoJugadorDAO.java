/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.crud.MetodosModelo;
import modelo.dto.TipoJugador;
/**
 *
 * @author jorge
 */
public class TipoJugadorDAO extends MetodosModelo<TipoJugador>{

    @Override
    public String getNombreModelo() {
        return "TipoJugador";
    }
    
}
