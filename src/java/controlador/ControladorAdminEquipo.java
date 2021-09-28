/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.EquipoDAO;
import modelo.dto.Equipo;
import modelo.dto.Liga;
import modelo.dto.PerfilJugador;


/**
 *
 * @author jorge
 */
public class ControladorAdminEquipo extends HttpServlet {

    EquipoDAO dao = new EquipoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion=request.getParameter("btnAccion");
        if(opcion.equalsIgnoreCase("cargarDatosEquipo")){
             cargarDatosEquipo(request, response);
        }
        if(opcion.equalsIgnoreCase("ModificarEquipo")){
             modificarEquipo(request, response);
         }
    }
    
    protected void cargarDatosEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Recuperamos el ID de la interfaz de admin
            int id = Integer.parseInt(request.getParameter("txtId"));
            //Buscamos el equipo en la BD
            Equipo equipo = dao.buscar(id);
            //Enviamos los datos a la página modificar equipo
            request.getSession().setAttribute("datosEquipo", equipo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            response.sendRedirect("modificar-equipo.jsp");
        }
    }
        
    protected void modificarEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idEquipo = Integer.parseInt(request.getParameter("txtIdEquipo"));
            String nombre = request.getParameter("txtNombreEquipo");
            Liga liga = new Liga(Integer.parseInt(request.getParameter("cboLiga")));
            PerfilJugador perfil = new PerfilJugador(Integer.parseInt(request.getParameter("txtPerfil")));
            int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            
            // Generamos el equipo para actualizarlo
            Equipo equipo = new Equipo(idEquipo, liga, perfil, nombre, cantidad);
            
            if(dao.modificar(equipo)){
                request.getSession().setAttribute("msjt", "Modificó!");
            }else{
                request.getSession().setAttribute("msjt", "No Modificó!");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("msjt", "ERROR");
        }finally{
            response.sendRedirect("modificar-equipo.jsp");
        }
    }

    protected void eliminarEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int equipo = Integer.parseInt(request.getParameter("equipo"));
            if (dao.eliminar(equipo)) {
                request.getSession().setAttribute("msjEquipo", "Eliminó!");
            } else {
                request.getSession().setAttribute("msjEquipo", "No se pudo eliminar!");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("msjEquipo", "Error");
        } finally {
            response.sendRedirect("ControladorAdminEquipo");
        }
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if(request.getParameter("opcionEquipo") != null){
                if(request.getParameter("opcionEquipo").equals("agregar")){
                   request.getRequestDispatcher("crear_equipo.jsp").forward(request, response);
                }   
            }else if (request.getParameter("equipo") != null) {
                    eliminarEquipo(request, response);
            }else {
                //Precargar listas
                request.setAttribute("listaEquipos", dao.listar());
                request.getRequestDispatcher("admin_equipo.jsp").forward(request, response);
            }

        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
