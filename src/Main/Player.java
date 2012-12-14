package Main;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends MoveObject {
	BulletsManager BulletsM;
	private BufferedImage Image;

	public Player(int x, int y, BufferedImage playerImage, Dimension GameDimension) {
		super(x, y,new Dimension(playerImage.getWidth(null),playerImage.getHeight(null)), GameDimension);

		setImage(playerImage);

		BulletsM=new BulletsManager();

	}
	
	public Image getImage() {
		return Image;
	}

	public void setImage(BufferedImage playerImage) {
		Image = playerImage;
	}
	
	public void setY(int y) {
		super.setY(y);
		if (getY() > getGameDimensionHeight() - getObjectDimensionHeight() / 2) {
			super.setY( getGameDimensionHeight() - getObjectDimensionHeight() / 2 );
		}
		if (getY() < 0 - getObjectDimensionHeight() / 2) {
			super.setY(0 - getObjectDimensionHeight() / 2);
		}
	}

	public void setX(int x) {
		super.setX(x);
		if (getX() > getGameDimensionWidth() - getObjectDimensionWidth() / 2 -2) {
			super.setX( getGameDimensionWidth() - getObjectDimensionWidth() / 2 -2);
		}
		if (getX() < 0 - getObjectDimensionWidth() / 2 ) {
			super.setX( 0 - getObjectDimensionWidth() / 2);
		}
	}

	public void move(int Direction) {
		//XXX
//		BulletsM.testOut();
//		this.testout();
	
		
		if (Direction == 4 || Direction == 1 || Direction == 7) {
			setX(getX() - 5);
		}
		if (Direction == 8 || Direction == 7 || Direction == 9) {
			setY(getY() - 5);
		}
		if (Direction == 2 || Direction == 1 || Direction == 3) {
			setY(getY() + 5);
		}
		if (Direction == 6 || Direction == 3 || Direction == 9) {
			setX(getX() + 5);
		}
	
		BulletsM.move();
	}
	
	public void testout(){
		System.out.println(getX()+","+getY());
		System.out.println(getObjectDimensionWidth()+","+getObjectDimensionHeight());
		System.out.println(getImage().getWidth(null)+","+getImage().getHeight(null));
		System.out.println("--------------------------------------");

	}
	
	
	public void checkExist() {
		BulletsM.checkExist();
	}

	public void shot(boolean ZPress) {
		if (ZPress) {
			Image image = getImage();
			//XXX
			BulletsM.add(new Bullet(getX() + image.getWidth(null) / 2, getY()));
		}
	}
	
	public void draw(Graphics Screen) {
		Screen.drawImage(Image, getX(), getY(),
				Image.getWidth(null), Image.getHeight(null), null);

		BulletsM.draw(Screen);
	}
	

}
