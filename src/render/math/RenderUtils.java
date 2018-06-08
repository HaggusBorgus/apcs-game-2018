package render.math;

import render.core.Wall;

/**
 * This class holds utility methods for rendering and other stuff.
 * 
 * @author Joe Desmond
 */
public class RenderUtils {
	
	/**
	 * This class is meant as a utility class; it holds only static utility methods.
	 * I don't want people creating instances of it.
	 */
	private RenderUtils() {
		throw new RuntimeException("don't you dare try to create a RenderUtils object");
	}
	
	/**
	 * Calculates the position where a ray intersects a Wall. Returns null if it doesn't.
	 * 
	 * @param rayStart ray endpoint
	 * @param rayDirection and point determining the direction of the ray
	 * @param segment a Wall
	 * @return point where the ray hits the Wall, or null
	 */
	public static Vector2 rayHitSegment(Vector2 rayStart, Vector2 rayDirection, Wall segment) {
		Vector2 r0 = rayStart;
		Vector2 r1 = rayDirection;
		Vector2 a = segment.v0;
		Vector2 b = segment.v1;
		
		Vector2 s1,s2;
		s1 = new Vector2(r1.x-r0.x,r1.y-r0.y);
		s2 = new Vector2(b.x-a.x,b.y-a.y);
		  
		float s,t;
		s = (-s1.y * (r0.x - a.x) + s1.x * (r0.y - a.y)) / (-s2.x * s1.y + s1.x * s2.y);
		t = (s2.x * (r0.y - a.y) - s2.y * (r0.x - a.x)) / (-s2.x * s1.y + s1.x * s2.y);
		  
		if (s >= 0 && s <= 1 && t >= 0) {
		  return new Vector2(r0.x + (t * s1.x), r0.y + (t * s1.y));
		}
		return null;
	}
}
