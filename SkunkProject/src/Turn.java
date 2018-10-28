

public class Turn {
	
	private Roll mRoll;
	private ISkunkUi Ui;
	private int startingScore;
	private int turnScore = 0;
	private int chipNumber;
	boolean turnDone = false;
	
	
	public Turn(ISkunkUi Ui, int startingTurnScore) {
		this.Ui = Ui;
		this.startingScore = startingTurnScore;
		mRoll = new Roll();
	}
	
	public void go() {
		boolean rollAgain;
		
		rollAgain = Ui.rollPrompt();
		
		while (rollAgain) {
			mRoll.shakeDie();
			
			boolean skunkRolled = handleShake(mRoll);
			
			int playerTurnScore = startingScore + turnScore;
			Ui.displayRollInfo(mRoll.getRoll(), playerTurnScore);
			
			if(skunkRolled) {
				rollAgain = false;
			} else {
				rollAgain = Ui.rollPrompt();
			}
		}
	}

	public boolean handleShake(Roll roll) {
		boolean turnDone = false;
		SkunkRoll rollResult = roll.getRoll();
		
		switch(rollResult) {
			case SKUNK:
				chipNumber = 1;
				turnScore = 0;
				turnDone = true;
				break;
			case DOUBLE_SKUNK:
				chipNumber = 4;
				turnScore = -1;
				turnDone = true;
				break;
			case SKUNK_DEUCE:
				chipNumber = 2;
				turnScore = 0;
				turnDone = true;
				break;
			default:
				
				int rollValue = roll.getRollValue();
				turnScore += rollValue;
				chipNumber = 0;
		}
		
		return turnDone;
		
	}

	public int getTotalChips() {
		
		return chipNumber;
	}

	public int getScore() {

		return turnScore;
	}

	public Roll getRoll() {
		return mRoll;
	}

}
