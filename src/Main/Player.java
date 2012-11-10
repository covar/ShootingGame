package Main;
import java.awt.*;
import java.util.ArrayList;

public class Player {
	private Dimension GameDimension;
	private int x, y;
	private Image PlayerImage;
	private BulletsManager BulletsM;

	public Player(int x, int y, Image playerImage, Dimension GameDimension) {
		super();
		this.x = x;
		this.y = y;

		setPlayerImage(playerImage);
		this.GameDimension = GameDimension;
		
		BulletsM=new BulletsManager();

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		Image image = getPlayerImage();
		if (getY() > GameDimension.height - image.getHeight(null) / 2) {
			this.y = GameDimension.height - image.getHeight(null) / 2;
		}
		if (getY() < 0 - image.getHeight(null) / 2) {
			this.y = 0 - image.getHeight(null) / 2;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		Image image = getPlayerImage();
		if (getX() > GameDimension.width - image.getWidth(null) / 2) {
			this.x = GameDimension.width - image.getWidth(null) / 2;
		}
		if (getX() < 0 - image.getWidth(null) / 2) {
			this.x = 0 - image.getWidth(null) / 2;
		}
	}

	// player move
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
	
	public void checkExist(){
		BulletsM.checkExist();
	}

	public void shot(boolean ZPress) {
		if (ZPress) {
			Image image = getPlayerImage();
			//XXX
			BulletsM.add(new Bullet(getX() + image.getWidth(null) / 2, getY()));
		}
	}

	public Image getPlayerImage() {
		return PlayerImage;
	}

	
	public void setPlayerImage(Image playerImage) {
		PlayerImage = playerImage;
	}

	public void drawPlayer(Graphics Screen) {
		Screen.drawImage(PlayerImage, getX(), getY(),
				PlayerImage.getWidth(null), PlayerImage.getHeight(null), null);
		BulletsM.draw(Screen);
	}

}
