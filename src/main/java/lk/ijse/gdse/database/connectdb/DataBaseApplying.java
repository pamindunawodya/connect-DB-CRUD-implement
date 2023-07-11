package lk.ijse.gdse.database.connectdb;

import jakarta.json.stream.JsonGenerationException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@WebServlet(name = "DataBaseApplying", value = "/DataBaseApplying")
public class DataBaseApplying extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Mapping Spec");
        System.out.println("Context path"+request.getContextPath());
        System.out.println("Path info"+request.getPathInfo());
//        System.out.println("Query string"+request.getQueryString());
        System.out.println("Request URL"+request.getRequestURL());
        System.out.println("Request URI"+request.getRequestURI());
        System.out.println("Protocol"+request.getProtocol());
        System.out.println("Scheme"+request.getScheme());
        System.out.println("Remote host"+request.getRemoteHost());
        System.out.println("Remote address"+request.getRemoteAddr());
        System.out.println("Server name"+request.getServerName());
        System.out.println("Server port"+request.getServerPort());
        System.out.println("Local Name"+request.getLocalName());
        System.out.println("Local address"+request.getLocalAddr());
        System.out.println("Local port"+request.getLocalPort());
        System.out.println("Method"+request.getMethod());
        System.out.println("Server Path"+request.getServletContext().getContextPath());
        System.out.println("Current Path"+request.getServletContext().getRealPath("map"));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String Name=   request.getParameter("name");
      String Email=   request.getParameter("email");
      String City=   request.getParameter("city");
//        System.out.println(Name);
//        System.out.println(Email);
//        System.out.println(City);

        PrintWriter writer = response.getWriter();
        writer.write("<h1>response generated now</h1>");
      try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/servelet","root","1234");
           PreparedStatement student=connection.prepareStatement("insert into student values(?,?,?)");
           student.setObject(1,Name);
           student.setObject(2,City);
           student.setObject(3,Email);
          boolean execute = student.executeUpdate()>0;

          response.getWriter().write("<h1>"+execute+"</h1>");


       } catch (SQLException | ClassNotFoundException throwables) {
           throwables.printStackTrace();
       }
   }

}
