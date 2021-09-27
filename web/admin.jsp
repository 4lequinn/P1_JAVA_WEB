<%-- 
    Document   : login
    Created on : 13-09-2021, 17:58:54
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    UsuarioDAO dao = new UsuarioDAO();
    HttpSession objSession = request.getSession(false);
    String usuario = String.valueOf(objSession.getAttribute("usuario"));
    if ("null".equals(usuario) || dao.TipoUsuario(usuario) == 2) {
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base_bar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Usuario</title>
    </head>
    <div class="home_content">
        <ul class="nav">
            <li class="nav-item ">
                <a class="nav-link" href="ControladorAdmin">Administrar Usuario</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="admin_equipo.jsp">Administrar Equipo</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ControladorAdminLiga">Administrar Liga</a>
            </li>
        </ul>
        <div class="container mt-5">
            <h2>Administrador de Usuario</h2>
            <table class="table ">
                <thead>
                    <tr>
                        <th><a href="ControladorUsuario?opcionUsuario=agregar" class="btn btn-success"><i class="fas fa-shield-alt"></i>Agregar</a></th>

                    </tr>
                </thead>
            </table>
        </div>
        <div class="container mt-5">
            <h2>Lista de Usuario</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Contraseña</th>
                        <th>Tipo Usuario</th>
                        <th>Opción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="x" items="${listaUsuarios}">
                    <form method="POST" action="ControladorUsuario">
                        <tr
                            <!-- Trucazo -->
                            <td>${x.getUsuario()}</td> <input value="${x.getUsuario()}" name="txtNomUser" id="txtNomUser" hidden>
                            <td>${x.getContrasenia()}</td> <input value="${x.getContrasenia()}" name="txtPassUser" id="txtPassUser" hidden>
                            <td>${x.getTipoUsuario().getDescripcion()}</td> <input value="${x.getTipoUsuario().getId()}" name="txtTipoUser" id="txtTipoUser" hidden>
                            <td>
                                <button type="submit" class="btn btn-primary" value="cargarDatosUsuario" name="btnAccion" id="btnAccion"><i class="fas fa-sign-in-alt"></i> Modificar</button>
                                <a href="#" onclick="eliminarUsuario('${x.getUsuario()}')"  class="btn btn-danger"><i class="fas fa-shield-alt"></i>Eliminar</a>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                <%
                    if (request.getSession().getAttribute("msj") != null) {
                %>
                <h4>${msj}</h4>
                <% } %>
                </tbody>
            </table>
            <%@include file="base_footer.jsp" %>
            <!--Importamos la librería Sweet Alert -->
            <jsp:include page="includes/cdn-sweet-alert.jsp"></jsp:include>
            <!-- Importamos el script de formulario -->
            <script src="static/js/formulario-eliminar.js" ></script>
            <link rel="stylesheet" href="static/css/admin.css">
        </div>


</html>


