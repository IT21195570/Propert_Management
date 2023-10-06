package pak.feedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDBUtil {
	
	
	//RETRIEVING
	
	
	//making static method called validate,to return feedback's array list
	
	public static List<feedback> validate(String username, String email){
		
		ArrayList<feedback> fed = new ArrayList<>();
		
		//create db con
		String url = "jdbc:mysql://localhost:3306/propertymanagement";
		String user = "root";
		String pass = "12345";
		
		
		//validate
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
			//Query
			String sql = "select * from feedback where username = '"+username+"' and email = '"+email+"'";
			
			//to run query
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			//fetching data
			
			if(rs.next()) {
				
				int id = rs.getInt(1);
				String uname =  rs.getString(2); //(2) means column number
				String mail = rs.getString(3);
				String feedback = rs.getString(4);
				
				//object from feedback class
				 
				feedback f = new feedback(id, uname, mail, feedback); //passing the values to constructor from database
				
				//passing feedback object to arraylist object
				
				fed.add(f);
				
				
				
			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return fed; //returning arraylist
		
		
		
	}
	
	//----------------------------------------------------------------------------------------------------
	
	
	//INSERTING
	
	public static boolean insertfeedback(String username, String email, String feedback) {
		
		boolean isSuccess = false;
		
		
		//db conn
		String url = "jdbc:mysql://localhost:3306/propertymanagement";
		String user = "root";
		String pass = "12345";
		
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
			//Query
			String sql = "insert into feedback values(0,'"+username+"', '"+email+"', '"+feedback+"' )";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				
				isSuccess = true;
	
			}else {
				
				isSuccess = false;
			}
			
	
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return isSuccess;
		
	}
	
	//------------------------------------------------------------------------------------------------------------------
	
	//UPDATE
	
	public static boolean updatefeedback(String id,String username, String email, String feedback) {
		
		boolean isSuccess = false;
		
		//db conn
				String url = "jdbc:mysql://localhost:3306/propertymanagement";
				String user = "root";
				String pass = "12345";
				
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
			
			//Query
			String sql = "update feedback set username='"+username+"', email='"+email+"', feedback='"+feedback+"'"+"where id='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				
				isSuccess = true;
	
			}else {
				
				isSuccess = false;
			}
			
			
		}		
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return isSuccess;
		
	}
	
	
	//----------------------------------------------------------------------------------------------------
	
	
	//DELETE
	
	
		public static boolean deletefeedback(String id) {
			
			boolean isSuccess = false;
			
			//db conn
			String url = "jdbc:mysql://localhost:3306/propertymanagement";
			String user = "root";
			String pass = "12345";
			
			int convId = Integer.parseInt(id); //converting id as an integer value
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, pass);
				Statement stmt = con.createStatement();
				
				
				//Query
				String sql = "delete from feedback where id='"+convId+"' ";
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					
					isSuccess = true;
		
				}else {
					
					isSuccess = false;
				}
				
				
			}		
			
			catch(Exception e) {
				
				e.printStackTrace();
			}
			
			
			return isSuccess;
		}
	
		
	
	
	
}
