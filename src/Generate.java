// Generate.java
// Part of TerrainGen 1.2
//
// Generates and assigns blocks' data values

/*
 * BLOCK TYPES:
 *	0 - Air
 *	1 - Dirt
 *	2 - Rock
 *	3 - Diamond
 *	4 - Iron
 *	5 - Redstone
 *	6 - Bedrock
 *	7 - Dirt (with grass)
 *  8 - Coal
 *  9 - Dirt (with snow)
 *
 *	Full documentation in doc/
 */

import java.util.Arrays;
import java.util.Random;
import javax.swing.*;
import java.io.*;

public class Generate
{
	public static int seed = 0;
	public static String wantSeed = "null";
	public static int row0[] = new int[40];
	public static int row1[] = new int[40];
	public static int row2[] = new int[40];
	public static int row3[] = new int[40];
	public static int row4[] = new int[40];
	public static int row5[] = new int[40];
	public static int row6[] = new int[40];
	public static int row7[] = new int[40];
	public static int row8[] = new int[40];
	public static int row9[] = new int[40];
	public static int row10[] = new int[40];
	public static int row11[] = new int[40];
	public static int row12[] = new int[40];
	public static int row13[] = new int[40];
	public static int row14[] = new int[40];
	public static int row15[] = new int[40];
	public static int row16[] = new int[40];
	public static int row17[] = new int[40];
	public static int row18[] = new int[40];
	public static int row19[] = new int[40];
	public static int row20[] = new int[40];
	public static int row21[] = new int[40];
	public static int row22[] = new int[40];
	public static int row23[] = new int[40];
	public static int row24[] = new int[40];
	public static int row25[] = new int[40];
	private static int rand[] = new int[2];
	public static boolean drawLeftHill = false;
	public static boolean drawRightHill = false;
	public static boolean drawMiddleHill = false;
	public static boolean snowing = false;

