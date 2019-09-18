package commonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelFileHandler3 {
	
	private static String[] tempString1 =null; 

	//reads all rows from sheet of a excel
	
	public static Object[][] readFromFile(String fileName,String sheetName) {
		Object[][] tableData = null;
		//Map<String, Object> mapObject = null;
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File(fileName));

			
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet[] sheets = workbook.getSheets();
			Sheet sheet = null;
			for (int j = 0; j < sheets.length; j++) {
				if (sheetName.equals(sheets[j].getName())) {
					sheet = sheets[j];
					break;
				} else {
					continue;
				}
			}
            
			
			//mapObject = getAllRowData(sheet);
			//Integer rowLength = getRowCount(fileName,sheetName);

			tableData = new Object[sheet.getRows()/2][3];
			
			int k=0;
			for(int i=1;i< sheet.getRows();i++){
				Cell[]  cells = sheet.getRow(i);
				//skip if blank row
				if(cells[0].getContents().trim().equals(null) || cells[0].getContents().trim().equals(""))
				{
					continue;
				}else{
				for(int j=0;j<3;j++){
					
				        tableData[k][j] = cells[j].getContents().trim();
				        System.out.println("i: "+k+"j: "+j +"tableData : "+tableData[k][j]);
				
					}
				k=k+1;	
				i=i+1;
				}	
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}

			}

		}
		return tableData;
	}

	
	//Generic method to get the row count from a particular sheet in Excel
	public static int getRowCount(String fileName, String sheetName){
		int rowCount=0;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fis);
			//Get a particular sheet in the workbook
			Sheet s = wb.getSheet(sheetName);
			rowCount = s.getRows();				
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}catch (BiffException b) {			
			b.printStackTrace();
		}catch ( IOException io) {			
			io.printStackTrace();
		}
		return rowCount;
	}

	
}
