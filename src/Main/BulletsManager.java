package Main;
import java.awt.Graphics;
import java.util.ArrayList;


public class BulletsManager implements MoveObjectManager{
	private ArrayList<Bullet> Bullets;

	public BulletsManager() {
		super();
		Bullets = new ArrayList<Bullet>();
	}
	
	public void add(Bullet bullet){
		Bullets.add(bullet);
	}

	public void move(){
		Bullet Temp;
		for (int i = 0; i < Bullets.size(); i++) {
			Temp = Bullets.get(i);
			Temp.move();
		}		
	}
	
	public void testOut(){
		for (int i = 0; i < Bullets.size(); i++) {
			System.out.print(i+",");
		}
		System.out.println();
	}

	
	public void checkExist(){
		Bullet Temp;
		for (int i = 0; i < Bullets.size(); i++) {
			Temp = Bullets.get(i);
			if( Temp.isOut() ){
				Bullets.remove(i);
			}
		}
	}

	public void draw(Graphics Screen){
		Bullet Temp;
		for (int i = 0; i < Bullets.size(); i++) {
			Temp = Bullets.get(i);
			Temp.paint(Screen);
		}

	}
	

}
