import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Blend Sadikaj, Albin Hoxha.
 * @extends JPanel
 * @implements KeyListener
 * 
 * Klasa Mice ka per detyre gjenerimin e nje GUI
 * ku paraqiten grafikisht dy 'minje' qe ndjekin 
 * tjetrin.
 */
public class Mice extends JPanel implements KeyListener{

	private int mRadius = 10; // Rrezja e miut

	private int mDiameter = 2 * mRadius;//Diametri i miut

	private int mXP1 = mRadius, mYP1 = mRadius,mYP2 = mRadius; // Pozita fillestare e 'miut' 1

	private int width = 400,height = 200;//Madhesia e dritares

	private int mXP2 = width - mRadius; // Pozita fillestare e 'miut' 2

	private int p1Points,p2Points;// Piket e secilit lojtar

	private String playersTurn = HelperClass.PLAYER_ONE; //Radhen se cili lojtar do ndjek tjetrin  

	/**
	  Konstruktori i klases Mice
	 */
	public Mice() {

		//Paneli i cili paralajmeron se loja po fillon
		JOptionPane.showMessageDialog(null,HelperClass.GAME_DSC);

		//setBackground i jep ngjyre paneles
		this.setBackground(Color.white);

		//setPreferredSize percakton madhesine e paneles
		this.setPreferredSize(new Dimension(width,height));      

		//setFocusable fokusin e paneles
		this.setFocusable(true);

		/*Shton ndegjuesin e tastatures qe te marr informata nga
		 *komponenta per shtypjen e tastatures*/
		this.addKeyListener(this);  

		//Krijimi i dritares
		JFrame frame = new JFrame(HelperClass.FRAME_TITLE);

		/*
		 * setDefaultCloseOperation mbyll ekzekutimin e programit 
		 * me rastin e mbylljes se dritares
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Shtimi i paneles ne dritare
		frame.getContentPane().add(this);

		//pack metode e JFrame e cila i jep madhesine dritares sipas paneles brenda saj
		frame.pack();  

		//setVisible eshte metode e JFrame e cila ne kete rast bene dritaren e dukshme
		frame.setVisible(true);

	}

	/**
	 * keyTyped eshte metode e cila thirret ne rastin kur 
	 * nje buton ne tastature shtypet.
	 */
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * keyPressed eshte metode e cila thirret ne rastin kur 
	 * nje buton ne tastature shtypet.
	 */
	public void keyPressed(KeyEvent e) {          
	}

	/**
	 * keyReleased eshte metode e cila thirret ne rastin kur 
	 * nje buton ne tastature shtypet dhe lirohet.
	 */
	public void keyReleased(KeyEvent e) {
		movePlayerOne(e);
		movePlayerTwo(e);
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
		mXP1 = (int)(Math.random()*width);
		mXP2 = (int)(Math.random()*width);
		mYP1 = (int)(Math.random()*height);
		mYP2 = (int)(Math.random()*height);

		if(HelperClass.checkIfOutOfBoundaries(mXP1,mXP2,mYP1,mYP2,width,height,mRadius) || HelperClass.checkBallPosition(mXP1,mXP2,mYP1,mYP2,mRadius))
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
			this.repaint();  
		}
	}

	/** 
	 * @param e eshte parameter i cili mbane informacionin
	 * se cili buton eshte shtypet.
	 * Kjo metode mundeson levizjen e 'miut' 1 neper dritare
	 */
	private void movePlayerOne(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT : 
			if(mXP1 + mRadius + 5 > width)
				return;
			mXP1 += 5;
			this.repaint();
			reset();
			break;
		case KeyEvent.VK_DOWN : 
			if(mYP1 + mRadius + 5 > height)
				return;
			mYP1 += 5;
			this.repaint();
			reset();
			break;
		case KeyEvent.VK_LEFT :
			if(mXP1 - mRadius - 5 < 0)
				return; 
			mXP1 -= 5;
			this.repaint();
			reset();
			break;
		case KeyEvent.VK_UP :
			if( mYP1 - mRadius - 5 < 0 )
				return;
			mYP1 -= 5;
			this.repaint();
			reset();
			break; 
		}
	}

	/**
	 * @param e eshte parameter i cili mban informacionin
	 * se cili buton eshte shtypur.
	 * Kjo metode mundeson levizjen e 'miut' 2 neper dritare.
	 */
	private void movePlayerTwo(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_D : 
			if(mXP2 + mRadius + 5 > width)
				return;   
			mXP2 += 5;
			this.repaint();
			reset();  
			break;
		case KeyEvent.VK_S : 
			if(mYP2 + mRadius + 5 > height)
				return;
			mYP2 += 5; 
			this.repaint();
			reset(); 
			break;
		case KeyEvent.VK_A :
			if(mXP2 - mRadius - 5 < 0)
				return;  
			mXP2 -= 5;  
			this.repaint();
			reset();
			break;
		case KeyEvent.VK_W :
			if( mYP2 - mRadius - 5 < 0 )
				return;
			mYP2 -= 5;  
			this.repaint();
			reset();
			break; 
		}
	}

	/**
	 * paintComponent perdoret per vizatimin ne panel
	 * te 'minjeve'.
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.fillOval(mXP1 - mRadius, mYP1 - mRadius, mDiameter, mDiameter);
		g.setColor(Color.red);
		g.fillOval(mXP2 - mRadius, mYP2 - mRadius, mDiameter, mDiameter);

	}

	//Metoda main e cila bene startimin e aplikacionit
	public static void main(String[] args) {
		new Mice();
	}

}