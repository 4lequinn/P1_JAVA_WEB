<%-- 
    Document   : registro
    Created on : 13-sep-2021, 19:07:19
    Author     : sebas
--%>
<%@page import="modelo.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession objSession2 = request.getSession(false);
    UsuarioDAO dao2 = new UsuarioDAO();
    String usuario2 = (String) objSession2.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="static/css/base.css">
        <!-- Boxicons CSS -->
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="icon" href="static/img/icon.png">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="siderbar">
            <div class="logo_content">
                <div class="logo">
                    <i class='bx bx-game' ></i>
                    <div class="logo_name">Video Juegos</div>
                </div>
                <i class='bx bx-menu' id="btn"></i>
            </div>
            <ul class="nav_list">
                <%if (dao2.TipoUsuario(usuario2) == 0) { %>
                <li>
                    <a href="index.jsp">
                        <i class='bx bx-grid-alt'></i>
                        <span class="links_name">Inicio</span>
                    </a>
                    <span class="tooltip">Inicio</span>
                </li>
                <li>
                    <a href="registro.jsp">
                        <i class='bx bx-lock'></i>
                        <span class="links_name">Registro</span>
                    </a>
                    <span class="tooltip">Registro</span>
                </li>
                <li>
                    <a href="login.jsp">
                        <i class='bx bx-log-in'></i>
                        <span class="links_name">Inicio Sesion</span>
                    </a>
                    <span class="tooltip">Inicio Sesion</span>
                </li>
                <%}%>
                <%if (dao2.TipoUsuario(usuario2) == 1) { %>
                <li>
                    <a href="index.jsp">
                        <i class='bx bx-grid-alt'></i>
                        <span class="links_name">Inicio</span>
                    </a>
                    <span class="tooltip">Inicio</span>
                </li>
                <li>
                    <a href="perfil_usuario.jsp">
                        <i class='bx bxs-id-card'></i>
                        <span class="links_name">Perfil Jugador</span>
                    </a>
                    <span class="tooltip">Perfil Jugador</span>
                </li>
                <li>
                    <a href="liga.jsp">
                        <i class='bx bx-desktop'></i>
                        <span class="links_name">Lista Liga</span>
                    </a>
                    <span class="tooltip">Lista Liga</span>
                </li>
                <li>
                    <a href="equipo.jsp">
                        <i class='bx bx-mouse'></i>
                        <span class="links_name">Lista Equipo</span>
                    </a>
                    <span class="tooltip">Lista Equipo</span>
                </li>
                <li>
                    <a href="crear_equipo.jsp">
                        <i class='bx bx-group'></i>
                        <span class="links_name">Crear Equipo</span>
                    </a>
                    <span class="tooltip">Crear Equipo</span>
                </li> 
                <li>
                    <a href="ver_solicitud.jsp">
                        <i class='bx bx-search'></i>
                        <span class="links_name">Ver solicitudes</span>
                    </a>
                    <span class="tooltip">Ver solicitudes</span>
                </li> 
                <li>
                    <a href="ControladorAdmin">
                        <i class='bx bx-lock'></i>
                        <span class="links_name">Admin</span>
                    </a>
                    <span class="tooltip">Admin</span>
                </li>
                <div class="profile_content">
                    <div class="profile">
                        <div class="profile_details">
                            <img src="static/img/imagen.jpg" alt="">
                            <div class="name_job">
                                <div class="name"><% out.println(usuario2);%></div>
                                <div class="job">Administrador</div>
                            </div>
                        </div>
                        <a href="index.jsp?c=1"><i class='bx bx-log-out' id="log_out"></i></a> 
                            <%if (request.getParameter("c") != null) {
                                    objSession2.invalidate();
                                    response.sendRedirect("index.jsp");
                                }
                            %>
                    </div>
                </div>
                <%}%>
                <%if (dao2.TipoUsuario(usuario2) == 2) { %>
                <li>
                    <a href="index.jsp">
                        <i class='bx bx-grid-alt'></i>
                        <span class="links_name">Inicio</span>
                    </a>
                    <span class="tooltip">Inicio</span>
                </li>
                <li>
                    <a href="perfil_usuario.jsp">
                        <i class='bx bxs-id-card'></i>
                        <span class="links_name">Perfil Jugador</span>
                    </a>
                    <span class="tooltip">Perfil Jugador</span>
                </li>
                <li>
                    <a href="liga.jsp">
                        <i class='bx bx-desktop'></i>
                        <span class="links_name">Liga</span>
                    </a>
                    <span class="tooltip">Liga</span>
                </li>
                <li>
                    <a href="equipo.jsp">
                        <i class='bx bx-mouse'></i>
                        <span class="links_name">Equipo</span>
                    </a>
                    <span class="tooltip">Equipo</span>
                </li>   
                <li>
                    <a href="crear_equipo.jsp">
                        <i class='bx bx-group'></i>
                        <span class="links_name">Crear Equipo</span>
                    </a>
                    <span class="tooltip">Crear Equipo</span>
                </li> 
                <li>
                    <a href="ver_solicitud.jsp">
                        <i class='bx bx-search'></i>
                        <span class="links_name">Ver solicitudes</span>
                    </a>
                    <span class="tooltip">Ver solicitudes</span>
                </li> 
                <div class="profile_content">
                    <div class="profile">
                        <div class="profile_details">
                            <img src="static/img/imagen.jpg" alt="">
                            <div class="name_job">
                                <div class="name"><% out.println(usuario2);%></div>
                                <div class="job">Usuario</div>
                            </div>
                        </div>
                        <a href="index.jsp?c=1"><i class='bx bx-log-out' id="log_out"></i></a> 
                            <%if (request.getParameter("c") != null) {
                                    objSession2.invalidate();
                                    response.sendRedirect("index.jsp");
                                }
                            %>
                    </div>
                </div>

                <%}%>
            </ul>

        </div>
        <script src="static/js/menu.js"></script>
    </body>
</html>