package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.dao.UsuarioDAO;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/base_bar.jsp");
    _jspx_dependants.add("/base_footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');

UsuarioDAO dao = new UsuarioDAO();
HttpSession objSession=request.getSession(false);
String usuario=String.valueOf(objSession.getAttribute("usuario"));
if("null".equals(usuario)){
    response.sendRedirect("login.jsp");
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
HttpSession objSession2=request.getSession(false);
UsuarioDAO dao2 = new UsuarioDAO(); 
String usuario2=(String)objSession2.getAttribute("usuario");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/base.css\">\n");
      out.write("    <!-- Boxicons CSS -->\n");
      out.write("    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"icon\" href=\"static/img/icon.png\">\n");
      out.write("    \n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"siderbar\">\n");
      out.write("        <div class=\"logo_content\">\n");
      out.write("            <div class=\"logo\">\n");
      out.write("                <i class='bx bx-game' ></i>\n");
      out.write("                <div class=\"logo_name\">Video Juegos</div>\n");
      out.write("            </div>\n");
      out.write("            <i class='bx bx-menu' id=\"btn\"></i>\n");
      out.write("        </div>\n");
      out.write("        <ul class=\"nav_list\">\n");
      out.write("            ");
if (dao2.TipoUsuario(usuario2)==0){ 
      out.write("\n");
      out.write("            <li>\n");
      out.write("                <a href=\"index.jsp\">\n");
      out.write("                    <i class='bx bx-grid-alt'></i>\n");
      out.write("                    <span class=\"links_name\">Inicio</span>\n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Inicio</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"registro.jsp\">\n");
      out.write("                    <i class='bx bx-lock'></i>\n");
      out.write("                    <span class=\"links_name\">Registro</span>\n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Registro</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"login.jsp\">\n");
      out.write("                    <i class='bx bx-log-in'></i>\n");
      out.write("                    <span class=\"links_name\">Inicio Sesion</span>\n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Inicio Sesion</span>\n");
      out.write("            </li>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            ");
if(dao2.TipoUsuario(usuario2)==1){ 
      out.write("\n");
      out.write("            <li>\n");
      out.write("                <a href=\"index.jsp\">\n");
      out.write("                    <i class='bx bx-grid-alt'></i>\n");
      out.write("                    <span class=\"links_name\">Inicio</span>\n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Inicio</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"perfil_usuario.jsp\">\n");
      out.write("                    <i class='bx bxs-id-card'></i>\n");
      out.write("                    <span class=\"links_name\">Perfil Jugador</span>\n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Perfil Jugador</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"liga.jsp\">\n");
      out.write("                    <i class='bx bx-desktop'></i>\n");
      out.write("                    <span class=\"links_name\">Liga</span>\n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Liga</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"equipo.jsp\">\n");
      out.write("                    <i class='bx bx-mouse'></i>\n");
      out.write("                    <span class=\"links_name\">Equipo</span>\n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Equipo</span>\n");
      out.write("            </li>        \n");
      out.write("            <li>\n");
      out.write("                <a href=\"admin.jsp\">\n");
      out.write("                    <i class='bx bx-lock'></i>\n");
      out.write("                    <span class=\"links_name\">Admin</span>\n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Admin</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                    <span class=\"links_name\">out.println(usuario2);</span>\n");
      out.write("            </li>\n");
      out.write("            <div class=\"profile_content\">\n");
      out.write("            <div class=\"profile\">\n");
      out.write("                <div class=\"profile_details\">\n");
      out.write("                    <img src=\"static/img/imagen.jpg\" alt=\"\">\n");
      out.write("                    <div class=\"name_job\">\n");
      out.write("                        <div class=\"name\">nombre</div>\n");
      out.write("                        <div class=\"job\">Web Designer</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <a href=\"index.jsp?c=1\"><i class='bx bx-log-out' id=\"log_out\"></i></a> \n");
      out.write("                ");
if(request.getParameter("c")!=null){
                    objSession2.invalidate();
                    response.sendRedirect("index.jsp");
                    }
                 
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("             ");
if(dao2.TipoUsuario(usuario2)==2){ 
      out.write("\n");
      out.write("                         <li>\n");
      out.write("                <a href=\"index.jsp\">\n");
      out.write("                    <i class='bx bx-grid-alt'></i>\n");
      out.write("                    <span class=\"links_name\">Inicio</span>\n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Inicio</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"perfil_usuario.jsp\">\n");
      out.write("                    <i class='bx bxs-id-card'></i>\n");
      out.write("                    <span class=\"links_name\">Perfil Jugador</span>\n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Perfil Jugador</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                    <span class=\"links_name\">out.println(usuario2);</span>\n");
      out.write("            </li>\n");
      out.write("            <div class=\"profile_content\">\n");
      out.write("            <div class=\"profile\">\n");
      out.write("                <div class=\"profile_details\">\n");
      out.write("                    <img src=\"static/img/imagen.jpg\" alt=\"\">\n");
      out.write("                    <div class=\"name_job\">\n");
      out.write("                        <div class=\"name\">nombre</div>\n");
      out.write("                        <div class=\"job\">Web Designer</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <a href=\"index.jsp?c=1\"><i class='bx bx-log-out' id=\"log_out\"></i></a> \n");
      out.write("                ");
if(request.getParameter("c")!=null){
                    objSession2.invalidate();
                    response.sendRedirect("index.jsp");
                    }
                 
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("             ");
}
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("    <script src=\"static/js/menu.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Administrador</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <div class=\"home_content\">\r\n");
      out.write("        <ul class=\"nav\">\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">Administrar Usuario</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">Administrar Equipo</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">Administrar Liga</a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <div class=\"container mt-5\">\r\n");
      out.write("            <h2>Administrador de Usuario</h2>\r\n");
      out.write("            <table class=\"table\">\r\n");
      out.write("                <thead class=\"thead-dark\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th><input class=\"form-control\" type=\"text\" name=\"txtNombre\" id=\"txtNombre\" placeholder=\"Ingrese un Nombre\" value=\"\" required></th>\r\n");
      out.write("                        <th><input class=\"form-control\" type=\"text\" name=\"txtContrasenia\" id=\"txtContrasenia\" placeholder=\"Ingrese una contraseña\" value=\"\" required></th>\r\n");
      out.write("                        <th><a href=\"#\" class=\"btn btn-success\"><i class=\"fas fa-shield-alt\"></i>Agregar</a></th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container mt-5\">\r\n");
      out.write("            <h2>Lista de Usuario</h2>\r\n");
      out.write("            <table class=\"table\">\r\n");
      out.write("                <thead class=\"thead-dark\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Usuario</th>\r\n");
      out.write("                        <th>Contraseña</th>\r\n");
      out.write("                        <th>Opción</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>John</td>\r\n");
      out.write("                        <td>Doe1274</td>\r\n");
      out.write("                        <td><a href=\"#\" class=\"btn btn-primary\"><i class=\"fas fa-shield-alt\"></i>Modificar</a>\r\n");
      out.write("                            <a onclick=\"confirmDelete()\"  class=\"btn btn-danger\"><i class=\"fas fa-shield-alt\"></i>Eliminar</a>\r\n");
      out.write("                            <!-- (<& = x.getId()&> a la función hace falta agregar el ID  -->\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/base.css\">\n");
      out.write("    <!-- Boxicons CSS -->\n");
      out.write("    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"icon\" href=\"static/img/icon.png\">\n");
      out.write("    \n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("</head>\n");
      out.write("    <footer>\n");
      out.write("        <div class=\"derecho text-center p-3\">\n");
      out.write("            <h1>© 2021 Liga de juegos . Derecho de Autor</h1>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("        <!--Importamos la librería Sweet Alert -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/cdn-sweet-alert.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Importamos el script de formulario -->\r\n");
      out.write("        <script src=\"static/js/formulario-eliminar.js\" ></script>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
