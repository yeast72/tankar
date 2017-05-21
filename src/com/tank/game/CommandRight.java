package com.tank.game;

public class CommandRight implements Command {
	
	private int position;
	
	public CommandRight(int position) {
		this.position = position;
	}

	@Override
	public int execute() {
		position += 1;
		if(position > Window.width - Tank.image.getWidth()) position = Window.width-Tank.image.getWidth();
		return position;
	}

}