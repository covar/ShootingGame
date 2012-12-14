package Main;
/*
  <applet code="main.class" width=500 height=500></applet>
 */

//java.applet�p�b�P�[�W��import�錾
//Graphics�N���X��awt�p�b�P�[�W�ɑ����Ă���̂�awt�p�b�P�[�W��import�錾
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controller.Controller;



//Applet�N���X���p��
public class main extends Applet implements Runnable, KeyListener {
	private final int GAME_HEIGHT = 500;
	private final int GAME_WIDTH = 500;
	
	private Controller Controller;

	Player ThePlayer;

	Thread thread = null;

	// ���C���[�W
	Image OffImage;
	// ���O���t�B�b�N
	Graphics OffGraphic;

	public void init() {

		// ���@�̐���
		try {
			ThePlayer = new Player(10, 10, ImageIO.read(new File("002.png")),new Dimension(GAME_WIDTH,GAME_HEIGHT));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Controller = new Controller();

		addKeyListener(this);
		// �C���[�W����
		OffImage = createImage(getWidth(), getHeight());
		// �O���t�B�b�N�R���e�L�X�g�擾
		OffGraphic = OffImage.getGraphics();

		
	}

	// �A�v���b�g���\�������ƌĂяo�����
	public void start() {
		System.out.println("start.");
		if (thread == null) {
			// �X���b�h�̐���
			thread = new Thread(this);
			// �X���b�h���J�n�����Arun���\�b�h���Ăяo��
			thread.start();
		}
	}

	// �A�v���b�g����ʂ��������ƌĂяo�����
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

	// ���C�����[�`��
	public void run() {
		// game loop
		while (thread != null) {

			// �I�t�X�N���[���̈�̏���
			clearBuffer(OffGraphic);


			ThePlayer.move(Controller.getStickDirection());
			
			ThePlayer.shot(Controller.isZPress());
			
			ThePlayer.checkExist();
			
			//System.out.println(Controller.isZPress());
			
			// �V��\��
			ThePlayer.draw(OffGraphic);

			// ��ʂ̋����X�V
			repaint();

			try {
				// 0.016�b��(��1�t���[��)�X���[�v�B�����Y���ƃn���O�A�b�v����
				Thread.sleep(17);
				Controller.incrementTime();

			} catch (InterruptedException e) {
			}
		}
	}

	// �I�[�o�[���C�h���čŒ���̂��Ƃ���������
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