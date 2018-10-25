
public class Turn {
	
	private ISkunkUi Ui;
	private int startingScore;
	private int turnScore = 0;
	
	
	public Turn(ISkunkUi Ui, int startingTurnScore) {
		this.Ui = Ui;
		this.startingScore = startingTurnScore;
	}
	
	public void go() {
		Roll roll = new Roll();
		boolean rollAgain;
		
		rollAgain = Ui.rollPrompt();
		
		while (rollAgain) {
			roll.shakeDie();
			
			handleShake();
		}
	}

	private void handleShake() {
		
	}
}
