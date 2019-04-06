import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class neighborhoodData {
    public static final String XLSX_FILE_PATH = "DataDownload.xls";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        /*
           =============================================================
           Iterating over all the sheets in the workbook
           =============================================================
        */

        System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });

        /*
           ==================================================================
           Iterating over all the rows and columns in a Sheet 
           ==================================================================
        */

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(4);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
        sheet.forEach(row -> {
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            });
            System.out.println();
        });

        // Closing the workbook
        workbook.close();
    }
}

