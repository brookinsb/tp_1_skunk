
public class Roll {

	private Die die1;
	private Die die2;
	private int lastDie1Value;
	private int lastDie2Value;
	
	public Roll() {
		die1 = new Die();
		die2 = new Die();
	}

	public void takeRoll() {

		die1.roll();
		die2.roll();
		
		lastDie1Value = die1.getLastRoll();
		lastDie2Value = die2.getLastRoll();
	}

	public int getLastDie1Value() {
		return lastDie1Value;
	}

	public int getLastDie2Value() {
		return lastDie2Value;
	}
	
	

}
