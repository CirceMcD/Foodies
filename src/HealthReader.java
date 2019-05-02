import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * This class read Health data and organize the statistic values in each State. 
 *
 * create HashMap {key=state, value.. accumulated }
 * 
 *
 */
public class HealthReader {

	public ArrayList<HealthIndex> readHealth(String filename) throws EncryptedDocumentException, IOException {

		
		neighborhoodData data = new neighborhoodData();
		Workbook workbook = data.readWorkbook(filename);
		Sheet currentSheet = workbook.getSheet("HEALTH");

		//	DescriptiveStatistics stats = new DescriptiveStatistics();
	//	System.out.println(currentSheet.getRow(0).getCell(0).getStringCellValue());
//		for (int i=1; i<currentSheet.getPhysicalNumberOfRows();i++) {
//			Double number = Double.parseDouble(currentSheet.getRow(i).getCell(0).getStringCellValue());
//			stats.addValue(number);
//		}
//		double mean = stats.getMean();
//		System.out.println(mean);
//	
//		
		
		
		
		ArrayList<HealthIndex> HealthData = new ArrayList<>();

//		File file = new File(filename);
//		// read 'health' file
//
//		Scanner scanner = new Scanner(file);
//		scanner.nextLine();
//		// skip the first header

//		while (scanner.hasNextLine()) {
//
//			String healthRow = scanner.nextLine();
//			String[] healthRowData = healthRow.split(",");

			/*
			 * Take the value corresponding to each Datum and save as Array In this step,
			 * all data called as String to handle empty one.
			 */
		for (int i=1; i<currentSheet.getPhysicalNumberOfRows();i++) {
			
			String countyCode =currentSheet.getRow(i).getCell(0).getStringCellValue();
			String state=currentSheet.getRow(i).getCell(1).getStringCellValue();
			String countyName=currentSheet.getRow(i).getCell(2).getStringCellValue();
			String diabetesRate2008=currentSheet.getRow(i).getCell(3).getStringCellValue();
			String diabetesRate2013=currentSheet.getRow(i).getCell(4).getStringCellValue();
			String obesityRate2008=currentSheet.getRow(i).getCell(5).getStringCellValue();
			String obesityRate2013=currentSheet.getRow(i).getCell(6).getStringCellValue();
			String highSchoolPhyAct2015=currentSheet.getRow(i).getCell(7).getStringCellValue();
			String fitnessFac2009=currentSheet.getRow(i).getCell(8).getStringCellValue();
			String fitnessFac2014=currentSheet.getRow(i).getCell(9).getStringCellValue();
			String fitnessFac2009_2014=currentSheet.getRow(i).getCell(10).getStringCellValue();
			String fitnessFac2009_pop=currentSheet.getRow(i).getCell(11).getStringCellValue();
			String fitnessFac2014_pop=currentSheet.getRow(i).getCell(12).getStringCellValue();
			String fitnessFac2009_2014_pop=currentSheet.getRow(i).getCell(13).getStringCellValue();
			

			HealthIndex healthIndex = new HealthIndex(countyCode,  state,  countyName,  diabetesRate2008,
					 diabetesRate2013,  obesityRate2008,  obesityRate2013,  highSchoolPhyAct2015,
					 fitnessFac2009,  fitnessFac2014,  fitnessFac2009_2014,  fitnessFac2009_pop,
					 fitnessFac2014_pop,  fitnessFac2009_2014_pop);

			HealthData.add(healthIndex);
		}

		return HealthData;

	}

}
