package Main;

import java.awt.Graphics;

public interface MoveObjectManager {
	public void add(Bullet bullet);
	public void move();
	public void checkExist();
	public void draw(Graphics Screen);

}
