<%-- 
    Document   : Employee List
    Created on : Jun 21, 2016, 7:52:01 PM
    Author     : Asus
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="menu.menu" %>--%>
<%@page import="models.Employee" %>
<%
    String ids = "", name = "", add = "", email = "", pass = "", mngr = "", role = "", site = "", phn = "",tgl="";
    Date dt;
    int leavequota = 0, aktif = 0;

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style_1.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>

        <title>JSP Page</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">


                <div id="menu_top" align="center">
                    <form action=".../AddEmployee" method="post">
                        <h4> <font size="5" face="Times New Roman" color="olive" align="center">EMPLOYEE LIST</font></h4>
                        <table class="zebra-table">
                            <%                    if (session.getAttribute("isiemployee") != null) {
                                    Employee sti = (Employee) session.getAttribute("isiemployee");
                                    ids = sti.getId();
                                    name = sti.getName();
                                    email = sti.getEmail();
                                    phn = sti.getPhone();
                                    aktif = sti.getIsActive();
                                    role = sti.getRoles().getId();
                                    site = sti.getSite().getId();
                                    leavequota = sti.getLeaveQuota();
                                    mngr = sti.getManager().getId();
                                    add = sti.getAddress();
                                    pass=sti.getPassword();
                                    Date dtt1 = sti.getJoinDate();
                                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                                    String dates1 = sdf.format(dtt1);
                                    tgl=dates1;
                                }
                                if (session.getAttribute("message") != null) {
                                    out.println(session.getAttribute("message"));
                                }
                            %>
                            <tr>
                                <td>Employee Id</td>
                                <td>:</td>
                                <td><input type="text" name="idemp" value="<%= ids%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Name</td>
                                <td>:</td>
                                <td><input type="text" name="nama" value="<%= name%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Address</td>
                                <td>:</td>
                                <td><input type="text" name="add" value="<%= add%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Join Date</td>
                                <td>:</td>
                                <td><input type="text" name="selDate" id="datepicker" value="<%= tgl%>"></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td>:</td>
                                <td><input type="text" name="email" value="<%= email%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Leave Quota</td>
                                <td>:</td>
                                <td><input type="text" name="leavekuota" value=<%=leavequota%> size="25"></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td>:</td>
                                <td><input type="text" name="pass" value="<%=pass%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Active</td>
                                <td>:</td>
                                <td><input type="text" name="aktif" value=<%=aktif%> size="25"></td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td>:</td>
                                <td><input type="text" name="phn" value="<%=phn%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Manager</td>
                                <td>:</td>
                                <td><input type="text" name="mngr" value="<%=mngr%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Roles</td>
                                <td>:</td>
                                <td><input type="text" name="role" value="<%=role%>" size="25"></td>
                            </tr>                
                            <tr>
                                <td>Site</td>
                                <td>:</td>
                                <td><input type="text" name="site" value="<%=site%>" size="25"></td>
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
                                    <td>Address</td>
                                    <td>Email</td>
                                    <td>Password</td>
                                    <td>Phone</td>
                                    <td>Join Date</td>
                                    <td>Manager</td>
                                    <td>Role</td>
                                    <td>Site</td>
                                    <td>Quota</td>
                                    <td>Aksi Edit</td>
                                    <td>Aksi Delete</td>


                                </tr>
                                <%

                                    if (session.getAttribute("loadEmployee") != null) {
                                        List<Employee> sta = (List<Employee>) session.getAttribute("loadEmployee");
//                                        for (Employee s : sta) {
                                        for (int idx = 0; idx < sta.size(); idx++) {
                                                Employee s = sta.get(idx);
                                              
                                            
                                            out.print("<td>" + s.getId());

                                %>
                                </td>            
                                <%                       out.print("<td>" + s.getName());
                                %>    
                                </td>
                                <%
                                    out.print("<td>" + s.getAddress());
                                %>
                                </td>
                                <%
                                    out.print("<td>" + s.getEmail());
                                %>
                                </td>
                                <%
                                    out.print("<td> ****");
                                %>
                                </td>
                                <%
                                    out.print("<td>" + s.getPhone());
                                %>
                                </td>
                                <%
                                    Date dtt = s.getJoinDate();
                                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                                    String dates = sdf.format(dtt);
                                    out.print("<td>" + dates);
                                %>
                                </td>
                                <%
                                    out.print("<td>" + s.getManager().getName());
                                %>
                                </td>
                                <%
                                    out.print("<td>" + s.getRoles().getName());
                                %>
                                </td>
                                <%
                                    out.print("<td>" + s.getSite().getName());
                                %>
                                </td>
                                <%
                                    out.print("<td>" + s.getLeaveQuota());
                                %>
                                </td>


                                <td align="center"><a href="../EditEmployee?id=<%=s.getId()%>">Edit</a></td>
                                <td align="center"><a href="../DeleteEmployee?id=<%=s.getId()%>">Delete</a></td>

                                </tr> <%}
           } else {%>
                                <tr><td colspan="4">Data Tidak ada</td></tr>
                                <%}
                                %>

                        </center></table></div>

                </div></div>
    </body>

    <%  session.removeAttribute("isiemployee");
        session.removeAttribute("message");
        session.removeAttribute("loadEmployee");
    %>  
</html>
