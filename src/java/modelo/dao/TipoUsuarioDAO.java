/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.crud.MetodosModelo;
import modelo.dto.TipoUsuario;

/**
 *
 * @author jorge
 */
public class TipoUsuarioDAO extends MetodosModelo<TipoUsuario> {

    @Override
    public String getNombreModelo() {
        return "TipoUsuario";//To change body of generated methods, choose Tools | Templates.
    }
    
}
