import java.awt.*;

public class Menu
{
	public void drawMain(Graphics g)
	{
		// Title and the such will be drawn using this method
		Expo.setFont(g,"Arial",Font.BOLD,36);
		Expo.drawString(g,"Hello There!",100,200);
	}

	public void drawDirections()
	{
		// Directions will be drawn using this method
	}

	public void drawDone()
	{
		// Expo.displayGUI("Generation complete!");
		// Removed 5/12/11 because it was annoying...
	}

}