
public class SkunkController {

	ISkunkUi skunkUi;
	
	
	public SkunkController() {
		
	}


	public void registerUi(ISkunkUi ui) {
		this.skunkUi = ui;
	}
	
	public void gameLoop() {
		boolean keepLooping = true;
		
		Round skunkRound = new Round(skunkUi);
		
		while(keepLooping) {
			String response;
			
			response = skunkUi.displayPrompt("");
			
			if(response.equals("n")) {
				keepLooping = false;
			}
		}
	}
}
