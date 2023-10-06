package pak.feedback;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FeedbackInsert")
public class FeedbackInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//getting data to servlet from jsp
		String username = request.getParameter("unm"); //unm from addfeedback form name
		String email = request.getParameter("eml");
		String feedback = request.getParameter("fdb");
		
		
		boolean isTrue;
		
		
		isTrue = FeedbackDBUtil.insertfeedback(username, email, feedback);
		
		if(isTrue == true) {
			
			//redirect from servlet to new jsp
			RequestDispatcher dis = request.getRequestDispatcher("fedsuccess.jsp");
			dis.forward(request, response);
			
		}else {
			
			RequestDispatcher dis = request.getRequestDispatcher("fedunsuccess.jsp");
			dis.forward(request, response);
			
		}
		
		
		
	}

}
