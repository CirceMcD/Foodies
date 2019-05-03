import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WorkbookClass {
	Workbook myWorkbook;
	
	public WorkbookClass(String filePath) throws EncryptedDocumentException, IOException {
		myWorkbook = WorkbookFactory.create(new File(filePath));
	}
   
    // METHOD: Print each cell in an sheet from a workbook object.  
    public void printSheet(Sheet sheet){
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        //Print out rows and columns using forEach.
        sheet.forEach(row -> {
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            });
            System.out.println();
        });
    }

    //METHOD: Print out sheet names of workbook.
    public void printSheetNames(){
    	myWorkbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });
    }
    
    //METHOD: Extracts rows as counties from all data sheets.
    public Map<String, County> countyCreator() {
    	Map<String, County> counties = new HashMap<String, County>();
    	myWorkbook.forEach(sheet -> {
    		if (isDataSheet(sheet)) {
    			ArrayList<String> columnNames = new ArrayList<>();
    			sheet.forEach(row -> {
    				//Get names of columns as an ArrayList.
				    if (row.getRowNum() == 0){
				    	for (int i=0; i<row.getPhysicalNumberOfCells(); i++) {
		    				String columnName = row.getCell(i).getStringCellValue();
		    				columnNames.add(columnName);
	    				}
				    //If not first row, add to county stats Map.
					} else {
						//Create and populate county.
	    				County tempCounty = new County(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue());
	    				for (int i=3; i<row.getPhysicalNumberOfCells(); i++) {
		    				Double number = row.getCell(i).getNumericCellValue();
		    				tempCounty.stats.put(columnNames.get(i), number);
	    				}
	    				//If county already exists, add every map value to existing county. 
	    				if (counties.containsKey(tempCounty.FIPS)) {
	    					County existingCounty = counties.get(tempCounty.FIPS);
							for (Map.Entry<String, Double> item : tempCounty.stats.entrySet()) {
							    String key = item.getKey();
							    Double value = item.getValue();
							    existingCounty.stats.put(key, value);
							}
						//If county does NOT already exist, store new county.
	    				} else {
	    					counties.put(tempCounty.FIPS, tempCounty);
	    				}
					}
    			});
    		}
    	});
     return counties;
    }

    public Boolean isDataSheet(Sheet sheet){
    	return (sheet.getRow(0).getCell(0).getStringCellValue().equals("FIPS") && 
        		sheet.getRow(0).getCell(1).getStringCellValue().equals("State") &&
        		sheet.getRow(0).getCell(2).getStringCellValue().equals("County"));
    }
   
    public ArrayList<Sheet> listDataSheets(){
    	ArrayList<Sheet> dataSheets = new ArrayList<>();
    	myWorkbook.forEach( sheet -> {
    		//System.out.println(sheet.getRow(0).getCell(0).getStringCellValue().equals("FIPS"));
        	if (sheet.getRow(0).getCell(0).getStringCellValue().equals("FIPS") && 
        		sheet.getRow(0).getCell(1).getStringCellValue().equals("State") &&
        		sheet.getRow(0).getCell(2).getStringCellValue().equals("County")) {
        		dataSheets.add(sheet);
	    	}
	    });
    	return dataSheets;
    }
}
