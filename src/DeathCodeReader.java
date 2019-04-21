import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeathCodeReader {
	/**
	 * This class read FiveLeadingCasuseOfDeath data and organize the statistic values in each State.
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */

	public ArrayList<DeathCode> readDeath(String filename) throws FileNotFoundException {

		ArrayList<DeathCode> deathCodes = new ArrayList<>();

		File file = new File(filename);
		// read 'NCHS' file

		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		// skip the first header

		while (scanner.hasNextLine()) {

			String deathRow = scanner.nextLine();
			String[] deathRowData = deathRow.split(",");

			/*
			 * Take the value corresponding to each Datum and save as Array In this step,
			 * all data called as String to handle empty one.
			 */
			String year=deathRowData[0];
			String causeOfDeath=deathRowData[1];
			String stateCode=deathRowData[3];
			String locality=deathRowData[7];
			String percentExcessDeath=deathRowData[11];

			//			try {
//				 stateCode=deathRowData[3];
//				 locality=deathRowData[7];
//				percentExcessDeath=deathRowData[11];
//			
//			} catch (Exception e) {
//				stateCode="";
//				locality="";
//				percentExcessDeath="";
//				
//			}

			DeathCode deathCode = new DeathCode(year, causeOfDeath, stateCode, locality,  percentExcessDeath);

			deathCodes.add(deathCode);
		}

		return deathCodes;

	}

}


