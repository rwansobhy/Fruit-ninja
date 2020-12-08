package states;

public class DifficultyContext {
	private String difficulty;
	private DifficultyState difficultyState;
	public DifficultyContext(String difficulty) {
		
		this.setDifficulty(difficulty); 
	}
	public void increaseSpeed()
	{
		difficultyState.increaseSpeed(0);
	}
	public void increaseNumberOfFruit()
	{
		difficultyState.increaseNumberOfFruit();
	}
	public void increaseNumberOfBombs()
	{
		difficultyState.increaseNumberOfBombs();
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
		if(difficulty.equalsIgnoreCase("Easy"))
		{
			difficultyState=new Easy();
		}
		else if(difficulty.equalsIgnoreCase("Medium"))
		{
			difficultyState=new Medium();
			
		}
		else
		{
			difficultyState=new Hard();
		}
		
		    
	}


}
