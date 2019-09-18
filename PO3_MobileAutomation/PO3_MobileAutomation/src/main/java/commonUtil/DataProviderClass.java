package commonUtil;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name = "Invoices")
    public static Object[][] getData1() {
        //System.out.println(ExcelFileHandler2.readFromFile("E:\\TestData\\Testdata1.xls","CAMS TAS","Invoices"));
        return ExcelFileHandler2.readFromFile("C:\\Users\\n9951880\\Desktop\\testdata.xls","CAMS Res","Invoices");
    }
	
}
