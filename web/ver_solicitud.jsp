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
        <title>Ver solicitudes</title>
    </head>
    <div class="home_content">
        <div class="container mt-5">
            <h3 class="text-left mb-3">Equipo</h3>
            <div class="table-responsive"> 
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre del usuario</th>
                            <th>Nombre de la persona</th>
                            <th>Correo</th>
                            <th>Habilidad</th>
                            <th>Tipo de jugador</th>
                            <th>Fecha</th>
                            <th>Estado solicitud</th>
                        </tr>
                    </thead>
                    <tbody>      
                        <tr>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/equipo.css">
</html>
