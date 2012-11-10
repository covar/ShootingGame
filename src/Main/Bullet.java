package Main;
import java.awt.Color;
import java.awt.Graphics;


public class Bullet {
	int X, Y;
	private boolean Exist;
	
	public boolean isExist() {
		return Exist;
	}

	public void setExist(boolean flag) {
		this.Exist = flag;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		this.X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		this.Y = y;
	}

	public Bullet(int x, int y) {
		setX(x);
		setY(y);
		setExist(true);
	}
	
	public void paint(Graphics graphic) {
		graphic.setColor(Color.black);
		graphic.fillOval(getX(), getY(), 5, 5);
	}
	
	public void move() {
		setY(getY() - 10);
	}
	
	public void checkExist(){
		if(getY()<0){
			setExist(false);
		}
	}
}
