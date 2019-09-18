package com.windstream.unit;


import org.testng.Assert;
import org.testng.annotations.Test;
import commonUtil.FileUtilities;

public class FileUtilitiesTest {

	private String fileName = ".\\src\\test\\resources\\PdfDownLoadTestFile.pdf";		

	@Test
	public void testFileDoesNotExist() {			
		Assert.assertFalse(FileUtilities.doesFileExist("badfile"));			
	}	

	@Test
	public void testFileDoesExist() {			
		Assert.assertTrue(FileUtilities.doesFileExist(fileName));			
	}
	
	@Test
	public void testFileDoesNotExistWait() {			
		Assert.assertFalse(FileUtilities.doesFileExist("badfile",7));	
		
		Assert.assertFalse(FileUtilities.doesFileExistWaitUpToTenSeconds("badfile"));
	}
	
	@Test
	public void testFileDoesExistWait() {			
		Assert.assertTrue(FileUtilities.doesFileExist(fileName,5));			
	}

}


