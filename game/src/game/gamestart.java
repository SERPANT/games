package game;

import java.awt.Image;

import javax.swing.JFrame;

public class gamestart extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
	public gamestart(Image i){
		image=i;
		gamestartpanel panel=new gamestartpanel(image);
		panel.setFocusable(true);
		add(panel);
	}

}
