import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 */

/**
 * @author Blend Sadikaj,Albin Hoxha
 * @implements KeyListener
 */
public class MiceController implements KeyListener {
	
	Mice mice;//mice mban objektin Mice
	
	/**
	 * @param mice pranon si parameter objektin Mice
	 */
	public MiceController(Mice mice) {
		this.mice = mice;
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {		
	}
	/**
	 * @param e pranon si parameter objektin KeyEvent
	 * Kjo metod thirret sa here qe nje buton shtypet e pastaj lirohet
	 */
	public void keyReleased(KeyEvent e) {
			mice.movePlayerOne(e);
			mice.movePlayerTwo(e);

	}
	
}
