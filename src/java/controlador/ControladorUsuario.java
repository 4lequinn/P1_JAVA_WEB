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
import modelo.dao.InscripcionDAO;
import modelo.dao.PerfilJugadorDAO;
import modelo.dao.UsuarioDAO;
import modelo.dto.EstadoSolicitud;
import modelo.dto.Incripcion;
import modelo.dto.PerfilJugador;
import modelo.dto.TipoJugador;
import modelo.dto.TipoUsuario;
import modelo.dto.Usuario;


public class ControladorUsuario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion=request.getParameter("btnAccion");
         if( opcion.equals("Loguear")){
             Loguear(request, response);
         }
         if( opcion.equals("RegistrarUsuario")){
             RegistrarUsuario(request,response);
         }
         if( opcion.equals("ModificarPerfil")){
             ModificarPerfil(request,response);
         }
         if( opcion.equals("EnviarSolicitud")){
             EnviarSolicitud(request,response);
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
    protected void RegistrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
           String usuario=request.getParameter("txtUsuario");
           String contrasenia=request.getParameter("txtContrasenia");
           TipoUsuario tipoUsuario=new TipoUsuario(2);
           Usuario u =new Usuario(usuario,tipoUsuario,contrasenia);
           UsuarioDAO daoU = new UsuarioDAO();
           String nombre=request.getParameter("txtNombre");
           String correo=request.getParameter("txtCorreo");
           String habilidad=request.getParameter("txtHabilidad");
           TipoJugador tipoJugador=new TipoJugador(Integer.parseInt(request.getParameter("cboTipoJugador")));
           PerfilJugador p = new PerfilJugador(tipoJugador, u, nombre, correo, habilidad);
           PerfilJugadorDAO daoJ = new PerfilJugadorDAO();
           if(daoU.agregar(u) && daoJ.agregar(p)){
               request.getSession().setAttribute("msOK","Usuario agregado correctamente");
           }
           else{
                request.getSession().setAttribute("msNO","El usuario no se ha podido agregar");
           }
       }catch(Exception e){
            request.getSession().setAttribute("msNO","Error:"+e.getMessage());
            }finally{
            response.sendRedirect("registro.jsp");
        }        
        
    }
    protected void ModificarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
           String usuario=request.getParameter("txtUsuario");
           String nombre=request.getParameter("txtNombre");
           String correo=request.getParameter("txtCorreo");
           String habilidad=request.getParameter("txtHabilidad");
           PerfilJugadorDAO daoP = new PerfilJugadorDAO();
           if(daoP.Modificar(usuario,nombre,correo,habilidad)){
               request.getSession().setAttribute("msOK","Usuario modificado correctamente");
           }
           else{
                request.getSession().setAttribute("msNO","El usuario no se ha podido modificar");
           }
       }catch(Exception e){
            request.getSession().setAttribute("msNO","Error:"+e.getMessage());
            }finally{
            response.sendRedirect("perfil_usuario.jsp");
        }        
        
    }
    protected void EnviarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
          HttpSession objSession=request.getSession(false);
          EstadoSolicitud e = new EstadoSolicitud(1);
          String usuario=String.valueOf(objSession.getAttribute("usuario"));
          PerfilJugadorDAO daoP = new PerfilJugadorDAO();
          PerfilJugador p = daoP.buscarPorNombreUsuario(usuario);
          InscripcionDAO daoI = new InscripcionDAO();
          // Arregla esto mukita uwu
          // Dejé el DAO inscripción tuki
          // La bd actualizala 
          Incripcion i = new Incripcion(e, p);
          if(daoI.agregar(i)){
              request.getSession().setAttribute("msOK","Solicitud enviada");
          }else{
                request.getSession().setAttribute("msNO","La solicitud no se ha podido enviar");
           }
       }catch(Exception e){
            request.getSession().setAttribute("msNO","Error:"+e.getMessage());
            }finally{
            response.sendRedirect("equipo.jsp");
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
