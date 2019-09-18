package com.windstream.unit;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import commonUtil.DownloadPdf;

public class PDFDownLoadTest {

	File pdfFileTestFromFile = new File(".\\src\\test\\resources\\PdfDownLoadTestFile.pdf");
	File pdfFileTestToFile = new File(".\\src\\test\\resources\\PdfDownLoadTestFileCopy.pdf");
	boolean isFileDeleted =false;
	
	String file = null;
	File copiedFile = null;
	
	@BeforeTest
	public void before() throws Exception {
		//Copy a pdf file to valdiate
		copiedFile = copyFile();
		file = copiedFile.toString();
	}
	
/**
 * This test downloads a copied pdf validates and deletes
 * @throws IOException
 * @throws ParseException
 * @throws InterruptedException
 */
	@Test
	public void testFileExistsAndDeletes() throws InterruptedException  {				
		DownloadPdf downloadPdf = new DownloadPdf();
		
		//down load the pdf to the users download directory		
		Assert.assertTrue(downloadPdf.doesFileExist(file));
		
		isFileDeleted = copiedFile.delete();
		
		Assert.assertTrue(isFileDeleted);		
	}
	
	@Test
	public void testFileDoesNotExists() throws InterruptedException {				
		DownloadPdf downloadPdf = new DownloadPdf();
		
		//down load the pdf to the users download directory		
		Assert.assertFalse(downloadPdf.doesFileExist("badfileName"));			
	}	

	/**
	 * This method copies and returns the copied pdf file
	 * @return returns the copied pdf file
	 * @throws IOException
	 */
	public File  copyFile( ) throws IOException {    	
	    Files.copy( pdfFileTestFromFile, pdfFileTestToFile );
	    return pdfFileTestToFile;
	}

}


