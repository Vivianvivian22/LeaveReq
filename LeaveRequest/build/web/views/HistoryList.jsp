<%-- 
    Document   : MenuCostumer
    Created on : Jun 21, 2016, 7:52:01 PM
    Author     : Acer
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="menu.menu" %>--%>
<%@page import="models.History" %>
<%
     String ids = "", name = "";
     int expquota=0;
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
		 <form action=".../AddHistory" method="post">
           <h4> <font size="5" face="Times New Roman" color="olive" align="center">HISTORY</font></h4>
            <table class="zebra-table">
                <%
            if (session.getAttribute("isihistory") != null) {
                History sti= (History) session.getAttribute("isihistory");
                ids = sti.getId();
                name = sti.getEmployee().getId();
                expquota=sti.getExpiredQuota();
               // address=sti.getAddress();
            }
            if (session.getAttribute("message") != null) {
                out.println(session.getAttribute("message"));
            }
                %>
                <tr>
                    <td>History Code</td>
                    <td>:</td>
                    <td><input type="text" name="idhistori" value="<%= ids%>" size="25"></td>
                </tr>
                <tr>
                    <td>Employee</td>
                    <td>:</td>
                    <td><input type="text" name="nama" value="<%= name%>" size="25"></td>
                </tr>
                <tr>
                    <td>Expired Quota</td>
                    <td>:</td>
                    <td><input type="text" name="expkuota" value=<%=expquota %> size="25"></td>
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
                <td>Employee</td>
               <td>Expired Quota</td>
                  <td>Aksi Edit</td>
                <td>Aksi Delete</td>
                
            
            </tr>
            <%
                
                if(session.getAttribute("loadHistory")!=null){
                    List<History> sta=(List<History>) session.getAttribute("loadHistory");
               for (History s : sta) {
                       
                  out.print("<td>"+s.getId());
               
                   %>
               </td>            
                   <%                 
                   out.print("<td>"+s.getEmployee().getName());
                     %>    
               </td>
                      <%                 
                   out.print("<td>"+s.getExpiredQuota());
                     %>
               </td>
 
               
               <td align="center"><a href="../EditDataHistory?id=<%=s.getId()%>">Edit</a></td>
              <td align="center"><a href="../DeleteDataHistory?id=<%=s.getId()%>">Delete</a></td>
                   
           </tr> <%}}
           else {%>
                <tr><td colspan="4">Data Tidak ada</td></tr>
                    <%}
                    %>
           
            </center></table></div>
           
    </div></div>
         </body>
         
           <%  session.removeAttribute("isihistory");
            session.removeAttribute("message");
            %>
</html>
