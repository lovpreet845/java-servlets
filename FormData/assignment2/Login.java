

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         String user=request.getParameter("username");                          
         String pass=request.getParameter("password");  
         
  String id=null;
  String userId=null;

  String sql = "SELECT usertype FROM Users where username='"+user+"' and password='"+pass+"'";
        ResultSet rs;
            rs = stmt.executeQuery(sql);
while(rs.next())
 {
 id=rs.getString("id");
userId=rs.getString("userId");   
}

if(id!=null)
System.out.println("Login Success");
else
System.out.println("Login Failed");
         
             
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
