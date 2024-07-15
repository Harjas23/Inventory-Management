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
@WebServlet(urlPatterns = {"/backend"})
public class backend extends HttpServlet {
    Connection con;
    Statement smt;
    ResultSet rs,rs1,rs2,rs3;

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
            out.println("<title>Servlet backend</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/db?useSSL=false&allowPublicKeyRetrieval=true";
                String user="root";
                String pass="HSB23";
                con=DriverManager.getConnection(url,user,pass);
                smt=con.createStatement();
                String name=request.getParameter("id");
                String name2=request.getParameter("prod");
                String price=request.getParameter("price");
                String button=request.getParameter("submitbutton");
                if("add".equals(button))
                {
                    //try{
                      // rs= smt.executeQuery("select * from inventory3");
                        //while(rs.next())
                        //{
                           // if(rs.getString(1).equals(name)){
                                //int val=rs.getInt(4);
                                //smt.executeQuery("UPDATE INVENTORY3 SET STOCK="+val+"where id="+name);
                          //  }
                       // }
                        
                   // }
                    //catch(Exception e){
                        smt.execute("insert into inventory3 values('"+name+"','"+name2+"','"+price+"',1)" );
                        out.println("success");
                        
                   // }
                }
                else if("update".equals(button)){
                    try{
                        smt.execute("update inventory3 set name='"+name2+"',price='"+price+"' where id='"+name+"'");
                        out.println("success");
                    }
                   catch(Exception e){
                        out.println("no product exists");
                    }
                    
                    
                }
                else if("delete".equals(button)){
                    try{
                        smt.execute("delete from inventory3 where id='"+name+"'");
                        out.println("success");
                    }
                   catch(Exception e){
                        out.println(e);
                    }
                    
                    
                    
                }
                 else if("quantity".equals(button)){
                    try{
                       rs= smt.executeQuery("select stock from inventory3 where id='"+name+"'");
                       rs.next();
                        out.println(rs.getInt(1));
                    }
                   catch(Exception e){
                        out.println(e);
                    }
                    
                    
                    
                }
                
            }
            catch(Exception e){
                out.println(e);
            }
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
