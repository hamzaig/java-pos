
import java.sql.*;

public class DbConnection 
{
	Connection c;
	Statement  s;
	
	DbConnection()  
	{
		try 
		{
			
			String driver="com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
//			System.out.println("Db Driver Loaded");
			
			String url="jdbc:mysql://localhost:3306/pos";
			String userName="hamzaig";
			String passWord="7229420000";
			
			c=DriverManager.getConnection(url,userName,passWord);
//			System.out.println("Connection is esteblished");
			
			s=c.createStatement();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("SQL Drivers is Not Loaded");
		}
		catch(SQLException e)
		{
			System.out.println("DB Connection is Not Esteblished");
		}
	}
	
}
