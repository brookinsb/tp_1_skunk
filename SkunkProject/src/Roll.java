
public class Roll {

	private Die die1;
	private Die die2;
	private int lastDie1Value;
	private int lastDie2Value;

	public enum Skunk_Roll {
		NO_SKUNK(0),
		SKUNK(0),
		DOUBLE_SKUNK(0),
		SKUNK_DEUCE(0),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		ELEVEN(11),
		TWELVE(12);
		
		private int value;
		
		private Skunk_Roll(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}
	
	
	public Roll() {
		die1 = new Die();
		die2 = new Die();
	}

	public void shakeDie() {

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
	
	private boolean isRollASkunkRoll() {
		Skunk_Roll roll = Skunk_Roll.NO_SKUNK;
		
		if(lastDie1Value == 1 && lastDie2Value == 1) {
			roll = Skunk_Roll.DOUBLE_SKUNK;
		} 
		else if(lastDie1Value + lastDie2Value == 3) {
			roll = Skunk_Roll.SKUNK_DEUCE;
		}
		else if(lastDie1Value == 1 || lastDie2Value == 1 ) {
				roll = Skunk_Roll.SKUNK;
		}
						
		return roll == Skunk_Roll.SKUNK;
	}
	
	
	public Skunk_Roll getRoll() {
		Skunk_Roll roll = Skunk_Roll.NO_SKUNK;
		
		if(isRollASkunkRoll() ) {
			roll = Skunk_Roll.SKUNK;
		} else {
			
			int rollValue = lastDie1Value + lastDie2Value;
			switch(rollValue) {
			case 2:
				roll = Skunk_Roll.DOUBLE_SKUNK;
				break;
			case 3:
				roll = Skunk_Roll.SKUNK_DEUCE;
				break;
			case 4:
				roll = Skunk_Roll.FOUR;
				break;
			case 5:
				roll = Skunk_Roll.FIVE;
				break;
			case 6:
				roll = Skunk_Roll.SIX;
				break;
			case 7:
				roll = Skunk_Roll.SEVEN;
				break;
			case 8:
				roll = Skunk_Roll.EIGHT;
				break;
			case 9:
				roll = Skunk_Roll.NINE;
				break;
			case 10:
				roll = Skunk_Roll.TEN;
				break;
			case 11:
				roll = Skunk_Roll.ELEVEN;
				break;
			case 12:
				roll = Skunk_Roll.TWELVE;
				break;
			default:
				roll = Skunk_Roll.NO_SKUNK;
				throw new IllegalArgumentException("Illegal roll value");
			}
			
		}
		
		return roll;
	}


	public int getRollValue() {
		return lastDie1Value + lastDie2Value;
	}
}
