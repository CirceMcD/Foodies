import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class neighborhoodData {
    public static final String XLSX_FILE_PATH = "DataDownload.xls";

    public Workbook readWorkbook() throws EncryptedDocumentException, IOException {
        Workbook workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));
    	return workbook;
    }
    
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

    public void printSheetNames(Workbook workbook){
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });
    }
}

