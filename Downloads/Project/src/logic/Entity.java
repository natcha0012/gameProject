package logic;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{
	protected double x,y;
	protected int z;
	protected boolean visible,destroyed;
	
	protected Entity() {
		visible = true;
		destroyed = false;
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public int getZ() {
		return z;
	}
	
}
