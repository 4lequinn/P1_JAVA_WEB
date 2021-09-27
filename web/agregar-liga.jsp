<%-- 
    Document   : agregar-liga
    Created on : 27-09-2021, 0:16:20
    Author     : jorge
--%>

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
