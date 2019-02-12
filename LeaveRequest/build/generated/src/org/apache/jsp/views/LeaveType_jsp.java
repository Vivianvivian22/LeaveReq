package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import daos.dao2;
import controllers.Controller;
import controllers.ControllerInterface;
import org.hibernate.SessionFactory;
import models.LeaveType;

public final class LeaveType_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write('\n');
      out.write('\n');

     String ids = "", name = "";
     int duration=0;
    
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
      out.write("         \n");
      out.write("\t\t\n");
      out.write("\t<div id=\"menu_top\" align=\"center\">\n");
      out.write("\t\t <form action=\".../AddLeaveTy\" method=\"post\">\n");
      out.write("           <h4> <font size=\"5\" face=\"Times New Roman\" color=\"olive\" align=\"center\">LEAVE TYPE</font></h4>\n");
      out.write("            <table class=\"zebra-table\">\n");
      out.write("                ");

               
            if (session.getAttribute("isileavety") != null) {
                LeaveType sti= (LeaveType) session.getAttribute("isileavety");
                ids = sti.getId();
                name = sti.getName();
                duration=sti.getDurationLimit();
               // address=sti.getAddress();
            }
            if (session.getAttribute("message") != null) {
                out.println(session.getAttribute("message"));
            }
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>Leave Type Code</td>\n");
      out.write("                    <td>:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"idLT\" value=\"");
      out.print( ids);
      out.write("\" size=\"25\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Leave Type</td>\n");
      out.write("                    <td>:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"namaLT\" value=\"");
      out.print( name);
      out.write("\" size=\"25\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Duration</td>\n");
      out.write("                    <td>:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"durasi\" value=");
      out.print(duration );
      out.write(" size=\"25\"></td>\n");
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
      out.write("                <td>Leave Type</td>\n");
      out.write("               <td>Duration</td>\n");
      out.write("                  <td>Aksi Edit</td>\n");
      out.write("                <td>Aksi Delete</td>\n");
      out.write("                \n");
      out.write("            \n");
      out.write("            </tr>\n");
      out.write("            ");

                
                if(session.getAttribute("loadLeavety")!=null){
                    List<LeaveType> sta=(List<LeaveType>) session.getAttribute("loadLeavety");
               for (LeaveType s : sta) {
                       
                  out.print("<td>"+s.getId());
               
                   
      out.write("\n");
      out.write("               </td>            \n");
      out.write("                   ");
                 
                   out.print("<td>"+s.getName());
                     
      out.write("    \n");
      out.write("               </td>\n");
      out.write("                      ");
                 
                   out.print("<td>"+s.getDurationLimit());
                     
      out.write("\n");
      out.write("               </td>\n");
      out.write(" \n");
      out.write("               \n");
      out.write("               <td align=\"center\"><a href=\"../EditLeaveTy?id=");
      out.print(s.getId());
      out.write("\">Edit</a></td>\n");
      out.write("              <td align=\"center\"><a href=\"../DeleteLeaveTy?id=");
      out.print(s.getId());
      out.write("\">Delete</a></td>\n");
      out.write("                   \n");
      out.write("           </tr> ");
}}
           else {
      out.write("\n");
      out.write("                <tr><td colspan=\"4\">Data Tidak ada</td></tr>\n");
      out.write("                    ");
}
                    
      out.write("\n");
      out.write("           \n");
      out.write("            </center></table></div>\n");
      out.write("           \n");
      out.write("    </div></div>\n");
      out.write("         </body>\n");
      out.write("         \n");
      out.write("           ");
  session.removeAttribute("isileavety");
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
