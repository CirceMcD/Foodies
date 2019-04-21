package FoodEnvironmentData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FoodReader {

	
	public ArrayList<HealthIndex> readFood(String filename) throws FileNotFoundException {

		ArrayList<FoodIndex> FoodData = new ArrayList<>();

		File file = new File(filename);
		// read 'health' file

		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		// skip the first header

		while (scanner.hasNextLine()) {

			String healthRow = scanner.nextLine();
			String[] healthRowData = healthRow.split(",");

			/*
			 * Take the value corresponding to each Datum and save as Array In this step,
			 * all data called as String to handle empty one.
			 */
			String state;
			
			String lowAccess_over_10_15;
			String lowAccess_hh_10_15;
			
			String grocery_09_14;
			String superCenter_09_14;
			
			String fastFood_09_14;
			String fullService_09_14;
			
			
			String countyCode=healthRowData[0];
			String state=healthRowData[1];
			String countyName=healthRowData[2];
			String diabetesRate2008=healthRowData[3];
			String diabetesRate2013=healthRowData[4];
			String obesityRate2008=healthRowData[5];
			String obesityRate2013=healthRowData[6];
			String highSchoolPhyAct2015=healthRowData[7];
			String fitnessFac2009=healthRowData[8];
			String fitnessFac2014=healthRowData[9];
			String fitnessFac2009_2014=healthRowData[10];
			String fitnessFac2009_pop=healthRowData[11];
			String fitnessFac2014_pop=healthRowData[12];
			String fitnessFac2009_2014_pop=healthRowData[13];
			

			HealthIndex healthIndex = new HealthIndex(countyCode,  state,  countyName,  diabetesRate2008,
					 diabetesRate2013,  obesityRate2008,  obesityRate2013,  highSchoolPhyAct2015,
					 fitnessFac2009,  fitnessFac2014,  fitnessFac2009_2014,  fitnessFac2009_pop,
					 fitnessFac2014_pop,  fitnessFac2009_2014_pop);

			HealthData.add(healthIndex);
		}

		return HealthData;

	}

}
