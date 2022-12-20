package model;

public class Produit {
private int P_ID ; 
private String P_NAME ; 
private String P_DESC ; 
private String P_PRICE ;
public int getP_ID() {
	return P_ID;
}
public void setP_ID(int p_ID) {
	P_ID = p_ID;
}
public String getP_NAME() {
	return P_NAME;
}
public void setP_NAME(String p_NAME) {
	P_NAME = p_NAME;
}
public String getP_DESC() {
	return P_DESC;
}
public void setP_DESC(String p_DESC) {
	P_DESC = p_DESC;
}
public String getP_PRICE() {
	return P_PRICE;
}
public void setP_PRICE(String p_PRICE) {
	P_PRICE = p_PRICE;
}
public Produit(String p_NAME, String p_DESC, String p_PRICE) {
	P_NAME = p_NAME;
	P_DESC = p_DESC;
	P_PRICE = p_PRICE;
} 


}
