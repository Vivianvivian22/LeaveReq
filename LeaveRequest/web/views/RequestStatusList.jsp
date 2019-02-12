<%-- 
    Document   : MenuCostumer
    Created on : Jun 21, 2016, 7:52:01 PM
    Author     : Acer
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="models.RequestStatus"%>
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
    String ids = "", lrid = "",
            sts="", rmrk="", stsdt="";
    Long dur;
    Date ddate;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style_1.css" rel="stylesheet" type="text/css" />
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
        <title>Request List Page</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="menu_top" align="center">
                    <form action=".../AddRequestStatus" method="post">
                        <h4> <font size="5" face="Times New Roman" color="olive" align="center">Leave Request</font></h4>
                        <table class="zebra-table">
                            <%
                                if (session.getAttribute("isiRequestStatus") != null) {
                                    RequestStatus sti = (RequestStatus) session.getAttribute("isiRequestStatus");
                                    ids = sti.getId();
                                    lrid = sti.getLeaveRequest().getId();
                                    sts = sti.getStatus().getId();
                                    rmrk = sti.getRemark();
                                    ddate = sti.getStatusDate();
                                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                                    stsdt = sdf.format(ddate);  
                                }
                                if (session.getAttribute("add") != null) {
                                    out.println(session.getAttribute("add"));
                                }
                            %>
                            <tr>
                                <td>Request Status ID</td>
                                <td>:</td>
                                <td><input type="text" name="idReqStatus" value="<%= ids%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Leave Request</td>
                                <td>:</td>
                                <td><input type="text" name="leaveReqId" value="<%= lrid%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Status</td>
                                <td>:</td>
                                <td><input type="text" name="status" value="<%= sts%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Remark</td>
                                <td>:</td>
                                <td><input type="text" name="remark" value="<%= rmrk%>" size="25"></td>
                            </tr>
                            <tr>
                                <td>Status Date</td>
                                <td>:</td>
                                <td><input type="text" name="statusDate" id="datepicker" value="<%= stsdt%>" size="25"></td>
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
                                <tr><td>Request Status ID</td>
                                    <td>Leave Request</td>
                                    <td>Status</td>
                                    <td>Remark</td>
                                    <td>Status Date</td>
                                    <td>Aksi Edit</td>
                                    <td>Aksi Delete</td>
                                </tr>
                                <%
                                    if (session.getAttribute("loadReqSts") != null) {
                                        List<RequestStatus> sta = (List<RequestStatus>) 
                                                session.getAttribute("loadReqSts");
                                        for (RequestStatus s : sta) {
                                            out.print("<td>" + s.getId());                              
                                %>       
                                </td>
                                <%
                                    out.print("<td>" + s.getLeaveRequest().getId());
                                %>      
                                </td>
                                <%
                                    out.print("<td>" + s.getStatus().getName());
                                %>      
                                </td>
                                <%
                                    out.print("<td>" + s.getRemark());
                                %>      
                                </td>
                                <%
                                    out.print("<td>" + s.getStatusDate());
                                %>      
                                </td>
                                <td align="center"><a href="../EditRequestStatus?id=<%=s.getId()%>">Edit</a></td>
                                <td align="center"><a href="../DeleteRequestStatus?id=<%=s.getId()%>">Delete</a></td>

                                </tr> <%}
           } else {%>
                                <tr><td colspan="4">Data Tidak ada</td></tr>
                                <%}
                                %>

                        </center></table></div>

                </div></div>
    </body>

    <%  session.removeAttribute("isiRequestStatus");
        session.removeAttribute("message");
    %>
</html>
