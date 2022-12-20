package model;

public class Credit {
	private String PR_ID ; 
	private String  US_ID ;
	private String RESTE_PAYER ;
	private String NB_TRANCHE ;
	
	public Credit(String pR_ID, String uS_ID, String rESTE_PAYER, String nB_TRANCHE) {
		super();
		PR_ID = pR_ID;
		US_ID = uS_ID;
		RESTE_PAYER = rESTE_PAYER;
		NB_TRANCHE = nB_TRANCHE;
	}
	public String getPR_ID() {
		return PR_ID;
	}
	public void setPR_ID(String pR_ID) {
		PR_ID = pR_ID;
	}
	public String getUS_ID() {
		return US_ID;
	}
	public void setUS_ID(String uS_ID) {
		US_ID = uS_ID;
	}
	public String getRESTE_PAYER() {
		return RESTE_PAYER;
	}
	public void setRESTE_PAYER(String rESTE_PAYER) {
		RESTE_PAYER = rESTE_PAYER;
	}
	public String getNB_TRANCHE() {
		return NB_TRANCHE;
	}
	public void setNB_TRANCHE(String nB_TRANCHE) {
		NB_TRANCHE = nB_TRANCHE;
	}
	
	
}
