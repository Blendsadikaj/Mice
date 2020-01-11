import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Blend Sadikaj, Albin Hoxha
 * @extends JPanel
 * Klasa MiceView ka per detyre krijimin
 * e paneles dhe dritares
 */
public class MiceView extends JPanel {
	
	private Mice mice;//mice mban objektin Mice
	
	public MiceView(MiceController controller) {
		
		this.mice = new Mice(this);
		//Paneli i cili paralajmeron se loja po fillon
		JOptionPane.showMessageDialog(null,HelperClass.GAME_DSC);

		//setBackground i jep ngjyre paneles
		this.setBackground(Color.white);

		//setPreferredSize percakton madhesine e paneles
		this.setPreferredSize(new Dimension(HelperClass.width,HelperClass.height));      

		//setFocusable fokusin e paneles
		this.setFocusable(true);

		/*Shton ndegjuesin e tastatures qe te marr informata nga
		 *komponenta per shtypjen e tastatures*/
		this.addKeyListener(controller);  

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
	 * paintComponent perdoret per vizatimin ne panel
	 * te 'minjeve'.
	 * @param g pranon si parameter nje objekt Graphics
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.fillOval(mice.getmXP1() - mice.getmRadius(), mice.getmYP1() - mice.getmRadius(), mice.getmDiameter(), mice.getmDiameter());
		g.setColor(Color.lightGray);
		g.fillOval(mice.getmXP2() - mice.getmRadius(), mice.getmYP2() - mice.getmRadius(), mice.getmDiameter(), mice.getmDiameter());

	}


	/**
	 * @return the mice
	 */
	public Mice getMice() {
		return mice;
	}
	
	

}
