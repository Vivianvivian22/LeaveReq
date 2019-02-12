<%-- 
    Document   : MenuCostumer
    Created on : Jun 21, 2016, 7:52:01 PM
    Author     : Acer
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="models.Employee"%>
<%@page import="models.LeaveRequest"%>
<%@page import="models.Parameter"%>
<%@page import="java.util.List"%>
<%@page import="daos.dao2"%>
<%@page import="controllers.Controller"%>
<%@page import="controllers.ControllerInterface"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    dao2 daoo = new dao2();
    String ids = "", name = "",
            idEmp = "", idType = "",
            stdt="", endt="";
    Long dur;
    Date stDate;
    Date endDate;
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
            $(function () {
                $("#datepicker2").datepicker();
            });
        </script>
        <title>Leave Request Page</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="menu_top" align="center">
                    <form action=".../AddLeaveRequest" method="post">
                        <h4> <font size="5" face="Times New Roman" color="olive" align="center">Leave Request</font></h4>
                        <table class="zebra-table">
                            <%
                                if (session.getAttribute("isiLeaveRequest") != null) {
                                    LeaveRequest sti = (LeaveRequest) session.getAttribute("isiLeaveRequest");
                                    ids = sti.getId();
                                    idEmp = sti.getEmployee().getId();
                                    idType = sti.getLeaveType().getId();
                                    stDate = sti.getStartDate();
                                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                                    stdt = sdf.format(stDate);                                    
                                    endDate = sti.getEndDate();
                                    endt = sdf.format(endDate); 
                                    dur = sti.getDuration();
                                }
                                if (session.getAttribute("add") != null) {
                                    out.println(session.getAttribute("add"));
                                }
                            %>
                            <tr>
                                <td>Leave Request ID</td>
                                <td>:</td>
                                <td><input type="text" name="idLeavreq" value="<%= ids%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Employee ID</td>
                                <td>:</td>
                                <td><input type="text" name="idEmployee" value="<%= idEmp%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Leave Type</td>
                                <td>:</td>
                                <td><input type="text" name="idType" value="<%= idType%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Start Date</td>
                                <td>:</td>
                                <td><input type="text" name="stDate" id="datepicker" value="<%= stdt%>"></td>
                            </tr>
                            <tr>
                                <td>End Date</td>
                                <td>:</td>
                                <td><input type="text" name="endDate" id="datepicker2" value="<%= endt%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Duration</td>
                                <td>:</td>
                                <td><input type="text" name="duration" value="<%= idType%>" size="25"></td>
                            </tr>
                            <tr>

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
                                <tr><td>Leave Request ID</td>
                                    <td>Employee ID</td>
                                    <td>Leave Type</td>
                                    <td>Start Date</td>
                                    <td>End Date</td>
                                    <td>Duration</td>
                                    <td>Aksi Edit</td>
                                    <td>Aksi Delete</td>
                                </tr>
                                <%
                                    if (session.getAttribute("loadLeaveReq") != null) {
                                        List<LeaveRequest> sta = (List<LeaveRequest>) session.getAttribute("loadLeaveReq");
                                        for (LeaveRequest s : sta) {
                                            out.print("<td>" + s.getId());
                                %>      
                                </td>
                                <%
                                    out.print("<td>" + s.getEmployee().getName());
                                %>      
                                </td>
                                <%
                                    out.print("<td>" + s.getLeaveType().getName());
                                %>      
                                </td>
                                <%
                                    Date dtt = s.getStartDate();
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
                                    String dt = sdf.format(dtt);
                                    out.print("<td>" + dt);
                                %>      
                                </td>
                                <%
                                    Date dtt1 = s.getEndDate();
                                    String dt1 = sdf.format(dtt1);
                                    out.print("<td>" + dt1);
                                %>      
                                </td>
                                <%
                                    out.print("<td>" + s.getDuration());
                                %>      
                                </td>
                                <td align="center"><a href="../EditLeaveRequest?id=<%=s.getId()%>">Edit</a></td>
                                <td align="center"><a href="../DeleteLeaveRequest?id=<%=s.getId()%>">Delete</a></td>

                                </tr> <%}
                                } else {%>
                                <tr><td colspan="4">Data Tidak ada</td></tr>
                                <%}
                                %>

                        </center></table></div>

                </div></div>
    </body>

    <%  session.removeAttribute("isiLeaveRequest");
        session.removeAttribute("message");
    %>
</html>
