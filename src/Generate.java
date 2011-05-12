// Generate.java
// Part of TerrainGen
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
 */

import java.util.Arrays;
import java.util.Random;

public class Generate
{
	public static int seed = 0;
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
	private static int rand1, rand2, rand3, rand4, rand5, rand6, rand7, rand8, rand9, rand10;

	public static void getSeed()
	{
		seed = Expo.enterIntGUI("Enter Seed (Leave blank for random seed)");
		Generate.makeSeeds();
	}

	private static void makeSeeds()
	{
		// Makes seeds from seeds
		// See documentation for an explanation

		Random random1 = new Random(seed);
		rand1 = random1.nextInt(1001) + 0;

		Random random2 = new Random(rand1);
		rand2 = random2.nextInt(1001) + 0;

		if (rand1 > rand2)
		{
			rand3 = rand1-rand2;
		}
		else
		{
			rand3 = rand2-rand1;
		}

		Random random4 = new Random(rand3);
		rand4 = random4.nextInt(1001) + 0;

		if (rand3 > rand1)
		{
			rand5 = rand3 - rand1;
		}
		else
		{
			rand5 = rand1 - rand3;
		}

		if (rand3 > rand2)
		{
			rand6 = rand3 - rand2;
		}
		else
		{
			rand6 = rand2 - rand3;
		}

		if (rand5 > rand2)
		{
			rand7 = rand5 - rand2;
		}
		else
		{
			rand7 = rand2 - rand5;
		}

		if (rand3 > rand5)
		{
			rand8 = rand3 - rand5;
			rand8 = rand8 * rand4;
		}
		else
		{
			rand8 = rand5 - rand3;
			rand8 = rand8 * rand4;
		}

		if (rand7 > rand1)
		{
			rand9 = rand7 - rand1;
			rand9 = rand9 * rand4;
			rand9 = rand9 / 2;
		}
		else
		{
			rand9 = rand1 - rand7;
			rand9 = rand9 * rand4;
			rand9 = rand9 / 2;
		}

		if (rand9 > rand8)
		{
			rand10 = rand9 - rand8;
		}
		else
		{
			rand10 = rand8 - rand9;
		}
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

	public static void assignRandom()
	{
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

		// Set 25% Iron (2)
		Random row11Iron = new Random();
		for(int k=0;k<=10;k++)
		{
			int row11IronIndex = row11Iron.nextInt(39);
			row11[row11IronIndex] = 4;
		}

		//////////////////////////////////////////////////////////////////////// row12
		// Set 75% Rock (1)
		Random row12Rock = new Random();
		for(int k=0;k<=30;k++)
		{
			int row12RockIndex = row12Rock.nextInt(39);
			row12[row12RockIndex] = 2;
		}

		// Set 25% Iron (4)
		Random row12Iron = new Random();
		for(int k=0;k<=10;k++)
		{
			int row12IronIndex = row12Iron.nextInt(39);
			row12[row12IronIndex] = 4;
		}

		//////////////////////////////////////////////////////////////////////// row13
		// Set 75% Rock (1)
		Random row13Rock = new Random();
		for(int k=0;k<=30;k++)
		{
			int row13RockIndex = row13Rock.nextInt(39);
			row13[row13RockIndex] = 2;
		}

		// Set 25% Iron (4)
		Random row13Iron = new Random();
		for(int k=0;k<=10;k++)
		{
			int row13IronIndex = row13Iron.nextInt(39);
			row13[row13IronIndex] = 4;
		}

		//////////////////////////////////////////////////////////////////////// row14
		// Set 75% Rock (1)
		Random row14Rock = new Random();
		for(int k=0;k<=30;k++)
		{
			int row14RockIndex = row14Rock.nextInt(39);
			row14[row14RockIndex] = 2;
		}

		// Set 25% Iron (2)
		Random row14Iron = new Random();
		for(int k=0;k<=10;k++)
		{
			int row14IronIndex = row14Iron.nextInt(39);
			row14[row14IronIndex] = 4;
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

		// Set 25% Diamond (3)
		Random row15Diamond = new Random();
		for(int k=0;k<=10;k++)
		{
			int row15DiamondIndex = row15Diamond.nextInt(39);
			row15[row15DiamondIndex] = 3;
		}

		// Set 25% Redstone (5)
		Random row15Redstone = new Random();
		for(int k=0;k<=10;k++)
		{
			int row15RedstoneIndex = row15Redstone.nextInt(39);
			row15[row15RedstoneIndex] = 5;
		}

		//////////////////////////////////////////////////////////////////////// row16
		// Set 50% Rock (1)
		Random row16Rock = new Random();
		for(int k=0;k<=20;k++)
		{
			int row16RockIndex = row16Rock.nextInt(39);
			row16[row16RockIndex] = 2;
		}

		// Set 25% Diamond (3)
		Random row16Diamond = new Random();
		for(int k=0;k<=10;k++)
		{
			int row16DiamondIndex = row16Diamond.nextInt(39);
			row16[row16DiamondIndex] = 3;
		}

		// Set 25% Redstone (5)
		Random row16Redstone = new Random();
		for(int k=0;k<=10;k++)
		{
			int row16RedstoneIndex = row16Redstone.nextInt(39);
			row16[row16RedstoneIndex] = 5;
		}

		//////////////////////////////////////////////////////////////////////// row17
		// Set 50% Rock (1)
		Random row17Rock = new Random();
		for(int k=0;k<=20;k++)
		{
			int row17RockIndex = row17Rock.nextInt(39);
			row17[row17RockIndex] = 2;
		}

		// Set 25% Diamond (3)
		Random row17Diamond = new Random();
		for(int k=0;k<=10;k++)
		{
			int row17DiamondIndex = row17Diamond.nextInt(39);
			row17[row17DiamondIndex] = 3;
		}

		// Set 25% Redstone (5)
		Random row17Redstone = new Random();
		for(int k=0;k<=10;k++)
		{
			int row17RedstoneIndex = row17Redstone.nextInt(39);
			row17[row17RedstoneIndex] = 5;
		}

		//////////////////////////////////////////////////////////////////////// row18
		// Set 50% Rock (1)
		Random row18Rock = new Random();
		for(int k=0;k<=20;k++)
		{
			int row18RockIndex = row18Rock.nextInt(39);
			row18[row18RockIndex] = 2;
		}

		// Set 25% Diamond (3)
		Random row18Diamond = new Random();
		for(int k=0;k<=10;k++)
		{
			int row18DiamondIndex = row18Diamond.nextInt(39);
			row18[row18DiamondIndex] = 3;
		}

		// Set 25% Redstone (5)
		Random row18Redstone = new Random();
		for(int k=0;k<=10;k++)
		{
			int row18RedstoneIndex = row18Redstone.nextInt(39);
			row18[row18RedstoneIndex] = 5;
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
		for(int k=0;k<=10;k++)
		{
			int row19DiamondIndex = row19Diamond.nextInt(39);
			row19[row19DiamondIndex] = 3;
		}

		// Set 25% Redstone (5)
		Random row19Redstone = new Random();
		for(int k=0;k<=10;k++)
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
		for(int k=0;k<=10;k++)
		{
			int row20DiamondIndex = row20Diamond.nextInt(39);
			row20[row20DiamondIndex] = 3;
		}

		// Set 25% Redstone (5)
		Random row20Redstone = new Random();
		for(int k=0;k<=10;k++)
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
		for(int k=0;k<=10;k++)
		{
			int row21DiamondIndex = row21Diamond.nextInt(39);
			row21[row21DiamondIndex] = 3;
		}

		// Set 25% Redstone (5)
		Random row21Redstone = new Random();
		for(int k=0;k<=10;k++)
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
		for(int k=0;k<=10;k++)
		{
			int row22DiamondIndex = row22Diamond.nextInt(39);
			row22[row22DiamondIndex] = 3;
		}

		// Set 25% Redstone (5)
		Random row22Redstone = new Random();
		for(int k=0;k<=10;k++)
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
		for(int k=0;k<=10;k++)
		{
			int row23DiamondIndex = row23Diamond.nextInt(39);
			row23[row23DiamondIndex] = 3;
		}

		// Set 25% Redstone (5)
		Random row23Redstone = new Random();
		for(int k=0;k<=10;k++)
		{
			int row23RedstoneIndex = row23Redstone.nextInt(39);
			row23[row23RedstoneIndex] = 5;
		}
	}


}