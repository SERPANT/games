package game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class gameframe extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public gameframe(){
		gamepanel panel=new gamepanel();
		add(panel,BorderLayout.CENTER);
	}

}
