package b;

import java.awt.AWTException;
import java.io.IOException;

import javax.xml.crypto.Data;

public class ToRead{
    //Main function is calling readExcel function to read data from excel file

   // private static String[][] Data1;

    public static void main(String[] args) throws IOException, AWTException{

    //Create an object of ReadGuru99ExcelFile class

    ExcelRead objExcelFile = new ExcelRead();

    //Prepare the path of excel file

    String filePath = "D:\\Selenium";
            objExcelFile.readExcel(filePath,"Megha.xlsx","Sheet2");
            for (int i = 0; i < 49; i++) {
               
               // String[] Data= Data1[i];
                FireF.dMethod();
              
               
                }
    }

}

