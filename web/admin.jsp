<%-- 
    Document   : login
    Created on : 13-09-2021, 17:58:54
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
UsuarioDAO dao = new UsuarioDAO();
HttpSession objSession=request.getSession(false);
String usuario=String.valueOf(objSession.getAttribute("usuario"));
if("null".equals(usuario) || dao.TipoUsuario(usuario)==2){
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
                        <th><input class="form-control" type="text" name="txtNombre" id="txtNombre" placeholder="Ingrese un Nombre" value="" required></th>
                        <th><input class="form-control" type="text" name="txtContrasenia" id="txtContrasenia" placeholder="Ingrese una contraseña" value="" required></th>
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
                        <td><a href="#" class="btn btn-primary"><i class="fas fa-shield-alt"></i>Modificar</a>
                            <a onclick="confirmDelete()"  class="btn btn-danger"><i class="fas fa-shield-alt"></i>Eliminar</a>
                            <!-- (<& = x.getId()&> a la función hace falta agregar el ID  -->
                        </td>
                    </tr>
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


