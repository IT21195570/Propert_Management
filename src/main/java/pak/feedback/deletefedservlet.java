package pak.feedback;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deletefedservlet")
public class deletefedservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		
		boolean isTrue;
		
		isTrue = FeedbackDBUtil.deletefeedback(id);
		
		if(isTrue==true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("delsuccess.jsp");
			dis.forward(request, response);
				
		}else {
			
			RequestDispatcher dis = request.getRequestDispatcher("delunsuccess.jsp");
			dis.forward(request, response);
			
		}
			
		
	}

}