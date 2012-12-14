package Main;
/*
  <applet code="main.class" width=500 height=500></applet>
 */

//java.appletパッケージをimport宣言
//Graphicsクラスはawtパッケージに属しているのでawtパッケージもimport宣言
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controller.Controller;



//Appletクラスを継承
public class main extends Applet implements Runnable, KeyListener {
	private final int GAME_HEIGHT = 500;
	private final int GAME_WIDTH = 500;
	
	private Controller Controller;

	Player ThePlayer;

	Thread thread = null;

	// 裏イメージ
	Image OffImage;
	// 裏グラフィック
	Graphics OffGraphic;

	public void init() {

		// 自機の生成
		try {
			ThePlayer = new Player(10, 10, ImageIO.read(new File("002.png")),new Dimension(GAME_WIDTH,GAME_HEIGHT));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Controller = new Controller();

		addKeyListener(this);
		// イメージ生成
		OffImage = createImage(getWidth(), getHeight());
		// グラフィックコンテキスト取得
		OffGraphic = OffImage.getGraphics();

		
	}

	// アプレットが表示されると呼び出される
	public void start() {
		System.out.println("start.");
		if (thread == null) {
			// スレッドの生成
			thread = new Thread(this);
			// スレッドを開始させ、runメソッドを呼び出す
			thread.start();
		}
	}

	// アプレットが画面から消えると呼び出される
	public void stop() {
		System.out.println("stop.");
		if (thread != null) {
			thread = null;
		}
	}

	public void clearBuffer(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	// メインルーチン
	public void run() {
		// game loop
		while (thread != null) {

			// オフスクリーン領域の消去
			clearBuffer(OffGraphic);


			ThePlayer.move(Controller.getStickDirection());
			
			ThePlayer.shot(Controller.isZPress());
			
			ThePlayer.checkExist();
			
			//System.out.println(Controller.isZPress());
			
			// 新城表示
			ThePlayer.draw(OffGraphic);

			// 画面の強制更新
			repaint();

			try {
				// 0.016秒間(約1フレーム)スリープ。これを忘れるとハングアップする
				Thread.sleep(17);
				Controller.incrementTime();

			} catch (InterruptedException e) {
			}
		}
	}

	// オーバーライドして最低限のことだけをする
	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		g.drawImage(OffImage, 0, 0, this);
	}

	public void keyPressed(KeyEvent e) {
		Controller.keyPressed(e);


	}

	public void keyReleased(KeyEvent e) {
		Controller.keyReleased(e);
	}

	public void keyTyped(KeyEvent e) {
	}

}