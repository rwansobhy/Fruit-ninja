package control;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.SlickException;

import gameobjects.Apple;
import gameobjects.DangerousBomb;
import gameobjects.FatalBomb;
import gameobjects.GameObject;
import gameobjects.GameObjectFactory;
import gameobjects.Mango;
import gameobjects.SpecialFruit;
import gameobjects.Watermelon;

public class GameControl{
	
private GameState gameState;

private ArrayList<GameState> checkpoint;
private Boolean sliced=false;
private ReadXml readXml=new ReadXml();
private GameObjectFactory gameFactory;
private int difficulty;
private int speedMin;
private int speedMax;
private int difficultyIterator;
private ArrayList <GameObject> gameObj;
private Player player;


public GameControl(int difficulty) {
	this.player=player.getInstance();
	this.difficulty=difficulty;
}


public void randomizeGameObjects()
{
	if(difficulty==0)
	{
		speedMin=3;
		speedMax=5;
		difficultyIterator=3;
		//Statics.arcade=false;
	}
	else if(difficulty==1)
	{
		speedMin=5;
		speedMax=6;
		difficultyIterator=4;
		//Statics.arcade=false;
	}
	else if(difficulty==2)
	{
		speedMin=6;
		speedMax=8;
		difficultyIterator=5;
		//Statics.arcade=false;
	}
	else if(difficulty==3)
	{
		speedMin=7;
		speedMax=9;
		difficultyIterator=5;
		//Statics.arcade=true;
		//player.setLives(0);
	}
	
	

}


public GameControl() {
	
	gameState=new GameState();
	checkpoint=new ArrayList<>();
}


public ArrayList<GameState> getCheckpoint() {
	return checkpoint;
}


public void setCheckpoint(ArrayList<GameState> checkpoint) {
	this.checkpoint = checkpoint;
}

/*
public void slice() throws SlickException
{     
	GameObject apple = new Apple();

GameObject mango = new Mango();
 GameObject watermelon = new Watermelon();
 GameObject fatalBomb=new FatalBomb();
 GameObject dangerousBomb=new DangerousBomb();
 GameObject specialFruit= new SpecialFruit();
	if(apple.isSliced(apple.getXlocation(), apple.getYlocation())==true || mango.isSliced(mango.getXlocation(), mango.getYlocation())==true || watermelon.isSliced(watermelon.getXlocation(), watermelon.getYlocation())==true) 
	{
		gameState.setCurrent_score(gameState.getCurrent_score()+5);
	    this.sliced=true;
	}
	else if(specialFruit.isSliced(specialFruit.getXlocation(), specialFruit.getYlocation())==true)
	{
		this.sliced=true;
		gameState.setCurrent_score(gameState.getCurrent_score()+10);
	}
	else if (sliced==false ||dangerousBomb.isSliced(dangerousBomb.getXlocation(), dangerousBomb.getYlocation())==true)
	gameState.setRemaining_lives(gameState.getRemainingLives()-1);
	else if (fatalBomb.isSliced(fatalBomb.getXlocation(), fatalBomb.getYlocation())==true)
	gameState.setRemaining_lives(0);
	 
			  
		}
*/
		
   public boolean hasWon() { 
			 int max =0;
			 boolean winningStatue;
			    for(int i=0; i<readXml.getGameList().size(); i++){
			        if(readXml.getGameList().get(i).getBest_score() > max){
			            max =readXml.getGameList().get(i).getBest_score();
			        }       
		     }
			    if(max>player.getCurrentScore())
		        	winningStatue=true;
		        else
		        	winningStatue=false;
			    return winningStatue;
		 }
		 
		 
		 
	
	

public void addMemento(GameState s)
{
	checkpoint.add(s);
	
}


public GameState getGameState(int index) {
	return checkpoint.get(index);
}


public Player getPlayer() {
	return player;
}


public void setPlayer(Player player) {
	this.player = player;
}





}