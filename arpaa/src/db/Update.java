package db;

import java.sql.*;

public class Update
{
	public Update(String uname,String loginTime) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/login";
		String user="root";
		String pass="mysql";
		String query="insert into pacific values (?,?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, uname);
		st.setString(2, loginTime);
		int count=st.executeUpdate();
		
		System.out.println(count + " row(s) affected");
		
		st.close();
		con.close();
	}

}
