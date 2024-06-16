package in.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.Entity.User;
import in.connection.Db;

public class UserDAO implements UserInterface {

	@Override
	public int insert(User u) {

		Db obj=new Db();
		Connection con;
		int count=0;
		try {
			con = obj.getConnection();
			PreparedStatement stmt=con.prepareStatement("insert into tilegallery values(?,?,?)");
			stmt.setString(1,u.getName());
			stmt.setString(2,u.getEmail());
			stmt.setString(3,u.getPassword());
			count=stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;

	}

	@Override
	public boolean retrieve(User u) {
		Db obj=new Db();
		Connection con;
		boolean result=false;
		try {
			con = obj.getConnection();
			PreparedStatement stmt=con.prepareStatement("select  * from  tilegallery where email=? and password=?");

			stmt.setString(1,u.getEmail());
			stmt.setString(2,u.getPassword());

			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				result=true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
