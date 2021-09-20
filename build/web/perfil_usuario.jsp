<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <%@include file="base_bar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
        <title>Perfil Usuario</title>
    </head>
    <div class="home_content">
        <div class="modal-dialog text-center " style="z-index: 1;">
            <div class="col-xs-12 col-md-14 main-section">
                <div class="modal-content">
                    <div class="col-12 user-img">
                        <div>
                            <h2>Perfil</h2>
                        </div>
                    </div>
                    <form class="col-12" action="{% url 'REG'%}" method="POST">
                        <div class="form-group" id="name-group">
                            <input class="form-control" type="text" name="txtNombre" id="txtNombre" placeholder="Ingrese un Nombre" value="" required>
                        </div> 
                        <div class="form-group" id="email-group">
                            <input class="form-control" type="email" name="txtCorreo" id="correo" placeholder="Ingrese un Correo" value="">
                        </div>   
                        <div class="form-group" id="user-group">
                            <input class="form-control" type="text" name="txtUsuario" id="user" placeholder="Ingrese un Usuario" value="" required>
                        </div>
                        <div class="form-group" id="contrasena-group">
                            <input class="form-control" type="password" name="txtContrasenia" id="passw1" placeholder="Ingrese una Contraseña" value="" required> 
                        </div>
                        <button type="submit" class="btn btn-primary"><i value="Registrar" class="fas fa-sign-in-alt"></i>  Editar </button>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/registro.css">
</html>
