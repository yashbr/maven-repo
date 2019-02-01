package Frameworks;


import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

    public void readExcel(String filePath,String sheetName) throws IOException{

    //Create an object of File class to open xlsx file

    File file =    new File(filePath);

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);

    Workbook workBook = null;

    //Find the file extension by splitting file name in substring  and getting only extension name

    String fileExtensionName = filePath.substring(filePath.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){

    //If it is xlsx file then create object of XSSFWorkbook class

    workBook = new XSSFWorkbook(inputStream);

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of XSSFWorkbook class

        workBook = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet workSheet = workBook.getSheet(sheetName);

    //Find number of rows in excel file

    int rowCount = workSheet.getLastRowNum()-workSheet.getFirstRowNum();

    //Create a loop over all the rows of excel file to read it

    for (int i = 0; i < rowCount+1; i++) {

        Row row = workSheet.getRow(i);

        //Create a loop to print cell values in a row

        for (int j = 0; j < row.getLastCellNum(); j++) {

            //Print Excel data in console
        	Cell cell = row.getCell(j);
        	String value = new DataFormatter().formatCellValue(cell);

            //System.out.print(row.getCell(j).getStringCellValue()+"|| ");
        	System.out.println(value+" || ");

        }

        System.out.println();
    } 

    }  

    //Main function is calling readExcel function to read data from excel file

    public static void main(String...strings) throws IOException{

    //Create an object of ReadGuru99ExcelFile class

    ReadExcelFile objExcelFile = new ReadExcelFile();

    //Prepare the path of excel file

    String filePath = System.getProperty("user.dir");

    //Call read file method of the class to read data

    objExcelFile.readExcel(filePath+"\\selenium-test-data.xlsx","test-data");

    }

}