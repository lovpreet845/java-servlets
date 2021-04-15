

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class welcome extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String username = request.getParameter("Username");
      
           Calendar c = Calendar.getInstance();
int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

if(timeOfDay >= 0 && timeOfDay < 12){
         out.print("Good Morninig "+username);   
}else if(timeOfDay >= 12 && timeOfDay < 16){
  out.print("Good Afternoon "+username); 
}else if(timeOfDay >= 16 && timeOfDay < 21){
    out.print("Good Evening "+username); 
}else if(timeOfDay >= 21 && timeOfDay < 24){
   out.print("Good Night "+username); 
}
           
      
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
