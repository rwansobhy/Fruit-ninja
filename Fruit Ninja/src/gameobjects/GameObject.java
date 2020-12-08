package gameobjects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class GameObject {
    public abstract void getType();
	public abstract int getXlocation();
	public abstract int getYlocation();
	public abstract Boolean isSliced(int x , int y );
	public abstract Image getImage () throws SlickException;
	public abstract Image getImageSlice () throws SlickException;
}
