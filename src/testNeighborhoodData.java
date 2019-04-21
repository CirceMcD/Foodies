import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class neighborhoodDataTest {
	
    public Workbook createTestWorkbook() throws EncryptedDocumentException, IOException {
    	//All of this creates a java workbook which should mirror the given test workbook.
    	String[] columns = {"State", "County", "Data"};
    	Workbook testworkbook = new XSSFWorkbook();
    	Sheet sheet1 = testworkbook.createSheet("Sheet1");
    	Sheet sheet2 = testworkbook.createSheet("Sheet2");
    	Row headerRow1 = sheet1.createRow(0);
    	Row headerRow2 = sheet2.createRow(0);
    	for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow1.createCell(i);
            cell.setCellValue(columns[i]);
            cell = headerRow2.createCell(i);
            cell.setCellValue(columns[i]);
        }
    	Row dataRow1 = sheet1.createRow(1); 
    	dataRow1.createCell(0).setCellValue("CA");
    	dataRow1.createCell(1).setCellValue("San Mateo");
    	dataRow1.createCell(2).setCellValue("1");
    	Row dataRow2 = sheet2.createRow(1); 
    	dataRow2.createCell(0).setCellValue("NV");
    	dataRow2.createCell(1).setCellValue("Clark");
    	dataRow2.createCell(2).setCellValue("2");
    	Row dataRow3 = sheet2.createRow(1); 
    	dataRow3.createCell(0).setCellValue("CA");
    	dataRow3.createCell(1).setCellValue("Santa Clara");
    	dataRow3.createCell(2).setCellValue("3");
    	
    	return testworkbook;
    }

	@Test
	public void testReadWorkbook() throws EncryptedDocumentException, IOException {
		neighborhoodData n1 = new neighborhoodData();
		Workbook importedWorkbook = n1.readWorkbook("test.xlsx");
		Workbook testworkbook = createTestWorkbook();
		assertSame(importedWorkbook, testworkbook);
		//assertEquals(1.0,importedWorkbook.getSheet("Sheet1").getRow(1).getCell(2).getNumericCellValue());
	}

	@Test
	public void testPrintSheet() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintSheetNames() {
		fail("Not yet implemented");
	}

}
