/**
 * @author Blend Sadikaj, Albin Hoxha
 * Kjo klase ka per detyre qe te ndihmoj 
 * klasen Mice me variablat dhe metodat
 * e saj.
 */

public class HelperClass{

	public static final String PLAYER_ONE = "Player one";
	public static final String PLAYER_TWO = "Player two";
	//Pershkrimi i lojes
	public static final String GAME_DSC = "Mice chasing game about to start. Players take turns on chasing each other starting with the black mice first.";
	public static final String FRAME_TITLE = "Mice Chasing Game";

	/**
	 * Konstruktori i klases HelperClass.
	 */
	private HelperClass(){}

	/**
	 * checkIfOutOfBoundaries kontrollon nese gjate gjenerimit 
	 * te pozites se re te 'minjeve' pozita e tyre nuk eshte 
	 * jashte dritares.
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @param width
	 * @param height
	 * @param mRadius
	 * @return nje vlere boolean varesisht nese 'miu' pozicionohet jasht dritares
	 */
	public static boolean checkIfOutOfBoundaries(int x1,int x2,int y1,int y2,int width,int height,int mRadius){ 
		if((x1 + mRadius >= width || x1 - mRadius <= 0) || (x2 + mRadius >= width || x2 - mRadius <= 0) || (y1 + mRadius >= height || y1 - mRadius <= 0) || 
				(y2 + mRadius >= height || y2 - mRadius <= 0))
			return true;
		return false;
	}

	/**
	 * checkBallPosition kontrollon se nese 'minjte' jane brenda 
	 * njeri tjetrit.
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @param radius
	 * @return nje vlere boolean varesisht a eshte 'miu' brenda tjetrit
	 */
	public static boolean checkBallPosition(int x1,int x2,int y1,int y2,int radius){
		if(Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2)) <= radius*2)
			return true;
		return false;
	}

	/**
	 * showPoints eshte metode e cila sherben per te
	 * shfaqur piket e lojtareve.
	 * @param p1Points
	 * @param p2Points
	 * @return nje String i cili permban informacionin me piket e lojtareve
	 */
	public static String showPoints(int p1Points,int p2Points) {
		return "Player one's points: " + p1Points + " and player two's points: " + p2Points; 
	}   
}