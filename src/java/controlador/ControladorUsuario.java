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
import javax.servlet.http.HttpSession;
import modelo.dao.UsuarioDAO;


public class ControladorUsuario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion=request.getParameter("btnAccion");
         if( opcion.equals("Loguear")){
             Loguear(request, response);
         }
    }
    protected void Loguear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
           String nombre=request.getParameter("txtUser");
           String contrasena=request.getParameter("txtPass");
           UsuarioDAO dao = new UsuarioDAO();
           if(dao.Loguear(nombre, contrasena)!=null){
               HttpSession objsesion=request.getSession(true);
               objsesion.setAttribute("usuario", nombre);
               response.sendRedirect("index.jsp");
           }else{
               response.sendRedirect("login.jsp");
           }
       }catch(Exception e){
           request.getSession().setAttribute("msNO","Error:"+e.getMessage());
       }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
