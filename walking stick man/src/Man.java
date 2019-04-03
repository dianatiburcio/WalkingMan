import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Man extends JComponent
{
	private Ellipse2D head;
	private Rectangle2D lA,rA,lL,rL,t;
	private int dX = 0, dY = 0;
	public Man(int x, int y)
	{
		this.setLocation(x,y);
		this.setSize(76,113);
		head = new Ellipse2D.Double(25,0,25,25);
		lA = new Rectangle2D.Double(0,25,25,12.5);
		rA = new Rectangle2D.Double(50,25,25,12.5);
		t = new Rectangle2D.Double(25,25,25,50);
		rL = new Rectangle2D.Double(12.5,62.5,12.5,50);
		lL = new Rectangle2D.Double(50,62.5,12.5,50);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(head);
		g2.draw(lA);
		g2.draw(rA);
		g2.setColor(Color.RED);
		g2.draw(t);
		g2.fill(t);
		g2.setColor(Color.BLUE);
		g2.draw(rL);
		g2.draw(lL);
		g2.fill(lL);
		g2.fill(rL);
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