	public static void getSeed() throws IOException
	{
		// Make sure random events don't get "stuck"
		drawLeftHill = false;
		drawMiddleHill = false;
		drawRightHill = false;
		snowing = false;
		////////////////////////////////////////////
		JDialog.setDefaultLookAndFeelDecorated(true);
    	int response = JOptionPane.showConfirmDialog(null, "Do you want to use a seed?", "Seed",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if (response == JOptionPane.NO_OPTION) {
      		wantSeed = "false";
    	} else if (response == JOptionPane.YES_OPTION) {
      		wantSeed = "true";
    	} else if (response == JOptionPane.CLOSED_OPTION) {
      		wantSeed = "null";
    	}

    	if(wantSeed.equals("null"))
		{
			JFrame parent = new JFrame();
    		String multiLineMsg[] = { "You did something wrong. Maybe you went the wrong way?", "You need to reset the applet viewer or web browser."} ;
    		JOptionPane.showMessageDialog(parent, multiLineMsg);
		}
		else
		{
			if(wantSeed.equals("true"))
			{
				// Read config.seed file and store values to memory
				// File needs to be in the same directory as the program... see file for instructions
				// Edit the file in Notepad, Notepad++, or a similar program
				boolean ignore = false;
				String firstSeedName = "#";
				String firstSeed = "0";
				String secondSeedName = "#";
				String secondSeed = "0";
				String thirdSeedName = "#";
				String thirdSeed = "0";
				String fourthSeedName = "#";
				String fourthSeed = "0";
				String fifthSeedName = "#";
				String fifthSeed = "0";

				ExpoInFile seedconfig = new ExpoInFile("config.seed");

				while(!ignore)
				{
					firstSeedName = seedconfig.readString();
					if(firstSeedName.indexOf("#") != -1) // determine which lines are commented
					{
						// Ignore the line
					}
					else
					{
						ignore = true;
					}
				}
				ignore = false;
				while(!ignore)
				{
					firstSeed = seedconfig.readString();
					if(firstSeed.indexOf("#") != -1) // determine which lines are commented
					{
						// Ignore the line
					}
					else
					{
						ignore = true;
					}
				}


				seedconfig.closeFile();

				// Display GUI
				JDialog.setDefaultLookAndFeelDecorated(true);
    			Object[] selectionValues = { "Custom Seed", "1 - Middle hill, no snow", "2 - Middle hill, snow", "3 - Left hill, no snow", "12324 - Flat, snow"};
    			String initialSelection = "Custom Seed";
    			Object selection = JOptionPane.showInputDialog(null, "What seed would you like to use?",
        		"Select Seed", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

    			if (selection == "Custom Seed")
    			{
    				seed = Expo.enterIntGUI("Enter Seed");
					Generate.makeSeeds();
					terraingen.numClicks = 999;
    			}

    			if(selection == "1 - Middle hill, no snow")
    			{
    				seed = 1;
    				Generate.makeSeeds();
					terraingen.numClicks = 999;
    			}

    			if(selection == "2 - Middle hill, snow")
    			{
    				seed = 2;
    				Generate.makeSeeds();
					terraingen.numClicks = 999;
    			}

    			if(selection == "3 - Left hill, no snow")
    			{
    				seed = 3;
    				Generate.makeSeeds();
					terraingen.numClicks = 999;
    			}

    			if(selection == "12324 - Flat, snow")
    			{
    				seed = 12324;
    				Generate.makeSeeds();
					terraingen.numClicks = 999;
    			}

    			if (selection == null)
    			{
    				JFrame parent = new JFrame();
    				String multiLineMsg[] = { "You did something wrong. Maybe you went the wrong way?", "You need to reset the applet viewer or web browser."} ;
    				JOptionPane.showMessageDialog(parent, multiLineMsg);
    			}


			}
			if(wantSeed.equals("false"))
			{
				terraingen.numClicks = 999;
			}
		}
	}

	private static void makeSeeds()
	{
		// See documentation (doc/)

		// Snow seed
		Random random0 = new Random(seed);
		rand[0] = random0.nextInt(3);

		// Hill seed
		Random random1 = new Random(seed+1);
		rand[1] = random1.nextInt(15);
	}

	public static void setConstants()
	{
		// First five rows with "air"
		Arrays.fill(row0,0);
		Arrays.fill(row1,0);
		Arrays.fill(row2,0);
		Arrays.fill(row3,0);
		Arrays.fill(row4,0);

		// First four land rows with "dirt"
		Arrays.fill(row5,7);
		Arrays.fill(row6,1);
		Arrays.fill(row7,1);
		Arrays.fill(row8,1);

		// Final 2 rows with "bedrock"
		Arrays.fill(row24,6);
		Arrays.fill(row25,6);

		// All others with "rock" (for now)

		// Intermediate Zone
		Arrays.fill(row9,2);
		Arrays.fill(row10,2);
		// Rock: 75%, Diamond: 0%, Iron: 25%, Redstone: 0%
		Arrays.fill(row11,2);
		Arrays.fill(row12,2);
		Arrays.fill(row13,2);
		Arrays.fill(row14,2);
		// Rock: 50%, Diamond: 25%, Iron: 0%, Redstone: 25%
		Arrays.fill(row15,2);
		Arrays.fill(row16,2);
		Arrays.fill(row17,2);
		Arrays.fill(row18,2);
		// Rock: 50%, Diamond: 25%, Iron: 0%, Redstone: 0%
		Arrays.fill(row19,2);
		Arrays.fill(row20,2);
		Arrays.fill(row21,2);
		Arrays.fill(row22,2);
		Arrays.fill(row23,2);
	}

	public static void checkHill()
	{
		if(drawLeftHill)
		{
			if(snowing)
			{
				row5[1] = 1;
				row5[2] = 1;
				row5[3] = 1;
				row5[4] = 1;
				row5[5] = 1;
				row4[1] = 9;
				row4[2] = 1;
				row4[3] = 1;
				row4[4] = 1;
				row4[5] = 1;
				row3[2] = 9;
				row3[3] = 1;
				row3[4] = 1;
				row3[5] = 9;
				row2[3] = 9;
				row2[4] = 9;
			}
			else
			{
				row5[1] = 1;
				row5[2] = 1;
				row5[3] = 1;
				row5[4] = 1;
				row5[5] = 1;
				row4[1] = 7;
				row4[2] = 1;
				row4[3] = 1;
				row4[4] = 1;
				row4[5] = 1;
				row3[2] = 7;
				row3[3] = 1;
				row3[4] = 1;
				row3[5] = 7;
				row2[3] = 7;
				row2[4] = 7;
			}

		}

		if(drawRightHill)
		{
			if(snowing)
			{
				row5[33] = 1;
				row5[34] = 1;
				row5[35] = 1;
				row5[36] = 1;
				row5[37] = 1;
				row4[33] = 9;
				row4[34] = 1;
				row4[35] = 1;
				row4[36] = 1;
				row4[37] = 1;
				row3[34] = 9;
				row3[35] = 1;
				row3[36] = 1;
				row3[37] = 9;
				row2[35] = 9;
				row2[36] = 9;
			}
			else
			{
				row5[33] = 1;
				row5[34] = 1;
				row5[35] = 1;
				row5[36] = 1;
				row5[37] = 1;
				row4[33] = 7;
				row4[34] = 1;
				row4[35] = 1;
				row4[36] = 1;
				row4[37] = 1;
				row3[34] = 7;
				row3[35] = 1;
				row3[36] = 1;
				row3[37] = 7;
				row2[35] = 7;
				row2[36] = 7;
			}
		}

		if(drawMiddleHill)
		{
			if(snowing)
			{
				row5[17] = 1;
				row5[18] = 1;
				row5[19] = 1;
				row5[20] = 1;
				row5[21] = 1;
				row5[22] = 1;
				row5[23] = 1;
				row5[24] = 1;
				row4[17] = 9;
				row4[18] = 1;
				row4[19] = 1;
				row4[20] = 9;
				row4[21] = 1;
				row4[22] = 1;
				row4[23] = 1;
				row4[24] = 9;
				row3[18] = 9;
				row3[19] = 1;
				row3[21] = 9;
				row3[22] = 1;
				row3[23] = 1;
				row2[19] = 9;
				row2[22] = 9;
				row2[23] = 9;
			}
			else
			{
				row5[16] = 1;
				row5[17] = 1;
				row5[18] = 1;
				row5[17] = 1;
				row5[20] = 1;
				row5[21] = 1;
				row5[22] = 1;
				row5[23] = 1;
				row5[24] = 1;
				row4[16] = 7;
				row4[17] = 7;
				row4[18] = 1;
				row4[17] = 1;
				row4[20] = 7;
				row4[21] = 1;
				row4[22] = 1;
				row4[23] = 1;
				row4[24] = 7;
				row3[18] = 7;
				row3[17] = 1;
				row3[21] = 7;
				row3[22] = 1;
				row3[23] = 1;
				row2[17] = 7;
				row2[22] = 7;
				row2[23] = 7;
			}
		}
	}

	public static void assignRandom()
	{
		if(wantSeed.equals("true"))
		{
			/////////////////////
			//////Top Layer//////
			/////////////////////

			// Snow?
			if(rand[0] == 1)
			{
				Arrays.fill(row5,9);
				snowing = true;
			}

			// Hill?
			if(rand[1] < 4)
			{
				drawLeftHill = true;
			}

			if(rand[1] > 3 && rand[1] < 7)
			{
				drawRightHill = true;
			}

			if(rand[1] > 10)
			{
				drawMiddleHill = true;
			}

			/////////////////////
			//Intermediate Zone//
			/////////////////////

			//////////////////////////////////////////////////////////////////////// row9
			// Set 50% dirt (1)
			int row9seed = seed;
			Random row9Dirt = new Random(row9seed);
			for(int k=0;k<=20;k++)
			{
				int row9DirtIndex = row9Dirt.nextInt(39);
				row9[row9DirtIndex] = 1;
				row9seed += 1;
			}

			//////////////////////////////////////////////////////////////////////// row10
			// Set 50% dirt (1)
			int row10seed = row9seed;
			Random row10Dirt = new Random(row10seed);
			for(int k=0;k<=20;k++)
			{
				int row10DirtIndex = row10Dirt.nextInt(39);
				row10[row10DirtIndex] = 1;
				row10seed += 1;
			}

			/////////////////////
			//Top Rock Zone    //
			/////////////////////

			//////////////////////////////////////////////////////////////////////// row11
			// Set 75% Rock (1)
			int row11seed = row10seed;
			Random row11Rock = new Random(row11seed);
			for(int k=0;k<=30;k++)
			{
				int row11RockIndex = row11Rock.nextInt(39);
				row11[row11RockIndex] = 2;
				row11seed++;
			}

			// Set 25% Coal (8)
			Random row11Coal = new Random(row11seed);
			for(int k=0;k<=6;k++)
			{
				int row11CoalIndex = row11Coal.nextInt(39);
				row11[row11CoalIndex] = 8;
				row11seed++;
			}

			//////////////////////////////////////////////////////////////////////// row12
			// Set 75% Rock (1)
			int row12seed = row11seed;
			Random row12Rock = new Random(row12seed);
			for(int k=0;k<=30;k++)
			{
				int row12RockIndex = row12Rock.nextInt(39);
				row12[row12RockIndex] = 2;
				row12seed++;
			}

			// Set 25% Coal (8)
			Random row12Coal = new Random(row12seed);
			for(int k=0;k<=6;k++)
			{
				int row12CoalIndex = row12Coal.nextInt(39);
				row12[row12CoalIndex] = 8;
				row12seed++;
			}

			//////////////////////////////////////////////////////////////////////// row13
			// Set 75% Rock (1)
			int row13seed = row12seed;
			Random row13Rock = new Random(row13seed);
			for(int k=0;k<=30;k++)
			{
				int row13RockIndex = row13Rock.nextInt(39);
				row13[row13RockIndex] = 2;
				row13seed++;
			}

			// Set 25% Coal (8)
			Random row13Coal = new Random(row13seed);
			for(int k=0;k<=6;k++)
			{
				int row13CoalIndex = row13Coal.nextInt(39);
				row13[row13CoalIndex] = 8;
				row13seed++;
			}

			//////////////////////////////////////////////////////////////////////// row14
			// Set 75% Rock (1)
			int row14seed = row13seed;
			Random row14Rock = new Random(row14seed);
			for(int k=0;k<=30;k++)
			{
				int row14RockIndex = row14Rock.nextInt(39);
				row14[row14RockIndex] = 2;
				row14seed++;
			}

			// Set 25% Coal (8)
			Random row14Coal = new Random(row14seed);
			for(int k=0;k<=6;k++)
			{
				int row14CoalIndex = row14Coal.nextInt(39);
				row14[row14CoalIndex] = 8;
				row14seed++;
			}

			/////////////////////
			//Mid Rock Zone    //
			/////////////////////

			//////////////////////////////////////////////////////////////////////// row15
			// Set 50% Rock (1)
			int row15seed = row14seed;
			Random row15Rock = new Random(row15seed);
			for(int k=0;k<=20;k++)
			{
				int row15RockIndex = row15Rock.nextInt(39);
				row15[row15RockIndex] = 2;
				row15seed++;
			}

			// Set 25% Iron (4)
			Random row15Iron = new Random(row15seed);
			for(int k=0;k<=3;k++)
			{
				int row15IronIndex = row15Iron.nextInt(39);
				row15[row15IronIndex] = 4;
				row15seed++;
			}

			// Set 25% Coal (8)
			Random row15Coal = new Random(row15seed);
			for(int k=0;k<=2;k++)
			{
				int row15CoalIndex = row15Coal.nextInt(39);
				row15[row15CoalIndex] = 8;
				row15seed++;
			}

			//////////////////////////////////////////////////////////////////////// row16
			// Set 50% Rock (1)
			int row16seed = row15seed;
			Random row16Rock = new Random(row16seed);
			for(int k=0;k<=20;k++)
			{
				int row16RockIndex = row16Rock.nextInt(39);
				row16[row16RockIndex] = 2;
				row16seed++;
			}

			// Set 25% Iron (4)
			Random row16Iron = new Random(row16seed);
			for(int k=0;k<=3;k++)
			{
				int row16IronIndex = row16Iron.nextInt(39);
				row16[row16IronIndex] = 4;
				row16seed++;
			}

			// Set 25% Coal (8)
			Random row16Coal = new Random(row16seed);
			for(int k=0;k<=2;k++)
			{
				int row16CoalIndex = row16Coal.nextInt(39);
				row16[row16CoalIndex] = 8;
				row16seed++;
			}

			//////////////////////////////////////////////////////////////////////// row17
			// Set 50% Rock (1)
			int row17seed = row16seed;
			Random row17Rock = new Random(row17seed);
			for(int k=0;k<=20;k++)
			{
				int row17RockIndex = row17Rock.nextInt(39);
				row17[row17RockIndex] = 2;
				row17seed++;
			}

			// Set 25% Iron (4)
			Random row17Iron = new Random(row17seed);
			for(int k=0;k<=3;k++)
			{
				int row17IronIndex = row17Iron.nextInt(39);
				row17[row17IronIndex] = 4;
				row17seed++;
			}

			// Set 25% Coal (8)
			Random row17Coal = new Random(row17seed);
			for(int k=0;k<=2;k++)
			{
				int row17CoalIndex = row17Coal.nextInt(39);
				row17[row17CoalIndex] = 8;
				row17seed++;
			}

			//////////////////////////////////////////////////////////////////////// row18
			// Set 50% Rock (1)
			int row18seed = row17seed;
			Random row18Rock = new Random(row18seed);
			for(int k=0;k<=20;k++)
			{
				int row18RockIndex = row18Rock.nextInt(39);
				row18[row18RockIndex] = 2;
				row18seed++;
			}

			// Set 25% Iron (4)
			Random row18Iron = new Random(row18seed);
			for(int k=0;k<=3;k++)
			{
				int row18IronIndex = row18Iron.nextInt(39);
				row18[row18IronIndex] = 4;
				row18seed++;
			}

			// Set 25% Coal (8)
			Random row18Coal = new Random(row18seed);
			for(int k=0;k<=2;k++)
			{
				int row18CoalIndex = row18Coal.nextInt(39);
				row18[row18CoalIndex] = 8;
				row18seed++;
			}

			/////////////////////
			//Lower Rock Zone  //
			/////////////////////

			//////////////////////////////////////////////////////////////////////// row19
			// Set 50% Rock (1)
			int row19seed = row18seed;
			Random row19Rock = new Random(row19seed);
			for(int k=0;k<=20;k++)
			{
				int row19RockIndex = row19Rock.nextInt(39);
				row19[row19RockIndex] = 2;
				row19seed++;
			}

			// Set 25% Diamond (3)
			Random row19Diamond = new Random(row19seed);
			for(int k=0;k<=2;k++)
			{
				int row19DiamondIndex = row19Diamond.nextInt(39);
				row19[row19DiamondIndex] = 3;
				row19seed++;
			}

			// Set 25% Redstone (5)
			Random row19Redstone = new Random(row19seed);
			for(int k=0;k<=3;k++)
			{
				int row19RedstoneIndex = row19Redstone.nextInt(39);
				row19[row19RedstoneIndex] = 5;
				row19seed++;
			}

			//////////////////////////////////////////////////////////////////////// row20
			// Set 50% Rock (1)
			int row20seed = row19seed;
			Random row20Rock = new Random(row20seed);
			for(int k=0;k<=20;k++)
			{
				int row20RockIndex = row20Rock.nextInt(39);
				row20[row20RockIndex] = 2;
				row20seed++;
			}

			// Set 25% Diamond (3)
			Random row20Diamond = new Random(row20seed);
			for(int k=0;k<=2;k++)
			{
				int row20DiamondIndex = row20Diamond.nextInt(39);
				row20[row20DiamondIndex] = 3;
				row20seed++;
			}

			// Set 25% Redstone (5)
			Random row20Redstone = new Random(row20seed);
			for(int k=0;k<=3;k++)
			{
				int row20RedstoneIndex = row20Redstone.nextInt(39);
				row20[row20RedstoneIndex] = 5;
				row20seed++;
			}

			//////////////////////////////////////////////////////////////////////// row21
			// Set 50% Rock (1)
			int row21seed = row20seed;
			Random row21Rock = new Random(row21seed);
			for(int k=0;k<=20;k++)
			{
				int row21RockIndex = row21Rock.nextInt(39);
				row21[row21RockIndex] = 2;
				row21seed++;
			}

			// Set 25% Diamond (3)
			Random row21Diamond = new Random(row21seed);
			for(int k=0;k<=2;k++)
			{
				int row21DiamondIndex = row21Diamond.nextInt(39);
				row21[row21DiamondIndex] = 3;
				row21seed++;
			}

			// Set 25% Redstone (5)
			Random row21Redstone = new Random(row21seed);
			for(int k=0;k<=3;k++)
			{
				int row21RedstoneIndex = row21Redstone.nextInt(39);
				row21[row21RedstoneIndex] = 5;
				row21seed++;
			}

			//////////////////////////////////////////////////////////////////////// row22
			// Set 50% Rock (1)
			int row22seed = row21seed;
			Random row22Rock = new Random(row22seed);
			for(int k=0;k<=20;k++)
			{
				int row22RockIndex = row22Rock.nextInt(39);
				row22[row22RockIndex] = 2;
				row22seed++;
			}

			// Set 25% Diamond (3)
			Random row22Diamond = new Random(row22seed);
			for(int k=0;k<=2;k++)
			{
				int row22DiamondIndex = row22Diamond.nextInt(39);
				row22[row22DiamondIndex] = 3;
				row22seed++;
			}

			// Set 25% Redstone (5)
			Random row22Redstone = new Random(row22seed);
			for(int k=0;k<=3;k++)
			{
				int row22RedstoneIndex = row22Redstone.nextInt(39);
				row22[row22RedstoneIndex] = 5;
				row22seed++;
			}

			//////////////////////////////////////////////////////////////////////// row23
			// Set 50% Rock (1)
			int row23seed = row22seed;
			Random row23Rock = new Random(row23seed);
			for(int k=0;k<=20;k++)
			{
				int row23RockIndex = row23Rock.nextInt(39);
				row23[row23RockIndex] = 2;
				row23seed++;
			}

			// Set 25% Diamond (3)
			Random row23Diamond = new Random(row23seed);
			for(int k=0;k<=2;k++)
			{
				int row23DiamondIndex = row23Diamond.nextInt(39);
				row23[row23DiamondIndex] = 3;
				row23seed++;
			}

			// Set 25% Redstone (5)
			Random row23Redstone = new Random(row23seed);
			for(int k=0;k<=3;k++)
			{
				int row23RedstoneIndex = row23Redstone.nextInt(39);
				row23[row23RedstoneIndex] = 5;
				row23seed++;
			}
		}
		else
		{
			/////////////////////
			//////Top Layer//////
			/////////////////////

			// Snow?
			snowing = false;
			Random snow = new Random();
			int willSnow = snow.nextInt(3); // 1/3 chance of snow
			if(willSnow == 1)
			{
				Arrays.fill(row5,9);
				snowing = true;
			}

			// Hill?
			Random hill = new Random();
			int doHill = hill.nextInt(20);
			if(doHill < 4)
			{
				drawLeftHill = true;
			}

			if(doHill > 3 && doHill < 7)
			{
				drawRightHill = true;
			}

			if(doHill > 10)
			{
				drawMiddleHill = true;
			}

			/////////////////////
			//Intermediate Zone//
			/////////////////////

			//////////////////////////////////////////////////////////////////////// row9
			// Set 50% dirt (1)
			Random row9Dirt = new Random();
			for(int k=0;k<=20;k++)
			{
				int row9DirtIndex = row9Dirt.nextInt(39);
				row9[row9DirtIndex] = 1;
			}

			// Set 50% rock (2)
			Random row9Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row9RockIndex = row9Rock.nextInt(39);
				row9[row9RockIndex] = 2;
			}

			//////////////////////////////////////////////////////////////////////// row10
			// Set 50% dirt (1)
			Random row10Dirt = new Random();
			for(int k=0;k<=20;k++)
			{
				int row10DirtIndex = row10Dirt.nextInt(39);
				row10[row10DirtIndex] = 1;
			}

			// Set 50% rock (2)
			Random row10Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row10RockIndex = row10Rock.nextInt(39);
				row10[row10RockIndex] = 2;
			}

			/////////////////////
			//Top Rock Zone    //
			/////////////////////

			//////////////////////////////////////////////////////////////////////// row11
			// Set 75% Rock (1)
			Random row11Rock = new Random();
			for(int k=0;k<=30;k++)
			{
				int row11RockIndex = row11Rock.nextInt(39);
				row11[row11RockIndex] = 2;
			}

			// Set 25% Coal (8)
			Random row11Coal = new Random();
			for(int k=0;k<=6;k++)
			{
				int row11CoalIndex = row11Coal.nextInt(39);
				row11[row11CoalIndex] = 8;
			}

			//////////////////////////////////////////////////////////////////////// row12
			// Set 75% Rock (1)
			Random row12Rock = new Random();
			for(int k=0;k<=30;k++)
			{
				int row12RockIndex = row12Rock.nextInt(39);
				row12[row12RockIndex] = 2;
			}

			// Set 25% Coal (8)
			Random row12Coal = new Random();
			for(int k=0;k<=6;k++)
			{
				int row12CoalIndex = row12Coal.nextInt(39);
				row12[row12CoalIndex] = 8;
			}

			//////////////////////////////////////////////////////////////////////// row13
			// Set 75% Rock (1)
			Random row13Rock = new Random();
			for(int k=0;k<=30;k++)
			{
				int row13RockIndex = row13Rock.nextInt(39);
				row13[row13RockIndex] = 2;
			}

			// Set 25% Coal (8)
			Random row13Coal = new Random();
			for(int k=0;k<=6;k++)
			{
				int row13CoalIndex = row13Coal.nextInt(39);
				row13[row13CoalIndex] = 8;
			}

			//////////////////////////////////////////////////////////////////////// row14
			// Set 75% Rock (1)
			Random row14Rock = new Random();
			for(int k=0;k<=30;k++)
			{
				int row14RockIndex = row14Rock.nextInt(39);
				row14[row14RockIndex] = 2;
			}

			// Set 25% Coal (8)
			Random row14Coal = new Random();
			for(int k=0;k<=6;k++)
			{
				int row14CoalIndex = row14Coal.nextInt(39);
				row14[row14CoalIndex] = 8;
			}

			/////////////////////
			//Mid Rock Zone    //
			/////////////////////

			//////////////////////////////////////////////////////////////////////// row15
			// Set 50% Rock (1)
			Random row15Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row15RockIndex = row15Rock.nextInt(39);
				row15[row15RockIndex] = 2;
			}

			// Set 25% Iron (4)
			Random row15Iron = new Random();
			for(int k=0;k<=2;k++)
			{
				int row15IronIndex = row15Iron.nextInt(39);
				row15[row15IronIndex] = 4;
			}

			// Set 25% Coal (8)
			Random row15Coal = new Random();
			for(int k=0;k<=3;k++)
			{
				int row15CoalIndex = row15Coal.nextInt(39);
				row15[row15CoalIndex] = 8;
			}

			//////////////////////////////////////////////////////////////////////// row16
			// Set 50% Rock (1)
			Random row16Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row16RockIndex = row16Rock.nextInt(39);
				row16[row16RockIndex] = 2;
			}

