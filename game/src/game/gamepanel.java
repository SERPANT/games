package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class gamepanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static selectplayer frame;
	Timer time;
	
int x=600;
 int y=350;
 int x2=0;
 int y2=10;
 int counter=0;
 
 Image i1,i2;
	public gamepanel(){
		setBackground(Color.red);
		setLayout(new BorderLayout());
		Font f=new Font("arial",Font.BOLD,30);
		JLabel loading=new JLabel("                                      LOADING.............");
		loading.setFont(f);
		add(loading,BorderLayout.CENTER);
		repeat rep=new repeat();
		loading l=new loading();
		Timer load=new Timer(2000,l);
		load.start();
		 time=new Timer(10,rep);
		time.start();
	}
	
	
	public void getimage(){
		String location="/images/player.jpg";
		String location2="/images/pl2.jpg";
		
		ImageIcon player=new ImageIcon(getClass().getResource(location));
		ImageIcon player2=new ImageIcon(getClass().getResource(location2));
		
		 i1=player.getImage();
		i2=player2.getImage();
	}
	 
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(counter==0){
	getimage();
	
		}
	g.drawImage(i1, x, y, null);
	g.drawImage(i2, x2, y2, null);
	}
	
	
	
	 private void inc(){
		 x-=2;
		 x2+=2;
		
	 }
	 
	 
	 public void swap(){
			Image i3;
			i3=i1;
			i1=i2;
			i2=i3;
		}
	 
	 
	public class repeat implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(x>0){
			inc();
			}
			else{
				try {
					swap();
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
				
					JOptionPane.showMessageDialog(null,"sorry something went wrong");
					System.exit(1);
				}
				
				x=600;
				x2=0;
				inc();
			}
			
			repaint();
			
			
			if(counter>3){                     //change counter.............................................
				time.stop();
				but.delete();
				
				frame=new selectplayer();
				frame.getContentPane().setBackground(Color.BLACK);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocation(400,300);
				Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
			     int height=(int)d.getHeight();
			     frame.setTitle("Player select");
			     frame.setSize(770,height/2);
				
			}
		}
		
	}
	
	
	public class loading implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			counter++;
			
			
		}
		
	}
	
	static public void destroy(){
		frame.dispose();
	}


}
