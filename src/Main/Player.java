package Main;
import java.awt.*;
import java.util.ArrayList;

public class Player extends MoveObject {
	BulletsManager BulletsM;
	private Image Image;

	public Player(int x, int y, Image playerImage, Dimension GameDimension) {
		super(x, y,new Dimension(playerImage.getWidth(null),playerImage.getHeight(null)), GameDimension);
		setImage(playerImage);
		
		BulletsM=new BulletsManager();

	}
	
	public Image getImage() {
		return Image;
	}

	public void setImage(Image playerImage) {
		Image = playerImage;
	}
	
	public void move(int Direction) {
		//XXX
		//testOut();
	
		
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
