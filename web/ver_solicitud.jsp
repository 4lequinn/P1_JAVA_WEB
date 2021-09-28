<%-- 
    Document   : login
    Created on : 13-09-2021, 17:58:54
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>
<%@page import="java.util.List"%>
<%@page import="modelo.dto.Incripcion"%>
<%@page import="modelo.dao.InscripcionDAO"%>
<%@page import="modelo.dto.PerfilJugador"%>
<%@page import="modelo.dao.PerfilJugadorDAO"%>
<%@page import="modelo.dto.Equipo"%>
<%@page import="modelo.dao.EquipoDAO"%>
<%
HttpSession objSession=request.getSession(false);
String usuario=String.valueOf(objSession.getAttribute("usuario"));
if("null".equals(usuario)){
    response.sendRedirect("login.jsp");
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base_bar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver solicitudes</title>
    </head>
    <div class="home_content">
        <div class="container mt-5">
            <h3 class="text-left mb-3">Solicitudes</h3>
            <div class="table-responsive"> 
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre del usuario</th>
                            <th>Nombre de la persona</th>
                            <th>Correo</th>
                            <th>Habilidad</th>
                            <th>Tipo de jugador</th>
                            <th>Fecha</th>
                            <th>Estado solicitud</th>
                            <th>Nombre de equipo a solicitar</th>
                            <th>Aceptar/Rechazar</th>
                        </tr>
                    </thead>
                    <tbody> 
                       <% 
                           PerfilJugadorDAO daoP = new PerfilJugadorDAO();
                           PerfilJugador pj = daoP.buscarPorNombreUsuario(usuario);
                           InscripcionDAO daoI = new InscripcionDAO();
                           EquipoDAO daoE = new EquipoDAO();
                       for (Equipo aux: daoE.buscarEquipoPorPerfil(pj.getId())){ 
                           for(Incripcion aux2:daoI.buscarIncripcionPorEquipo(aux.getId())){ 
                       %>              
                        <tr>
                            <form action="ControladorUsuario" method="post">
                            <th>
                                <input class="form-control" type="number" name="txtIdSolicitud" id="txtIdSolicitud" value="<%=aux2.getId() %>" required="" hidden="">
                                <%=aux2.getPerfilJugador().getUsuario().getUsuario() %>
                            </th>
                            <th><%=aux2.getPerfilJugador().getNombre() %></th>
                            <th><%=aux2.getPerfilJugador().getCorreo() %></th>
                            <th><%=aux2.getPerfilJugador().getHabilidad() %></th>s
                            <th><%=aux2.getPerfilJugador().getTipoJugador().getDescripcion() %></th>
                            <th><%=aux2.getFecha() %></th>
                            <th><%=aux2.getEstadoSolicitud().getDescripcion() %></th>
                            <th><%=aux2.getEquipo().getNombre() %></th>    
                            <th><button type="submit" class="btn btn-success mb-1" value="AceptarSolicitud" name="btnAccion" id="btnAccion"> Aceptar </button>
                                <button type="submit" class="btn btn-danger mt-1" value="RechazarSolicitud" name="btnAccion" id="btnAccion"> Rechazar </button></th>
                            
                            </form>
                        </tr>
                            <% }%>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/equipo.css">
</html>
