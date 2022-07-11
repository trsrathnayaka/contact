/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author THEVINDU RATHNAYAKA
 */
@WebServlet(urlPatterns = {"/bussinesServlet"})
public class bussinesServlet extends HttpServlet {

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
            out.println("<title>Servlet bussinesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet bussinesServlet at " + request.getContextPath() + "</h1>");
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
       //processRequest(request, response);
        
          response.setContentType("text/html");
        
          PrintWriter out = response.getWriter();
          
          String title ="Your Entered Values";
          
          String docType = 
          "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
          
           out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n"+
                    "<body bgcolor = \"#FFC0CB\">\n" +
                    "<h1 align = \"center\">" + title + "</h1>\n" +
                    "<table width = \"70%\" border = \"1\" align = \"center\">\n" + 
                    "<tr bgcolor = \"#ffad00\">\n" +   
                    "<th>Parameter Name</th><th>Parameter Value</th>\n"
                   
           );
           
             Enumeration paramNames = request.getParameterNames();
              while(paramNames.hasMoreElements()) {
                String paramName = (String)paramNames.nextElement();
                  out.println("<tr><td>" + paramName  + "\n<td>");
                  
             String[] paramValues = request.getParameterValues(paramName);
             
               if (paramValues.length == 1){
                      String paramValue = paramValues[0];
                      
                        if(paramValue.length() ==0)
                       out.print("<i>No Value</i>");
                        
                    else
                       out.print(paramValue);
                      }
                  
                else{
                      out.print("<ul>");
                      for(int i=0; i<paramValues.length; i++){
                          out.println("<li>" + paramValues[i]);
                      }
                      
                        out.println("<ul>");
                  }        
                  
              }      
              
               out.println("<table> \n </body> </html>"); 
        
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
         doGet(request, response);
        //processRequest(request, response);
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
