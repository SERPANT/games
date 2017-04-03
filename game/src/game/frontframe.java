package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class frontframe {
	static tiner frame=new tiner();
	public static void main(String[] args){
		
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(null);//....................................very important
		frame.setLocation(400,300);
		frame.setTitle("the KiLLING");
		Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
	     int height=(int)d.getHeight();
	     
	     frame.setSize(770,height/2);
	    
	}
	
	static public void delete(){
		frame.dispose();
	}
	
	
}
