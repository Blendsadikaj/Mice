import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Blend Sadikaj, Albin Hoxha
 * Klasa MiceService ka per detyre te merret
 * me logjiken e aplikacionit
 */
public class MiceService {
	
	Mice mice;//mice mban objektin Mice
	
	/**
	 * @param mice pranon si parameter objektin Mice
	 */
	public MiceService(Mice mice) {
		this.mice = mice;
	}
	
	/**
	 * changePlayersTurnAndAddPoints eshte metode e cila
	 * e nderron radhen e lojtarit per t'u ndjekur
	 * dhe njekohesisht shton piket.
	 */
	private void changePlayersTurnAndAddPoints(){
		if(mice.getPlayersTurn().equals(HelperClass.PLAYER_ONE)){
			mice.setPlayersTurn(HelperClass.PLAYER_TWO);
			mice.setP1Points((mice.getP1Points()+1));
			JOptionPane.showMessageDialog(null, HelperClass.showPoints(mice.getP1Points(),mice.getP2Points()));
		}
		else{
			mice.setPlayersTurn(HelperClass.PLAYER_ONE);
			mice.setP2Points((mice.getP2Points()+1));
			JOptionPane.showMessageDialog(null, HelperClass.showPoints(mice.getP1Points(),mice.getP2Points()));
		}
	}

	/**
	 * gjenerateNewPosition gjeneron pozitat e reja
	 * te 'minjeve'.
	 */
	public void generateNewPosition(){
		mice.setmXP1((int)(Math.random()*HelperClass.width));
		mice.setmXP2((int)(Math.random()*HelperClass.width));
		mice.setmYP1((int)(Math.random()*HelperClass.width));
		mice.setmYP2((int)(Math.random()*HelperClass.width));

		if(HelperClass.checkIfOutOfBoundaries(mice.getmXP1(),mice.getmXP2(),mice.getmYP1(),mice.getmYP2(),HelperClass.width,HelperClass.height,mice.getmRadius()) || 
				HelperClass.checkBallPosition(mice.getmXP1(),mice.getmXP2(),mice.getmYP1(),mice.getmYP2(),mice.getmRadius()))
			generateNewPosition();
	}

	/**
	 * reset bene rifillimin e lojes me pozite te 
	 * 'minjeve' te rendomte,shton piket dhe nderron
	 * radhen e lojtarit per t'u ndjekur.
	 */
	public void reset(){
		if(HelperClass.checkBallPosition(mice.getmXP1(),mice.getmXP2(),mice.getmYP1(),mice.getmYP2(),mice.getmRadius())){
			generateNewPosition();
			changePlayersTurnAndAddPoints();
			mice.getView().repaint();  
		}
	}
}
