package com.Web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Web.ServiceImpl.ViewServiceImpl;
import com.Web.ServiceInterfaces.ViewServiceInterface;
import com.Web.dto.ViewDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ViewServiceInterface viewInterface;
	private List<ViewDTO> viewList;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        viewInterface = new ViewServiceImpl();
        viewList = new ArrayList<ViewDTO>();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		viewList = viewInterface.getAll();
		
		//	viewList = viewInterface.getAll().stream().collect(Collectors.toList());
		
		for(ViewDTO viewUser:viewList) {
			System.out.println(viewUser.getFirstName() + " " + viewUser.getLastName() + " " + 
					viewUser.getUsername() + " " + viewUser.getAddress() + " " + viewUser.getEmail() + " " +
					viewUser.getPhone());
		}
		
		request.setAttribute("ViewData", viewList);
		
		//	Redirect to VIEW page
		request.getRequestDispatcher("/view.jsp").include(request, response);
		
		//	response.sendRedirect("view.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
