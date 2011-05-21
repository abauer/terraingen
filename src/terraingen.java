////////////////////////////////////////
//                                    //
//          TerrainGen 1.2            //
//                                    //
////////////////////////////////////////
//                                    //
//           See /doc for             //
//        full documentation          //
//                                    //
////////////////////////////////////////

import java.awt.*;
import java.util.Arrays;

public class terraingen extends java.applet.Applet
{
	Image dirt,topdirt,rock,diamond,iron,redstone,bedrock,coal,snowdirt;
	public static int numClicks;
	public boolean night = false;
	public boolean regen = true;

	public void init()
	{
		dirt = getImage(getDocumentBase(),"dirt.png");
		topdirt = getImage(getDocumentBase(),"topdirt.png");
		rock = getImage(getDocumentBase(),"rock.png");
		diamond = getImage(getDocumentBase(),"diamond.png");
		iron = getImage(getDocumentBase(),"iron.png");
		redstone = getImage(getDocumentBase(),"redstone.png");
		bedrock = getImage(getDocumentBase(),"bedrock.png");
		coal = getImage(getDocumentBase(),"coal.png");
		snowdirt = getImage(getDocumentBase(),"snowdirt.png");
	}

	public void paint(Graphics g)
	{
		if (numClicks == 1)
		{
			g.drawString("Debug: Prompting for seed...",20,20);
			numClicks++;
			Generate.getSeed();
			repaint();
		}
		else
		{
			if (numClicks < 1)
			{
				g.drawString("Debug: Waiting for mouse click.",20,20);
				drawMain(g);
				drawDirections(g);
				drawCredits(g);
				regen = true;
			}
			else
			{
				if (numClicks == 999)
				{
					g.drawString("Debug: Ignoring mouse click(s). Already prompted for seed.",20,20);
					if(regen == true)
					{
						Generate.setConstants();
						Generate.assignRandom();
						Generate.checkHill();
					}
					drawSky(g);
					drawGround(g);
					drawRock(g);
					drawBedrock(g);
					regen = false;
				}

				if (numClicks == 1000)
				{
					numClicks = 0;
					repaint();
				}
			}
		}

	}

	public boolean mouseDown(Event e, int x, int y)
	{
		numClicks++;
		if (numClicks <= 1 || numClicks == 1000)
		{
			repaint();
		}
		return true;
	}

	public boolean mouseExit(Event e, int x, int y)
	{
		night = true;
		repaint();
		return true;
	}

	public boolean mouseEnter(Event e, int x, int y)
	{
		night = false;
		repaint();
		return true;
	}


	public void drawSky(Graphics g)
	{
		if(night)
		{
			Expo.setBackground(g,Expo.black);
			// Moon
			Expo.setColor(g,Expo.white);
			Expo.fillRectangle(g,450,10,550,110);
			Expo.setColor(g,Expo.lightGrey);
			Expo.fillRectangle(g,455,15,460,75);
			Expo.fillRectangle(g,525,15,535,25);
			Expo.fillRectangle(g,480,30,490,40);
			Expo.fillRectangle(g,510,90,520,100);
			Expo.fillRectangle(g,520,50,530,60);
			Expo.fillRectangle(g,475,80,485,90);

			// Stars
			Expo.setColor(g,Expo.white);
			Expo.fillRectangle(g,10,5,15,10);
			Expo.fillRectangle(g,750,30,755,35);
			Expo.fillRectangle(g,400,100,405,105);
			Expo.fillRectangle(g,900,120,905,125);
			Expo.fillRectangle(g,100,50,105,55);
			Expo.fillRectangle(g,600,70,605,75);
			Expo.fillRectangle(g,250,30,255,35);
			Expo.fillRectangle(g,875,15,880,20);

			// Debug text
			if(Generate.wantSeed.equals("true"))
			{
				Expo.setColor(g,Expo.white);
				g.drawString("Debug: Render complete (Seed: " + Generate.seed + ")",20,20);
			}
			if(Generate.wantSeed.equals("false"))
			{
				Expo.setColor(g,Expo.white);
				g.drawString("Debug: Render complete",20,20);
			}
		}
		else
		{
			Expo.setBackground(g,Expo.lightBlue);
			// Sun
			Expo.setColor(g,255,255,204);
			Expo.fillRectangle(g,450,10,550,110);

			// Clouds

			if(Generate.drawLeftHill)
			{
				Expo.setColor(g,Expo.white);
				Expo.fillRectangle(g,800,60,900,80);
				Expo.fillRectangle(g,875,50,900,80);
			}

			if(Generate.drawRightHill)
			{
				Expo.setColor(g,Expo.white);
				Expo.fillRectangle(g,100,50,200,75);
				Expo.fillRectangle(g,175,40,200,75);
			}

			if(Generate.drawMiddleHill)
			{
				Expo.setColor(g,Expo.white);
				Expo.fillRectangle(g,800,60,900,80);
				Expo.fillRectangle(g,875,50,900,80);
				Expo.fillRectangle(g,100,50,200,75);
				Expo.fillRectangle(g,175,40,200,75);
			}

			// Debug text
			if(Generate.wantSeed.equals("true"))
			{
				Expo.setColor(g,Expo.black);
				g.drawString("Debug: Render complete (Seed: " + Generate.seed + ")",20,20);
			}
			if(Generate.wantSeed.equals("false"))
			{
				Expo.setColor(g,Expo.black);
				g.drawString("Debug: Render complete",20,20);
			}
		}
	}

