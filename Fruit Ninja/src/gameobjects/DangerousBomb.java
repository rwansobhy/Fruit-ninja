package gameobjects;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DangerousBomb extends GameObject{
	Random rand =new Random();
	Image dangerBomb;
	
	public DangerousBomb () throws SlickException {
		this.dangerBomb = new Image("res/bomb1.png");
	}
	
	
	public Image getImage() throws SlickException {
		return dangerBomb;
	}
	
	//get x location of dangerous bomb 
	@Override
	public int getXlocation() {
		
		return rand.nextInt(400);
	}
	//get y location of dangerous bomb
	@Override
	public int getYlocation() {
		
		return rand.nextInt(600);
	}
	

	@Override
	public void getType() {
		// TODO Auto-generated method stub
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
