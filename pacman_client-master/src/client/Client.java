package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.Maze;
import controlers.CommandReceiver;
import controlers.CommandSender;
import controlers.KeyCommandSender;
import view.ViewCommand;
import view.ViewGame;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SocketClient c = new SocketClient(2000,"localhost");
			
			Scanner clavier = new Scanner(System.in);
			
			DataInputStream in = new DataInputStream(c.getEntree());
			DataOutputStream out = new DataOutputStream(c.getSortie());
			
			System.out.println(in.readUTF());
			//out.writeUTF(clavier.nextLine());
			
			//System.out.println(in.readUTF());
			//out.writeUTF(clavier.nextLine());
			
			Boolean connectionOk = in.readBoolean();
			
			if(connectionOk) {
				CommandSender commands= new CommandSender(c);
				
				ViewGame vg= null;

				Thread t= new Thread(new CommandReceiver(c,vg));

				t.start();

				ViewCommand v= new ViewCommand(commands);
				
				
				v.showWindow();
				
			}else {
				System.out.println("Problème connection");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
