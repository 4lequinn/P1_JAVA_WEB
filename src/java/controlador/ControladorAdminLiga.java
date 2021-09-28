/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.LigaDAO;
import modelo.dto.Liga;
import modelo.dto.VideoJuego;

/**
 *
 * @author jorge
 */
public class ControladorAdminLiga extends HttpServlet {

    LigaDAO dao = new LigaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("btnAccion");
        if (opcion.equalsIgnoreCase("AgregarLiga")) {
            agregarLiga(request, response);
        }
        
        if( opcion.equals("cargarDatosLiga")){
            cargarDatosLiga(request,response);
        }
        
        if( opcion.equals("ModificarLiga")){
            modificarLiga(request,response);
        }
        
    }

    protected void agregarLiga(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
            String descripcion = request.getParameter("txtDescripcion");
            VideoJuego videoJuego = new VideoJuego(Integer.parseInt(request.getParameter("cboVideoJuego")));
            //Se debe crear con cantidad 0 por defecto
            Liga liga = new Liga(videoJuego, descripcion, 0);
            if(dao.agregar(liga)){
                request.getSession().setAttribute("msjl", "Agregó!");
            }else{
                request.getSession().setAttribute("msjl", "No agregó!");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("msjl", "ERROR");
        }finally{
            response.sendRedirect("agregar-liga.jsp");
        }
    }

    protected void eliminarLiga(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int liga = Integer.parseInt(request.getParameter("liga"));
            if (dao.eliminar(liga)) {
                request.getSession().setAttribute("msjLiga", "Eliminó!");
            } else {
                request.getSession().setAttribute("msjLiga", "No se pudo eliminar!");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("msjLiga", "Error");
        } finally {
            response.sendRedirect("ControladorAdminLiga");
        }
    }
    
    protected void cargarDatosLiga(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Recuperamos el ID de la interfaz de admin
            int id = Integer.parseInt(request.getParameter("txtIdLiga"));
            //Buscamos el equipo en la BD
            Liga liga = dao.buscar(id);
            //Enviamos los datos a la página modificar equipo
            request.getSession().setAttribute("datosLiga", liga);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            response.sendRedirect("modificar-liga.jsp");
        }
    }
    
    
    protected void modificarLiga(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idLiga = Integer.parseInt(request.getParameter("txtIdLiga"));
            String descripcion = request.getParameter("txtDescripcion");
            int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            VideoJuego videoJuego = new VideoJuego(Integer.parseInt(request.getParameter("cboVideoJuego")));
            
            // Generamos la liga para actualizarla
            Liga liga = new Liga(idLiga, videoJuego, descripcion, cantidad);
            
            if(dao.modificar(liga)){
                request.getSession().setAttribute("msjML", "Modificó!");
            }else{
                request.getSession().setAttribute("msjML", "No Modificó!");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("msjML", "ERROR");
        }finally{
            response.sendRedirect("modificar-liga.jsp");
        }
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            if (request.getParameter("liga") != null) {
                eliminarLiga(request, response);
            } else {
                //Precargar listas
                request.setAttribute("listaLigas", dao.listar());
                request.getRequestDispatcher("admin_liga.jsp").forward(request, response);
            }

        } catch (Exception e) {

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
