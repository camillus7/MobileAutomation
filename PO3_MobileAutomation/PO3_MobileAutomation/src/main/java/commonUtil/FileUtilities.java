package commonUtil;

import java.io.File;

public class FileUtilities {
		
	/**
	 * Determine if a file exists.
	 * @param fileName - a String that represents the file.
	 * @return true of file exists, else return false.
	 */
	public static boolean doesFileExist(String fileName) {
		String exists = "does exist";
		File f = new File(fileName);
		if(!f.exists()) { 
			exists = "does not exist";			
		} 		
			
		System.out.println("File '" + fileName + "' "+exists);
		return f.exists();
	}
	
	/**
	 * Check for a file's existence.
	 * If file is not found, continue checking until 'maxSecondsToWait' time is reached.
	 * @param fileName - A String that represents the name of the file.
	 * @param maxSecondsToWait - an int that represents the maximum number of seconds to wait (e.g. 2 = 2 seconds),
	 * before giving up.
	 * @return true if the file is found, else return false.
	 */
	public static boolean doesFileExist(String fileName, int maxSecondsToWait) {
		boolean fileExists = false;
		int seconds = 0;
		
		for (; seconds < maxSecondsToWait; seconds++) {
			if (doesFileExist(fileName)) {
				fileExists = true;
				break;
			} else {				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}				
			}
		} 
		
		String time = "'"+fileName+"' after waiting for '"+seconds+"' seconds.";
		if (seconds < maxSecondsToWait) {
			System.out.println(" found file "+time);
		} else {
			System.out.println(" giving up on waiting for file "+time);
		}
		
		return fileExists;
	}
	
	/**
	 * Check for a file's existence.
	 * If file is not found, continue checking for up to 10 seconds before giving up.
	 * @param fileName - A String that represents the name of the file.
	 * @return true if the file is found, else return false.
	 */
	public static boolean doesFileExistWaitUpToTenSeconds(String fileName) {
		return doesFileExist(fileName, 10);
	}

	/**
	 * Delete the file.
	 * @param pdfFile
	 * @return true if the found existed and was deleted, else return false.
	 */
	public static boolean deleteFile(String pdfFile) {
		File f = new File(pdfFile);
		return f.delete();		
	}

}
