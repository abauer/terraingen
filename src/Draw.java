// Draw.java
//
// Reads the arrays' indexes
// Draws the blocks on the screen

import java.util.Arrays;
import java.awt.*;

public class Draw extends java.applet.Applet
{
	Image dirt,topdirt,rock,diamond,iron,redstone,bedrock;

	public void run(Graphics g)
	{
		Generate.setConstants();
		Generate.assignRandom();
		drawSky(g);
		drawGround(g);
		drawRock(g);
		drawBedrock(g);
	}

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