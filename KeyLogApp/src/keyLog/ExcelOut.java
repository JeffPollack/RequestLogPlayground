package keyLog;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.Sheet;
import jxl.Cell;

import java.io.File;
import java.io.IOException;


public class ExcelOut {
	
	ExcelOut(int column, String data) throws WriteException, IOException, BiffException{
		Workbook workbook = Workbook.getWorkbook(new File(""));
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(""));
		
		WritableSheet wbCopySheet = wbCopy.getSheet(0);
		Sheet sheet = workbook.getSheet(0);
		
		Cell [] cell = sheet.getColumn(column);
		int length = cell.length;
		Label output = new Label(column, length, data);
		
		wbCopySheet.addCell(output);
		
		workbook.close();
		wbCopy.write();
		wbCopy.close();
	}
}
