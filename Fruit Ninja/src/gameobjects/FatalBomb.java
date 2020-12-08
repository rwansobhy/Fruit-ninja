package gameobjects;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FatalBomb extends GameObject {
	Random rand= new Random();
	Image fatalBomb;
	
	public FatalBomb() throws SlickException {
		this.fatalBomb = new Image("res/boom.png");
	}
	
	public Image getImage() throws SlickException {
		return fatalBomb;
	}
	
	@Override
	public void getType() {
	}
	//get x location of fatalbomb 
	@Override
	public int getXlocation() {
		
		return rand.nextInt(400);
	}
	//get y location of fatalbomb
	@Override
	public int getYlocation() {
		
		return rand.nextInt(600);
	}
	@Override
	public Boolean isSliced(int x, int y) {
		  if(x==getXlocation()&& y==getYlocation())
		  { 
			  
		  return true; } 
		  else {

             
		  return false;
		  }
	}

	public Image getImageSlice() throws SlickException {
		return null;
	}
}
	


