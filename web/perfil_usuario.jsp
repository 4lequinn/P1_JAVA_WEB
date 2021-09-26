<%@page import="modelo.dto.PerfilJugador"%>
<%@page import="modelo.dao.PerfilJugadorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
HttpSession objSession=request.getSession(false);
String usuario=String.valueOf(objSession.getAttribute("usuario"));
if("null".equals(usuario)){
    response.sendRedirect("login.jsp");
}
%>
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
                    <form class="col-12" action="ControladorUsuario" method="POST">
                        <%  
                            PerfilJugadorDAO dao = new PerfilJugadorDAO();
                            PerfilJugador perfilJugador=dao.buscarPorNombreUsuario(usuario);
                        %>
                        <div class="form-group" id="user-group">
                            <input class="form-control" type="text" placeholder="Ingrese un Usuario" value="<%=perfilJugador.getUsuario().getUsuario() %>" required="" disabled="">
                            <input class="form-control" type="text" name="txtUsuario" id="user" placeholder="Ingrese un Usuario" value="<%=perfilJugador.getUsuario().getUsuario() %>" required="" hidden>
                        </div>
                        <div class="form-group" id="name-group">
                            <input class="form-control" type="text" name="txtNombre" id="txtNombre" placeholder="Ingrese un Nombre" value="<%=perfilJugador.getNombre() %>" required="">
                        </div> 
                        <div class="form-group" id="email-group">
                            <input class="form-control" type="email" name="txtCorreo" id="correo" placeholder="Ingrese un Correo" value="<%=perfilJugador.getCorreo() %>" required="">
                        </div>
                        <div class="form-group" id="name-group">
                            <input class="form-control" type="text" name="txtHabilidad" id="txtHabilidad" placeholder="Ingrese su Habilidad" value="<%=perfilJugador.getHabilidad()%>" required="">
                        </div> 
                        <div class="form-group">
                            <select name="cboTipoJugador" class="form-control" disabled="">
                                <option value="<%=perfilJugador.getTipoJugador().getId() %>"><%=perfilJugador.getTipoJugador().getDescripcion() %> </option>
                            </select>    
                        </div> 
                        <button type="submit" class="btn btn-primary" value="ModificarPerfil" name="btnAccion" id="btnAccion"><i class="fas fa-sign-in-alt"></i>  Editar </button>
                    </form>
                                
                </div>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/perfil.css">
</html>
