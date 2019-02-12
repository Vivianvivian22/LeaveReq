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
<%@page import="models.LeaveType" %>
<%
     String ids = "", name = "";
     int duration=0;
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
		 <form action=".../AddLeaveTy" method="post">
           <h4> <font size="5" face="Times New Roman" color="olive" align="center">LEAVE TYPE</font></h4>
            <table class="zebra-table">
                <%
               
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
                %>
                <tr>
                    <td>Leave Type Code</td>
                    <td>:</td>
                    <td><input type="text" name="idLT" value="<%= ids%>" size="25"></td>
                </tr>
                <tr>
                    <td>Leave Type</td>
                    <td>:</td>
                    <td><input type="text" name="namaLT" value="<%= name%>" size="25"></td>
                </tr>
                <tr>
                    <td>Duration</td>
                    <td>:</td>
                    <td><input type="text" name="durasi" value=<%=duration %> size="25"></td>
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
                <td>Leave Type</td>
               <td>Duration</td>
                  <td>Aksi Edit</td>
                <td>Aksi Delete</td>
                
            
            </tr>
            <%
                
                if(session.getAttribute("loadLeavety")!=null){
                    List<LeaveType> sta=(List<LeaveType>) session.getAttribute("loadLeavety");
               for (LeaveType s : sta) {
                       
                  out.print("<td>"+s.getId());
               
                   %>
               </td>            
                   <%                 
                   out.print("<td>"+s.getName());
                     %>    
               </td>
                      <%                 
                   out.print("<td>"+s.getDurationLimit());
                     %>
               </td>
 
               
               <td align="center"><a href="../EditLeaveTy?id=<%=s.getId()%>">Edit</a></td>
              <td align="center"><a href="../DeleteLeaveTy?id=<%=s.getId()%>">Delete</a></td>
                   
           </tr> <%}}
           else {%>
                <tr><td colspan="4">Data Tidak ada</td></tr>
                    <%}
                    %>
           
            </center></table></div>
           
    </div></div>
         </body>
         
           <%  session.removeAttribute("isileavety");
            session.removeAttribute("message");
            %>
</html>