	public void drawGround(Graphics g)
	{
		// ROW 0
		// This is blank because nothing will be drawn up here...

		// ROW 1
		int x = 0;
		int y = 50;
		for(int k=0; k < Generate.row4.length;k++)
		{
			if(Generate.row1[k] == 7)
			{
				g.drawImage(topdirt,x,y,this);
			}

			if(Generate.row1[k] == 9)
			{
				g.drawImage(snowdirt,x,y,this);
			}

			if(Generate.row1[k] == 1)
			{
				g.drawImage(dirt,x,y,this);
			}
			x += 25;
		}

		// ROW 2
		x = 0;
		y = 75;
		for(int k=0; k < Generate.row4.length;k++)
		{
			if(Generate.row2[k] == 7)
			{
				g.drawImage(topdirt,x,y,this);
			}

			if(Generate.row2[k] == 9)
			{
				g.drawImage(snowdirt,x,y,this);
			}

			if(Generate.row2[k] == 1)
			{
				g.drawImage(dirt,x,y,this);
			}
			x += 25;
		}

		// ROW 3
		x = 0;
		y = 100;
		for(int k=0; k < Generate.row4.length;k++)
		{
			if(Generate.row3[k] == 7)
			{
				g.drawImage(topdirt,x,y,this);
			}

			if(Generate.row3[k] == 9)
			{
				g.drawImage(snowdirt,x,y,this);
			}

			if(Generate.row3[k] == 1)
			{
				g.drawImage(dirt,x,y,this);
			}
			x += 25;
		}

		// ROW 4
		x = 0;
		y = 125;
		for(int k=0; k < Generate.row4.length;k++)
		{
			if(Generate.row4[k] == 7)
			{
				g.drawImage(topdirt,x,y,this);
			}

			if(Generate.row4[k] == 9)
			{
				g.drawImage(snowdirt,x,y,this);
			}

			if(Generate.row4[k] == 1)
			{
				g.drawImage(dirt,x,y,this);
			}
			x += 25;
		}

		// ROW 5
		x = 0;
		y = 150;
		for(int k=0; k < Generate.row5.length;k++)
		{
			if(Generate.row5[k] == 7)
			{
				g.drawImage(topdirt,x,y,this);
			}

			if(Generate.row5[k] == 9)
			{
				g.drawImage(snowdirt,x,y,this);
			}

			if(Generate.row5[k] == 1)
			{
				g.drawImage(dirt,x,y,this);
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

			if(Generate.row11[k] == 8)
			{
				g.drawImage(coal,x,y,this);
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

			if(Generate.row12[k] == 8)
			{
				g.drawImage(coal,x,y,this);
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

			if(Generate.row13[k] == 8)
			{
				g.drawImage(coal,x,y,this);
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

			if(Generate.row14[k] == 8)
			{
				g.drawImage(coal,x,y,this);
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

			if(Generate.row15[k] == 4)
			{
				g.drawImage(iron,x,y,this);
			}
			if(Generate.row15[k] == 8)
			{
				g.drawImage(coal,x,y,this);
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

			if(Generate.row16[k] == 4)
			{
				g.drawImage(iron,x,y,this);
			}
			if(Generate.row16[k] == 8)
			{
				g.drawImage(coal,x,y,this);
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

			if(Generate.row17[k] == 4)
			{
				g.drawImage(iron,x,y,this);
			}
			if(Generate.row17[k] == 8)
			{
				g.drawImage(coal,x,y,this);
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

			if(Generate.row18[k] == 4)
			{
				g.drawImage(iron,x,y,this);
			}
			if(Generate.row18[k] == 8)
			{
				g.drawImage(coal,x,y,this);
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
		// ROW 22
		x = 0;
		y = 575;
		for(int k=0; k< Generate.row22.length;k++)
		{
			if(Generate.row22[k] == 2)
			{
				g.drawImage(rock,x,y,this);
			}

			if(Generate.row22[k] == 3)
			{
				g.drawImage(diamond,x,y,this);
			}
			if(Generate.row22[k] == 5)
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

	public void drawMain(Graphics g)
	{
		Expo.setFont(g,"Arial",Font.BOLD,36);
		Expo.drawString(g,"TerrainGen",100,200);
		Expo.setFont(g,"Arial",Font.PLAIN,12);
		g.drawString("v. 1.2",300,200);
	}

	public void drawCredits(Graphics g)
	{
		Expo.setFont(g,"Arial",Font.PLAIN,12);
		g.drawString("Inspired by Minecraft - (c) Mojang AB",775,630);
		g.drawString("mojang.com - minecraft.net",775,645);
	}

	public void drawDirections(Graphics g)
	{
		Expo.setFont(g,"Arial",Font.BOLD,16);
		g.drawString("How to Use",600,350);
		Expo.setFont(g,"Arial",Font.PLAIN,12);
		g.drawString("1) Click the screen to begin",600,375);
		g.drawString("2) Answer prompts",600,400);
		g.drawString("3) Click again to reset - move mouse outsite applet to change time",600,425);
		Expo.setFont(g,"Arial",Font.BOLD,16);
		g.drawString("Interesting Seeds",600,450);
		Expo.setFont(g,"Arial",Font.PLAIN,12);
		g.drawString("2 - snow without hills",600,475);
		g.drawString("More to be added...",600,500);
	}
}