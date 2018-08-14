package com.Web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Web.ServiceImpl.LoginServiceImpl;
import com.Web.ServiceInterfaces.LoginServiceInterface;
import com.Web.dto.LoginDTO;
import com.Web.validation.LoginValidation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginServiceInterface loginInterface;
	private LoginDTO loginDTO;
	private LoginValidation loginValidation;
	private String validationMsg;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        loginInterface = new LoginServiceImpl();
        loginValidation = new LoginValidation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//	Extract parameters from POST Request and create DTO object for service layer
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		if(user != null && pwd != null) { 
			loginDTO = new LoginDTO(request.getParameter("username"), request.getParameter("password"));
			validationMsg = "User credentials format not ok";
		}
		
		System.out.println(request.getParameter("username") + " "+ request.getParameter("password"));
		
		//	initial data format validation
		if( (validationMsg = loginValidation.validateUserCredentials(loginDTO)) == null) {
			
			//	no data Validation failed & invoke service layer with DTO object for verification
			if( loginInterface.verify(loginDTO) ) {
				//	user credentials validation found ok
				HttpSession session = request.getSession();
				
				//	User credentials inclusion in current session
				session.setAttribute("User", request.getParameter("username"));
				
				//	Redirect to VIEW page
				response.sendRedirect("home.jsp");				
			}
			else {
				//	Duplicate user exists; User not registered
				validationMsg = "No user found with given credentials, please insert correctly.";		
			}
		}
		System.out.println("Data validation-" + validationMsg);

		if(validationMsg != null) {
			//	Error message inclusion in Login Page Page
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>" + validationMsg + "</font>");
			
			//	Keep in Login page
			rd.include(request, response);
		}
	}

}
