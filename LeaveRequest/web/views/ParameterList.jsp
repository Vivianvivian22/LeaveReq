<%-- 
    Document   : MenuCostumer
    Created on : Jun 21, 2016, 7:52:01 PM
    Author     : Acer
--%>

<%@page import="models.Parameter"%>
<%@page import="java.util.List"%>
<%@page import="daos.dao2"%>
<%@page import="controllers.Controller"%>
<%@page import="controllers.ControllerInterface"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    dao2 daoo = new dao2();
    String ids = "", name = "";
    int limit = 0;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style_1.css" rel="stylesheet" type="text/css" />
        <title>Parameter Page</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">


                <div id="menu_top" align="center">
                    <form action=".../AddParameter" method="post">
                        <h4> <font size="5" face="Times New Roman" color="olive" align="center">Parameter</font></h4>
                        <table class="zebra-table">
                            <%
                                if (session.getAttribute("isiParam") != null) {
                                    Parameter sti = (Parameter) session.getAttribute("isiParam");
                                    ids = sti.getId();
                                    name = sti.getName();
                                    limit = sti.getLimit();
                                }
                                if (session.getAttribute("add") != null) {
                                    out.println(session.getAttribute("add"));
                                }
                            %>
                            <tr>
                                <td>Parameter ID</td>
                                <td>:</td>
                                <td><input type="text" name="idParam" value="<%= ids%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Parameter Name</td>
                                <td>:</td>
                                <td><input type="text" name="namaParam" value="<%= name%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Limit</td>
                                <td>:</td>
                                <td><input type="text" name="limitParam" value="<%= limit%>" size="25"></td>
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
                                    <td>Parameter Name</td>
                                    <td>Limit</td>
                                    <td>Aksi Edit</td>
                                    <td>Aksi Delete</td>
                                </tr>
                                <%
                                    if (session.getAttribute("loadParam") != null) {
                                        List<Parameter> sta = (List<Parameter>) 
                                                session.getAttribute("loadParam");
                                        for (Parameter s : sta) {
                                            out.print("<td>" + s.getId());
                                %>
                                </td>             
                                <%
                                    out.print("<td>" + s.getName());
                                %>      
                                </td>
                                <%
                                    out.print("<td>" + s.getLimit());
                                %>      
                                </td>
                                <td align="center"><a href="../EditParameter?id=<%=s.getId()%>">Edit</a></td>
                                <td align="center"><a href="../DeleteParameter?id=<%=s.getId()%>">Delete</a></td>

                                </tr> <%}
           } else {%>
                                <tr><td colspan="4">Data Tidak ada</td></tr>
                                <%}
                                %>

                        </center></table></div>

                </div></div>
    </body>

    <%  session.removeAttribute("isiParam");
        session.removeAttribute("message");
    %>
</html>
