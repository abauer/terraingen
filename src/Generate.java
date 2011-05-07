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
 *	6 - Gravel
 *	7 - Bedrock
 */

import java.util.Arrays;

public class Generate
{
	public static int seed = 0;
	public static int row0[] = new int[39];
	public static int row1[] = new int[39];
	public static int row2[] = new int[39];
	public static int row3[] = new int[39];
	public static int row4[] = new int[39];
	public static int row5[] = new int[39];
	public static int row6[] = new int[39];
	public static int row7[] = new int[39];
	public static int row8[] = new int[39];
	public static int row9[] = new int[39];
	public static int row10[] = new int[39];
	public static int row11[] = new int[39];
	public static int row12[] = new int[39];
	public static int row13[] = new int[39];
	public static int row14[] = new int[39];
	public static int row15[] = new int[39];
	public static int row16[] = new int[39];
	public static int row17[] = new int[39];
	public static int row18[] = new int[39];
	public static int row19[] = new int[39];
	public static int row20[] = new int[39];
	public static int row21[] = new int[39];
	public static int row22[] = new int[39];
	public static int row23[] = new int[39];
	public static int row24[] = new int[39];
	public static int row25[] = new int[39];

	public static void getSeed()
	{
		seed = Expo.enterIntGUI("Enter Seed (Leave blank for random seed)");
		Generate.seeds();
	}

	public static void seeds();
	{
		// Makes seeds from seeds
		// See documentation for an explanation

		/*
		 * Make random # from entered seed
		 *
		 * Use that # as seed for new random #
		 *
		 * If first rand. # > second rand. # --> subtract 1st # from 2nd # to get a third # (else do vice versa)
		 *
		 * Take 3rd # and make another rand # with it
		 *
		 * Compare the 3rd number to 1st and 2nd #'s (separately) and do same subtration as above to make 4th and 5th random #
		 *
		 * That should be it??
		 *
		 */
	}

	public static void draw()
	{
		Generate.setConstants();
		Generate.assignRandom();
	}

	private static void setConstants()
	{
		// First five rows with "air"
		Arrays.fill(row0,0);
		Arrays.fill(row1,0);
		Arrays.fill(row2,0);
		Arrays.fill(row3,0);
		Arrays.fill(row4,0);

		// First two land rows with "dirt"
		Arrays.fill(row5,1);
		Arrays.fill(row6,1);
		Arrays.fill(row7,1);
		Arrays.fill(row8,1);

		// Final 2 rows with "bedrock"
		Arrays.fill(row24,7);
		Arrays.fill(row25,7);

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

	private static void assignRandom()
	{
		/////////////////////
		//Intermediate Zone//
		/////////////////////

		//row9

		//row10

		/////////////////////
		//Top Rock Zone    //
		/////////////////////

		/////////////////////
		//Mid Rock Zone    //
		/////////////////////

		/////////////////////
		//Lower Rock Zone  //
		/////////////////////
	}


}