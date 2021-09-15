package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/base.css\">\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/base.css\">\r\n");
      out.write("    <!-- Boxicons CSS -->\r\n");
      out.write("    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("    <link rel=\"icon\" href=\"static/img/icon.png\">\r\n");
      out.write("    \r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"siderbar\">\r\n");
      out.write("        <div class=\"logo_content\">\r\n");
      out.write("            <div class=\"logo\">\r\n");
      out.write("                <i class='bx bx-game' ></i>\r\n");
      out.write("                <div class=\"logo_name\">Video Juegos</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <i class='bx bx-menu' id=\"btn\"></i>\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"nav_list\">\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"index.jsp\">\r\n");
      out.write("                    <i class='bx bx-grid-alt'></i>\r\n");
      out.write("                    <span class=\"links_name\">Inicio</span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <span class=\"tooltip\">Inicio</span>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"perfil_usuario.jsp\">\r\n");
      out.write("                    <i class='bx bxs-id-card'></i>\r\n");
      out.write("                    <span class=\"links_name\">Perfil Jugador</span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <span class=\"tooltip\">Perfil Jugador</span>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"liga.jsp\">\r\n");
      out.write("                    <i class='bx bx-desktop'></i>\r\n");
      out.write("                    <span class=\"links_name\">Liga</span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <span class=\"tooltip\">Liga</span>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"equipo.jsp\">\r\n");
      out.write("                    <i class='bx bx-mouse'></i>\r\n");
      out.write("                    <span class=\"links_name\">Equipo</span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <span class=\"tooltip\">Equipo</span>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"registro.jsp\">\r\n");
      out.write("                    <i class='bx bx-lock'></i>\r\n");
      out.write("                    <span class=\"links_name\">Registro</span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <span class=\"tooltip\">Registro</span>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"login.jsp\">\r\n");
      out.write("                    <i class='bx bx-log-in'></i>\r\n");
      out.write("                    <span class=\"links_name\">Inicio Sesion</span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <span class=\"tooltip\">Inicio Sesion</span>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"admin.jsp\">\r\n");
      out.write("                    <i class='bx bx-lock'></i>\r\n");
      out.write("                    <span class=\"links_name\">Admin</span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <span class=\"tooltip\">Admin</span>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <div class=\"profile_content\">\r\n");
      out.write("            <div class=\"profile\">\r\n");
      out.write("                <div class=\"profile_details\">\r\n");
      out.write("                    <img src=\"static/img/imagen.jpg\" alt=\"\">\r\n");
      out.write("                    <div class=\"name_job\">\r\n");
      out.write("                        <div class=\"name\">nombre</div>\r\n");
      out.write("                        <div class=\"job\">Web Designer</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <a href=\"#\"><i class='bx bx-log-out' id=\"log_out\"></i></a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script src=\"static/js/menu.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Index</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/base.css\">\r\n");
      out.write("    <!-- Boxicons CSS -->\r\n");
      out.write("    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("    <link rel=\"icon\" href=\"static/img/icon.png\">\r\n");
      out.write("    \r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("</head>\r\n");
      out.write("    <footer>\r\n");
      out.write("        <div class=\"derecho text-center p-3\">\r\n");
      out.write("            <h1>© 2021 Liga de juegos . Derecho de Autor</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</html>\r\n");
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
