/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author Acer
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    Statement smt1,smt2;
    

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String userid=request.getParameter("username");
            String password=request.getParameter("password");
           try{
               Connection con;
               ResultSet rs;
               Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/db?useSSL=false&allowPublicKeyRetrieval=true";
                String user="root";
                String pass="HSB23";
                con=DriverManager.getConnection(url,user,pass);
                smt1=con.createStatement();
                rs=smt1.executeQuery("select * from inventory");
            if(userid.equals("admin")&&password.equals("123"))
            {
                out.println("<form method='post' action='backend'>");
                out.println("ID"+"<INPUT TYPE='TExt' NAME='id'");
                out.println("<p>  </p>");
                
                out.println("NAME"+"<INPUT TYPE='TEXT' NAME='prod'");
                out.println("<p>  </p>");
                out.println("<p>   </p>");
                out.println("PRICE"+"<INPUT TYPE='TEXT' NAME='price'");
                out.println("<p>  </p>");
                out.println("<input type='submit' name='submitbutton'value='add'");
                out.println("<p>   </p>");
                out.println("<input type='submit' name='submitbutton'value='delete'");
                out.println("<p>   </p>");
                out.println("<input type='submit' name='submitbutton'value='update'");
                out.println("<p>   </p>");
                out.println("<input type='submit' name='submitbutton'value='quantity'");
                
                
                out.println("</form>");
                
            }
            else
            {
                out.println("failed");
            }}
           catch(Exception e){
               out.println(e);
           }
            //out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
