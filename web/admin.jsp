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
                <a class="nav-link" href="admin_liga.jsp">Administrar Liga</a>
            </li>
        </ul>
        <div class="container mt-5">
            <h2>Administrador de Usuario</h2>
            <table class="table ">
                <thead>
                    <tr>
                        <th><a href="#" class="btn btn-success"><i class="fas fa-shield-alt"></i>Agregar</a></th>

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
                        <th>Opción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="x" items="${listaUsuarios}">
                        <tr>
                            <td>${x.getUsuario()}</td>
                            <td>${x.getContrasenia()}</td>
                            <td>
                                <a href="#" class="btn btn-primary"><i class="fas fa-shield-alt"></i>Modificar</a>
                                <a href="#" onclick="confirmDelete('${x.getUsuario()}')"  class="btn btn-danger"><i class="fas fa-shield-alt"></i>Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <%
                        if (request.getSession().getAttribute("msj") != null) {
                    %>
                <h4>${msj}</h4>
                <% }%>
                </tbody>
            </table>
            <!-- MODAL -->
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Launch demo modal
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            ...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
        <!--Importamos la librería Sweet Alert -->
        <jsp:include page="includes/cdn-sweet-alert.jsp"></jsp:include>
        <!-- Importamos el script de formulario -->
        <script src="static/js/formulario-eliminar.js" ></script>
        <link rel="stylesheet" href="static/css/admin.css">
    </div>


</html>


