
public class Player {

	private ISkunkUi ui;
	private String name;
	private int chips = 50;
	private int score = 0;
	
	public Player(ISkunkUi ui, String name) {
		this.ui = ui;
		this.name = name;
	}

	public void takeTurn() {
		Turn turn = new Turn(ui, score);
		
		turn.go();
	}
}
