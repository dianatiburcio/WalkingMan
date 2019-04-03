import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkManWithBall extends JFrame implements ActionListener
{
	private Man walkMan = new Man(0,0);
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public WalkManWithBall()
	{
		this.setBounds(45,45,500,900);
		this.setLayout(null);
		Timer t = new Timer(10,this);
		t.start();
		this.add(walkMan);
		this.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent eP)
			{}
			public void keyPressed(KeyEvent eT) 
			{
				if (eT.getKeyCode() == KeyEvent.VK_LEFT)
				{
					walkMan.setDx(-5);
				}
				if (eT.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					walkMan.setDx(5);
				}
				if (eT.getKeyCode() == KeyEvent.VK_UP)
				{
					walkMan.setDy(-5);
				}
				if (eT.getKeyCode() == KeyEvent.VK_DOWN)
				{
					walkMan.setDy(5);
				}
				if (eT.getKeyCode() == KeyEvent.VK_SPACE)
				{
					Ball ball = new Ball(walkMan.getX()+walkMan.getWidth(),walkMan.getY()+ (walkMan.getHeight()/4));
					balls.add(ball);
					add(ball);
				}
			}
			
			public void keyReleased(KeyEvent eT) 
			{
				if (eT.getKeyCode() == KeyEvent.VK_LEFT)
				{
					walkMan.setDx(0);
				}
				if (eT.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					walkMan.setDx(0);
				}
				if (eT.getKeyCode() == KeyEvent.VK_UP)
				{
					walkMan.setDy(0);
				}
				if (eT.getKeyCode() == KeyEvent.VK_DOWN)
				{
					walkMan.setDy(0);
				}                  
			}
		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		if(walkMan.getX()+walkMan.getDx()>= 0 && walkMan.getX()+walkMan.getDx()<= this.getWidth()-walkMan.getWidth()-15 && walkMan.getY()+walkMan.getDy()>=0 && walkMan.getY()+walkMan.getDy()<=this.getHeight()-walkMan.getHeight()-50)
		{
			walkMan.update();
		}
		for (int i=0; i<balls.size(); i++)
		{
			balls.get(i).update();
			
			if (balls.get(i).getX() > this.getWidth())
			{
				remove(balls.get(i));
				balls.remove(i);
				i--;
			}
		}
		repaint();
	}
}