			// Set 25% Iron (4)
			Random row16Iron = new Random();
			for(int k=0;k<=2;k++)
			{
				int row16IronIndex = row16Iron.nextInt(39);
				row16[row16IronIndex] = 4;
			}

			// Set 25% Coal (8)
			Random row16Coal = new Random();
			for(int k=0;k<=3;k++)
			{
				int row16CoalIndex = row16Coal.nextInt(39);
				row16[row16CoalIndex] = 8;
			}

			//////////////////////////////////////////////////////////////////////// row17
			// Set 50% Rock (1)
			Random row17Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row17RockIndex = row17Rock.nextInt(39);
				row17[row17RockIndex] = 2;
			}

			// Set 25% Iron (4)
			Random row17Iron = new Random();
			for(int k=0;k<=2;k++)
			{
				int row17IronIndex = row17Iron.nextInt(39);
				row17[row17IronIndex] = 4;
			}

			// Set 25% Coal (8)
			Random row17Coal = new Random();
			for(int k=0;k<=3;k++)
			{
				int row17CoalIndex = row17Coal.nextInt(39);
				row17[row17CoalIndex] = 8;
			}

			//////////////////////////////////////////////////////////////////////// row18
			// Set 50% Rock (1)
			Random row18Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row18RockIndex = row18Rock.nextInt(39);
				row18[row18RockIndex] = 2;
			}

			// Set 25% Iron (4)
			Random row18Iron = new Random();
			for(int k=0;k<=2;k++)
			{
				int row18IronIndex = row18Iron.nextInt(39);
				row18[row18IronIndex] = 4;
			}

			// Set 25% Coal (8)
			Random row18Coal = new Random();
			for(int k=0;k<=3;k++)
			{
				int row18CoalIndex = row18Coal.nextInt(39);
				row18[row18CoalIndex] = 8;
			}

			/////////////////////
			//Lower Rock Zone  //
			/////////////////////

			//////////////////////////////////////////////////////////////////////// row19
			// Set 50% Rock (1)
			Random row19Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row19RockIndex = row19Rock.nextInt(39);
				row19[row19RockIndex] = 2;
			}

			// Set 25% Diamond (3)
			Random row19Diamond = new Random();
			for(int k=0;k<=2;k++)
			{
				int row19DiamondIndex = row19Diamond.nextInt(39);
				row19[row19DiamondIndex] = 3;
			}

			// Set 25% Redstone (5)
			Random row19Redstone = new Random();
			for(int k=0;k<=3;k++)
			{
				int row19RedstoneIndex = row19Redstone.nextInt(39);
				row19[row19RedstoneIndex] = 5;
			}

			//////////////////////////////////////////////////////////////////////// row20
			// Set 50% Rock (1)
			Random row20Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row20RockIndex = row20Rock.nextInt(39);
				row20[row20RockIndex] = 2;
			}

			// Set 25% Diamond (3)
			Random row20Diamond = new Random();
			for(int k=0;k<=2;k++)
			{
				int row20DiamondIndex = row20Diamond.nextInt(39);
				row20[row20DiamondIndex] = 3;
			}

			// Set 25% Redstone (5)
			Random row20Redstone = new Random();
			for(int k=0;k<=3;k++)
			{
				int row20RedstoneIndex = row20Redstone.nextInt(39);
				row20[row20RedstoneIndex] = 5;
			}

			//////////////////////////////////////////////////////////////////////// row21
			// Set 50% Rock (1)
			Random row21Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row21RockIndex = row21Rock.nextInt(39);
				row21[row21RockIndex] = 2;
			}

			// Set 25% Diamond (3)
			Random row21Diamond = new Random();
			for(int k=0;k<=2;k++)
			{
				int row21DiamondIndex = row21Diamond.nextInt(39);
				row21[row21DiamondIndex] = 3;
			}

			// Set 25% Redstone (5)
			Random row21Redstone = new Random();
			for(int k=0;k<=3;k++)
			{
				int row21RedstoneIndex = row21Redstone.nextInt(39);
				row21[row21RedstoneIndex] = 5;
			}

			//////////////////////////////////////////////////////////////////////// row22
			// Set 50% Rock (1)
			Random row22Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row22RockIndex = row22Rock.nextInt(39);
				row22[row22RockIndex] = 2;
			}

			// Set 25% Diamond (3)
			Random row22Diamond = new Random();
			for(int k=0;k<=2;k++)
			{
				int row22DiamondIndex = row22Diamond.nextInt(39);
				row22[row22DiamondIndex] = 3;
			}

			// Set 25% Redstone (5)
			Random row22Redstone = new Random();
			for(int k=0;k<=3;k++)
			{
				int row22RedstoneIndex = row22Redstone.nextInt(39);
				row22[row22RedstoneIndex] = 5;
			}

			//////////////////////////////////////////////////////////////////////// row23
			// Set 50% Rock (1)
			Random row23Rock = new Random();
			for(int k=0;k<=20;k++)
			{
				int row23RockIndex = row23Rock.nextInt(39);
				row23[row23RockIndex] = 2;
			}

			// Set 25% Diamond (3)
			Random row23Diamond = new Random();
			for(int k=0;k<=2;k++)
			{
				int row23DiamondIndex = row23Diamond.nextInt(39);
				row23[row23DiamondIndex] = 3;
			}

			// Set 25% Redstone (5)
			Random row23Redstone = new Random();
			for(int k=0;k<=3;k++)
			{
				int row23RedstoneIndex = row23Redstone.nextInt(39);
				row23[row23RedstoneIndex] = 5;
			}
		}
	}
}