/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controllers.Controller;
import controllers.ControllerInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Employee;
import models.LeaveRequest;
import models.LeaveType;
import models.NewHibernateUtil;
import models.Parameter;
import models.RequestStatus;
import models.Status;
import org.hibernate.SessionFactory;

/**
 *
 * @author vivian
 */
@WebServlet(name = "AddRequestStatus", urlPatterns = {"/AddRequestStatus"})
public class AddRequestStatus extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ids = request.getParameter("idReqStatus");
        String lrid = request.getParameter("leaveReqId");
        String sts = request.getParameter("status");
        String rmrk = request.getParameter("remark");
        String stsdt = request.getParameter("statusDate");
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            ControllerInterface<models.RequestStatus> stcon = new Controller(sessionFactory);
            RequestStatus s = new RequestStatus(ids, rmrk, new Date(stsdt), new LeaveRequest(lrid), new Status(sts));
            String message = "Gagal";
            if (stcon.saveOrEdit(s)) {
                message = "Berhasil";
            }
            session.setAttribute("add", message);
            response.sendRedirect("views/LeaveRequestList.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
