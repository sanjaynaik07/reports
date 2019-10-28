package com.dorman.bitest.comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dorman.bitest.pages.DormanSharedCorporatePage;
import com.dorman.bitest.pages.ReportProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExcelComparator {

	
	public static ExtentReports report;	
	public static ExtentTest etest;	
	public static String finalreportname;
	
	public static List<ReportProperties> rp_List = new ArrayList<ReportProperties>();
	
	
	static
	{
		System.out.println("constructor");
		 report=new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport.html");
		 System.out.println(System.getProperty("user.dir"));
		 report.loadConfig(new File(System.getProperty("user.dir")+"\\config\\extent-config.xml"));	
		}
	
	 public int col_count;
     HashMap<String, Integer> hm = new HashMap<String, Integer>();
     HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
     HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>();
     public HashMap<String, String> hm3 = new HashMap<String, String>();
     DataFormatter df = new DataFormatter();
     int i = 0;
     private final String CELL_DATA_DOES_NOT_MATCH = "Cell Data does not Match";
     
    

     private class Locator {
                     Workbook workbook;
                     Sheet sheet;
                     Row row;
                     Cell cell;
     }

     
     

     
     List<String> listOfDifferences = new ArrayList<>();
     public static String currentdate() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date(); 
		    return formatter.format(date);  
		    
	}
	
	public static void currentdateinexactformat() {
		//String s=DormanSharedCorporatePage.currentdate();
		
	//	String s1=s.replace("/", "_");
	//	String s2=s1.replace(":", "_");
		
	//	return s2;
				
	}
	//This is the starting point of the code
     public void excelcompare(String wb_source_path, String wb_destination_path, String comparison_result_path
                                     ) throws FileNotFoundException, IOException {
    	 String [] getreportname=wb_source_path.replace("\\", "#").split("#");
    	 
         etest=report.startTest("Report - NP$_Sales_RID_124");  
    	
    	 
                     System.out.println("Starting the comparision");
                     
                     etest.log(LogStatus.INFO, "Starting the comparision");
                     System.out.println("loading excel files...");
                     
                     etest.log(LogStatus.INFO, "loading excel files...");
                     long time_start = System.currentTimeMillis();
                     Workbook wb1=null;
                     
                  try { wb1 = WorkbookFactory.create(new File(wb_source_path));}
                  catch(Exception e) {
                	  System.out.println(e.getMessage());
                  }
                  Workbook wb2=null;
                  try {
                 wb2 = WorkbookFactory.create(new File(wb_destination_path));
                     }
                  catch(Exception e1) {
                	  System.out.println(e1.getMessage());
                  }
                     System.out.println("loading excel files completed!");   
                     etest.log(LogStatus.INFO, "loading excel files completed!");

                     XSSFWorkbook workbook = new XSSFWorkbook();
                     XSSFSheet sheet = workbook.createSheet(getreportname[getreportname.length-2]);
                     Row row1=   sheet.createRow(1);
                     Cell cell1=row1.createCell(0);
                     Cell cell2=row1.createCell(1);
                     finalreportname=getreportname[getreportname.length-1];
                     cell1.setCellValue("Reportname:"+getreportname[getreportname.length-2]);
                    
                   
               //      cell2.setCellValue("Execution Date and Time:"+ExcelComparator.currentdateinexactformat());
                     int rowCount = 1;

                     System.out.println("Excel Comparision Started : " + (System.currentTimeMillis() - (time_start)));
                     long time_start2 = System.currentTimeMillis()- (time_start);
                     etest.log(LogStatus.INFO, "Excel Comparision Started :"+time_start2);
                     
                
                    
                     
                    
                     for (String d : compare(wb1, wb2)) {
                    	 System.out.println(d);
                                     Row row = sheet.createRow(++rowCount);
                                     int columnCount = 0;
                                     String s[] = d.split("\\| ");
                                     for (String s1 : s) {
                                                     Cell cell = row.createCell(columnCount++);
                                                     cell.setCellValue(s1);
                                                     
                                     }
                                     etest.log(LogStatus.FAIL," " +d);
                                     // out.println(d);
                     }
                     System.out.println("Writing to Excel Begin..." + (System.currentTimeMillis() - (time_start)));
                     
                     long   time_start3 = System.currentTimeMillis() - time_start;
                    etest.log(LogStatus.INFO, "Writing to Excel Begin..."+time_start3);
                     
                  
                     try (FileOutputStream outputStream = new FileOutputStream(comparison_result_path)) {
                                     workbook.write(outputStream);
                     }
                     wb2.close();
                     wb1.close();
                     // out.close();
                     
                long     time_start4 = System.currentTimeMillis() - time_start;
                
                cell2.setCellValue("Time taken for execution in ms:"+time_start4);
                workbook.close();
                     System.out.println("Completed the comparision : took milsec" + time_start4);
                     
                     etest.log(LogStatus.INFO, "Completed the comparision : took milsec " +time_start4);
                     report.endTest(etest);
                     report.flush();
               //     
                    
     }

   

     /**
     * Utility to compare Excel File Contents cell by cell for all sheets.
     * 
      * @param wb1the
     *            workbook1 *
     * @param wb2
     *            the workbook2 *
     * @return the Excel file difference containing a flag and a list of differences
     * 
      */
     public List<String> compare(Workbook wb1, Workbook wb2) {
                     Locator loc1 = new Locator();
                     Locator loc2 = new Locator();
                     loc1.workbook = wb1;
                     loc2.workbook = wb2;
                     ExcelComparator excelComparator = new ExcelComparator();
                     excelComparator.compareSheetNames(loc1, loc2);
                     excelComparator.compareSheetData(loc1, loc2);
                     System.out.println("Excel Comparison Completed!");
                     
                    etest.log(LogStatus.INFO, "Excel Comparison Completed!");
                     
                     
         //         System.out.println(excelComparator.listOfDifferences.size() + " : Data mismatch found!");
                   
                     int datamismatch=excelComparator.listOfDifferences.size();
                     if(datamismatch>0)
                     {
                    	 etest.log(LogStatus.FAIL, "Failed");
                     etest.log(LogStatus.INFO, "Data mismatch found : " +datamismatch);
                     }
                     else
                    	 etest.log(LogStatus.PASS, "Passed"); 
                     return excelComparator.listOfDifferences;
     }

     /**
     * 
      * Compare data in all sheets.
     * 
      */
     
     
     
     public void TestMethod() {

         // This list can be formed from test method and passed here this is initialization example
    	 rp_List.clear();
         ReportProperties rp1 = new ReportProperties("Material_Details_Stage.xls", "Report 1", new Integer[] {0});
         
     /*    ReportProperties rp2 = new ReportProperties("ZWM_Slotting_Report.xlsx", "Slotting Report", new Integer[] {2,3});
       // ReportProperties rp3 = new ReportProperties("DormanSales_KPI_Analysis_OI_Sales", "NP$ by Material Group", new Integer[] { 2 });
 //ReportProperties rp3 = new ReportProperties("NP$_Sales_RID_124", "BillToCustomerSales_QA1", new Integer[] { 0 });
         
         ReportProperties rp3 = new ReportProperties("Credits_&_Debits_Issued_3_-_CORE_CHARGES_ONLY_2018.xlsx", "Report 1", new Integer[] {12});
         ReportProperties rp4 = new ReportProperties("Credits_&_Debits_Issued_2_-_LESS_CORE_CHARGES_-_USE_FOR_CDS_2018.xlsx", "Report 1", new Integer[] {12});
         ReportProperties rp5 = new ReportProperties("AZ_Program_Order_Status.xlsx", "Report 1", new Integer[] {15,16});
         ReportProperties rp6 = new ReportProperties("Sales_Order_Flow_by_Fiscal_Week.xlsx", "Report 1", new Integer[] {1});
         ReportProperties rp7 = new ReportProperties("Weekly_Rejected_Lines_Part_Status.xlsx","Report 1", new Integer[] {1,7});
         
         ReportProperties rp8 = new ReportProperties("BOM_Details_-_By_Material_or_BOM_Usage_-_Tech_Line.xlsx","Basic Part Info", new Integer[] {1});
         ReportProperties rp9 = new ReportProperties("Fill_Rates_-_Historical_-_ML.xlsx","ML", new Integer[] {1,2});
         ReportProperties rp10 = new ReportProperties("TOTAL_ORDERS_NEW_MODIFIED.xlsx","ORDERED", new Integer[] {4});
         ReportProperties rp11 = new ReportProperties("TOTAL_ORDERS_NEW_MODIFIED.xlsx","CANCELLED", new Integer[] {4});
         ReportProperties rp12 = new ReportProperties("TOTAL_ORDERS_NEW_MODIFIED.xlsx","ORDERED", new Integer[] {4});
         ReportProperties rp13 = new ReportProperties("TOTAL_ORDERS_NEW_MODIFIED.xlsx","ORDERED", new Integer[] {4});
         ReportProperties rp14 = new ReportProperties("TOTAL_ORDERS_NEW_MODIFIED.xlsx","ORDERED", new Integer[] {4});
         ReportProperties rp15 = new ReportProperties("TOTAL_ORDERS_NEW_MODIFIED.xlsx","ORDERED", new Integer[] {4});
         ReportProperties rp16 = new ReportProperties("TOTAL_ORDERS_NEW_MODIFIED.xlsx","ORDERED", new Integer[] {4});
         
         rp_List.add(rp1);

        rp_List.add(rp2);

        rp_List.add(rp3);
        rp_List.add(rp4);
        rp_List.add(rp5);
        rp_List.add(rp6);
        rp_List.add(rp7);
        rp_List.add(rp8);
        rp_List.add(rp9);
        rp_List.add(rp10);
        rp_List.add(rp11);
}*/
         rp_List.add(rp1);
     }
     public ReportProperties GetSheetProperties(String _sheet_name,String reportname) {
    	 TestMethod();

         Iterator<ReportProperties> rp_itr = rp_List.iterator();

         ReportProperties match = null;

         while (rp_itr.hasNext()) {

                         ReportProperties curr = rp_itr.next();

                         if (curr.get_reportName().contains(reportname)&& curr.get_sheetName().contains(_sheet_name)) {

                                         match = curr;

                                         break;

                         }

         }



         return match;

}
     private void compareDataInAllSheets(Locator loc1, Locator loc2) {
                     for (int i = 0; i < loc1.workbook.getNumberOfSheets(); i++) {
                                     if (loc2.workbook.getNumberOfSheets() <= i)
                                                     return;
                                     String Sheetname=loc1.workbook.getSheetName(i);
                                    
                                     loc1.sheet = loc1.workbook.getSheetAt(i);
                                     loc2.sheet = loc2.workbook.getSheetAt(i);
                                     System.out.println("Comparing sheet (" + loc1.sheet.getSheetName() + ") with sheet ("
                                                                     + loc2.sheet.getSheetName() + ")");
                                     etest.log(LogStatus.INFO, "Comparing sheet (" + loc1.sheet.getSheetName() + ") with sheet ("
                                             + loc2.sheet.getSheetName() + ")");
                                     
                                     listOfDifferences.add("Comparing sheet (" + loc1.sheet.getSheetName() + ") with sheet ("
                                                                     + loc2.sheet.getSheetName() + ")");
                                     System.out.println("Source Sheet has : " + loc1.sheet.getLastRowNum() + " records");
                                     
                                     etest.log(LogStatus.INFO, "Source Sheet has : " + loc1.sheet.getLastRowNum() + " records");
                                     
                                     System.out.println("Destination Sheet has : " + loc2.sheet.getLastRowNum() + " records");
                                     
                                     etest.log(LogStatus.INFO,"Destination Sheet has : " + loc2.sheet.getLastRowNum() + " records"); 
                                     
                                     listOfDifferences.add(String.format(Locale.ROOT, "%s | %s | %s | %s ", "Mismatch Type", "Primary Key",
                                                                     "Source_coulmn Name[Data]", "Destination_coulmn Name[Data]"));
                                    
                                     compareDataInSheet(loc1, loc2, i,GetSheetProperties(Sheetname,finalreportname));
                     }
     }

 	public void compareDataInSheet(Locator loc1, Locator loc2, int sheetIndex,ReportProperties rp) {
 		
 		
hm.clear();
hm1.clear();
hm2.clear();
hm3.clear();


	StringBuilder primaykeyvalue = new StringBuilder();
	

     Cell currCell = null;
     Row row = null;
     Iterator<Row> rItrLoc1 = loc1.workbook.getSheetAt(sheetIndex).rowIterator();

     






		
		
		// External Material Group
		
int mergedrow=1;
		
		int numberofmergedregions=loc1.workbook.getSheetAt(sheetIndex).getNumMergedRegions();
		System.out.println("number of merged regions are"+numberofmergedregions);
		 for (int i = 0; i < loc1.workbook.getSheetAt(sheetIndex).getNumMergedRegions(); i++) {
             CellRangeAddress region = loc1.workbook.getSheetAt(sheetIndex).getMergedRegion(i); //Region of merged cells
             System.out.println("row merged"+region.getLastRow()); 
             mergedrow=region.getLastRow();
		 }
         
             
		
	
		int row_number=1;
		try {
			
			while (rItrLoc1.hasNext()) {
				 row = rItrLoc1.next();
				 if ((row.getPhysicalNumberOfCells() > 1 && row.getRowNum()!=mergedrow)) {
						System.out.println("row numbers are "+row.getRowNum());
						row_number=row.getRowNum();
					break;
						/*
						 * row_number=rItrLoc4.next().getRowNum()-1;
						 * System.out.println("row_number to be stared"+row_number); break;
						 */

					}
				 }
			
			while (rItrLoc1.hasNext()) {
				 row = rItrLoc1.next();
				// System.out.println("Row number
				// "+rItrLoc4.next().getRowNum()+"has"+rItrLoc4.next().getPhysicalNumberOfCells()+"
				// cells");
				
				if ((row.getPhysicalNumberOfCells() > 1 && row.getRowNum()==mergedrow)||row.getPhysicalNumberOfCells() <= 1) {
						continue;
					/*
					 * row_number=rItrLoc4.next().getRowNum()-1;
					 * System.out.println("row_number to be stared"+row_number); break;
					 */

				} else {
	
					
					 currCell = row.getCell(rp.get_primary_keys()[0]); // This code is just to have referece to cell of index1 to retrieve the rowindex later

                     for (int i = 0; i < rp.get_primary_keys().length; i++) {

                                     primaykeyvalue.append(row.getCell(rp.get_primary_keys()[i])); // this code reads each primarykey index in current row and concatenate

                     }
					
					
					
					
					
					
					//currCell = row.getCell(primary_key_index);

					//hm.put(currCell.toString(), currCell.getRowIndex());
                    // System.out.println("primarykey(report1): "+primaykeyvalue.toString()+"-"+"index"+ currCell.getRowIndex());
                  //  System.out.println("IN R1:"+primaykeyvalue.toString()+"index:"+currCell.getRowIndex());
                    
                     hm.put(primaykeyvalue.toString(), currCell.getRowIndex());
                     primaykeyvalue.delete(0, primaykeyvalue.length());
				}
			}
		} catch (NullPointerException e) {

		}
		System.out.println("row_number is"+row_number);
		

		

		Iterator<Row> rItrLoc2 = loc2.workbook.getSheetAt(sheetIndex).rowIterator();
		try {
			while (rItrLoc2.hasNext()) {
			 row = rItrLoc2.next();
				
				if (row.getPhysicalNumberOfCells() <= 1 || row.getRowNum()==mergedrow) {
					continue;
					
				} else {
					
					 currCell = row.getCell(rp.get_primary_keys()[0]); // This code is just to have referece to cell of index1 to retrieve the rowindex later

                     for (int i = 0; i < rp.get_primary_keys().length; i++) {

                                     primaykeyvalue.append(row.getCell(rp.get_primary_keys()[i])); // this code reads each primarykey index in current row and concatenate

                     }
					
					
					
					
				//	System.out.println("primarykey(r2): "+primaykeyvalue.toString()+"-"+"index"+ currCell.getRowIndex());
                    // System.out.println("IN R1:"+primaykeyvalue.toString()+"index:"+currCell.getRowIndex());
                     
					
                     hm1.put(primaykeyvalue.toString(), currCell.getRowIndex());
					
                     primaykeyvalue.delete(0, primaykeyvalue.length());
					

					//currCell = row.getCell(primary_key_index);

					//hm1.put(currCell.toString(), currCell.getRowIndex());
				}

			}
		} catch (NullPointerException e1) {

		}

		Iterator<Cell> rItrLoc3 = loc2.workbook.getSheetAt(sheetIndex).getRow(row_number).cellIterator();

		while (rItrLoc3.hasNext()) {

			currCell = rItrLoc3.next();

			hm3.put(String.valueOf(currCell.getAddress().toString().charAt(0)), currCell.toString());

		}

		

		hm.entrySet().stream().forEach(k -> {

			hm2.put(k.getValue(), hm1.get(k.getKey()));
			

		});

		Iterator<Entry<Integer, Integer>> it2 = hm2.entrySet().iterator();

		int NA_count = 0;
		
		while (it2.hasNext()) {

			Map.Entry<Integer, Integer> itr2 = (Map.Entry<Integer, Integer>) it2.next();
			System.out.println(itr2.getKey() + " " + itr2.getValue());
			
			loc1.row = loc1.sheet.getRow(itr2.getKey());
			
			StringBuilder sb=new StringBuilder();

			try {

				loc2.row = loc2.sheet.getRow(itr2.getValue());

			} catch (NullPointerException e) {
		
				
				  for (int i = 0; i < rp.get_primary_keys().length; i++) {

					  sb.append(loc1.row.getCell(rp.get_primary_keys()[i])); // this code reads each primarykey index in current row and concatenate

      }

				String str = String.format(Locale.ROOT, " Primary Key %s is not present in Destination",

						sb);

				listOfDifferences.add(str);
				

				NA_count = NA_count + 1;

				continue;

			}
			sb.delete(0, sb.length());

			if ((loc1.row == null) || (loc2.row == null)) {

				continue;

			}

			compareDataInRow(loc1, loc2,rp);

		}

		System.out.println("Total number of N/A accounts are" + NA_count);

	}

     /*public void compareDataInSheet_woIndexing(Locator loc1, Locator loc2, int sheetIndex) {
                     Cell currCell = null;
                     Iterator<Row> rItrLoc1 = loc1.workbook.getSheetAt(sheetIndex).rowIterator();
                     Iterator<Row> rItrLoc2 = loc2.workbook.getSheetAt(sheetIndex).rowIterator();
                     Iterator<Cell> rItrLoc3 = loc2.workbook.getSheetAt(sheetIndex).getRow(0).cellIterator();
                     while (rItrLoc3.hasNext()) {
                                     currCell = rItrLoc3.next();
                                     hm3.put(String.valueOf(currCell.getAddress().toString().charAt(0)), currCell.toString());
                     }
                     while (rItrLoc1.hasNext() && rItrLoc2.hasNext()) {
                                     loc1.row = rItrLoc1.next();
                                     loc2.row = rItrLoc2.next();
                                     if ((loc1.row == null) || (loc2.row == null)) {
                                                     continue;
                                     }
                                     compareDataInRow(loc1, loc2);
                     }
     }
*/
     private void compareDataInRow(Locator loc1, Locator loc2,ReportProperties rp) {
                     // System.out.println(loc1.row.getCell(0));// debug code
                     int x = loc1.row.getLastCellNum();
                     int y = loc2.row.getLastCellNum();
                     for (int k = 0; k < x; k++) {
                                     if (y <= k)
                                                     return;
                                     loc1.cell = loc1.row.getCell(k);
                                     loc2.cell = loc2.row.getCell(k);
                                     // System.out.println(loc1.row.getCell(k));
                                     // System.out.println(loc2.row.getCell(k));
                                     if ((loc1.cell == null) || (loc2.cell == null)) {
                                                     continue;
                                     }
                                     try {
                                                     compareDataInCell(loc1, loc2,rp);
                                     }
                                     catch (OutOfMemoryError er) {
                                                     Runtime.getRuntime().gc();
                                     }
                     }
     }

     private void compareDataInCell(Locator loc1, Locator loc2,ReportProperties rp) {
                     if (isCellTypeMatches(loc1, loc2,rp)) {
                                     final CellType loc1cellType = loc1.cell.getCellType();
                                     switch (loc1cellType) {
                                     case BLANK:
                                     case STRING:
                                                     isCellContentMatchesString(loc1, loc2,rp);
                                                     break;
                                     case ERROR:
                                                     isCellContentMatches(loc1, loc2,rp);
                                                     break;
                                     case BOOLEAN:
                                                     isCellContentMatchesForBoolean(loc1, loc2,rp);
                                                     break;
                                     case FORMULA:
                                                     isCellContentMatchesForFormula(loc1, loc2,rp);
                                                     break;
                                     case NUMERIC:
                                                     if (DateUtil.isCellDateFormatted(loc1.cell)) {
                                                                     isCellContentMatchesForDate(loc1, loc2,rp);
                                                     } else {
                                                                     isCellContentMatchesForNumeric(loc1, loc2,rp);
                                                     }
                                                     break;
                                     default:
                                                     throw new IllegalStateException("Unexpected cell type: " + loc1cellType);
                                     }
                     }
     }

     /**
     * 
      * Compare number of columns in sheets.
     * 
      */
     private void compareNumberOfColumnsInSheets(Locator loc1, Locator loc2) {
                     for (int i = 0; i < loc1.workbook.getNumberOfSheets(); i++) {
                                     if (loc2.workbook.getNumberOfSheets() <= i)
                                                     return;
                                     loc1.sheet = loc1.workbook.getSheetAt(i);
                                     loc2.sheet = loc2.workbook.getSheetAt(i);
                                     Iterator<Row> ri1 = loc1.sheet.rowIterator();
                                     Iterator<Row> ri2 = loc2.sheet.rowIterator();
                                     int num1 = (ri1.hasNext()) ? ri1.next().getPhysicalNumberOfCells() : 0;
                                     int num2 = (ri2.hasNext()) ? ri2.next().getPhysicalNumberOfCells() : 0;
                                     if (num1 != num2) {
                                                     String str = String.format(Locale.ROOT, "%s\nworkbook1 | %s [%d] != workbook2 | %s [%d]",
                                                                                     "Number Of Columns does not Match ::", loc1.sheet.getSheetName(), num1,
                                                                                     loc2.sheet.getSheetName(), num2);
                                                     listOfDifferences.add(str);
                                     }
                     }
     }

     /**
     * 
      * Compare number of rows in sheets.
     * 
      */
     private void compareNumberOfRowsInSheets(Locator loc1, Locator loc2) {
                     for (int i = 0; i < loc1.workbook.getNumberOfSheets(); i++) {
                                     if (loc2.workbook.getNumberOfSheets() <= i)
                                                     return;
                                     loc1.sheet = loc1.workbook.getSheetAt(i);
                                     loc2.sheet = loc2.workbook.getSheetAt(i);
                                     int num1 = loc1.sheet.getPhysicalNumberOfRows();
                                     int num2 = loc2.sheet.getPhysicalNumberOfRows();
                                     if (num1 != num2) {
                                                     String str = String.format(Locale.ROOT, "%s\nworkbook1 | %s [%d] != workbook2 | %s [%d]",
                                                                                     "Number Of Rows does not Match ::", loc1.sheet.getSheetName(), num1, loc2.sheet.getSheetName(),
                                                                                     num2);
                                                     listOfDifferences.add(str);
                                     }
                     }
     }

     /**
     * 
      * Compare sheet data.
     * 
      */
     private void compareSheetData(Locator loc1, Locator loc2) {
                     compareNumberOfRowsInSheets(loc1, loc2);
                     compareNumberOfColumnsInSheets(loc1, loc2);
                     compareDataInAllSheets(loc1, loc2);
     }

     /**
     * 
      * Compare sheet names.
     * 
      */
     private void compareSheetNames(Locator loc1, Locator loc2) {
                     for (int i = 0; i < loc1.workbook.getNumberOfSheets(); i++) {
                                     String name1 = loc1.workbook.getSheetName(i);
                                     String name2 = (loc2.workbook.getNumberOfSheets() > i) ? loc2.workbook.getSheetName(i) : "";
                                     if (  !name1.equals(name2)) {
                                                     String str = String.format(Locale.ROOT, "%s\nworkbook1 | %s [%d] != workbook2 | %s [%d]",
                                                                                     "Name of the sheets do not match ::", name1, i + 1, name2, i + 1);
                                                     listOfDifferences.add(str);
                                     }
                     }
     }

     /**
     * 
      * Formats the message.
     * 
      */
     private void addMessage(Locator loc1, Locator loc2, String messageStart, String value1, String value2,String primarykey) {
                     String str = String.format(Locale.ROOT, "%s | %s | %s [%s] | %s [%s]", messageStart,
                    		 primarykey.toString(),
                                                     hm3.get(String.valueOf(loc1.cell.getAddress().toString().charAt(0))), value1,
                                                     hm3.get(String.valueOf(loc2.cell.getAddress().toString().charAt(0))), value2);
                     listOfDifferences.add(str);
                    
     }

     private void addMessage1(Locator loc1, Locator loc2, String messageStart, String value1, String value2,
                                     String value1_actual, String value2_actual,String primarykey) {
                     String str = String.format(Locale.ROOT, "%s | %s | %s [%s][%s] | %s [%s][%s]", messageStart,
                    		 primarykey.toString(),
                                                     hm3.get(String.valueOf(loc1.cell.getAddress().toString().charAt(0))), value1, value1_actual,
                                                     hm3.get(String.valueOf(loc2.cell.getAddress().toString().charAt(0))), value2, value2_actual);
                     listOfDifferences.add(str);
               
     }

     /**
     * 
      * Checks if cell content matches.
     * 
      */
     private void isCellContentMatchesString(Locator loc1, Locator loc2,ReportProperties rp) {
    	 
    	 StringBuilder sb=new StringBuilder();

		  for (int i = 0; i < rp.get_primary_keys().length; i++) {

			  sb.append(loc1.row.getCell(rp.get_primary_keys()[i])); // this code reads each primarykey index in current row and concatenate

}

                     i = loc1.cell.getColumnIndex();
                     String str1 = loc1.cell.getStringCellValue();
                     String str2 = loc2.cell.getStringCellValue();
                     if (!str1.equals(str2)) {
                                     addMessage(loc1, loc2, CELL_DATA_DOES_NOT_MATCH, str1, str2,sb.toString());
                     }
                     sb.delete(0, sb.length())   ;
                     
     }

     /**
     * 
      * Checks if cell content matches.
     * 
      */
     private void isCellContentMatches(Locator loc1, Locator loc2,ReportProperties rp) {
    	 StringBuilder sb=new StringBuilder();
    	 for (int i = 0; i < rp.get_primary_keys().length; i++) {

    		 sb.append(loc1.row.getCell(rp.get_primary_keys()[i])); // this code reads each primarykey index in current row and concatenate

}
                     i = loc1.cell.getColumnIndex();
                     String str1 = loc1.cell.getRichStringCellValue().getString();
                     String str2 = loc2.cell.getRichStringCellValue().getString();
                     if (!str1.equals(str2)) {
                                     addMessage(loc1, loc2, CELL_DATA_DOES_NOT_MATCH, str1, str2,sb.toString());
                     }
                     sb.delete(0, sb.length())   ;
     }

     /**
     * 
      * Checks if cell content matches for boolean.
     * 
      */
     private void isCellContentMatchesForBoolean(Locator loc1, Locator loc2,ReportProperties rp) {
    	 StringBuilder sb=new StringBuilder();
    	 for (int i = 0; i < rp.get_primary_keys().length; i++) {

             sb.append(loc1.row.getCell(rp.get_primary_keys()[i])); // this code reads each primarykey index in current row and concatenate

}
                     boolean b1 = loc1.cell.getBooleanCellValue();
                     boolean b2 = loc2.cell.getBooleanCellValue();
                     if (b1 != b2) {
                                     addMessage(loc1, loc2, CELL_DATA_DOES_NOT_MATCH, Boolean.toString(b1), Boolean.toString(b2),sb.toString());
                     }
                     sb.delete(0, sb.length()) ;
     }

     /**
     * 
      * Checks if cell content matches for date.
     * 
      */
     private void isCellContentMatchesForDate(Locator loc1, Locator loc2,ReportProperties rp) {
    	 StringBuilder sb=new StringBuilder();
    	 for (int i = 0; i < rp.get_primary_keys().length; i++) {

             sb.append(loc1.row.getCell(rp.get_primary_keys()[i])); // this code reads each primarykey index in current row and concatenate

}
                     Date date1 = loc1.cell.getDateCellValue();
                     Date date2 = loc2.cell.getDateCellValue();
                     if (!date1.equals(date2)) {
                                     addMessage(loc1, loc2, CELL_DATA_DOES_NOT_MATCH, date1.toString(), date2.toString(),sb.toString());
                     }
                     sb.delete(0, sb.length()) ;
     }

     /**
     * 
      * Checks if cell content matches for formula.
     * 
      */
     private void isCellContentMatchesForFormula(Locator loc1, Locator loc2,ReportProperties rp) {
    	 StringBuilder sb=new StringBuilder();
    	 for (int i = 0; i < rp.get_primary_keys().length; i++) {

             sb.append(loc1.row.getCell(rp.get_primary_keys()[i])); // this code reads each primarykey index in current row and concatenate

}
                     String form1 = loc1.cell.getCellFormula();
                     String form2 = loc2.cell.getCellFormula();
                     if (!form1.equals(form2)) {
                                     addMessage(loc1, loc2, CELL_DATA_DOES_NOT_MATCH, form1, form2,sb.toString());
                     }
                     sb.delete(0, sb.length()) ;
     }

     /**
     * 
      * Checks if cell content matches for numeric.
     * 
      */
     private void isCellContentMatchesForNumeric(Locator loc1, Locator loc2,ReportProperties rp) {
    	 StringBuilder sb=new StringBuilder();
    	 for (int i = 0; i < rp.get_primary_keys().length; i++) {

             sb.append(loc1.row.getCell(rp.get_primary_keys()[i])); // this code reads each primarykey index in current row and concatenate

}
                     double num1 = loc1.cell.getNumericCellValue();
                     double num2 = loc2.cell.getNumericCellValue();
                     if (num1 != num2) {
                                     addMessage(loc1, loc2, CELL_DATA_DOES_NOT_MATCH, Double.toString(num1), Double.toString(num2),sb.toString());
                     }
                     sb.delete(0, sb.length()) ;
     }

     /**
     * 
      * Checks if cell type matches.
     * 
      */
     private boolean isCellTypeMatches(Locator loc1, Locator loc2,ReportProperties rp) {
    	 
    	 StringBuilder sb=new StringBuilder();
    	 for (int i = 0; i < rp.get_primary_keys().length; i++) {

             sb.append(loc1.row.getCell(rp.get_primary_keys()[i])); // this code reads each primarykey index in current row and concatenate

}
        
                     CellType type1 = loc1.cell.getCellType();
                     CellType type2 = loc2.cell.getCellType();
                     String s1 = null;
                     String s2 = null;
                     try {
                                     s1 = df.formatCellValue(loc1.cell);
                     } catch (NullPointerException e) {
                                     s1 = null;
                     }
                     try {
                                     s2 = df.formatCellValue(loc2.cell);
                     } catch (Exception e) {
                                     s2 = null;
                     }
                     if (type1 == type2)
                                     return true;
                     addMessage1(loc1, loc2, "Cell Data-Type does not Match in :: ", type1.name(), type2.name(), s1, s2,sb.toString());
                     sb.delete(0, sb.length()) ;
                     return false;
                   
     }
	
}
