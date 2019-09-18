package commonUtil;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.webautomation.validation.Validator;

@Deprecated //see FileUtilities class
public class DownloadPdf {
	
	
	/**
	 * This method takes a file name.
	 * Validates that the file exists. 	 
	 * @param fileName
	 * @return boolean - a boolean that indicates whether or not the file exists	
	 * @throws InterruptedException 
	 */
	@Deprecated
	public boolean doesFileExist(String fileName) throws InterruptedException  {

		//This Thread.sleep(3000) gives the file time to download in the directory - do not delete
		Thread.sleep(3000);
		//assert the file exists
		File f = new File(fileName);
		if(f.exists()) { 
			System.out.println("pdfFile " + fileName + " exists");			
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {			
		}
		return f.exists();
	}	

}
