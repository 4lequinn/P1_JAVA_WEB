<%-- 
    Document   : login
    Created on : 13-09-2021, 17:58:54
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>
<%@page import="modelo.dto.Liga"%>
<%@page import="modelo.dao.LigaDAO"%>
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
        <title>Liga</title>
    </head>
    <div class="home_content">
        <div class="container mt-5">
            <h3 class="text-left mb-3">Liga</h3>
            <div class="table-responsive"> 
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre de la Liga</th>
                            <th>Cantidad de Equipo</th>
                            <th>Videojuego</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%  LigaDAO dao = new LigaDAO();
                        for (Liga aux:dao.listar()){ %>        
                        <tr>
                            <th><%=aux.getDescripcion() %></th>
                            <th><%=aux.getCantidadEquipo()%></th>
                            <th><%=aux.getVideoJuego().getNombre() %></th>
                        </tr>
                    <% }%>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/liga.css">
</html>
