package controlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Maze;
import client.SocketClient;
import view.ViewGame;

public class KeyCommandSender implements KeyListener{

	private SocketClient cs;
	
	public KeyCommandSender(SocketClient c) {
		this.cs=c;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case 37:
			cs.sendToStream("LEFT");
			System.out.println("LEFT");
			break;
		case 38:
			cs.sendToStream("UP");
			System.out.println("UP");
			break;
		case 39:
			cs.sendToStream("RIGHT");
			System.out.println("RIGHT");
			break;
		case 40:
			cs.sendToStream("DOWN");
			System.out.println("DOWN");
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
