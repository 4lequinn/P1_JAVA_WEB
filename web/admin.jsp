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
        <div class="container mt-5">
            <h2>Administrador de Usuario</h2>
            <table class="table">
                <thead class="thead-dark">
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
        <%@include file="base_footer.jsp" %>
    </div>

</html>


