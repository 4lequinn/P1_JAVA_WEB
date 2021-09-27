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
        <title>Administrar Equipo</title>
    </head>
    <div class="home_content">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="ControladorAdmin">Administrar Usuario</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ControladorAdminEquipo">Administrar Equipo</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ControladorAdminLiga">Administrar Liga</a>
            </li>
        </ul>
        <div class="container mt-5">
            <h2>Administrar Equipo</h2>
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th><a href="#" class="btn btn-success"><i class="fas fa-shield-alt"></i>Agregar</a></th>
                    </tr>
                </thead>
            </table>
        </div>
        <div class="container mt-5">
            <h2>Lista de Equipo</h2>
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th>Nombre del Equipo</th>
                        <th>Liga</th>
                        <th>Capitán</th>
                        <th>Miembros</th>
                        <th>Cupos</th>
                        <th>Opción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="x" items="${listaEquipos}">
                    <tr>
                        <td>${x.getNombre()}</td>
                        <td>${x.getLiga().getDescripcion()}</td>
                        <td>${x.getPerfilJugador().getUsuario().getUsuario()}</td>
                        <td>${x.getCantidadJugador()}</td>
                        <td>${ 8 - x.getCantidadJugador()}</td>
                        <td>
                            <a href="#" class="btn btn-primary"><i class="fas fa-shield-alt"></i>Modificar</a>
                            <a onclick="eliminarEquipo(${x.getId()})"  class="btn btn-danger"><i class="fas fa-shield-alt"></i>Eliminar</a>
                        </td>
                    </c:forEach>
                    </tr>
                </tbody>
            </table>
        </div>
        <%@include file="base_footer.jsp" %>
        <!--Importamos la librería Sweet Alert -->
        <jsp:include page="includes/cdn-sweet-alert.jsp"></jsp:include>
        <!-- Importamos el script de formulario -->
        <script src="static/js/formulario-eliminar.js" ></script>
        <link rel="stylesheet" href="static/css/admin.css">
    </div>

</html>


