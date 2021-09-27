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
import modelo.dao.EquipoDAO;

/**
 *
 * @author jorge
 */
public class ControladorAdminEquipo extends HttpServlet {

    EquipoDAO dao = new EquipoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            if (request.getParameter("equipo") != null) {
                eliminarEquipo(request, response);
            } else {
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
