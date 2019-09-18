package commonUtil;

import java.util.ArrayList;
import java.util.List;

import org.testng.Reporter;

public class ExcelUtils_SelGrid {
	
	private static final String fileString = PropertiesUtil.getValue(PropertiesUtil.TESTDATAPATH_PROPERTY);
	
	public List<String> setTestDataSelGrid(String dataProviderMenuName, String sheetName) throws Exception {		
		
		String[][] dataInfo = new DataProviderReader_SelGrid().getTableArray(fileString, sheetName);
		
		int col = 0;

		List<String> testData = new ArrayList<String>();
		//System.out.println(dataInfo.length);
		for (int row = 0; row < dataInfo.length; row++) {
			//System.out.println((dataInfo[row][col]).trim());
				if ( (dataInfo[row][col]).trim().equalsIgnoreCase( dataProviderMenuName.trim() )) {
					
					Reporter.log("***************  Properties ***************",true);
					Reporter.log("URL :=" + PropertiesUtil.getValue(PropertiesUtil.URL_PROPERTY).toLowerCase());
					Reporter.log("                                                   ",true);
					Reporter.log("*************** Data  ***************",true);
					Reporter.log("col A - Menu : " + dataInfo[row][col],true);
					
					testData.add( (dataInfo[row][col+1]).trim() );
					Reporter.log("col B - Username : "+ dataInfo[row][col+1],true);
					
					testData.add( (dataInfo[row][col+2]).trim() );					
					Reporter.log("col C - Pwd : " + dataInfo[row][col+2],true);
					
					testData.add( (dataInfo[row][col+3]).trim() );
			
					Reporter.log("col D - additional customer parameters: " + dataInfo[row][col+3],true);
					
					testData.add( (dataInfo[row][col+4]).trim() );
					
					Reporter.log("col E - additional usernames: " + dataInfo[row][col+4],true);
					
					testData.add( (dataInfo[row][col+5]).trim() );
					
					Reporter.log("col F - external user name: " + dataInfo[row][col+5],true);
					
					testData.add( (dataInfo[row][col+6]).trim() );
					Reporter.log("col G - external user password: " + dataInfo[row][col+6],true);
					Reporter.log("                                                   ",true);
					Reporter.log("*************** Test Execution log  ***************",true);
					break;
				}
			
		}
		return testData;
	}

}
