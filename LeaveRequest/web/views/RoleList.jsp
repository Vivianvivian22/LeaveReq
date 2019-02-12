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
<%@page import="models.Role" %>
<%
    dao2 daoo = new dao2();
    String ids = "", name = "", address = "";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style_1.css" rel="stylesheet" type="text/css" />
        <title>Role Page</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="menu_top" align="center">
                    <form action=".../AddRole" method="post">
                        <h4> <font size="5" face="Times New Roman" color="olive" align="center">ROLE</font></h4>
                        <table class="zebra-table">
                            <%
                                if (session.getAttribute("isiROLE") != null) {
                                    Role role = (Role) session.getAttribute("isiROLE");
                                    ids = role.getId();
                                    name = role.getName();
                                }
                                if (session.getAttribute("add") != null) {
                                    out.println(session.getAttribute("add"));
                                }
                            %>
                            <tr>
                                <td>ROLE ID</td>
                                <td>:</td>
                                <td><input type="text" name="idstatus" value="<%= ids%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>ROLE</td>
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
                                    <td>ROLE Name</td>
                                    <td>Aksi Edit</td>
                                    <td>Aksi Delete</td>
                                </tr>
                                <%
                                    if (session.getAttribute("loadRL") != null) {
                                        List<Role> roles = (List<Role>) session.getAttribute("loadRL");
                                        for (Role r : roles) {
                                            out.print("<td>" + r.getId());
                                %>
                                </td>             
                                <%
                                    out.print("<td>" + r.getName());
                                %>      
                                </td>
                                <td align="center"><a href="../EditRole?id=<%=r.getId()%>">Edit</a></td>
                                <td align="center"><a href="../DeleteRole?id=<%=r.getId()%>">Delete</a></td>

                                </tr> <%}
           } else {%>
                                <tr><td colspan="4">Data Tidak ada</td></tr>
                                <%}
                                %>

                        </center></table></div>

                </div></div>
    </body>

    <%  session.removeAttribute("isiRole");
        session.removeAttribute("message");
    %>
</html>
