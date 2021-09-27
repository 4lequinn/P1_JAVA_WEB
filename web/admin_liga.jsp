<%-- 
    Document   : login
    Created on : 13-09-2021, 17:58:54
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base_bar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Liga</title>
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
            <h2>Administrar Liga</h2>
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th><a href="#" class="btn btn-success"><i class="fas fa-shield-alt"></i>Agregar</a></th>
                    </tr>
                </thead>
            </table>
        </div>
        <div class="container mt-5">
            <h2>Lista de Liga</h2>
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th>Descripción</th>
                        <th>Video Juego</th>
                        <th>Opción</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="x" items="${listaLigas}">
                    <form method="POST" action="ControladorUsuario">
                        <tr>
                            <td>${x.getDescripcion()}</td>
                            <td>${x.getVideoJuego().getNombre()}</td>
                            <td>
                                <a href="#" class="btn btn-primary"><i class="fas fa-shield-alt"></i>Modificar</a>
                                <a onclick="eliminarLiga(${x.getId()})"  class="btn btn-danger"><i class="fas fa-shield-alt"></i>Eliminar</a>
                            </td>
                        </tr>
                    </form>
                    </c:forEach>

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


