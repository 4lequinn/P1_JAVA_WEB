<%-- 
    Document   : login
    Created on : 13-09-2021, 17:58:54
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>
<%@page import="modelo.dto.Equipo"%>
<%@page import="modelo.dao.EquipoDAO"%>
<%
HttpSession objSession=request.getSession(false);
String usuario=String.valueOf(objSession.getAttribute("usuario"));
if("null".equals(usuario)){
    response.sendRedirect("login.jsp");
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base_bar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipo</title>
    </head>
    <div class="home_content">
        <div class="container mt-5">
            <h3 class="text-left mb-3">Equipo</h3>
            <div class="table-responsive"> 
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre Equipo</th>
                            <th>Cantidad Jugador</th>
                            <th>Liga</th>
                            <th>Capitan Equipo</th>
                            <th>Solicitud</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%  EquipoDAO dao = new EquipoDAO();
                        for (Equipo aux:dao.listar()){ %>        
                        <tr>
                            <form action="ControladorUsuario" method="post">
                            <th>
                                <input class="form-control" type="number" name="txtIdEquipo" id="txtIdEquipo" value="<%=aux.getId() %>" required="" hidden="">
                                <%=aux.getNombre() %>
                            </th>
                            <th>      
                                <%=aux.getCantidadJugador()%>
                            </th>
                            <th>     
                                <%=aux.getLiga().getDescripcion() %>
                            </th>
                            <th>
                                <%=aux.getPerfilJugador().getUsuario().getUsuario() %>
                            </th>
                            <th><button type="submit" class="btn btn-primary" value="EnviarSolicitud" name="btnAccion" id="btnAccion"><i class="fas fa-sign-in-alt"></i>  Enviar solicitud </button></th>
                            </form>
                        </tr>
                    <% }%>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/equipo.css">
</html>
