package cluedo.assets;

import java.awt.Color;
import java.awt.Graphics;

public class DoorTile extends Tile{
	private Door door;
	
	public DoorTile(int x, int y, Door d) {
		super(x, y);
		this.door = d;
	}
	
	public Door getDoor(){
		return this.door;
	}
	
	public void draw(Graphics g){
		g.setColor(new Color(0, 179, 89));
		g.fillRect(super.xLoc, super.yLoc, super.size, super.size);
		g.drawString(door.getString(), super.xLoc + super.size/2, super.yLoc + super.size/2);
	}
}