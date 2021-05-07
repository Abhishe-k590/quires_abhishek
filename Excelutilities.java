package genericutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilities {
	
	
	
	
	//to read the data from the excelsheet
	public String getdata(String sheetname,int rowrum,int column ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("E:\\selenium\\Project\\excel\\data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet(sheetname);
		Row r = sh.getRow(rowrum);
		Cell c = r.getCell(column);
		String value = c.getStringCellValue();
		wb.close();
		return value;
		
		
		
	}
	public void setExcelData(String SheetName,int rowNum,int colNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("E:\\selenium\\Project\\excel\\data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row r = sh.createRow(rowNum);
		Cell c = r.createCell(colNum);
	 c.setCellValue(data);
	 FileOutputStream fos=new FileOutputStream("E:\\selenium\\Project\\excel\\data.xlsx");
	 wb.write(fos);
	 wb.close();
	}

}
