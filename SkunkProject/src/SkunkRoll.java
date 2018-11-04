
public enum SkunkRoll {
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
	
	private SkunkRoll(int value) {
		setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
