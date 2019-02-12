package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      <html class=\"no-js\" lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n");
      out.write("    <title>Login | Kiaalap - Kiaalap Admin Template</title>\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <!-- favicon\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"img/favicon.ico\">\n");
      out.write("    <!-- Google Fonts\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Play:400,700\" rel=\"stylesheet\">\n");
      out.write("    <!-- Bootstrap CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("    <!-- Bootstrap CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("    <!-- owl.carousel CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.carousel.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.theme.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.transitions.css\">\n");
      out.write("    <!-- animate CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/animate.css\">\n");
      out.write("    <!-- normalize CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("    <!-- main CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("    <!-- morrisjs CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/morrisjs/morris.css\">\n");
      out.write("    <!-- mCustomScrollbar CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/scrollbar/jquery.mCustomScrollbar.min.css\">\n");
      out.write("    <!-- metisMenu CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/metisMenu/metisMenu.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/metisMenu/metisMenu-vertical.css\">\n");
      out.write("    <!-- calendar CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/calendar/fullcalendar.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/calendar/fullcalendar.print.min.css\">\n");
      out.write("    <!-- forms CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/form/all-type-forms.css\">\n");
      out.write("    <!-- style CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("    <!-- responsive CSS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/responsive.css\">\n");
      out.write("    <!-- modernizr JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/vendor/modernizr-2.8.3.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<div class=\"error-pagewrap\">\n");
      out.write("\t\t<div class=\"error-page-int\">\n");
      out.write("\t\t\t<div class=\"text-center m-b-md custom-login\">\n");
      out.write("\t\t\t\t<h3>PLEASE LOGIN</h3>\n");
      out.write("\t\t\t\t<p>Leave Request Sytem</p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"content-error\">\n");
      out.write("\t\t\t\t<div class=\"hpanel\">\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <form action=\".../CekLogin\" method=\"post\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"username\">Username</label>\n");
      out.write("                                <input type=\"text\" placeholder=\"example@gmail.com\" title=\"Please enter you username\" required=\"\" value=\"\" name=\"username\" id=\"username\" class=\"form-control\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"password\">Password</label>\n");
      out.write("                                <input type=\"password\" title=\"Please enter your password\" placeholder=\"******\" required=\"\" value=\"\" name=\"password\" id=\"password\" class=\"form-control\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                          \n");
      out.write("                            <button class=\"btn btn-success btn-block loginbtn\">Login</button>\n");
      out.write("                          \n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"text-center login-footer\">\n");
      out.write("\t\t\t\t<p>------------------------------------------------------------</div>\n");
      out.write("\t\t</div>   \n");
      out.write("    </div>\n");
      out.write("    <!-- jquery\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/vendor/jquery-1.12.4.min.js\"></script>\n");
      out.write("    <!-- bootstrap JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <!-- wow JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/wow.min.js\"></script>\n");
      out.write("    <!-- price-slider JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/jquery-price-slider.js\"></script>\n");
      out.write("    <!-- meanmenu JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/jquery.meanmenu.js\"></script>\n");
      out.write("    <!-- owl.carousel JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("    <!-- sticky JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/jquery.sticky.js\"></script>\n");
      out.write("    <!-- scrollUp JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/jquery.scrollUp.min.js\"></script>\n");
      out.write("    <!-- mCustomScrollbar JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/scrollbar/jquery.mCustomScrollbar.concat.min.js\"></script>\n");
      out.write("    <script src=\"js/scrollbar/mCustomScrollbar-active.js\"></script>\n");
      out.write("    <!-- metisMenu JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/metisMenu/metisMenu.min.js\"></script>\n");
      out.write("    <script src=\"js/metisMenu/metisMenu-active.js\"></script>\n");
      out.write("    <!-- tab JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/tab.js\"></script>\n");
      out.write("    <!-- icheck JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/icheck/icheck.min.js\"></script>\n");
      out.write("    <script src=\"js/icheck/icheck-active.js\"></script>\n");
      out.write("    <!-- plugins JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/plugins.js\"></script>\n");
      out.write("    <!-- main JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("    <!-- tawk chat JS\n");
      out.write("\t\t============================================ -->\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
