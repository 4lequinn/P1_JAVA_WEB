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
        <section>
            <div class="modal-dialog text-center" style="z-index: 1;">
                <div class="col-xs-12 col-md-14 main-section">
                    <div class="modal-content">
                        <div class="col-12 user-img">
                            <img src="static/img/avatar.png" th:src="@{/img/user.png}" />
                            <div>
                                <h2 style="color: white;">Ingresa a tu cuenta</h2>
                            </div>
                        </div>
                        <form class="col-12" action="ControladorUsuario" method="POST" onsubmit="return validarTodo_formularioUsuario()">
                            <div class="form-group" id="user-group">
                                <input class="form-control" type="text" name="txtUser" id="user" placeholder="Ingrese su Usuario" value="">
                            </div>
                            <div class="form-group" id="contrasena-group">
                                <input class="form-control" type="password" name="txtPass" id="pass" placeholder="Ingrese su Contraseña" value="">
                            </div>
                            <button type="submit" class="btn btn-primary" value="Loguear" name="btnAccion" id="btnAccion"><i class="fas fa-sign-in-alt"></i>  Ingresar </button>
                        </form>
                        <div class="condicion">
                            <p><a href="registro.jsp">¿No tienes cuenta? Crea una aquí</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/login.css">
</html>
