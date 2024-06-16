package in.aditi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.Entity.User;
import in.connection.Db;
import in.dao.UserDAO;
import in.dao.UserInterface;

/**
 * Servlet implementation class Register
 */
@WebServlet("/signTo")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name1");
		String email=request.getParameter("email1");
		String password=request.getParameter("password1");

		User u=new User(name,email,password);

		UserInterface ui=new UserDAO();
		int count=ui.insert(u);




		 System.out.println(count+"rows executed");

		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<h2 style=\"color:white\">You are Registered Successfully. please log in</h2>");

		RequestDispatcher rd=request.getRequestDispatcher("/login.html");
		rd.include(request, response);

	}

}
