package render.core;

import image.Texture;

/**
 * Represents a 1x1 space in a world map. Can be either a full block or a custom "sector" containing custom Walls.
 *
 * @author Joe Desmond
 */
public class Block {
	public static final Texture DEFAULT_TEXTURE = new Texture("assets/textures/default32.png",32,32);
	public static final Block SPACE = new Block("space").fakeBlock();
	
	public Wall[] walls = null;
	private boolean solid = true;
	public String name;
	public Texture frontTexture = DEFAULT_TEXTURE;
	public Texture sideTexture = DEFAULT_TEXTURE;
	
	public Block(String _name) {
		name = _name;
	}
	
	/**
	 * Allows a Block to be rendered as a group of custom Walls defined relative to block space
	 * instead of a default block. If solid, collision will still occur with block boundaries.
	 * 
	 * @param _walls varArgs parameter: can be a Wall[] or any number of Walls
	 * @return this Block
	 */
	public Block customize(Wall ... _walls) {
		walls = _walls;
		return this;
	}
	
	/**
	 * Makes this block non-solid.
	 */
	public Block fakeBlock() {
		solid = false;
		return this;
	}
	
	public void solidify() {
		solid = true;
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public boolean isCustom() {
		return walls != null;
	}
	
	public Block applyFrontTexture(Texture front) {
		frontTexture = front;
		return this;
	}
	
	public Block applySideTexture(Texture side) {
		sideTexture = side;
		return this;
	}
	
	public Block applyTexture(Texture texture) {
		frontTexture = texture;
		sideTexture = texture;
		return this;
	}
}
