/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.w3c.dom.css.Counter;

/**
 *
 * @author rgukt
 */
public class Order extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static int count;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PreparedStatement preparedStatement = null;
        try {
            PrintWriter out=response.getWriter();
            out.println("hihihhihiii");
          
            //processRequest(request, response);
           String uname = request.getParameter("uname");
            int weight = Integer.parseInt(request.getParameter("volume"));
            String froms=request.getParameter("from");
            String destination=request.getParameter("destination");
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            long dobj=System.currentTimeMillis();
            Date date=new Date(dobj);
            
            String sts="notassigned";
          String id=Integer.toString(getCount())+df.format(date);
             Mytruck db = new Mytruck();
            Connection conn = db.getConnection();
            Statement smt = conn.createStatement();
             String sql = "insert into clientorder values ('"+uname+"','"+froms+"','"+destination+"','"+date+"','"+weight+"','"+sts+"','"+id+"')";
            smt.executeUpdate(sql);
            //preparedStatement = conn.prepareStatement("insert into order values ('"+weight+"','"+uname+"','"+froms+"','"+destination+"')");
             JFrame f=new JFrame();
              JOptionPane.showMessageDialog(f,"Submitted succesfully, You can order another one");
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("UserHome.jsp");
            rd.forward(request,response);
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     public static synchronized int getCount() {
      count++;
      return count;
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
