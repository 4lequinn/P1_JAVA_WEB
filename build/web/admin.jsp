<%-- 
    Document   : login
    Created on : 13-09-2021, 17:58:54
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base_bar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
    </head>
    <div class="home_content">
        <div class="container">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Administrar Usuario</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Administrar Liga</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Administrar Equipo</a>
                </li>
            </ul>
        </div>
        <div class="container mt-5">
            <h2>Administrar Usuario</h2>
            <form  action="index.jsp" method="POST">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th><input class="form-control" type="text" name="txtNombre" id="txtNombre" placeholder="Ingrese un Nombre" value="" required></th>
                            <th><input class="form-control" type="text" name="txtContrasenia" id="txtContrasenia" placeholder="Ingrese una contraseña" value="" required></th>
                            <th><a href="#" class="btn btn-success"><i class="fas fa-shield-alt"></i>Agregar</a></th>
                        </tr>
                    </thead>
                </table>
            </form>
        </div>
        <div class="container mt-5">
            <h2>Lista de Usuario</h2>
            <div class="table-responsive-sm">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th>Usuario</th>
                            <th>Contraseña</th>
                            <th>Opción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>John</td>
                            <td>Doe1274</td>
                            <td><a href="#" class="btn btn-primary"><i class="fas fa-shield-alt"></i>Modificar</a>
                                <a href="#" class="btn btn-danger"><i class="fas fa-shield-alt"></i>Eliminar</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
    </div>


</html>


