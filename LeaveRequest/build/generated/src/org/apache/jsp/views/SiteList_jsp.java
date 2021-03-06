package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import daos.dao2;
import controllers.Controller;
import controllers.ControllerInterface;
import org.hibernate.SessionFactory;
import models.Site;

public final class SiteList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');

    dao2 daoo=new dao2();
     String ids = "", name = "", address="";
    
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link href=\"css/style_1.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    \t<div id=\"wrapper\">\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <a href=\".../LoadStatus\">Status</a>\n");
      out.write("                  <a href=\".../LoadLeavetype\">Type</a>\n");
      out.write("                  <a href=\".../LoadDataHistory\">History</a>\n");
      out.write("                  <a href=\".../LoadEmployee\">Employee</a>\n");
      out.write("\t\t\n");
      out.write("\t<div id=\"menu_top\" align=\"center\">\n");
      out.write("\t\t <form action=\".../addSites\" method=\"post\">\n");
      out.write("           <h4> <font size=\"5\" face=\"Times New Roman\" color=\"olive\" align=\"center\">SITE</font></h4>\n");
      out.write("            <table class=\"zebra-table\">\n");
      out.write("                ");

               
            if (session.getAttribute("isiST") != null) {
                Site sti
                        = (Site) session.getAttribute("isiST");
                ids = sti.getId();
                name = sti.getName();
                address=sti.getAddress();
            }
            if (session.getAttribute("message") != null) {
                out.println(session.getAttribute("message"));
            }
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>SITE ID</td>\n");
      out.write("                    <td>:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"idsite\" value=\"");
      out.print( ids);
      out.write("\" size=\"25\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>SITE</td>\n");
      out.write("                    <td>:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"namasite\" value=\"");
      out.print( name);
      out.write("\" size=\"25\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>SITE ADDRESS</td>\n");
      out.write("                    <td>:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"alamat\" value=\"");
      out.print( address );
      out.write("\" size=\"25\"></td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <td colspan=\"2\"></td>\n");
      out.write("                <td><input type=\"submit\" value=\"Kirim\">\n");
      out.write("                    <input type=\"reset\" value=\"Reset\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"content\">\n");
      out.write("        <div class =\"content\">\n");
      out.write("            <center><table border=\"1\">\n");
      out.write("            <tr><td>ID</td>\n");
      out.write("                <td>Site Name</td>\n");
      out.write("                <td>Site Address</td>\n");
      out.write("                  <td>Aksi Edit</td>\n");
      out.write("                <td>Aksi Delete</td>\n");
      out.write("                \n");
      out.write("            \n");
      out.write("            </tr>\n");
      out.write("            ");

                for (Site s : daoo.function(new Site(), 3, "", "")) {
                   
               if(s.getId()!=null){     
               out.print("<td>"+s.getId());
               }
                else {
               out.print("<td>0");}
                   
      out.write("\n");
      out.write("        \n");
      out.write("               </td>\n");
      out.write("             \n");
      out.write("                   ");

                  if(s.getName()!=null) 
                   out.print("<td>"+s.getName());

                  else 
                    out.print("<td>0");
                     
      out.write("\n");
      out.write("      \n");
      out.write("               </td>\n");
      out.write("                      ");

                  if(s.getAddress()!=null) 
                   out.print("<td>"+s.getAddress());

                  else 
                    out.print("<td>0");
                     
      out.write("\n");
      out.write("      \n");
      out.write("               </td>\n");
      out.write("               <td align=\"center\"><a href=\"../EditSites?id=");
      out.print(s.getId());
      out.write("\">Edit</a></td>\n");
      out.write("              <td align=\"center\"><a href=\"../DeleteSite?id=");
      out.print(s.getId());
      out.write("\">Delete</a></td>\n");
      out.write("                   \n");
      out.write("           </tr> ");
}
      out.write("\n");
      out.write("            </center></table></div>\n");
      out.write("           \n");
      out.write("    </div></div>\n");
      out.write("         </body>\n");
      out.write("         \n");
      out.write("           ");
  session.removeAttribute("isiST");
            session.removeAttribute("message");
            
      out.write("\n");
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
