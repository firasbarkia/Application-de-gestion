package serveur;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import controler.Controler;
import model.Produit;
import model.User;

public class Serveur2 {
	public static void main(String args[]) throws SQLException {
		try {
			
			ServerSocket s = new ServerSocket(1234) ;
			while(true) {
				Socket ss = s.accept() ; 
			
				DataInputStream dis  = new DataInputStream(ss.getInputStream()) ; 
				
				String message  = dis.readUTF() ; 
				System.out.println(message);
				String[] table = message.split(" ") ;
				Produit  p = new Produit(table[1],table[2],table[3]) ; 
				Controler c = new Controler() ; 
				c.saveproduit(p) ;
			}
			
		
	}catch(Exception e) {
		
	}
		
	}
}
