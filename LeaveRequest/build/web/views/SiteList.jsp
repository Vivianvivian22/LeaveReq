<%-- 
    Document   : MenuCostumer
    Created on : Jun 21, 2016, 7:52:01 PM
    Author     : Acer
--%>

<%@page import="daos.dao2"%>
<%@page import="controllers.Controller"%>
<%@page import="controllers.ControllerInterface"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="menu.menu" %>--%>
<%@page import="models.Site" %>
<%
    dao2 daoo=new dao2();
     String ids = "", name = "", address="";
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/style_1.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
    	<div id="wrapper">
            <div id="header">
                <a href=".../LoadStatus">Status</a>
                  <a href=".../LoadLeavetype">Type</a>
                  <a href=".../LoadDataHistory">History</a>
                  <a href=".../LoadEmployee">Employee</a>
		
	<div id="menu_top" align="center">
		 <form action=".../addSites" method="post">
           <h4> <font size="5" face="Times New Roman" color="olive" align="center">SITE</font></h4>
            <table class="zebra-table">
                <%
               
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
                %>
                <tr>
                    <td>SITE ID</td>
                    <td>:</td>
                    <td><input type="text" name="idsite" value="<%= ids%>" size="25"></td>
                </tr>
                <tr>
                    <td>SITE</td>
                    <td>:</td>
                    <td><input type="text" name="namasite" value="<%= name%>" size="25"></td>
                </tr>
                <tr>
                    <td>SITE ADDRESS</td>
                    <td>:</td>
                    <td><input type="text" name="alamat" value="<%= address %>" size="25"></td>
                </tr>
                
                <td colspan="2"></td>
                <td><input type="submit" value="Kirim">
                    <input type="reset" value="Reset"></td>
                </tr>
            </table>
        </form>
        </div>
        <div id="content">
        <div class ="content">
            <center><table border="1">
            <tr><td>ID</td>
                <td>Site Name</td>
                <td>Site Address</td>
                  <td>Aksi Edit</td>
                <td>Aksi Delete</td>
                
            
            </tr>
            <%
                for (Site s : daoo.function(new Site(), 3, "", "")) {
                   
               if(s.getId()!=null){     
               out.print("<td>"+s.getId());
               }
                else {
               out.print("<td>0");}
                   %>
        
               </td>
             
                   <%
                  if(s.getName()!=null) 
                   out.print("<td>"+s.getName());

                  else 
                    out.print("<td>0");
                     %>
      
               </td>
                      <%
                  if(s.getAddress()!=null) 
                   out.print("<td>"+s.getAddress());

                  else 
                    out.print("<td>0");
                     %>
      
               </td>
               <td align="center"><a href="../EditSites?id=<%=s.getId()%>">Edit</a></td>
              <td align="center"><a href="../DeleteSite?id=<%=s.getId()%>">Delete</a></td>
                   
           </tr> <%}%>
            </center></table></div>
           
    </div></div>
         </body>
         
           <%  session.removeAttribute("isiST");
            session.removeAttribute("message");
            %>
</html>
