package testing;

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


public class ExcelReader {
    public static void main(String[] args) {
        File file=new File("firstexcel.xls");
        if(!file.exists())
        {
            try {
                create();
                excelWritingwriting();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }
        }
        try {
            excelWritingwriting();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

    }

    private static void excelWritingwriting() throws WriteException, IOException, BiffException {
        Workbook aWorkBook = Workbook.getWorkbook(new File("firstexcel.xls"));
        WritableWorkbook aCopy = Workbook.createWorkbook(new File("firstexcel.xls"), aWorkBook);

        WritableSheet aCopySheet = aCopy.getSheet(0);
        Sheet sheet = aWorkBook.getSheet(0);
        
        Label anotherWritableCell = new Label(0,3,"Jeff");
        Label anotherWritableCel2 = new Label(0,4,"test");
        Label test;

//        for (int i = 0; i < sheet.getColumns(); i++){        	
//        	for (int j = 0; j < sheet.getRows(); j++){
//        		Cell [] cell = sheet.getColumn(i);
//        		int length = cell.length;
//        		test = new Label(i,j,"input below");
//        		aCopySheet.addCell(test);
//        		
//        	}	
//        }
        Cell [] cell = sheet.getColumn(0);
		int length = cell.length;
		test = new Label(0,length,"input below");
		aCopySheet.addCell(test);
        
        
        aCopySheet.addCell(anotherWritableCell);
        aCopySheet.addCell(anotherWritableCel2);
        
        
        

        
       
        aWorkBook.close();
        aCopy.write();
        aCopy.close();

    }

    private static void create() throws IOException, WriteException {

        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("firstexcel.xls"));
        writableWorkbook.createSheet("firstexcel.xls",0);

        writableWorkbook.write();
        writableWorkbook.close();
    }
}