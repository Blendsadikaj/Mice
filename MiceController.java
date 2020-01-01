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
	
	Mice mice;
	
	public MiceController(Mice mice) {
		this.mice = mice;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		mice.movePlayerOne(e);
		mice.movePlayerTwo(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//mice.movePlayerOne(e);
		//mice.movePlayerTwo(e);

	}
	
}
