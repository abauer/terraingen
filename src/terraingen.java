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
		// ROW 9
		int x = 0;
		int y = 250;
		for(int k=0; k< Generate.row9.length;k++)
		{
			if(Generate.row9[k] == 1)
			{
				g.drawImage(dirt,x,y,this);
			}

			if(Generate.row9[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}
			x += 25;
		}
		// ROW 10
		x = 0;
		y = 275;
		for(int k=0; k< Generate.row10.length;k++)
		{
			if(Generate.row10[k] == 1)
			{
				g.drawImage(dirt,x,y,this);
			}

			if(Generate.row10[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}
			x += 25;
		}
		// ROW 11
		x = 0;
		y = 300;
		for(int k=0; k< Generate.row11.length;k++)
		{
			if(Generate.row11[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row11[k] == 4)
			{
				g.drawImage(iron,x,y,this);
			}
			x += 25;
		}
		// ROW 12
		x = 0;
		y = 325;
		for(int k=0; k< Generate.row12.length;k++)
		{
			if(Generate.row12[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row12[k] == 4)
			{
				g.drawImage(iron,x,y,this);
			}
			x += 25;
		}
		// ROW 13
		x = 0;
		y = 350;
		for(int k=0; k< Generate.row13.length;k++)
		{
			if(Generate.row13[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row13[k] == 4)
			{
				g.drawImage(iron,x,y,this);
			}
			x += 25;
		}
		// ROW 14
		x = 0;
		y = 375;
		for(int k=0; k< Generate.row14.length;k++)
		{
			if(Generate.row14[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row14[k] == 4)
			{
				g.drawImage(iron,x,y,this);
			}
			x += 25;
		}
		// ROW 15
		x = 0;
		y = 400;
		for(int k=0; k< Generate.row15.length;k++)
		{
			if(Generate.row15[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row15[k] == 3)
			{
				g.drawImage(diamond,x,y,this);
			}
			if(Generate.row15[k] == 5)
			{
				g.drawImage(redstone,x,y,this);
			}
			x += 25;
		}
		// ROW 16
		x = 0;
		y = 425;
		for(int k=0; k< Generate.row16.length;k++)
		{
			if(Generate.row16[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row16[k] == 3)
			{
				g.drawImage(diamond,x,y,this);
			}
			if(Generate.row16[k] == 5)
			{
				g.drawImage(redstone,x,y,this);
			}
			x += 25;
		}
		// ROW 17
		x = 0;
		y = 450;
		for(int k=0; k< Generate.row17.length;k++)
		{
			if(Generate.row17[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row17[k] == 3)
			{
				g.drawImage(diamond,x,y,this);
			}
			if(Generate.row17[k] == 5)
			{
				g.drawImage(redstone,x,y,this);
			}
			x += 25;
		}
		// ROW 18
		x = 0;
		y = 475;
		for(int k=0; k< Generate.row18.length;k++)
		{
			if(Generate.row18[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row18[k] == 3)
			{
				g.drawImage(diamond,x,y,this);
			}
			if(Generate.row18[k] == 5)
			{
				g.drawImage(redstone,x,y,this);
			}
			x += 25;
		}
		// ROW 19
		x = 0;
		y = 500;
		for(int k=0; k< Generate.row19.length;k++)
		{
			if(Generate.row19[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row19[k] == 3)
			{
				g.drawImage(diamond,x,y,this);
			}
			if(Generate.row19[k] == 5)
			{
				g.drawImage(redstone,x,y,this);
			}
			x += 25;
		}
		// ROW 20
		x = 0;
		y = 525;
		for(int k=0; k< Generate.row20.length;k++)
		{
			if(Generate.row20[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row20[k] == 3)
			{
				g.drawImage(diamond,x,y,this);
			}
			if(Generate.row20[k] == 5)
			{
				g.drawImage(redstone,x,y,this);
			}
			x += 25;
		}
		// ROW 21
		x = 0;
		y = 550;
		for(int k=0; k< Generate.row21.length;k++)
		{
			if(Generate.row21[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row21[k] == 3)
			{
				g.drawImage(diamond,x,y,this);
			}
			if(Generate.row21[k] == 5)
			{
				g.drawImage(redstone,x,y,this);
			}
			x += 25;
		}
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

