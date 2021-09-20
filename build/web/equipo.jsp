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
        <title>Registro Usuario</title>
    </head>
    <div class="home_content">
        <div class="container mt-5">
            <h3 class="text-left mb-3">Equipo</h3>
            <div class="table-responsive"> 
                <table class="table table-bordered table-striped">
                    <thead class="thead-">
                        <tr class="bg-warning">
                            <th>Nombre Equipo</th>
                            <th>Cantidad Jugador</th>
                            <th>Solicitud</th>
                        </tr>
                    </thead>
                    <tbody>

                        <tr>
                            <th>{{c.0}}</th>
                            <th>{{c.1}}</th>
                            <th><a href="#" class="btn btn-primary"><i class="fas fa-shield-alt"></i>Enviar Solicitud</a></th>
                        </tr>

                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/equipo.css">
</html>
