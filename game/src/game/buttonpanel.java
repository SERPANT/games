package game;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class buttonpanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public buttonpanel(){
		
		but Start=new but("Play");
		setLayout(new BorderLayout());
		add(Start,BorderLayout.CENTER);
	}
}
