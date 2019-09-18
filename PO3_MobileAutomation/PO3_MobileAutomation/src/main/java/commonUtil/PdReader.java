package commonUtil;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
public class PdReader {
    private static String INPUTFILE = "C:\\Users\\n9951880\\Downloads\\011221036Statement20150715.pdf"; //Specifying the file location.
   public static void main(String[] args) {
        try {
          
        PdfReader reader = new PdfReader(INPUTFILE);
        int n = reader.getNumberOfPages();
     
  String str=PdfTextExtractor.getTextFromPage(reader, 2); //Extracting the content from a particular page.
            System.out.println(str.contains("011221036"));
        //document.close();
        }
        catch (Throwable e) {
            System.out.println(e);
        }
   }
 }