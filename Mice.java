import java.awt.event.*;
import javax.swing.*;
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
	
	MiceView view;

	private int p1Points,p2Points;// Piket e secilit lojtar

	private String playersTurn = HelperClass.PLAYER_ONE; //Radhen se cili lojtar do ndjek tjetrin  

	private int miceSpeed = 5;
	
	/**
	  Konstruktori i klases Mice
	 */
	public Mice(MiceView view) {
		this.view = view;
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
	 * changePlayersTurnAndAddPoints eshte metode e cila
	 * e nderron radhen e lojtarit per t'u ndjekur
	 * dhe njekohesisht shton piket.
	 */
	private void changePlayersTurnAndAddPoints(){
		if(playersTurn.equals(HelperClass.PLAYER_ONE)){
			playersTurn = HelperClass.PLAYER_TWO;
			p1Points++;
			JOptionPane.showMessageDialog(null, HelperClass.showPoints(p1Points,p2Points));
		}
		else{
			playersTurn = HelperClass.PLAYER_ONE;
			p2Points++;
			JOptionPane.showMessageDialog(null, HelperClass.showPoints(p1Points,p2Points));
		}

	}

	/**
	 * gjenerateNewPosition gjeneron pozitat e reja
	 * te 'minjeve'.
	 */
	private void generateNewPosition(){
		mXP1 = (int)(Math.random()*HelperClass.width);
		mXP2 = (int)(Math.random()*HelperClass.width);
		mYP1 = (int)(Math.random()*HelperClass.width);
		mYP2 = (int)(Math.random()*HelperClass.width);

		if(HelperClass.checkIfOutOfBoundaries(mXP1,mXP2,mYP1,mYP2,HelperClass.width,HelperClass.height,mRadius) || HelperClass.checkBallPosition(mXP1,mXP2,mYP1,mYP2,mRadius))
			generateNewPosition();
	}

	/**
	 * reset bene rifillimin e lojes me pozite te 
	 * 'minjeve' te rendomte,shton piket dhe nderron
	 * radhen e lojtarit per t'u ndjekur.
	 */
	private void reset(){
		if(HelperClass.checkBallPosition(mXP1,mXP2,mYP1,mYP2,mRadius)){
			generateNewPosition();
			changePlayersTurnAndAddPoints();
			view.repaint();  
		}
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
			view.repaint();
			reset();
			break;
		case KeyEvent.VK_DOWN : 
			mYP1 = (mYP1 + mRadius >= HelperClass.height) ? (HelperClass.height - mRadius) : (mYP1 += miceSpeed);	
			view.repaint();
			reset();
			break;
		case KeyEvent.VK_LEFT :
			mXP1 = (mXP1 - mRadius <= 0) ? mRadius : (mXP1 -= miceSpeed);			
			view.repaint();
			reset();
			break;
		case KeyEvent.VK_UP :
			mYP1 = ( mYP1 - mRadius <= 0 ) ? mRadius : (mYP1 -= miceSpeed);			
			view.repaint();
			reset();
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
			view.repaint();
			reset();  
			break;
		case KeyEvent.VK_S : 
			mYP2 = (mYP2 + mRadius >= HelperClass.height) ? (HelperClass.height - mRadius) : (mYP2 += miceSpeed);
			view.repaint();
			reset(); 
			break;
		case KeyEvent.VK_A :
			mXP2 = (mXP2 - mRadius <= 0) ? mRadius : (mXP2 -= miceSpeed); 
			view.repaint();
			reset();
			break;
		case KeyEvent.VK_W :
			mYP2 = (mYP2 - mRadius <= 0) ? mRadius : (mYP2 -= miceSpeed);		  
			view.repaint();
			reset();
			break; 
		}
	}
}