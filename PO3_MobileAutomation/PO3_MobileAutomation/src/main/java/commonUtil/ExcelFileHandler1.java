package commonUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ExcelFileHandler1 {
	

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
				System.out.println(mapObject);

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
			List<Map<String, Map<String,Object>>> table = new ArrayList<Map<String, Map<String,Object>>>();
			
			
			Cell[] tempString = (sheet.getRow(sheet.findCell("MENU/SubMenu").getRow()));//{"Customer Number","Username","Additional Customer Number(s)","Additional Username(s)","Automated test case name","Automated Y/N"};
			Map<String, Object> map = new HashMap<String, Object>();
			List<String> rowData = new ArrayList<String>();
			Map<String, Map<String,Object>> invoiceMaps = new HashMap<String, Map<String,Object>>();
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
				for (int j=1;j<cells.length-1;j++){
	//			System.out.print(cells[j].getContents());
					map.put(tempString[j].getContents(), cells[j].getContents());
				}
//				invoiceMaps.put(cells[0].getContents(), map);
			return map;
		}

		/*
		 * public static void main(String[] args){ ExcelFileHandler excelFileHandler
		 * = new ExcelFileHandler();
		 * excelFileHandler.readFromFile("C:/Users/n9951880/Desktop/login.xls");
		 * 
		 * 
		 * Cell cell = sheet.getCell(j, i); CellType cellType = cell.getType();
		 * 
		 * DateCell dCell = null; NumberCell nCell = null; BooleanCell bCell = null;
		 * LabelCell lCell = null;
		 * 
		 * // Check the Type of the Cell contents and assign the object // to the
		 * appropriate reference type if (cellType == CellType.DATE) { dCell =
		 * (DateCell) cell; DateFormat destFormat = new
		 * SimpleDateFormat("dd/MM/yyyy");
		 * rowData.add(destFormat.format(dCell.getDate()));
		 * tableData[i][j]=destFormat.format(dCell.getDate());
		 * System.out.println(destFormat.format(dCell.getDate()));
		 * System.out.println(dCell.getDateFormat().toString()); } else if (cellType
		 * == CellType.NUMBER) { nCell = (NumberCell) cell;
		 * rowData.add(String.valueOf(nCell.getValue()));
		 * tableData[i][j]=String.valueOf(nCell.getValue());
		 * 
		 * } else if (cellType == CellType.BOOLEAN) { bCell = (BooleanCell) cell;
		 * rowData.add(String.valueOf(bCell.getValue()));
		 * tableData[i][j]=String.valueOf(bCell.getValue()); } else if (cellType ==
		 * CellType.LABEL) { lCell = (LabelCell) cell;
		 * rowData.add(String.valueOf(lCell.getString()));
		 * tableData[i][j]=String.valueOf(lCell.getString()); }
		 * 
		 * }
		 */

		/*public static void main(String[] args) {
			readFromFile("C:\\Users\\n9951880\\Desktop\\testdata.xls","RC_MSS","Invoices");
		}*/
	}


