////////////////////////////////////////
//                                    //
//          TerrainGen 1.0            //
//                                    //
////////////////////////////////////////

import java.awt.*;

public class terraingen extends java.applet.Applet
{
	int numClicks;

	public void init()
	{
		// add variables here
	}

	public void paint(Graphics g)
	{
		if (numClicks == 1)
		{
			g.drawString("Debug: Prompting for seed...",20,20);
			numClicks++;
			repaint();
			Generate.getSeed();
			if (Generate.seed == 0)
			{
				numClicks = 1;
			}
		}
		else
		{
			if (numClicks < 1)
			{
				g.drawString("Debug: Waiting for mouse click.",20,20);
			//	Menu.drawMain(g);
			//	Menu.drawDirections(g);
			}
			else
			{
				g.drawString("Debug: Ignoring mouse click(s). Already prompted for seed.",20,20);
				//Generate.draw();
			}
		}
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		numClicks++;
		if (numClicks <= 1)
		{
			repaint();
		}
		return true;
	}
}

