package render.core;

import image.Texture;

public class WorldMap {
	public static Texture DEFAULT_FLOOR = new Texture("assets/textures/floor32.png",32,32);
	public static Texture DEFAULT_CEILING = new Texture("assets/textures/ceil32.png",32,32);
	
	private Block[][] blocks;
	private Texture[][] floorMap;
	private Texture[][] ceilMap;
	
	public WorldMap(Block[][] _blocks) {
		blocks = _blocks;
		floorMap = new Texture[blocks.length][blocks[0].length];
		ceilMap = new Texture[blocks.length][blocks[0].length];
	}
	
	public Block getBlockAt(int x, int y) {
		return blocks[y][x];
	}
	
}
