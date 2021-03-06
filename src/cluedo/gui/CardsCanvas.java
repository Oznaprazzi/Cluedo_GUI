package cluedo.gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.List;

import cluedo.assets.Player;
import cluedo.cards.Card;
import cluedo.cards.CharacterCard;
import cluedo.cards.RoomCard;
import cluedo.cards.WeaponCard;
import cluedo.main.CluedoGameController;

/**
 * Canvas used to display the cards that a current Player has.
 * This is drawn on an attached JFrame.
 * @author Casey and Linus
 *
 */
public class CardsCanvas extends Canvas{
	/**
	 * List of cards to display on the canvas.
	 */
	private List<Card> cards;
	public boolean hasbeenPainted = false;
	private int index_R = 0;
	private int index_W = 0;
	private int index_C = 0;
	
	/**
	 * x position of cards to be drawn.
	 */
	protected static final int X_OFFSET = 5;
	
	/**
	 * Y position of character card.
	 */
	private static final int Y_CHAR_OFFSET = 350;
	
	/**
	 * Y position of room card.
	 */
	private static final int Y_ROOM_OFFSET = 57+Card.CARD_HT;
	
	/**
	 * Y position of weapon card.
	 */
	private static final int Y_WEP_OFFSET = 37;
	

	public CardsCanvas(List<Card> cards){
		this.cards = cards;
		hasbeenPainted = false;
	}

	@Override
	public void paint(Graphics g){
		g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		g.drawString("Cards in hand:", 5, 15);
		g.drawString("Weapons:", 5, 27);
		g.drawString("Rooms:", 5, 2*Card.CARD_HT);
		g.drawString("Characters: " , 5, (3*Card.CARD_HT));
		this.drawCards();
	}

	public void drawCards(){
		for(int i = 0; i < cards.size(); i++){
			Card c = cards.get(i);
			if(c instanceof RoomCard){
				((RoomCard)c).draw(this.getGraphics(), index_R, Y_ROOM_OFFSET, X_OFFSET);
				index_R++;
			}else if(c instanceof WeaponCard){
				((WeaponCard)c).draw(this.getGraphics(), index_W, Y_WEP_OFFSET, X_OFFSET);
				index_W++;
			}else if(c instanceof CharacterCard){
				((CharacterCard)c).draw(this.getGraphics(), index_C, Y_CHAR_OFFSET, X_OFFSET);
				index_C++;
			}
		}
		index_R = 0;
		index_W = 0;
		index_C = 0;
	}
}
