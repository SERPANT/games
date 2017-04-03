package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class but extends JButton {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
static gameframe frame;
	
	public but(String name){
		setText(name);
		start s=new start();
		addActionListener(s);
	
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.green);
		String l="/images/k.jpg";
		String lo="/images/text.png";//.................................................
		ImageIcon j=new ImageIcon(getClass().getResource(lo));
		ImageIcon i=new ImageIcon(getClass().getResource(l));
		g.drawImage(j.getImage(),0,0,null);
		g.drawImage(i.getImage(), 0, 260, null);
		
		
	}
	
	
	public static class start implements ActionListener{
		 
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			frontframe.delete();
			frame=new gameframe();
			frame.getContentPane().setBackground(Color.BLACK);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocation(400,300);
			Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
		     int height=(int)d.getHeight();
		     
		     frame.setSize(770,height/2);
			
			
		}
		
	}
		static public void delete(){
			frame.dispose();
		}
	
	
}
