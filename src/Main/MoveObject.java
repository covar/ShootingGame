package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class MoveObject {

	private Dimension GameDimension;
	private Dimension ObjectDimension;
	private int X;
	private int Y;
	private boolean Exist;

	public MoveObject(int x, int y,Dimension objectDimension, Dimension GameDimension) {
		super();
		
		setObjectDimension(objectDimension);
		setGameDimension(GameDimension);
		setX(x);
		setY(y);
		setExist(true);
	}

	public Dimension getObjectDimension() {
		return ObjectDimension;
	}

	public void setObjectDimension(Dimension objectDimension) {
		ObjectDimension = objectDimension;
	}

	public Dimension getGameDimension() {
		return GameDimension;
	}

	public void setGameDimension(Dimension gameDimension) {
		GameDimension = gameDimension;
	}
	
	public int getY() {
		return Y;
	}

	public void setY(int y) {
		this.Y = y;
		if (getY() > GameDimension.height - ObjectDimension.height / 2) {
			this.Y = GameDimension.height - ObjectDimension.height / 2;
		}
		if (getY() < 0 - ObjectDimension.height / 2) {
			this.Y = 0 - ObjectDimension.height / 2;
		}
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		this.X = x;
		if (getX() > GameDimension.width - ObjectDimension.width / 2) {
			this.X = GameDimension.width - ObjectDimension.width / 2;
		}
		if (getX() < 0 - ObjectDimension.width / 2) {
			this.X = 0 - ObjectDimension.width / 2;
		}
	}

	public boolean isExist() {
		return Exist;
	}

	public void setExist(boolean exist) {
		Exist = exist;
	}

	
	public void move(){}

	public void draw(Graphics Screen) {}

}