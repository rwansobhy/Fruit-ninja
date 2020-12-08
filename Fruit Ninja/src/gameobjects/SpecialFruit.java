package gameobjects;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpecialFruit extends GameObject {
	Random rand=new Random();	
	Image special;
	Image specialSlice;
	public SpecialFruit() throws SlickException {
		this.special = new Image("res/special.png");
		this.specialSlice = new Image("res/special1.png");
	}
	
	public Image getImage() throws SlickException {
		return special;
	}
	
	@Override
	public void getType() {
		
		System.out.println("Special Fruit");
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
		return specialSlice;
	}
}
