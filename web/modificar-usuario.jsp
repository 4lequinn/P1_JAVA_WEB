<%-- 
    Document   : modificar-usuario
    Created on : 26-09-2021, 17:13:06
    Author     : jorge
--%>
<%@page import="modelo.dto.Usuario"%>
<%@page import="modelo.dto.TipoUsuario"%>
<%@page import="modelo.dao.TipoUsuarioDAO"%>
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
        <title>Registro</title>
    </head>
    <div class="home_content">
        <div class="modal-dialog text-center " style="z-index: 1;">
            <div class="col-xs-12 col-md-14 main-section">
                <div class="modal-content">
                    <div class="col-12 user-img mt-4">
                        <h2>Modificar Usuario</h2>
                        <form class="col-12" action="ControladorUsuario" method="POST">
                            <!--Usuario-->
                            <%
                                Usuario user = (Usuario) request.getSession().getAttribute("datosUsuario");
                            %>
                            <div class="form-group" id="user-group">
                                <input class="form-control" type="text" placeholder="Ingrese un Usuario" value="<%= user.getUsuario()%>" disabled required>
                                <input class="form-control" type="text" name="txtUsuario" id="user" placeholder="Ingrese un Usuario" value="<%= user.getUsuario()%>" hidden>
                            </div>
                            <div class="form-group" id="contrasena-group">
                                <input class="form-control" type="text" name="txtContrasenia" id="passw1" placeholder="Ingrese una Contraseña" value="<%= user.getContrasenia()%>" required> 
                            </div>
                            <div class="form-group" id="tipo-group">
                                <select name="cboTipoJugador" class="form-control">
                                    <%
                                        TipoUsuarioDAO tipoDAO = new TipoUsuarioDAO();
                                        for (TipoUsuario x : tipoDAO.listar()) {
                                    %> 

                                    <% if (x.getId() == user.getTipoUsuario().getId()) {%>
                                    <option selected value="<%= x.getId()%>"><%= x.getDescripcion()%></option>
                                    <% } else if (x.getId() != user.getTipoUsuario().getId()) {%>
                                    <option value="<%= x.getId()%>"><%= x.getDescripcion()%></option>
                                    <%  } %>

                                    <% } %>

                                </select>    
                            </div>
                            <button type="submit" class="btn btn-primary" value="ModificarUsuario" name="btnAccion" id="btnAccion"><i class="fas fa-sign-in-alt"></i>Modificar Usuario</button>
                        </form>
                        <% if (request.getSession().getAttribute("msju") != null) { %>
                        <h3>${msju}</h3>
                        <% }%>
                    </div>
                </div>
            </div>
            <%@include file="base_footer.jsp" %>
        </div>
        <link rel="stylesheet" href="static/css/registro.css">
        </html>