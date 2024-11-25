package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtilities {
	
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	//method created to read string from excel
	public static String readStringData(int row, int col,String sheet) throws IOException
	{
		//System.out.println(row+" "+col);
		String filepath = Constants.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
		
	}
	//method created to read integer from excel
	public static String readIntigerData(int row, int col,String sheet) throws IOException
	{
		String filepath = Constants.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		//getNumericValue is reading the value as double so need to type cast it to int
		int val = (int)c.getNumericCellValue();
		// Return the string representation of val
		return String.valueOf(val);
		
	}

}
