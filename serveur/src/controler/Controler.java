package controler;



import java.sql.Statement;

import model.Credit;
import model.Produit;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controler {
	public int saveCredit(Credit c ) throws SQLException{
		int i =0 ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_db","root","admin123") ; 
			
			Statement statement = connection.createStatement() ;
			
			statement.executeQuery("select * from user_table"); 
	 
			String req = "insert into credit_table"+
			"(PR_ID,US_ID,RESTE_PAYER,NB_TRANCHE)VALUES("
			+"\""+c.getPR_ID()+"\""+","
			+"\""+c.getUS_ID()+"\""+","
			+"\""+c.getRESTE_PAYER()+"\""
			+"\""+c.getNB_TRANCHE()+"\""+") ;";
			 i = statement.executeUpdate(req);
			return i ; 		
		}catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}
public int saveproduit(Produit p ) throws SQLException{
	int i =0 ;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver") ;
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_db","root","admin123") ; 
		
		Statement statement = connection.createStatement() ;
		
		statement.executeQuery("select * from user_table"); 
 
		String req = "insert into product_table"+
		"(P_Name,P_DESC,P_PRICE)VALUES("
		+"\""+p.getP_NAME()+"\""+","
		+"\""+p.getP_DESC()+"\""+","
		+"\""+p.getP_PRICE()+"\""+") ;";
		 i = statement.executeUpdate(req);
		return i ; 		
	}catch(Exception e) {
		System.out.println(e);
	}
	return i;
}
public static int saveuser( User u) throws SQLException {
	int i =0 ;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver") ;
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_db","root","admin123") ; 
		
		Statement statement = connection.createStatement() ;
		
		statement.executeQuery("select * from user_table"); 

		u.setRole("admin") ; 
		String req = "insert into user_table"+
		"(U_NAME,U_EMAIL,U_PASSWORD,ROLE)VALUES("
		+"\""+u.getU_NAME()+"\""+","
		+"\""+u.getU_EMAIL()+"\""+","
		+"\""+u.getU_PASSWORD()+"\""+","
		+"\""+u.getRole()+"\""+") ;";
		 i = statement.executeUpdate(req);
		return i ; 		
	}catch(Exception e) {
		System.out.println(e);
	}
	return i;
	}



}
