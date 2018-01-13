package model;

import java.util.ArrayList;


//http://code.makery.ch/library/javafx-8-tutorial/part2/
	// this is a guide to help

public class CreateModel<E> {
	
	
	
	/// USE for undo and redo stck or hashmap
	
	
	
	/**
	 * The top line string of this meme
	 */
	private String topText;
	
	/**
	 * The bottom line string of this meme
	 */
	private String bottomText;
	
	/**
	 * The arrayList to hold the blank memes
	 */
	private ArrayList<E> memesBlank;
	
	/**
	 * The arrayList of completes memes
	 */
	private ArrayList<E> memesDone;
	
	/**
	 * The name of the creator(player)
	 */
	private String creator;
	
	
	/**
	 * Constructs a an arrayList of memes
	 */
	public CreateModel() {
		this.memesBlank = new ArrayList<E>();
	}
	
	/**
	 * Returns the top line of this meme
	 * @return The top text of this meme
	 */
	public String getTopText() {
		return this.topText;
	}
	
	/**
	 * Changes the top line of this meme
	 * @param topText The top line of this meme
	 */
	public void setTopText(String topText) {
		this.topText = topText;
	}
	
	/**
	 * Adds a generic type of line to the top of the meme
	 * @param meme The top line of this meme
	 */
	public void addTopText(E meme) {
		this.memesBlank.add(meme);
	}
	
	/**
	 * Deletes a generic type of line to the top of the meme 
	 * @param meme The top line of this meme
	 */
	public void removeTopText(E meme) {
		this.memesBlank.remove(meme);
	}
	
	/**
	 * Returns a String type of the bottom line of the meme
	 * @return The bottom line of this meme
	 */
	public String getBottomText() {
		return this.bottomText;
	}
	
	/**
	 * Changes the bottom line of this meme
	 * @param bottomText The bottom line of this meme
	 */
	public void setBottomText(String bottomText) {
		this.bottomText = bottomText;
	}
	
	/**
	 * Inserts a generic type of a bottom line of the meme
	 * @param meme The meme image
	 */
	public void addBottomText(E meme) {
		this.memesBlank.add(meme);
	}
	
	/**
	 * Deletes a generic type of a bottom line of the meme
	 * @param meme
	 */
	public void removeBottomText(E meme) {
		this.memesBlank.remove(meme);
	}
	
	/**
	 * The name of the creator of meme
	 * @return
	 */
	public String getCreator() {
		return this.creator;
	}
	
	//public Image loadImage(File)
	
		
}
