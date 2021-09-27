<%-- 
    Document   : agregar-liga
    Created on : 27-09-2021, 0:16:20
    Author     : jorge
--%>

<%@page import="modelo.dto.VideoJuego"%>
<%@page import="modelo.dao.VideoJuegoDAO"%>
<%@page import="modelo.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UsuarioDAO dao = new UsuarioDAO();
    HttpSession objSession = request.getSession(false);
    String usuario = String.valueOf(objSession.getAttribute("usuario"));
    if ("null".equals(usuario) || dao.TipoUsuario(usuario) == 2) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base_bar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
        <title>Ligas</title>
    </head>
    <div class="home_content">
        <div class="modal-dialog text-center " style="z-index: 1;">
            <div class="col-xs-12 col-md-14 main-section">
                <div class="modal-content">
                    <div class="col-12 user-img mt-4">
                        <h2>Agregar Ligas</h2>
                    </div>
                    <form class="col-12" action="ControladorAdminLiga" method="POST">
                        <div class="form-group" id="name-group">
                            <input class="form-control" type="text" name="txtDescripcion" id="txtDescripcion" placeholder="Ingrese un Nombre" value="" required>
                        </div> 

                        <div class="form-group" required>
                            <select name="cboVideoJuego" class="form-control">
                                <option selected disabled >Seleccione un vídeo juego</option>
                                <%
                                    VideoJuegoDAO videoJuegos = new VideoJuegoDAO();
                                    for (VideoJuego x : videoJuegos.listar()) {
                                %>  
                                <option value="<%= x.getId()%>"><%= x.getNombre()%></option>
                                <%  }%>
                            </select>    
                        </div> 

                        <button type="submit" class="btn btn-primary" value="AgregarLiga" name="btnAccion" id="btnAccion"><i class="fas fa-sign-in-alt"></i>Agregar</button>
                    </form>
                    <div>
                        ${msjl}
                    </div>
                </div>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/registro.css">
</html>

