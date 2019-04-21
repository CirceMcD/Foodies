import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FoodReader {

	public ArrayList<FoodIndex> readFood(String filename) throws FileNotFoundException {

		ArrayList<FoodIndex> FoodData = new ArrayList<>();

		File file = new File(filename);
		// read 'health' file

		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		// skip the first header

		while (scanner.hasNextLine()) {

			String foodRow = scanner.nextLine();
			String[] foodRowData = foodRow.split(",");

			/*
			 * Take the value corresponding to each Datum and save as Array In this step,
			 * all data called as String to handle empty one.
			 */
			String state = foodRowData[0]; 
			String lowAccess_over_10_15 = foodRowData[1];
			String lowAccess_hh_10_15 = foodRowData[2];
			String grocery_09_14 = foodRowData[3];
			String superCenter_09_14 = foodRowData[4];
			String fastFood_09_14 = foodRowData[5];
			String fullService_09_14 = foodRowData[6];

			FoodIndex foodIndex = new FoodIndex(state, lowAccess_over_10_15, lowAccess_hh_10_15, grocery_09_14, superCenter_09_14, fastFood_09_14, fullService_09_14);
			FoodData.add(foodIndex);
		}
		return FoodData;
	}
}
