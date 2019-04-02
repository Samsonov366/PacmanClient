package controlers;


import java.io.IOException;
import java.io.ObjectInputStream;

import Model.Maze;
import client.SocketClient;
import view.ViewGame;

public class CommandReceiver implements Runnable{

	private SocketClient cs;
	private ViewGame vg;


	public CommandReceiver(SocketClient c, ViewGame v) {
		this.cs=c;
		this.vg=v;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		String ch="";
		while( !cs.getSocket().isClosed()) {
			
			try {
				
				ObjectInputStream ois = new ObjectInputStream(cs.getEntree());
				
				System.out.println("Waiting for maze");
				
				Maze newMaze = (Maze)ois.readObject();
				
				if( vg != null)
					vg.update(newMaze);
				else {
					KeyCommandSender key= new KeyCommandSender(cs);
					vg= new ViewGame(newMaze, key);
					vg.showWindow();
				}
				
				System.out.println(" Maze received");
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Data sent is not serializable");
				break;
			}
		}

		
	}
}

