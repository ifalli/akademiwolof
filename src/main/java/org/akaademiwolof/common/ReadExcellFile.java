package org.akaademiwolof.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        String code = System.getProperty("file.encoding");
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
                if(wrd.startsWith(" "))
                	wrd = wrd.substring(1);
                words.add(wrd);                 
                
            }
            
            if(words.size() > 0 && words.get(0) != null && !words.get(0).isEmpty())
            	lineList.add(fillRowObject(words));
        } 
        
        return lineList;
	}
	
	private static RowObject fillRowObject(List<String>  words) {
		RowObject ro = new RowObject();
		
		
		try {		
			ro.setWord(words.get(0));
			ro.setType(words.get(1));
			
			for(String ex : words.get(2).split(",") ){
				ro.getRoot().add(ex);
			}
			
			ro.setSense(words.get(3));
			
			
			for(String ex : words.get(4).split(",") ){
				ro.getExamples().add(ex);
			}
			
			for(String see : words.get(5).split(",") ){
				ro.getSeeAlso().add(see);
			}
			
			
			for(String sy : words.get(6).split(",") ){
				ro.getSynonyms().add(sy);
			}
			
			for(String an : words.get(7).split(",") ){
				ro.getAntonyms().add(an);
			}
			
			for(String fr : words.get(8).split(",") ){
				ro.getFrench().add(fr);
			}
			
			for(String en : words.get(9).split(",") ){
				ro.getEnglish().add(en);
			}
			
			for(String ar : words.get(10).split(",") ){
				ro.getArabic().add(ar);
			}
			
		}catch (Exception ex ){
			System.out.print("eror during this op");
		}		
	
		return ro;
		
	}

}
