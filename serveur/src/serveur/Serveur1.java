package serveur;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import controler.Controler;
import model.User ; 

public class Serveur1 {
	public static void main(String args[]) throws SQLException {
		try {
			
			ServerSocket s = new ServerSocket(1234) ;
			while(true) {
				Socket ss = s.accept() ; 
			
				DataInputStream dis  = new DataInputStream(ss.getInputStream()) ; 
				
				String message  = dis.readUTF() ;
				String[] table = message.split(" ") ; 
				System.out.println(message);
				User u = new User(table[0],table[1],table[2]) ;
				Controler c = new Controler() ; 
				c.saveuser(u) ;
			}
			
		
	}catch(Exception e) {
		
	}
		
	}
}
