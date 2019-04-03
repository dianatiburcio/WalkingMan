import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent
{
	private int dX = 3, dY = 0;
	private Ellipse2D ball;
	
	public Ball(int x, int y)
	{
		this.setLocation(x,y);
		this.setSize(25,25);
		ball = new Ellipse2D.Double(0,0,12.5,12.5);
		
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		g2.fill(ball);
	}
	
	public int getDy()
	{
		return dY;
	}
	public int getDx()
	{
		return dX;
	}
	public void setDy(int y)
	{
		dY = y;
	}
	public void setDx(int x)
	{
		dX = x;
	}
	
	public void update()
	{
		this.setLocation(this.getX() + dX, this.getY() + dY);
	}
}
