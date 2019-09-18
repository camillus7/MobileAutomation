package commonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelFileHandler4 {
	
	private static String[] tempString1 =null; 

	public static Object[][] readFromFile(String fileName,String sheetName,String searchText) {
		Object[][] tableData = null;
		Map<String, Object> mapObject = null;
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

			mapObject = getRowData(sheet,searchText);
			//System.out.println(mapObject);
			//tableData = new Object[1][tempString1.length];
			tableData = new Object[1][4];
			for(int i=0;i< 1;i++){
				//for(int j=0;j<tempString1.length;j++){
					for(int j=0;j<4;j++){
				//	System.out.println("tempString1[j]"+tempString1[j]);
				//	System.out.println("mapObject.get(tempString1[j]) "+mapObject.get(tempString1[j]));
					tableData[i][j] = mapObject.get(tempString1[j]);
				System.out.println("i: "+i+"j: "+j +"tableData : "+tableData[i][j]);
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

	private static Map<String,Object> getRowData(Sheet sheet,String searchText) {
		//List<Map<String, Map<String,Object>>> table = new ArrayList<Map<String, Map<String,Object>>>();
		
		
		Cell[] tempString = (sheet.getRow(sheet.findCell("MENU/SubMenu").getRow()));//{"Customer Number","Username","Additional Customer Number(s)","Additional Username(s)","Automated test case name","Automated Y/N"};
		Map<String, Object> map = new HashMap<String, Object>();
		tempString1 = new String[tempString.length];
		//List<String> rowData = new ArrayList<String>();
		//Map<String, Map<String,Object>> invoiceMaps = new HashMap<String, Map<String,Object>>();
		int rowId = 0;
		boolean isfound=true;
		do{
			if(searchText.equals(sheet.findCell(searchText).getContents())){
				rowId = sheet.findCell(searchText).getRow();
				isfound = false;
			}
		}
		while(isfound);
		
			Cell[]  cells = sheet.getRow(rowId);
			for (int j=1;j<cells.length;j++){
				tempString1[j] = tempString[j].getContents();
			System.out.println("column :"+tempString[j].getContents().trim()+"Value: "+cells[j].getContents());
				map.put(tempString[j].getContents().trim(), cells[j].getContents().trim());
			}
//			invoiceMaps.put(cells[0].getContents(), map);
		return map;
	}

	
}
