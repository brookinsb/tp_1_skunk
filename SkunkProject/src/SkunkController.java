
public class SkunkController {

	ISkunkUi skunkUi;
	
	
	public SkunkController() {
		
	}


	public void registerUi(ISkunkUi ui) {
		this.skunkUi = ui;
	}
	
	public void gameLoop() {
		boolean keepLooping = false;
		
		Round skunkRound = new Round(skunkUi);
		skunkRound.start();
	}	
}
