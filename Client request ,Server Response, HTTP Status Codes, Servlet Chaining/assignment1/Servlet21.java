

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet21 extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       int number = Integer.parseInt(request.getParameter("number"));
		
		PrintWriter out = response.getWriter();
		request.setAttribute("number", number);
		
		if (number < 10)
			request.getRequestDispatcher("page1.jsp").forward(request, response);
		else if (number >= 10 && number < 99)
			request.getRequestDispatcher("page2.jsp").forward(request, response);
		else
			request.getRequestDispatcher("error.jsp").forward(request, response);
		
		out.close();
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
