package commonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jxl.BooleanCell;
import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class ExcelFileHandler {
	

	


		public Object[][] readFromFile(String fileName) {
			Object[][] tableData = null;
			List<List<String>> table = new ArrayList<List<String>>();
			FileInputStream file = null;
			try {
				file = new FileInputStream(new File(fileName));

				Workbook workbook = Workbook.getWorkbook(file);
				Sheet sheet = workbook.getSheet(0);
				tableData = new String[sheet.getRows()][sheet.getColumns()];
				for (int i = 0; i < sheet.getRows(); i++) {


					List<String> rowData = new ArrayList<String>();
					for (int j = 0; j < sheet.getColumns(); j++) {

						Cell cell = sheet.getCell(j, i);
						CellType cellType = cell.getType();

						DateCell dCell = null;
						NumberCell nCell = null;
						BooleanCell bCell = null;
						LabelCell lCell = null;

						// Check the Type of the Cell contents and assign the object
						// to the appropriate reference type
						if (cellType == CellType.DATE) {
							dCell = (DateCell) cell;
							DateFormat destFormat = new SimpleDateFormat("dd/MM/yyyy");
							rowData.add(destFormat.format(dCell.getDate()));
							tableData[i][j]=destFormat.format(dCell.getDate());
							System.out.println(destFormat.format(dCell.getDate()));
							System.out.println(dCell.getDateFormat().toString());
						} else if (cellType == CellType.NUMBER) {
							nCell = (NumberCell) cell;
							rowData.add(String.valueOf(nCell.getValue()));
							tableData[i][j]=String.valueOf(nCell.getValue());

						} else if (cellType == CellType.BOOLEAN) {
							bCell = (BooleanCell) cell;
							rowData.add(String.valueOf(bCell.getValue()));
							tableData[i][j]=String.valueOf(bCell.getValue());
						} else if (cellType == CellType.LABEL) {
							lCell = (LabelCell) cell;
							rowData.add(String.valueOf(lCell.getString()));
							tableData[i][j]=String.valueOf(lCell.getString());
						}

					}
					table.add(rowData);
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
		/*public static void main(String[] args){
			ExcelFileHandler excelFileHandler = new ExcelFileHandler();
			excelFileHandler.readFromFile("C:/Users/n9951880/Desktop/login.xls");
		}*/
	}

