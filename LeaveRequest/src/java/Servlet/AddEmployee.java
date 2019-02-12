/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controllers.Controller;
import controllers.ControllerInterface;
import controllers.LoginController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Employee;
import models.NewHibernateUtil;
import models.Role;
import models.Site;
import org.hibernate.SessionFactory;

/**
 *
 * @author vivian
 */
@WebServlet(name = "AddEmployee", urlPatterns = {"/AddEmployee"})
public class AddEmployee extends HttpServlet {

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
        String ids = request.getParameter("idemp");
        String nm = request.getParameter("nama");
        String add = request.getParameter("add");
        String email=request.getParameter("email");
        String hp=request.getParameter("phn");
        String kuota=request.getParameter("leavekuota");
        String pass=request.getParameter("pass");
        String actv=request.getParameter("aktif");
        String mngr=request.getParameter("mngr");
        String rol=request.getParameter("role");
        String site=request.getParameter("site");
        String date=request.getParameter("selDate");
        Date dat=new Date(date);
//      
        
        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            ControllerInterface<models.Employee> stcon = new Controller(sessionFactory);
            LoginController logincon=new LoginController(sessionFactory);
            Employee s = new Employee(ids, nm, add, dat, email, new Integer(kuota), logincon.encrypt(pass), new Integer(actv), hp
                    ,new Employee(mngr), new Role(rol), new Site(site));
            String message = "Gagal";
            if (stcon.saveOrEdit(s)) {
                message = "Berhasil";
            }
            session.setAttribute("message", message);
            response.sendRedirect("LoadEmployee");
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
