package db;

import java.sql.*;

public class CreateNew 
{
	//public CreateNew()throws Exception
	public static void main(String[] args)throws Exception
	{
		String url="jdbc:mysql://localhost:3306/login";
		String user="root";
		String pass="mysql";
		String table_name="myTable";
		String query="create table "+ table_name + "(user varchar(20),"
				+ "login_time varchar(20), device varchar(20))";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		Statement st=con.createStatement();
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
}
