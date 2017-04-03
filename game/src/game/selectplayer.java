package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class selectplayer extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon x,y;
	JPanel panel=new JPanel();
	JButton player1,player2;
	
	
	public selectplayer(){
		
		JLabel name1=new JLabel("Woody Alan");
		JLabel name2=new JLabel("NIGHT WATCHER");
		JPanel names=new JPanel();
	    names.setLayout(new GridLayout(1,1));
		names.add(name1);
		names.add(name2);
		
		changefont(name1);
		changefont(name2);
		
		panel.setLayout(new GridLayout(1,1));
		
		
		String location1="/images/player.jpg";
		 x=new ImageIcon(getClass().getResource(location1));
		String location2="/images/pl2.jpg";
		 y=new ImageIcon(getClass().getResource(location2));
		
		
         player2=new JButton("2.",y);
		player1=new JButton("1.",x);
		selected select=new selected();
		player1.addActionListener(select);
		player2.addActionListener(select);
		player1.setBackground(Color.RED);
		player2.setBackground(Color.RED);
		panel.add(player1);
		panel.add(player2);
		
		
		add(panel);
		add(names,BorderLayout.SOUTH);
	}
	
	
	public void changefont(JLabel a){
		Font f=new Font("arial",Font.PLAIN,30);
		a.setFont(f);
	}
	
	
	public class selected implements ActionListener{
		Image i3;
		public void actionPerformed(ActionEvent e){
		String v=e.getActionCommand();
		if(v.equals("1.")){
		 i3=x.getImage();	
		}
		else if(v.equals("2.")){
			String imag="/images/pla.jpg";
			y=new ImageIcon(getClass().getResource(imag));
		 i3=y.getImage();
		}
		else{
			JOptionPane.showMessageDialog(null,"AN ERROR HAS OCCURED");
			System.exit(1);
		}
		
		gamestart frame=new gamestart(i3);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(250,100);
		frame.setTitle("DO NOT DIE");
	     frame.setSize(1500,850);
	     frame.setResizable(false);
	     gamepanel.destroy();
		
		}
	}
	

}
