package FireFlinkCrmTask.UtilityMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of generic methods related to File operations like property file,excel file
 * 
 * 
 * @author Muskan
 */

public class FileUtility {

	/**
	 * This method will read data from properties file and return
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public  String  readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\SeleniumCourse\\FireFlinkCrmTask\\src\\test\\resources\\CommonData1.properties");
		Properties p = new Properties();
		p.load(fis);
		String value =p.getProperty(key);	
		return value;
		
	}
	
	/**
	 * This method is used to read the data from excel file and return
	 * @param sheetName
	 * @param rowno
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
	public String readDatafROMExcelFile(String sheetName,int rowno,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		return w.getSheet(sheetName).getRow(rowno).getCell(cellNo).toString();
	}
	
	 public Object[][] readMultipleDataFromExcelFile(String sheetName) throws EncryptedDocumentException, IOException {
	  
	        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	        Workbook workbook = WorkbookFactory.create(fis);

	     
	        Sheet sheet = workbook.getSheet("Sheet2");

	        int totalRows = sheet.getLastRowNum(); 
	        int totalCells = sheet.getRow(0).getLastCellNum(); 

	       
	        Object[][] data = new Object[totalRows + 1][totalCells];

	
	        for (int i = 0; i <= totalRows; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < totalCells; j++) {
	                Cell cell = row.getCell(j);
	                data[i][j] = cell.toString();
	            }
	        }

	    
	        return data;
	    }
	}
	
	

