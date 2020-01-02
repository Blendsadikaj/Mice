import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 */

/**
 * @author Blend Sadikaj,Albin Hoxha
 * @implements KeyListener
 * Klasa MiceController ka per detyre detektimin
 * e shtypjes se tastatures.
 */
public class MiceController implements KeyListener {
	
	Mice mice;
	private String playersTurnToMove = HelperClass.PLAYER_ONE;
	
	public MiceController(Mice mice) {
		this.mice = mice;
	}

	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		if((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT || 
				e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
				&& playersTurnToMove.equals(HelperClass.PLAYER_ONE))
		{
			mice.movePlayerOne(e);
			playersTurnToMove = HelperClass.PLAYER_TWO;
			
		}
		else if((e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_D || 
				e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_A) 
				&& playersTurnToMove.equals(HelperClass.PLAYER_TWO)){
			mice.movePlayerTwo(e);
			playersTurnToMove = HelperClass.PLAYER_ONE;
		}}}
