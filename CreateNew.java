package cli;

import java.sql.*;

public class CreateNew 
{
	//public CreateNew()throws Exception
	//public static void main(String[] args)throws Exception
	public CreateNew(String email)
	{
//		String url="jdbc:mysql://localhost:3306/login";
//		String user="root";
//		String pass="mysql";
//		String table_name="myTable";
//		String query="create table "+ table_name + "(user varchar(20),"
//				+ "login_time varchar(20), device varchar(20))";
		
		email=removeSpecialChars(email);
		
		String url="jdbc:mysql://remotemysql.com:3306/qi85RrFx3v";
		String user="qi85RrFx3v";
		String pass="vKd8KLNlxi";
		String table_name=email;
		String query="create table "+ table_name + "(user varchar(20),"
				+ "login_time varchar(20), device varchar(20))";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			Statement st=con.createStatement();
			st.executeUpdate(query);
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	static String removeSpecialChars(String email)
	{
		String[] arrOfStr = email.split("[@.]"); 
		StringBuilder modified=new StringBuilder();  
        for (String a : arrOfStr)
        {
            System.out.println(a);
            modified.append(a);
        }
        return new String(modified);
	}
	
//	public static void main(String[] args) 
//	{
//		String email="prashant.bittu@gmail.com";
//		System.out.println(CreateNew.removeSpecialChars(email));
//	}
}
