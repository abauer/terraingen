////////////////////////////////////////
//                                    //
//          TerrainGen 1.0            //
//                                    //
////////////////////////////////////////

import java.awt.*;
import java.util.Arrays;

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
		// ROW 5
		int x = 0;
		int y = 150;
		for(int k=0; k < Generate.row5.length;k++)
		{
			if(Generate.row5[k] == 7)
			{
				g.drawImage(topdirt,x,y,this);
			}
			x += 25;
		}
		// ROW 6
		x = 0;
		y = 175;
		for(int k=0; k < Generate.row6.length;k++)
		{
			if(Generate.row6[k] == 1)
			{
				g.drawImage(dirt,x,y,this);
			}
			x += 25;
		}
		// ROW 7
		x = 0;
		y = 200;
		for(int k=0; k < Generate.row7.length;k++)
		{
			if(Generate.row7[k] == 1)
			{
				g.drawImage(dirt,x,y,this);
			}
			x += 25;
		}
		// ROW 8
		x = 0;
		y = 225;
		for(int k=0; k< Generate.row8.length;k++)
		{
			if(Generate.row8[k] == 1)
			{
				g.drawImage(dirt,x,y,this);
			}
			x += 25;
		}
	}

	public void drawRock(Graphics g)
	{

	}

	public void drawBedrock(Graphics g)
	{
		// ROW 24
		int x = 0;
		int y = 600;
		for (int k=0; k < Generate.row24.length;k++)
		{
			if(Generate.row24[k] == 6)
			{
				g.drawImage(bedrock,x,y,this);
			}
			x += 25;
		}
		// ROW 25
		x = 0;
		y = 625;
		for (int k=0; k <Generate.row25.length;k++)
		{
			if(Generate.row25[k] == 6)
			{
				g.drawImage(bedrock,x,y,this);
			}
			x += 25;
		}

	}
}

