<%-- 
    Document   : MenuCostumer
    Created on : Jun 21, 2016, 7:52:01 PM
    Author     : Acer
--%>

<%@page import="java.util.List"%>
<%@page import="daos.dao2"%>
<%@page import="controllers.Controller"%>
<%@page import="controllers.ControllerInterface"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="menu.menu" %>--%>
<%@page import="models.Status" %>
<%
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
         
		
	<div id="menu_top" align="center">
		 <form action=".../AddStatus" method="post">
           <h4> <font size="5" face="Times New Roman" color="olive" align="center">STATUS</font></h4>
            <table class="zebra-table">
                <%
               
            if (session.getAttribute("isistatus") != null) {
                Status sti= (Status) session.getAttribute("isistatus");
                ids = sti.getId();
                name = sti.getName();
               // address=sti.getAddress();
            }
            if (session.getAttribute("message") != null) {
                out.println(session.getAttribute("message"));
            }
                %>
                <tr>
                    <td>STATUS CODE</td>
                    <td>:</td>
                    <td><input type="text" name="idstatus" value="<%= ids%>" size="25"></td>
                </tr>
                <tr>
                    <td>STATUS</td>
                    <td>:</td>
                    <td><input type="text" name="namastatus" value="<%= name%>" size="25"></td>
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
                <td>Status Name</td>
                  <td>Aksi Edit</td>
                <td>Aksi Delete</td>
                
            
            </tr>
            <%
                
                if(session.getAttribute("load")!=null){
                    List<Status> sta=(List<Status>) session.getAttribute("load");
               for (Status s : sta) {
                       
                  out.print("<td>"+s.getId());
               
                   %>
               </td>
             
                   <%                 
                   out.print("<td>"+s.getName());
                     %>
      
               </td>
               <td align="center"><a href="../EditStatus?id=<%=s.getId()%>">Edit</a></td>
              <td align="center"><a href="../DeleteStatus?id=<%=s.getId()%>">Delete</a></td>
                   
           </tr> <%}}
           else {%>
                <tr><td colspan="4">Data Tidak ada</td></tr>
                    <%}
                    %>
           
            </center></table></div>
           
    </div></div>
         </body>
         
           <%  session.removeAttribute("isistatus");
            session.removeAttribute("message");
            %>
</html>
