<%-- 
    Document   : modificar-equipo
    Created on : 27-09-2021, 0:15:56
    Author     : jorge
--%>

<%@page import="modelo.dto.Equipo"%>
<%
    UsuarioDAO dao = new UsuarioDAO();
    HttpSession objSession = request.getSession(false);
    String usuario = String.valueOf(objSession.getAttribute("usuario"));
    if ("null".equals(usuario) || dao.TipoUsuario(usuario) == 2) {
        response.sendRedirect("login.jsp");
    }
%>
<%@page import="modelo.dto.Liga"%>
<%@page import="modelo.dao.LigaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base_bar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
        <title>Modificar Equipo</title>
    </head>
    <div class="home_content">
        <div class="modal-dialog text-center " style="z-index: 1;">
            <div class="col-xs-12 col-md-14 main-section">
                <div class="modal-content">
                    <div class="col-12 user-img mt-4">
                        <h2>Modificar Equipo</h2>
                    </div>
                    <%
                        Equipo equipo = (Equipo) request.getSession().getAttribute("datosEquipo");
                    %>
                    <form class="col-12" action="ControladorAdminEquipo" method="POST">
                        <div class="form-group" id="equipo-group">
                            <input class="form-control" type="text" name="txtIdEquipo" id="txtIdEquipo" value="<%= equipo.getId()%>" hidden>
                            <input class="form-control" type="text" name="txtCantidad" id="txtIdEquipo" value="<%= equipo.getCantidadJugador() %>" hidden>
                            <input class="form-control" type="text" name="txtPerfil" id="txtIdEquipo" value="<%= equipo.getPerfilJugador().getId() %>" hidden>
                            <input class="form-control" type="text" name="txtNombreEquipo" id="txtNombreEquipo" placeholder="Ingrese el nombre del equipo" value="<%= equipo.getNombre() %>" required>
                        </div> 

                        <div class="form-group" required>
                            <select name="cboLiga" class="form-control">
                                <% 
                                    LigaDAO Liga = new LigaDAO();
                                    for(Liga x: Liga.listar()){
                                %>  
                                    <% if(x.getId()==equipo.getId()){ %>
                                        <option selected value="<%= x.getId() %>"><%= x.getDescripcion() %></option>
                                    <% }else if(x.getId()!=equipo.getId()){ %>
                                       <option value="<%= x.getId() %>"><%= x.getDescripcion() %></option>
                                    <% } %>
                                <%  } %>
                            </select>    
                        </div> 
                        <button type="submit" class="btn btn-primary" value="ModificarEquipo" name="btnAccion" id="btnAccion"><i class="fas fa-sign-in-alt"></i>  Modificar Equipo </button>
                    </form>
                    <div>
                        ${msjt}
                    </div>
                </div>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/crear_equipo.css">
</html>
