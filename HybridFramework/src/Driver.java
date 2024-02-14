import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Driver extends Keyword   // Driver is parent class Keyword is child class // Extends keyword to use inherite method and variable defined in the keyword class ino driver class
{

	public static void main(String[] args) throws IOException  // main class 
	{
		File controllerFile = new File("D:/Automation/Framework/Scenario controller/Controller.xlsx");  // here controllerfile is object of controller.xlsx file
		FileInputStream Cfile = new FileInputStream(controllerFile);    // FileInputStream use to read the data from controller.xlsx file
	   
		Sheet sh = WorkbookFactory.create(Cfile).getSheet("Sheet1"); //  sh is object of sheet. Workbookfactory is used for creating appropriate  workbook 
		// ( for .xlsx file - XSSFWorkbook class is used , for .xls file - HSSFWorkbook class is used )
		
	     int Srow = sh.getLastRowNum();      // Srow variable is storing count of total number row in Sheet1
	     System.out.println(Srow);
	     int Scol = sh.getRow(0).getLastCellNum();  // Scol variable is storing count of total number col in sheet1
		 System.out.println(Scol);
	     
	//   String [] []  Scndata= new String [Srow] [Scol];
		 
	     Driver objdriver = new Driver();  // objdriver is object of parent class i.e Driver 
	   
	     for(int S=1; S<=Srow; S++)        // This for loop is used for controller sheet
	 {
		 Row Scriptrow = sh.getRow(S);   // Scriptrow is variable deciding which row will featch the data 
		 
		 Cell Scnname = Scriptrow.getCell(0);  //Scnname is variable contain name of Scenario from first col 
		 
		 Cell Flagname = Scriptrow.getCell(1);  // Flagname Contains the flag of Scenario from second col
		 
		 String Strscnname = Scnname.toString();   // Strscnname is converted into String
		 
		 String StrFlagname = Flagname.toString();  // StrFlagname is converted into String
		 
	//	 System.out.println("Scriptnameis " + Strscnname + " and Flag is " + StrFlagname);
		 if(StrFlagname.equalsIgnoreCase("Y"))     //    We use if conditions  when Flag value of scenario is YES only that scenario will  execute. If flag value is NO that scenario will not execute.
		 {
			System.out.println("Read the script for the "+ Strscnname);  
		 
		 // Creating object of Excel Script file  
			File ScriptsFile = new File("D:/Automation/Framework/Scripts/"+Strscnname+".xlsx");  //ScriptFile is object of Scripts.xlsx file
			System.out.println("Name of scenario is "+Strscnname);
			FileInputStream Sfile = new FileInputStream(ScriptsFile);   // FileInputStream use to read the data from Scripts.xlsx file
			//objdriver = new Driver();
		   
			Sheet Scriptsh = WorkbookFactory.create(Sfile).getSheet("Sheet1");  //  Scriptsh is object of sheet. Workbookfactory is used for creating appropriate  workbook 
			// ( for .xlsx file - XSSFWorkbook class is used , for .xls file - HSSFWorkbook class is used )
			
			
		    int Scriptsrow = Scriptsh.getLastRowNum();  // Scriptsrow variable is storing count of total number row in Sheet1
		     System.out.println(Scriptsrow);
		     
	//		int Scriptscol = Scriptsh.getRow(0).getLastCellNum();  // Scriptscol variable is storing count of total number col in sheet1
	//		 System.out.println("Datafromcoulmn"+Scriptscol);
		     
	//	   String [] []  Scriptdata= new String [Scriptsrow] [Scriptscol];
		   
				for(int K=0; K<=Scriptsrow; K++)          // This for loop used for Scripts of sheet
				{
					
					Row Krow = Scriptsh.getRow(K); // Krow is variable deciding which row will featch the data
					
					Cell Strobj = Krow.getCell(1);  // Strobj is variable fetch data from 2nd col of scriptssheet(Scriptsh) and store variable Strobj
					
					Cell Skeyword = Krow.getCell(2);  // Skeyword is variable fetch data from 3rd col of scriptssheet(Scriptsh) and store variable Skeyword
					
					Cell Sxpath = Krow.getCell(3);   //   Sxpath is variable fetch data from 4th col of scriptssheet(Scriptsh) and store variable Sxpath
					
					Cell Sdata = Krow.getCell(4);    //  Sdata is variable fetch data from 5th col scriptssheet(Scriptsh) and store variable SdataS
					
					String strObject = Strobj.toString();  // Strobj is converted into string
	
					String strKeyword =Skeyword.toString(); // Skeyword is converted into string
					
					String strXpath = Sxpath.toString();   // Sxpath is converted into string
					
					String strData = Sdata.toString();    //  Sdata is converted into string
					
					switch (strKeyword)           // switch condition is used to call the method from Keyword.javafile. there is corresponding method defined against each keyword in keyword.javafile.
					{
	
					case "EnterText":             //  if the value of strKeyword is "EnterText" then EnterText method defined in keyword.javafile will be called
						if(objdriver.EnterTextt(strObject, strXpath, strData).equals("True")) // objdriver is used to call EnterText method and passing 3 parameter / values to method
						{
							System.out.println("Enter text "+strData+" Successfully");
							} 
					break;                       
					case "BtnClick" :// if the value of strKeyword is "BtnClick" then BtnClick method defined in keyword.javafile will be called
						if(objdriver.BtnClickk(strData, strXpath).equals("True"))// objdriver is used to call BtnClick method and passing 2 parameter/values to method
						{
							System.out.println("BtnClick " +strData+" Successfully");
						}
						else
						{
							System.out.println("BtnClick unsuccesfull ");
						}
				    break;
					case "LaunchURL":      //  if the value of strKeyword is "LaunchURL" then LaunchURL method defined in keyword.javafile will be called          
						 objdriver.LaunchURLl(strXpath, strData); // objdriver is used to call LaunchURL method and passing parameter / values to method
					break;   
					case "linkClick":
						if(objdriver.linkClick(strData, strXpath).equals("True"))
                        {
	                          System.out.println("linkClick" + strData +"Successfully");
                         }
						else
						{
							System.out.println("linkClick unsuccesfull");
						}
                    break;
					case "Dropdown":
						if(objdriver.Dropdown(strData, strXpath).equals("True"))
						{
							System.out.println("Dropdown" + strData +"Successfully");
						}
						else
						{
							System.out.println("Dropdown unsuccesfull");
						}
						break;
					   
					
					} // loop close for Switch statement
					
				
				 } //  End of For loop of Script sheet
			
			} //  End of If condition set for Flag (Y/N)
		 else {
			 System.out.println("Flag value for Scenario "+Strscnname+" is set for No");
		 }
			
		 } //  End of For loop of Controller sheet 
			
	} // End of main method
} //  End of Driver Class
