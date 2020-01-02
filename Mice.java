import java.awt.event.*;
/**
 * @author Blend Sadikaj, Albin Hoxha.
 * Klasa Mice ka per detyre gjenerimin e nje GUI
 * ku paraqiten grafikisht dy 'minje' qe ndjekin njeri
 * tjetrin.
 */
public class Mice{
	
	private int mRadius = 10; // Rrezja e miut

	private int mDiameter = 2 * mRadius;//Diametri i miut

	private int mXP1 = mRadius, mYP1 = mRadius,mYP2 = mRadius; // Pozita fillestare e 'miut' 1

	private int mXP2 = HelperClass.width - mRadius; // Pozita fillestare e 'miut' 2
	
	private MiceView view;//view mban objektin MiceView 
	
	private MiceService service;//service mban objektin MiceService

	private int p1Points,p2Points;// Piket e secilit lojtar

	private String playersTurn = HelperClass.PLAYER_ONE; //Radhen se cili lojtar do ndjek tjetrin  

	private int miceSpeed = 10;//Shpejtesia e 'miut'
	
	/**
	 * @param view pranon si parameter objektin MiceView
	  Konstruktori i klases Mice
	 */
	public Mice(MiceView view) {
		this.view = view;
		service = new MiceService(this);
		
	}
	
	/**
	 * paintAndCheck() therret metodat repaint 
	 * qe eshte ne klasen MiceView dhe reset
	 * ne klasen MiceService
	 */
	private void paintAndCheck() {
		view.repaint();
		service.reset(); 
	}

	/** 
	 * @param e eshte parameter i cili mbane informacionin
	 * se cili buton eshte shtypet.
	 * Kjo metode mundeson levizjen e 'miut' 1 neper dritare
	 */
	public void movePlayerOne(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT : 
			mXP1 = (mXP1 + mRadius >= HelperClass.width) ? (HelperClass.width - mRadius) : (mXP1 += miceSpeed);			
			paintAndCheck();
			break;
		case KeyEvent.VK_DOWN : 
			mYP1 = (mYP1 + mRadius >= HelperClass.height) ? (HelperClass.height - mRadius) : (mYP1 += miceSpeed);	
			paintAndCheck();
			break;
		case KeyEvent.VK_LEFT :
			mXP1 = (mXP1 - mRadius <= 0) ? mRadius : (mXP1 -= miceSpeed);			
			paintAndCheck();
			break;
		case KeyEvent.VK_UP :
			mYP1 = ( mYP1 - mRadius <= 0 ) ? mRadius : (mYP1 -= miceSpeed);			
			paintAndCheck();
			break; 
		}
	}

	/**
	 * @param e eshte parameter i cili mban informacionin
	 * se cili buton eshte shtypur.
	 * Kjo metode mundeson levizjen e 'miut' 2 neper dritare.
	 */
	public void movePlayerTwo(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_D : 
			mXP2 = (mXP2 + mRadius >= HelperClass.width) ? (HelperClass.width - mRadius) : (mXP2 += miceSpeed);			
			paintAndCheck();
			break;
		case KeyEvent.VK_S : 
			mYP2 = (mYP2 + mRadius >= HelperClass.height) ? (HelperClass.height - mRadius) : (mYP2 += miceSpeed);
			paintAndCheck(); 
			break;
		case KeyEvent.VK_A :
			mXP2 = (mXP2 - mRadius <= 0) ? mRadius : (mXP2 -= miceSpeed); 
			paintAndCheck();
			break;
		case KeyEvent.VK_W :
			mYP2 = (mYP2 - mRadius <= 0) ? mRadius : (mYP2 -= miceSpeed);		  
			paintAndCheck();
			break; 
		}
	}
	
	/**
	 * @return the mRadius
	 */
	public int getmRadius() {
		return mRadius;
	}
	
	/**
	 * @return the mDiameter
	 */
	public int getmDiameter() {
		return mDiameter;
	}

	/**
	 * @param mXP1 the mXP1 to set
	 */
	public void setmXP1(int mXP1) {
		this.mXP1 = mXP1;
	}

	/**
	 * @param mYP1 the mYP1 to set
	 */
	public void setmYP1(int mYP1) {
		this.mYP1 = mYP1;
	}

	/**
	 * @param mYP2 the mYP2 to set
	 */
	public void setmYP2(int mYP2) {
		this.mYP2 = mYP2;
	}

	/**
	 * @param mXP2 the mXP2 to set
	 */
	public void setmXP2(int mXP2) {
		this.mXP2 = mXP2;
	}

	/**
	 * @return the p1Points
	 */
	public int getP1Points() {
		return p1Points;
	}

	/**
	 * @param p1Points the p1Points to set
	 */
	public void setP1Points(int p1Points) {
		this.p1Points = p1Points;
	}

	/**
	 * @return the p2Points
	 */
	public int getP2Points() {
		return p2Points;
	}

	/**
	 * @param p2Points the p2Points to set
	 */
	public void setP2Points(int p2Points) {
		this.p2Points = p2Points;
	}

	/**
	 * @return the playersTurn
	 */
	public String getPlayersTurn() {
		return playersTurn;
	}

	/**
	 * @param playersTurn the playersTurn to set
	 */
	public void setPlayersTurn(String playersTurn) {
		this.playersTurn = playersTurn;
	}

	/**
	 * @return the miceSpeed
	 */
	public int getMiceSpeed() {
		return miceSpeed;
	}

	/**
	 * @return the mXP1
	 */
	public int getmXP1() {
		return mXP1;
	}

	/**
	 * @return the mYP1
	 */
	public int getmYP1() {
		return mYP1;
	}

	/**
	 * @return the mYP2
	 */
	public int getmYP2() {
		return mYP2;
	}
	
	/**
	 * @return the mXP2
	 */
	public int getmXP2() {
		return mXP2;
	}
	
	/**
	 * @return the view
	 */
	public MiceView getView() {
		return view;
	}
}