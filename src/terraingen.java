////////////////////////////////////////
//                                    //
//          TerrainGen 1.0            //
//                                    //
////////////////////////////////////////

import java.awt.*;

public class terraingen extends java.applet.Applet
{
	Image dirt,topdirt,rock,diamond,iron,redstone,bedrock;
	int numClicks;

	public void init()
	{
		dirt = getImage(getDocumentBase(),"dirt.png");
		topdirt = getImage(getDocumentBase(),"topdirt.png");
		rock = getImage(getDocumentBase(),"rock.png");
		diamond = getImage(getDocumentBase(),"diamond.png");
		iron = getImage(getDocumentBase(),"iron.png");
		redstone = getImage(getDocumentBase(),"redstone.png");
		bedrock = getImage(getDocumentBase(),"bedrock.png");
	}

	public void paint(Graphics g)
	{
		if (numClicks == 1)
		{
			g.drawString("Debug: Prompting for seed...",20,20);
			numClicks++;
			Generate.getSeed();
			if (Generate.seed == 0)
			{
				numClicks = 1;
			}
			repaint();
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
				Generate.setConstants();
				Generate.assignRandom();
				drawSky(g);
				drawGround(g);
				drawRock(g);
				drawBedrock(g);
				Menu.drawDone();
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

	public void drawSky(Graphics g)
	{
		Expo.setBackground(g,Expo.lightBlue);
	}

	public void drawGround(Graphics g)
	{
		int x = 0;
		int y = 150;
		for(int k=0; k<100;k++)
		{
			g.drawImage(topdirt,x,y,this);
			x += 25;
		}
	}

	public void drawRock(Graphics g)
	{
		g.drawImage(dirt,0,0,this);
	}

	public void drawBedrock(Graphics g)
	{
		// ROW 25
		int x = 0;
		int y = 600;
		for (int k=0; k <100;k++)
		{
			g.drawImage(bedrock,x,y,this);
			x += 25;
		}
		// ROW 26
		x = 0;
		y = 625;
		for (int k=0; k <100;k++)
		{
			g.drawImage(bedrock,x,y,this);
			x += 25;
		}

	}
}

