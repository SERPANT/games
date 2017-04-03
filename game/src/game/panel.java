package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class panel extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public  panel(){
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		buttonpanel button=new buttonpanel();
		add(button,BorderLayout.EAST);
	}
	
	
	
	public void paintComponent(Graphics g){
		
		
		super.paintComponent(g);
		g.drawImage(getImage(), 0, 0, null);
		//for(int i=0;i<=400;i+=400){
			//for(int j=0;j<=800;j+=400){
				//g.drawImage(getImage(), j, i, null);
			//}
		//}
	}
	
	
	public Image getImage(){
		String location="/images/b.jpg";
		ImageIcon i =new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}
}
