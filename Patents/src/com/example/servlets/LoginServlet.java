package com.example.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(request.getParameter("name").equals("anish") && request.getParameter("password").equals("wireless"))
		{
			HttpSession sess=request.getSession(true);
			sess.setAttribute("name", request.getParameter("name"));
			request.getRequestDispatcher("home.jsp").forward(request, response);
			return;
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("header.jsp");
			RequestDispatcher rd1=request.getRequestDispatcher("authenticate.jsp");
			RequestDispatcher rd2=request.getRequestDispatcher("footer.jsp");
			rd.include(request, response);
			response.getWriter().print("<div align=\"center\">Invalid username or password, try again</div>");
			rd1.include(request, response);
			rd2.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
