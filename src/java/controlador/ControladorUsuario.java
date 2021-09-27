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
import modelo.dao.EquipoDAO;
import modelo.dao.InscripcionDAO;
import modelo.dao.PerfilJugadorDAO;
import modelo.dao.UsuarioDAO;
import modelo.dto.Equipo;
import modelo.dto.EstadoSolicitud;
import modelo.dto.Incripcion;
import modelo.dto.Liga;
import modelo.dto.PerfilJugador;
import modelo.dto.TipoJugador;
import modelo.dto.TipoUsuario;
import modelo.dto.Usuario;


public class ControladorUsuario extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();

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
         if(opcion.equalsIgnoreCase("AgregarUsuario")){
             agregarUsuario(request, response);
         }
         if(opcion.equalsIgnoreCase("cargarDatosUsuario")){
            cargarDatosUsuario(request, response);
         }
         if(opcion.equalsIgnoreCase("ModificarUsuario")){
             modificarUsuario(request, response);
         }
         if(opcion.equalsIgnoreCase("RegistrarEquipo")){
             RegistrarEquipo(request, response);
         }
         if(opcion.equalsIgnoreCase("AceptarSolicitud")){
             AceptarSolicitud(request, response);
         }
         if(opcion.equalsIgnoreCase("RechazarSolicitud")){
             RechazarSolicitud(request, response);
         }
    }
    protected void Loguear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
           String nombre=request.getParameter("txtUser");
           String contrasena=request.getParameter("txtPass");
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
          int idEquipo=Integer.parseInt(request.getParameter("txtIdEquipo"));
          EquipoDAO daoE = new EquipoDAO();
          Equipo e = daoE.buscar(idEquipo);
          HttpSession objSession=request.getSession(false);
          EstadoSolicitud es = new EstadoSolicitud(1);
          String usuario=String.valueOf(objSession.getAttribute("usuario"));
          PerfilJugadorDAO daoP = new PerfilJugadorDAO();
          PerfilJugador p = daoP.buscarPorNombreUsuario(usuario);
          InscripcionDAO daoI = new InscripcionDAO();
          // Arregla esto mukita uwu
          // Dejé el DAO inscripción tuki
          // La bd actualizala 
          Incripcion i = new Incripcion(e, es,p);
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
    
    protected void RegistrarEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Buscar el usuario actual de la session
            HttpSession objSession2 = request.getSession(false);
            String usuario = (String) objSession2.getAttribute("usuario");

            //Dao
            EquipoDAO daoE = new EquipoDAO();
            PerfilJugadorDAO daoP = new PerfilJugadorDAO();

            //Campos para crear Equipo
            String nombre = request.getParameter("txtEquipo");
            Liga l = new Liga(Integer.parseInt(request.getParameter("cboLiga")));
            
            //Se busca el perfil de jugador con el usuario encontrado anteriormente
            PerfilJugador p = daoP.buscarIdUsuario(usuario);
            
            //Se pasa los parametros a equipo
            Equipo e = new Equipo(1, l, p, nombre, 1);
            
            //Se agrega el equipo
            if (daoE.agregar(e)) {
                request.getSession().setAttribute("msOK", "Equipo agregado correctamente");
            } else {
                request.getSession().setAttribute("msNO", "El Equipo no se ha podido agregar");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("msNO", "Error:" + e.getMessage());
        } finally {
            response.sendRedirect("crear_equipo.jsp");
        }
    }
    
    
    protected void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String usuario = request.getParameter("usuario");
            if(dao.eliminar(usuario)){
                request.getSession().setAttribute("msj", "Usuario " + usuario + " Eliminado!");
            }else{
                request.getSession().setAttribute("msj", "No eliminado!");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("msj", "Error");
        }finally{
            response.sendRedirect("ControladorAdmin");
        }
    
    }
    
    protected void agregarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        try {
            String usuario=request.getParameter("txtUsuario");
            String contrasenia=request.getParameter("txtContrasenia");
            int tipo = Integer.parseInt(request.getParameter("cboTipoJugador"));
            TipoUsuario tipoUsuario = new TipoUsuario(tipo);
            Usuario u = new Usuario(usuario, tipoUsuario, contrasenia);
            if(dao.agregar(u)){
                request.getSession().setAttribute("msja", "Agregó!");
            }else{
                request.getSession().setAttribute("msja", "No agregó!");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("msja", "ERROR");
        }finally{
            response.sendRedirect("agregar-usuario.jsp");
        }
    }
    
    protected void modificarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        try {
            String usuario=request.getParameter("txtUsuario");
            String contrasenia=request.getParameter("txtContrasenia");
            int tipo = Integer.parseInt(request.getParameter("cboTipoJugador"));
            TipoUsuario tipoUsuario = new TipoUsuario(tipo);
            Usuario u = new Usuario(usuario, tipoUsuario, contrasenia);
            if(dao.modificar(u)){
                request.getSession().setAttribute("msju", "Modificó!");
            }else{
                request.getSession().setAttribute("msju", "No Modificó!");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("msju", "ERROR");
        }finally{
            response.sendRedirect("modificar-usuario.jsp");
        }
    }
    
    protected void cargarDatosUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String usuario = request.getParameter("txtNomUser");
        String contrasenia = request.getParameter("txtPassUser");
        int tipo = Integer.parseInt(request.getParameter("txtTipoUser"));
        TipoUsuario tipoUsuario = new TipoUsuario(tipo);
        Usuario usu = new Usuario(usuario, tipoUsuario, contrasenia);
        request.getSession().setAttribute("datosUsuario", usu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            response.sendRedirect("modificar-usuario.jsp");
        }
    }
    protected void AceptarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
             int idSolicitud = Integer.parseInt(request.getParameter("txtIdSolicitud"));
             EstadoSolicitud e = new EstadoSolicitud(2);
             InscripcionDAO daoI = new InscripcionDAO();
             if(daoI.modificarEstadoIncripcion(idSolicitud,e)){
                request.getSession().setAttribute("msj", "Aceptó la solicitud");
            }else{
                request.getSession().setAttribute("msj", "No se pudo aceptar la solicitud!");
            }
        }catch(Exception e){
            request.getSession().setAttribute("msj", "ERROR");
        }
        finally{
            response.sendRedirect("ver_solicitud.jsp");
        }

    }
    protected void RechazarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
            int idSolicitud = Integer.parseInt(request.getParameter("txtIdSolicitud"));
            EstadoSolicitud e = new EstadoSolicitud(3);
            InscripcionDAO daoI = new InscripcionDAO();
             if(daoI.modificarEstadoIncripcion(idSolicitud,e)){
                request.getSession().setAttribute("msj", "Rechazó la solicitud");
            }else{
                request.getSession().setAttribute("msj", "No se pudo Rechazar la solicitud!");
            }
        }catch(Exception e){
            request.getSession().setAttribute("msj", "ERROR");
        }
        finally{
            response.sendRedirect("ver_solicitud.jsp");
        }


    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if(request.getParameter("opcionUsuario") != null){
                if(request.getParameter("opcionUsuario").equals("agregar")){
                   request.getRequestDispatcher("agregar-usuario.jsp").forward(request, response);
                }
            }else{
                //Verificamos si se manda un usuario por GET
                String usuario = request.getParameter("usuario");
                eliminarUsuario(request, response);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
