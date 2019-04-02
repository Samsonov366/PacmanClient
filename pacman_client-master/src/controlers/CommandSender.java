package controlers;
import client.*;

public class CommandSender implements InterfaceControler {

	private SocketClient cs;
	private boolean isInitialized;
	private String filename;
	public CommandSender(SocketClient cs) {
		super();
		this.cs = cs;
		this.isInitialized=false;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		if( isInitialized)
			cs.sendToStream("START");
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		if( isInitialized) {
			cs.sendToStream("RESTART");
			cs.sendToStream(filename);
			}
			
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		if( isInitialized)
			cs.sendToStream("STEP");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		if( isInitialized)
			cs.sendToStream("PAUSE");
	}

	public void setTime(double time) {
		if( isInitialized)
			cs.sendToStream("TIME : "+Double.toString(time));
	}

	public void setMap(String filename) {
		this.filename=filename;
		System.out.println(filename);
		cs.sendToStream("MAP");
		cs.sendToStream(filename);

		isInitialized=true;
	}

}
