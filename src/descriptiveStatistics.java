import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class descriptiveStatistics {
//	
//	public Map<String, Integer> countRowParser(int RowNum, int ColNum){
//		
//		
//	}
//	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Workbook workbook = WorkbookClass.readWorkbook("DataDownload.xls");
		Sheet currentSheet = workbook.getSheet("ACCESS");
		DescriptiveStatistics stats = new DescriptiveStatistics();
		System.out.println(currentSheet.getRow(0).getCell(0).getStringCellValue());
		for (int i=1; i<currentSheet.getPhysicalNumberOfRows();i++) {
			Double number = Double.parseDouble(currentSheet.getRow(i).getCell(0).getStringCellValue());
			stats.addValue(number);
		}
		double mean = stats.getMean();
		System.out.println(mean);
	}
}
