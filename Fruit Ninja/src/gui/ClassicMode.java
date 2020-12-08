package gui;

import java.io.File;
import java.util.ArrayList;
import control.*;
import control.GameState;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import gameobjects.Apple;
import gameobjects.DangerousBomb;
import gameobjects.FatalBomb;
import gameobjects.GameObject;
import gameobjects.GameObjectFactory;
import gameobjects.Mango;
import gameobjects.SpecialFruit;
import gameobjects.Watermelon;

public class ClassicMode extends BasicGameState{
	Image backGround;
	Image score1;
	Image gameOver;
	Image lives; 
	Image livesX;
	
	Sound s;
	Sound slice;
	Sound slice2;
	
	Image watermelon;
	Image strawberry;
	Image  apple;
	Image special;
	Image fatalBomb;
	Image dangerBomb;
	
	Image appleSlice;
	Image watermelonSlice;
	Image strawberrySlice;
	Image specialSlice;
	Image temp;
	StateJAXB state;
	GameControl gameControl;
	ArrayList<GameObject> gameObjects = new ArrayList<>();
	int counter=0;
	GameObjectFactory factory=new GameObjectFactory();
	GameState gameState = new GameState();
	ReadXml readXml;
	
	Image object1;
	Image objectSlice1;
	int randomNumber;
	ArrayList<String> fruits=new ArrayList<String>();
	Random rand = new Random();
	int xpos;
	int ypos;
	int bestScore;
	
	float shiftX=500;
	float shiftY=400;
	
	String mouse="";
	
	private Player player;
	
	public ClassicMode(int state) {
		
	}
	
	
	
