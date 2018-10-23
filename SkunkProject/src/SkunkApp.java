import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{

	static SkunkController skunkController;
	
	public static void main(String[] args)
	{
		StdOut.println("Welcome to 635 Skunk!");
		
		skunkController = new SkunkController();
		
		skunkController.registerUi(new SkunkUi());
		
		skunkController.gameLoop();

	}

}
