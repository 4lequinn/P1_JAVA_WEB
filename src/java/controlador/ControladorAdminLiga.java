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

/**
 *
 * @author jorge
 */
public class ControladorAdminLiga extends HttpServlet {

    LigaDAO dao = new LigaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    protected void eliminarLiga(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int liga = Integer.parseInt(request.getParameter("liga"));
            if(dao.eliminar(liga)){
                request.getSession().setAttribute("msjLiga", "Eliminó!");
            }else{
                request.getSession().setAttribute("msjLiga", "No se pudo eliminar!");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("msjLiga", "Error");
        }finally{
            response.sendRedirect("admin_liga.jsp");
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
