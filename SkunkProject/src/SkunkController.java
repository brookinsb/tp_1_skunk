
public class SkunkController {

	ISkunkUi skunkUi;
	
	
	public SkunkController() {
		
	}


	public void registerUi(ISkunkUi ui) {
		this.skunkUi = ui;
	}
}
