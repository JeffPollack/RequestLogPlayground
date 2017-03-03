package testing;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;

public class TExcel {

	public static void main(String[] args) {
	   File file = new File("firstexcel.xls");
	   if(!file.exists()){
		   createExcel();
	   }else{
		   writingExcel();
	   }

	}
	public static void createExcel()
	{
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File("firstexcel.xls"));
			workbook.createSheet("first sheet", 0);
			workbook.write();
			try {
				workbook.close();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writingExcel()
	{
		try {
			Workbook wb = Workbook.getWorkbook(new File("firstexcel.xls"));
			WritableWorkbook copy = Workbook.createWorkbook(new File("firstexcel.xls"), wb);
			WritableSheet copySheet = copy.getSheet(0);
			Label label1 = new Label(0,0,"My name is Jeff");
			copySheet.addCell(label1);
			copy.write();
			copy.close();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}
