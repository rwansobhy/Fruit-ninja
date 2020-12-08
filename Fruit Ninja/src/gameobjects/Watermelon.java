package gameobjects;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Watermelon extends GameObject {
	Random rand=new Random();	
	Image watermelon;
	Image watermelonSlice;
	
	public Watermelon() throws SlickException {
		this.watermelon = new Image("res/watermelon.png");
		this.watermelonSlice = new Image("res/watermelon1.png");
	}
	
	public Image getImage() throws SlickException {
		return watermelon;
	}
	
	@Override
	public void getType() {
		
		System.out.println("Watermelon");
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
		   return true;
		 }
	 else 
	 { 
	     return false ;
		 
	 }
		
	}

	public Image getImageSlice() throws SlickException {
		return watermelonSlice;
	}
}
