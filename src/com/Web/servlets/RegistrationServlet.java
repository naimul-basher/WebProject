package com.Web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Web.ServiceImpl.RegServiceImpl;
import com.Web.ServiceInterfaces.RegServiceInterface;
import com.Web.dto.RegDTO;
import com.Web.validation.RegistrationValidation;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegServiceInterface serviceInterface;
	private String validationMsg;
	private RequestDispatcher rd;
	private RegDTO regDTO;
	private RegistrationValidation regValidation;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        serviceInterface = new RegServiceImpl();
        regValidation = new RegistrationValidation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		System.out.println(request.getParameter("firstname") + " " + request.getParameter("lastname") + " " +
				request.getParameter("username") + " " + request.getParameter("address") + " " + 
				request.getParameter("email") + " " + request.getParameter("phone") + " " +
				request.getParameter("password"));
		
		
		//	Extract parameters from POST Request and create DTO object for service layer	
		regDTO = new RegDTO(request.getParameter("firstname"), request.getParameter("lastname"),
				request.getParameter("username"), request.getParameter("address"), request.getParameter("email"),
				request.getParameter("phone"), request.getParameter("password"));
		
		//	initial data format validation
		if( (validationMsg = regValidation.validateUserCredentials(regDTO)) == null) {

			// 	no Validation failed & invoke service layer with DTO object for Registration
			if( serviceInterface.save(regDTO) ) {			

				//	no Duplicate user exists; new User registered
				//	Redirect to Login page
				response.sendRedirect("index.html");
			}
			else {
				//	Duplicate user exists; User not registered
				validationMsg = "User already exists!";
			}
		}
	
		if (validationMsg != null) {
			//	Error message inclusion in Registration Page
			rd = getServletContext().getRequestDispatcher("/registration.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>"+validationMsg+"</font>");

			//	Keep in Registration page
			rd.include(request, response);
		}	
	}
}
