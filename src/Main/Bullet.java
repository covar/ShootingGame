package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;



public class Bullet extends MoveObject{
	
	public Bullet(int x, int y) {
		super(x, y, new Dimension(5,5), new Dimension(500,500));
	}
	
	public void paint(Graphics graphic) {
		graphic.setColor(Color.black);
		graphic.fillOval(getX(), getY(), 5, 5);
	}
	
	public void move() {
		setY(getY() - 10);
	}
	
}