	public void init (GameContainer gc,StateBasedGame sbg) throws SlickException{
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ReadXml.class);
			 state = new StateJAXB();
			state.readXML(jaxbContext);
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("error");
		}
		
		player=Player.getInstance();
		
		backGround = new Image("res/background.jpg");
		score1 = new Image("res/score.png");
		gameOver = new Image("res/GameOver.png");
		lives = new Image("res/lives.png");
		livesX = new Image("res/livesx.png");
		s = new Sound("res/start.wav");
		slice = new Sound("res/slice.wav");
		slice2 = new Sound("res/throw.wav");
		
		apple = new Image("res/apple.png");
		appleSlice = new Image("res/apple1.png");
		watermelon = new Image("res/watermelon.png");
		watermelonSlice = new Image("res/watermelon1.png");
		strawberry = new Image("res/strawberry.png");
		strawberrySlice = new Image("res/strawberry1.png");
		fatalBomb = new Image("res/boom.png");
		dangerBomb = new Image("res/bomb1.png");
		special = new Image("res/special.png");
		specialSlice = new Image("res/special1.png");
	
		
		fruits.add("apple");
		fruits.add("mango");
		fruits.add("watermelon");
		fruits.add("special fruit");
		fruits.add("fatal bomb");
		fruits.add("dangerous bomb");
		
		
		randomNumber = rand.nextInt(6);
		
		
		//n4eeha b3dean 
		gameControl=new GameControl(0);
		
		for(int i=0;i<10;i++) {
			randomNumber = rand.nextInt(6);
		    gameObjects.add(factory.create(fruits.get(randomNumber)));
		}
		/*
		if(gameObjects.get(counter) instanceof Apple) {
			object1=apple;
			objectSlice1=appleSlice;
		}
		if(gameObjects.get(counter) instanceof Watermelon) {
			object1=watermelon;
			objectSlice1=watermelonSlice;
		}
		if(gameObjects.get(counter) instanceof Mango) {
			object1=strawberry;
			objectSlice1=strawberrySlice;
		}
		if(gameObjects.get(counter) instanceof FatalBomb) {
			object1=fatalBomb;
			objectSlice1=fatalBomb;
		}
		if(gameObjects.get(counter) instanceof DangerousBomb) {
			object1=dangerBomb;
			objectSlice1=dangerBomb;
		}
		if(gameObjects.get(counter) instanceof SpecialFruit) {
			object1=special;
			objectSlice1=specialSlice;
		}
		
		*/
		
	}
	
	
	
	
	public void render(GameContainer gc,StateBasedGame sbg ,Graphics g) throws SlickException{
		backGround.draw(0,0,1200,800);
		if(player.getRemainingLives()==3) {
			lives.draw(30,30,60,60);
			lives.draw(95,30,60,60);
			lives.draw(160,30,60,60);
		}
		if(player.getRemainingLives()==2) {
			livesX.draw(30,30,60,60);
			lives.draw(95,30,60,60);
			lives.draw(160,30,60,60);
		}
		if(player.getRemainingLives()==1) {
			livesX.draw(30,30,60,60);
			livesX.draw(95,30,60,60);
			lives.draw(160,30,60,60);
		}
		if(player.getRemainingLives()==0) {
			livesX.draw(30,30,60,60);
			livesX.draw(95,30,60,60);
			livesX.draw(160,30,60,60);
			gameOver.draw(250,300,1.5f);
		}
		
		
		g.drawString(mouse,500,500);
		//object1.draw(shiftX,shiftY,50,50);
		
		gameObjects.get(counter).getImage().draw(shiftX,shiftY,50,50);
		
		bestScore=state.getList().get(state.getList().size()-1).getBest_score();
		g.scale(2f, 2f);
		g.drawString("Score: "+player.getCurrentScore()+" Best:"+bestScore,250, 10);
		
	}
	
	public boolean slice(Input input, int xpos,int ypos) throws SlickException {
		
if(input.isMousePressed(0) && shiftX+50>=xpos && shiftX<=xpos &&((((shiftY-646)+50>=ypos)||(shiftY-646)+50>=-ypos))&&(((shiftY-646)<=ypos)||(shiftY-646)<=-ypos)) {
			
			switch (gameObjects.get(counter).getImage().getResourceReference()) {
			case"res/apple.png":
				object1=appleSlice;
				player.setCurrentScore(player.getCurrentScore()+1);
 				break;
			case"res/watermelon.png":
				temp=object1;
				object1=watermelonSlice;
				player.setCurrentScore(player.getCurrentScore()+1);

				break;
			case"res/strawberry.png":
				temp=object1;
				object1=strawberrySlice;
				player.setCurrentScore(player.getCurrentScore()+1);

				break;
			case"res/special.png":
				temp=object1;
				object1=specialSlice;
				player.setCurrentScore(player.getCurrentScore()+5);

				break;
			case"res/boom.png":
				temp=object1;
				object1=fatalBomb;
				player.setRemainingLives(0);
				break;
			case"res/bomb1.png":
				temp=object1;
				object1=dangerBomb;
			    player.setRemainingLives(player.getRemainingLives()-1);;
				break;
			}
		
		return true;
}
return false;
	}
	
	public void update(GameContainer gc,StateBasedGame sbg,int delta) throws SlickException{
		s.play();
		Input input=gc.getInput();
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		mouse = "Mouse position x pos"+ shiftX +" y pos " + shiftY;
		
	
		shiftY+=0.3;
		shiftX-=0.3;
		
		if(shiftY<-1) {
			shiftY+=0.3;
		}
		
		if(shiftX<-1) {
			shiftX+=0.3;
		}
		
		if(shiftX>1150) {
			shiftX-=0.3;
		}
		
		//lama el sora tenzl ta7t el shasha
		if(shiftY>646) {
			if(slice(input,xpos,ypos)==false) {
			if(player.getRemainingLives()>0) {
			player.setRemainingLives(player.getRemainingLives()-1);
			shiftX=500;
			shiftY=400;
			
			}else {
				//save in file
				//constructor
				player.setRemainingLives(3);
				player.setCurrentScore(0);
				sbg.enterState(0,new FadeOutTransition(),new FadeInTransition());
			}
			}
			counter++;
		}
		
		/*if(input.isKeyDown(Input.KEY_UP)) {
			shiftY-= 1;
			if(shiftY<-1) {
				shiftY+= 1;
			}
		}
		if(input.isKeyDown(Input.KEY_DOWN)) {
			shiftY+= 1;
			if(shiftY>646) {
				shiftY-=1;
			}
		}
		if(input.isKeyDown(Input.KEY_LEFT)) {
			shiftX-= 1;
			if(shiftX<-1) {
				shiftX +=1;
			}
		}
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			shiftX+= 1;
			if(shiftX>1150) {
				shiftX-=1;
			}
		}
		*/
		/*
		if(input.isMousePressed(0) && shiftX+50>=xpos && shiftX<=xpos &&((((shiftY-646)+50>=ypos)||(shiftY-646)+50>=-ypos))&&(((shiftY-646)<=ypos)||(shiftY-646)<=-ypos)) {
			
			switch (gameObjects.get(counter).getImage().getResourceReference()) {
			case"res/apple.png":
				object1=appleSlice;
				player.setCurrentScore(player.getCurrentScore()+1);
 				break;
			case"res/watermelon.png":
				temp=object1;
				object1=watermelonSlice;
				player.setCurrentScore(player.getCurrentScore()+1);

				break;
			case"res/strawberry.png":
				temp=object1;
				object1=strawberrySlice;
				player.setCurrentScore(player.getCurrentScore()+1);

				break;
			case"res/special.png":
				temp=object1;
				object1=specialSlice;
				player.setCurrentScore(player.getCurrentScore()+5);

				break;
			case"res/boom.png":
				temp=object1;
				object1=fatalBomb;
				player.setRemainingLives(0);
				break;
			case"res/bomb1.png":
				temp=object1;
				object1=dangerBomb;
			    player.setRemainingLives(player.getRemainingLives()-1);;
				break;
			}
			//object1=temp;
			//System.out.println(object1.getResourceReference());
		} 
		*/
		s.stop();
		
	}

	public int getID() {
		return 1;
	}
  }