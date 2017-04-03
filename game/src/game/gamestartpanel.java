package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class gamestartpanel extends JPanel implements KeyListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Image image;
Image enemy2;
Image enemy1,enemy3;
 int x=600,y=350;
 int counter=0;
int goal=0;
int score;
int killed;
int time=0;
int vx=0;
int vy=0;
static int  tim=0;
Rectangle goal0=new Rectangle(700,0,100,60);
Rectangle goal1=new Rectangle(700,750,100,60);

//enemy objects..........................................................................
enemy e=new enemy(0,400,"/images/enemy.jpg",116,80);
enemy f=new enemy(200,200,"/images/demon.png",81,80);
enemy k=new enemy(5,100,"/images/demon.png",81,80);



	public gamestartpanel(Image i){
	image=i;
	enemy1=e.getimage();
	enemy2=f.getimage();
	enemy3=k.getimage();//...........................................updates
	setBackground(Color.black);
	times inc=new times();
	Timer sec=new Timer(1000,inc);
	sec.start();
	
	this.addKeyListener(this);
	enemyaction en=new enemyaction();
	Timer enemytimer=new Timer(18,en);
	enemytimer.start();
	again re =new again();
	Timer redo=new Timer(10,re);
	redo.start();
	}
	
	
	
	public void paintComponent(Graphics g){
		
		
		super.paintComponent(g);
		
		
		g.drawImage(image, x, y, null);
		g.drawImage(enemy1, e.getx(), e.gety(), null);
		if(time>=15){
		g.drawImage(enemy2,f.getx(),f.gety(),null);
		}
		g.drawImage(enemy3,k.getx(),k.gety(),null);//...........................updates
		g.setColor(Color.RED);
		g.fillRect(700,0, 100, 60);
		g.fillRect(700,750,100,60);
		
		
		
		
		Graphics2D g2=(Graphics2D)g;
	g2.setColor(Color.black);
	//area around enemy
		g2.draw(e.getBounds());
		g2.draw(f.getBounds());
		g2.draw(k.getBounds());
		//g2.draw(getBound());
		
		g2.setColor(Color.white);
		//part of the goal
		g2.draw(new Rectangle(700,0,100,60));//...............................................
		g2.draw(new Rectangle(700,750,100,60));

		Font f=new Font("arial",Font.PLAIN,100);
		
		
		
		
		g2.drawString("  Score",0,20);
		g2.drawString("  Time",1350,20);
		g2.setFont(f);
		
		
		if(time>40 && time<43){
			g2.setColor(Color.yellow);
			g2.drawString("Speed boost", 500, 500);
		}
		g2.setColor(Color.WHITE);
		g2.drawString(String.valueOf(score), 0, 115);
		g2.drawString(String.valueOf(time), 1350, 115);
		f=new Font("arial",Font.BOLD,28);
		g.setFont(f);
		g.setColor(Color.black);
		g2.drawString(Integer.toString(killed),740 ,55);
		g2.drawString("killed", 715, 30);
		
		
		puttime();
	}
	
	
	
		@Override
		public void keyPressed(KeyEvent e) {
			int k=e.getKeyCode();
			if(k==KeyEvent.VK_RIGHT){
			 
				 if(time<40){
					 vx=5;
				//x+=20;   
				 }
				 else{
					// x+=25;
					 vx=10;
				 }
			 }
		
				
			
			 if(k==KeyEvent.VK_LEFT){
				
					if(time<40){
			//	 x-=20;
						vx=-5;
					}
					else{
				//		 x-=25;
						vx=-10;
					 }
				}
				
			
			 if(k==KeyEvent.VK_UP){
				
					if(time<40){
				// y-=20;
						vy=-5;
				 
					}
					else{
				//		y-=25;
						vy=-10;
					}
				
			}
			 if(k==KeyEvent.VK_DOWN){
				 
					 if(time<40){
			//	y+=20;
						 vy=5;
					 }
					 else{
				//		 y+=25;
						 vy=10;
					 }
				
			}
			       //change has been made repaint();
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			int k=e.getKeyCode();
			if(k==KeyEvent.VK_RIGHT){
			
				  vx=0;
			 
				//x+=20;   
				 
				
				
			}
			 if(k==KeyEvent.VK_LEFT){
				
			//	 x-=20;
			
						vx=0;
			 }	
			
			 if(k==KeyEvent.VK_UP){
			
						vy=0;
				 
				
			 }
			 if(k==KeyEvent.VK_DOWN){
			
						 vy=0;
				
		}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
public class enemyaction implements ActionListener{
	
	public void actionPerformed(ActionEvent event){
		//................................................
		checkvalue(e);
		checkvalue(f);
		if(time>30){
       checkvalued(k);
		}                         //..............................update
		Collision(e);
		if(time>=15){
		Collision(f);
		}
		Collision(k);
		if(goal0.intersects(getBound()) || goal1.intersects(getBound())){
		collisiongoal();
		}
		putcall(e);
		putcall(f);
		if(time>30){
		putcalld(k);
		}                     //for update...................................
		repaint();        
	}
}



public Rectangle getBound(){
	return new Rectangle(x,y,57,60);
}



public void Collision(enemy t){
	if(getBound().intersects(t.getBounds())){
		if(counter==0){
			counter=20;
		killed++;
		
		}
		else{
		counter--;
		}
		}
}



public void collisiongoal(){

if(goal==0 && goal0.intersects(getBound())){
	score++;
	goal=1;
}

if(goal==1 && goal1.intersects(getBound())){
	score++;
	goal=0;
}
}


public class times implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
time++;
		}
	}


public void checkvalue(enemy t){
	if(t.getx()>1400){
		t.update1();
		
	}
	if(t.getx()<0){
		t.update2();
		
	}	
}


public void putcall(enemy t){
	t.putx();
}

public void putcalld(enemy t){
	t.putxy();
}


public void checkvalued(enemy t){
	if(t.getx()<0){
		t.update2();
	}
	if(t.gety()>800){
		t.update1();
	}
}


public  void puttime(){
tim=time;	
}

public static int gettime(){
	return tim;
}


public class again implements ActionListener{
	public void actionPerformed(ActionEvent event){
		update();
		repaint();
	}
	
	private void update(){
		x=x+vx;
		y=y+vy;
		if(!(x>0)){
			//x=1350;     
			x=0;
		}
		if(!(x<1450)){
			//x=0;        
			x=1450;
		}
		if(!(y>0)){
		//	y=740;            
			y=0;
		}
		if(!(y<750)){
			//y=0;                
			y=750;
		}                     
	}
}

}
