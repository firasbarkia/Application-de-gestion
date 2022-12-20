package model;

import java.io.Serializable;

public class User  {

	private int  U_ID ; 
	private String U_NAME  ; 
	private String U_EMAIL ; 
	private String U_PASSWORD  ;
	private String Role ; 
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public int getU_ID() {
		return U_ID;
	}
	public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}
	public String getU_NAME() {
		return U_NAME;
	}
	public void setU_NAME(String u_NAME) {
		U_NAME = u_NAME;
	}
	public String getU_EMAIL() {
		return U_EMAIL;
	}
	public void setU_EMAIL(String u_EMAIL) {
		U_EMAIL = u_EMAIL;
	}
	public String getU_PASSWORD() {
		return U_PASSWORD;
	}
	public void setU_PASSWORD(String u_PASSWORD) {
		U_PASSWORD = u_PASSWORD;
	}
	public User( String u_NAME, String u_EMAIL, String u_PASSWORD) {
		
		U_NAME = u_NAME;
		U_EMAIL = u_EMAIL;
		U_PASSWORD = u_PASSWORD;
	} 
	
}
