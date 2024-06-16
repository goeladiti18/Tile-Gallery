package in.aditi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 * Servlet implementation class Login
 */
@WebServlet("/loginTo")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter ob=response.getWriter();

		UserInterface ui=new UserDAO();

		//right credentials

		String email=request.getParameter("email1");
		String password=request.getParameter("password1");

		User u=new User(email,password);
		boolean result=ui.retrieve(u);


		 System.out.println(result+"found");

		if(result) {

		response.sendRedirect("https://www.justdial.com/Delhi/Tile-Gallery-Near-A-Block-Near-Vishal-Megamart-Khanpur/011PXX11-XX11-180906173813-I3N9_BZDET");
		}else {

			ob.print("<h1 style=\"text-align:center; color:red; margin:500px;\">Either your credentials are wrong or you need to register again. Thanks</h1>");

		}


	}



}
