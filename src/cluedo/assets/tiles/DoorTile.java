package cluedo.assets.tiles;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import cluedo.assets.Door;
import cluedo.assets.Player;

public class DoorTile extends Tile{
	private Door door;
	private String direction;
	private Player player = null;
	
	public DoorTile(int x, int y, Door d, String dir) {
		super(x, y);
		this.door = d;
		this.direction = dir;
	}
	
	public Door getDoor(){
		return this.door;
	}
	
	public void setPlayer(Player p){
		this.player = p;
	}
	
	public void draw(Graphics g){
		/*g.setColor(new Color(255, 255, 153, 0));
		g.fillRect(super.xLoc, super.yLoc, super.TILESIZE, super.TILESIZE);
		g.setColor(new Color(0, 0, 0, 0));
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		if(this.direction != null){
			switch(this.direction){
			case "right":
				g.drawLine(super.xLoc+TILESIZE, super.yLoc, super.xLoc+TILESIZE, super.yLoc+TILESIZE);
				break;
			case "left":
				g.drawLine(super.xLoc, super.yLoc, super.xLoc, super.yLoc+TILESIZE);
				break;
			case "top":
				g.drawLine(super.xLoc, super.yLoc, super.xLoc+TILESIZE, super.yLoc);
				break;
			case "bottom":
				g.drawLine(super.xLoc, super.yLoc+TILESIZE, super.xLoc+TILESIZE, super.yLoc+TILESIZE);
				break;
			}
		}
		g2.setStroke(new BasicStroke(0));
		*/
		if(this.player  != null){
			g.setColor(this.player.getCharacter().getColor());
			g.drawOval(super.xLoc, super.yLoc, super.TILESIZE, super.TILESIZE);
		}
	}
}