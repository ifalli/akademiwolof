package org.akaademiwolof.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ReadExcellFile  {
	
	public static List<RowObject> parseFile (String filename) throws IOException
	{
		File myFile = new File(filename);
        FileInputStream fis = new FileInputStream(myFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
       
        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
       
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();
        int k = 0;
        
        List<RowObject>  lineList = new ArrayList<RowObject> ();
        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            
            if (k <=1) // skip header
            {
           	 k++;
           	 continue;
            }
            List<String>  words = new ArrayList<String> ();
            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                String wrd ="";
                
                switch (cell.getCellType()) {
	                 case Cell.CELL_TYPE_STRING:
	                     System.out.print(cell.getStringCellValue() + "\t");
	                     wrd = cell.getStringCellValue();
	                     break;
	                 case Cell.CELL_TYPE_NUMERIC:
	                     System.out.print(cell.getNumericCellValue() + "\t");
	                     break;
	                 case Cell.CELL_TYPE_BOOLEAN:
	                     System.out.print(cell.getBooleanCellValue() + "\t");
	                     break;
	                 default :              
                }
                
                words.add(wrd);                 
                
            }
            lineList.add(fillRowObject(words));
        } 
        
        return lineList;
	}
	
	private static RowObject fillRowObject(List<String>  words) {
		RowObject ro = new RowObject();
		
		
		try {		
			ro.setWord(words.get(0));
			ro.setType(words.get(1));
			ro.setRoot(words.get(2));
			ro.setSense(words.get(3));
			ro.setExample(words.get(4));
			ro.setSeeAlso(words.get(5));
			ro.setSynonym(words.get(6));
			ro.setAntonym(words.get(7));
			ro.setFrench(words.get(8));
			ro.setEnglish(words.get(9));
			ro.setArabic(words.get(10));
		}catch (Exception ex ){
			System.out.print("eror during this op");
		}		
	
		return ro;
		
	}

}
