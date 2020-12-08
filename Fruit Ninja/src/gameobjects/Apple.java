package gameobjects;


import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Apple extends GameObject {
	Random rand=new Random();
	Image apple;
	Image appleSlice;
	
	public Apple() throws SlickException {
		this.apple=new Image("res/apple.png");
		this.appleSlice = new Image("res/apple1.png");
	}
	
	@Override
	public void getType() {
		
		System.out.println("Apple");
	}
	//get x location of fruit 
	@Override
	public int getXlocation() {
		
		return rand.nextInt(400);
	}
	//get y location of fruit 
	@Override
	public int getYlocation() {
		
		return rand.nextInt(600);
	}
	//checking whether fruit is sliced or not 
	@Override
	public Boolean isSliced(int x ,int y ) {
		
		  if(x==getXlocation()&& y==getYlocation())
		  { 
			  
		  return true; } 
		  else {

             
		  return false;
		  }
		 

		
	}
	
	
	public Image getImage() throws SlickException {
		return apple;
	}

	public Image getImageSlice() throws SlickException {
		return appleSlice;
	}
	
}
