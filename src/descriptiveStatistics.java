import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class descriptiveStatistics {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WorkbookClass workbook = new WorkbookClass("DataDownload.xls");
		ArrayList<Sheet> dataSheets = workbook.listDataSheets();
		dataSheets.forEach(sheet ->{
		        System.out.println(sheet);
		    }); 
		Map<String, County> counties = workbook.countyCreator();
		System.out.println(counties.get("56045").stats.keySet());
	}
}
