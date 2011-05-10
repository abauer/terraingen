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
				Generate.setConstants();
				Generate.assignRandom();
				drawSky(g);
				drawGround(g);
				drawRock(g);
				drawBedrock(g);
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
		g.drawImage(dirt,0,0,this);
		g.drawImage(dirt,600,150,this);
		g.drawImage(dirt,300,400,this);
	}

	public void drawGround(Graphics g)
	{
		g.drawImage(dirt,0,0,this);
		g.drawImage(dirt,600,150,this);
		g.drawImage(dirt,300,400,this);
	}

	public void drawRock(Graphics g)
	{
		g.drawImage(dirt,0,0,this);
		g.drawImage(dirt,600,150,this);
		g.drawImage(dirt,300,400,this);
	}

	public void drawBedrock(Graphics g)
	{
		g.drawImage(dirt,0,0,this);
		g.drawImage(dirt,600,150,this);
		g.drawImage(dirt,300,400,this);
	}
}

