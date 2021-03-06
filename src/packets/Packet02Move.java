package packets;

import server.GameClient;
import server.GameServer;

public class Packet02Move extends Packet{

	private String username;
	private String color;
	private int x,y, direction;
	
	public Packet02Move(byte[] data){
		super(02);
		String[] dataArray = readData(data).split(" ");
		this.username = dataArray[1];
		this.color = dataArray[2];
		this.x = Integer.parseInt(dataArray[3]);
		this.y = Integer.parseInt(dataArray[4]);
		this.direction = Integer.parseInt(dataArray[5]);
	}
	public Packet02Move(String username,String color,int x,int y, int direction){
		super(02);
		this.username = username;
		this.color = color;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	@Override
	public void writeData(GameClient client) {
		client.sendData(getData());
		
	}
	@Override
	public void writeData(GameServer server) {
		server.sendDataToAllClients(getData());
		
	}
	@Override
	public byte[] getData() {
		return ("02" +" " + this.username +" " + this.color + " " + this.x + " " + this.y+" "+this.direction).getBytes();
	}
	
	public String getUsername(){
		return username;
	}
	public String getColor(){
		return color;
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getDirection() {
		return this.direction;
	}
}
