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

	public int getObjectDimensionHeight() {
		return ObjectDimension.height;
	}

	public int getObjectDimensionWidth() {
		return ObjectDimension.width;
	}

	public int getGameDimensionHeight() {
		return GameDimension.height;
	}

	public int getGameDimensionWidth() {
		return GameDimension.width;
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
	

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public boolean isExist() {
		return Exist;
	}

	public void setExist(boolean exist) {
		Exist = exist;
	}
	
	public boolean isOut(){
		if( (getX() > GameDimension.width - ObjectDimension.width / 2) 
		 || (getX() < 0 - ObjectDimension.width / 2) 
		 || (getY() > GameDimension.height - ObjectDimension.height / 2) 
		 || (getY() < 0 - ObjectDimension.height / 2) ){
			return true;
		}
		return false;
	}

	
	public void move(){}

	public void draw(Graphics Screen) {}

}