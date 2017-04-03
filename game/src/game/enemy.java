package game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class enemy {
	int enemyx=0,enemyy=400;
	int velocity=8;
	int speed=velocity;
	int width;
	int height;
		Image i4;
		public enemy(int x,int y,String lo,int w,int h){
			enemyx=x;
			enemyy=y;
			height=h;
			width=w;		
			ImageIcon enemy=new ImageIcon(getClass().getResource(lo));
		 i4=enemy.getImage();
		 time inc=new time();
		 Timer t=new Timer(10000/2,inc);
		t.start();	
		}
		
		
		public void update1(){
			
				speed=-velocity;
			
		}
		
		public void update2()
		{
		
			speed=velocity;
			}
		
		
		
		
		public Image getimage(){
			return i4;
			
		}
		
		
		public int getx(){
		return enemyx;
		}
		
		public void putx(){
			enemyx+=speed;
		}
		
		
		
		public void putxy(){
			//enemyx+=speed;//if you increment and decrement in uneven proportion
			if(speed>0){
			enemyx=speed+enemyx+3;
			}
			else{
			enemyx=speed+enemyx-3;
			}
			enemyy+=speed;
			//enemyy=speed+enemyy+2;          //very important look at it
		}
		
		public int gety(){
			return enemyy;
		}
		
		
		public Rectangle getBounds(){
			return new Rectangle(enemyx,enemyy,width,height);
		}
		
		
		
		
		public class time implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent event) {
				if(gamestartpanel.gettime()<=40){
			 velocity+=2;
				}
				else if(gamestartpanel.gettime()>=60 && gamestartpanel.gettime()<=70){
					velocity+=3;
				}
				
			}
			
		}
		
		
	
	}

