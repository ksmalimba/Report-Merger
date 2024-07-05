/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cyperbrotest;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
/**
 *
 * @author KhayelihleMalimba
 */
public class Load {
    
    private String Job;
    private String Candidate;
    private int Branch;
   private int sizec=0;
   private int size=0;
   private int jobexecluded=0;
   private int candidatesexecluded=0;
   private String Jobcodesleftout="";

    public int getJobexecluded() {
        return jobexecluded;
    }

    public void setJobexecluded(int jobexecluded) {
        this.jobexecluded = jobexecluded;
    }

    public int getCandidatesexecluded() {
        return candidatesexecluded;
    }

    public void setCandidatesexecluded(int candidatesexecluded) {
        this.candidatesexecluded = candidatesexecluded;
    }

    public String getJobcodesleftout() {
        return Jobcodesleftout;
    }

    public void setJobcodesleftout(String Jobcodesleftout) {
        this.Jobcodesleftout = Jobcodesleftout;
    }

    public int getSizec() {
        return sizec;
    }

    public void setSizec(int sizec) {
        this.sizec = sizec;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
   
     private boolean isRowMerged(Sheet sheet, Row row) {
        int rowIndex = row.getRowNum();
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
            if (mergedRegion.getFirstRow() <= rowIndex && mergedRegion.getLastRow() >= rowIndex) {
                return true;
            }
        }
        return false;
    }
   private static void populateJobOpeningRow(Row row, Jobs jobOpening) {
       row.createCell(0).setCellValue(jobOpening.getCompanyName());
        row.createCell(1).setCellValue(jobOpening.getJobOpeningID().substring(0, jobOpening.getJobOpeningID().indexOf("B")+1));
        row.createCell(2).setCellValue(jobOpening.getJobCustomerContact());
        row.createCell(3).setCellValue(jobOpening.getCustomerJobID());
        row.createCell(4).setCellValue(jobOpening.getPostingTitle());
        row.createCell(5).setCellValue(jobOpening.getJobNotes());
        row.createCell(6).setCellValue(jobOpening.getJobOpeningStatus());
        row.createCell(7).setCellValue(jobOpening.getJobType());
        row.createCell(8).setCellValue(jobOpening.getAccountManager());
         row.createCell(9).setCellValue(jobOpening.getNumberOfPositions());
        row.createCell(10).setCellValue(jobOpening.getDateOpened());
        
    }

   
    private static void populateCandidateRow(Row row, Candidates x) {
        row.createCell(0).setCellValue("");
        row.createCell(1).setCellValue("");
        row.createCell(2).setCellValue("");
        row.createCell(3).setCellValue("");
        row.createCell(4).setCellValue("");
        row.createCell(5).setCellValue("");
        row.createCell(6).setCellValue("");
        row.createCell(7).setCellValue("");
        row.createCell(8).setCellValue(x.getAccountManager());
       row.createCell(9).setCellValue("");
        row.createCell(10).setCellValue("");
       row.createCell(11).setCellValue(x.getCandidateName());
        row.createCell(12).setCellValue(x.getCandidateOwner()); 
        row.createCell(13).setCellValue(x.getApplicationStatus()); 
    }
private static String getStringCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    private static int getIntCellValue(Cell cell) {
        if (cell == null) {
            return 0;
        }

        switch (cell.getCellType()) {
            case STRING:
                try {
                    return Integer.parseInt(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    return 0; // or handle this scenario as needed
                }
            case NUMERIC:
                return (int) cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue() ? 1 : 0;
            case FORMULA:
                return (int) cell.getNumericCellValue();
            default:
                return 0;
        }
    }
    public Load(String Job, String Candidate,int Branch) throws FileNotFoundException, IOException {
        this.Job = Job;
        this.Candidate = Candidate;
        this.Branch=Branch;
        
        
           

//Job headings
String companyName;
String jobOpeningID;
String jobCustomerContact;
String customerJobID;
String postingTitle;
String jobNotes;
String jobOpeningStatus;
String jobType;
String accountManager;
String numberOfPositions;
String dateOpened;

//Candidates headings
String CompanyName;
String JobOpeningID;
String CandidateName;
String PostingTitle;
String JobOpeningStatus;
String ApplicationID;
String CandidateID;
String FirstName;
String LastName;
String CandidateOwner;
String ApplicationStatus;

ArrayList<Jobs> objJobs = new ArrayList<Jobs>();
//Jobs[] objJobs = new Jobs[3000];
ArrayList<Candidates> objcan = new ArrayList<Candidates>();
///Candidates[] objcan= new Candidates[3000];

int total=0;

int countvalues=0;
 
      

        try (FileInputStream fis = new FileInputStream(new File(this.Job));
             Workbook workbook = new HSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

        
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
             if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            while (rowIterator.hasNext() ) {
                Row row = rowIterator.next();
            if (isRowMerged(sheet, row)) {
                    System.out.println("Found a merged cell in row " + row.getRowNum() + ". Stopping.");
                    break;
            }
                companyName = getStringCellValue(row.getCell(0));
                jobOpeningID = getStringCellValue(row.getCell(1));
                jobCustomerContact = getStringCellValue(row.getCell(2));
                customerJobID = getStringCellValue(row.getCell(3));
                   postingTitle = getStringCellValue(row.getCell(4));
                 jobNotes = getStringCellValue(row.getCell(5));
                 jobOpeningStatus = getStringCellValue(row.getCell(6));
                 jobType = getStringCellValue(row.getCell(7));
                 accountManager = getStringCellValue(row.getCell(8));
                numberOfPositions = getStringCellValue(row.getCell(9));
                 dateOpened = getStringCellValue(row.getCell(10));
                   if(size!=0 && companyName.isEmpty())
                   {
                 Jobs e = new Jobs(objJobs.get(size-1).getCompanyName(), jobOpeningID, jobCustomerContact,  customerJobID,
			postingTitle,  jobNotes, jobOpeningStatus, jobType, accountManager,
                    numberOfPositions,  dateOpened);
                objJobs.add(e);
               // objJobs[size] = new Jobs(objJobs[size-1].getCompanyName(), jobOpeningID, jobCustomerContact,  customerJobID,
		//	postingTitle,  jobNotes, jobOpeningStatus, jobType, accountManager,
                  //  numberOfPositions,  dateOpened);
                   }
                   else
                   {
                       Jobs e = new Jobs(companyName, jobOpeningID, jobCustomerContact,  customerJobID,
			postingTitle,  jobNotes, jobOpeningStatus, jobType, accountManager,
                    numberOfPositions,  dateOpened);
                       objJobs.add(e);
                       // objJobs[size] = new Jobs(companyName, jobOpeningID, jobCustomerContact,  customerJobID,
			//postingTitle,  jobNotes, jobOpeningStatus, jobType, accountManager,
                    //numberOfPositions,  dateOpened);
                   }
                size++;
              
            }

            
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Candidates
      
     

        try (FileInputStream fis = new FileInputStream(new File(this.Candidate));
             Workbook workbook = new HSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
             if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                  if (isRowMerged(sheet, row)) {
                    System.out.println("Found a merged cell in row " + row.getRowNum() + ". Stopping.");
                    break;
            }
                companyName = getStringCellValue(row.getCell(0));
                JobOpeningID = getStringCellValue(row.getCell(1));
                CandidateName = getStringCellValue(row.getCell(2));
                PostingTitle = getStringCellValue(row.getCell(3));
                JobOpeningStatus = getStringCellValue(row.getCell(4));
                ApplicationID = getStringCellValue(row.getCell(5));
                CandidateID = getStringCellValue(row.getCell(6));
                FirstName = getStringCellValue(row.getCell(7));
                LastName = getStringCellValue(row.getCell(8));
                CandidateOwner = getStringCellValue(row.getCell(9));
                ApplicationStatus = getStringCellValue(row.getCell(10));

              if(sizec!=0)
                {
                    if(JobOpeningID.isEmpty())
                    {
                        Candidates e =new Candidates(companyName, objcan.get(sizec-1).getJobOpeningID(),  CandidateName,  PostingTitle,
                                JobOpeningStatus,  ApplicationID,  CandidateID, FirstName, LastName,
                                CandidateOwner, ApplicationStatus);
                        objcan.add(e);
                        //objcan[sizec]=new Candidates(companyName, objcan[sizec-1].getJobOpeningID(),  CandidateName,  PostingTitle,
                          //      JobOpeningStatus,  ApplicationID,  CandidateID, FirstName, LastName,
                            //    CandidateOwner, ApplicationStatus);
                    }
                    else
                    {
                         Candidates e =new Candidates(companyName, JobOpeningID,  CandidateName,  PostingTitle,
                                JobOpeningStatus,  ApplicationID,  CandidateID, FirstName, LastName,
                                CandidateOwner, ApplicationStatus);
                        objcan.add(e);
                    }
                    
                    
                    
                    
                }
                else
                {
                    
                    Candidates e =new Candidates(companyName, JobOpeningID,  CandidateName,  PostingTitle,
                                JobOpeningStatus,  ApplicationID,  CandidateID, FirstName, LastName,
                                CandidateOwner, ApplicationStatus);
                        objcan.add(e);
                }
               
                sizec++;
            }

            
          

        } catch (IOException e) {
            e.printStackTrace();
        }
        Workbook workbook = new XSSFWorkbook();


        Sheet sheet = workbook.createSheet("CyberPro");

    
        Row row = sheet.createRow(0);

     
        String[] headers = {
            "Company Name", "Job Opening ID", "Job Customer Contact","Customer Job ID",
            "Posting Title","Job Notes", "Job Opening Status", "Job Type", "Account Manager","Number of Positions",
             "Date Opened", "Full Name",  "Candidate Owner",
            "Application Status"
        };

        // Create cells with headers
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
        }
        int rowNum = 1;
        for(int counter=0;counter<objJobs.size();counter++)
        {
        
       
         if(objJobs.get(counter).getAccountManager().isEmpty() && objJobs.get(counter).getPostingTitle().isEmpty()&&objJobs.get(counter).getJobType().isEmpty())
         {
              this.Jobcodesleftout=this.Jobcodesleftout+objJobs.get(counter).getJobOpeningID()+", ";
             objJobs.set(counter,null);
             this.jobexecluded++;
            
            // objJobs.remove(counter);
         }
          
        
         if(objJobs.get(counter)!=null)
         {
              Row jobRow = sheet.createRow(rowNum++);
         populateJobOpeningRow(jobRow, objJobs.get(counter));
       String xc,xs; 
    
	xs=objJobs.get(counter).getJobOpeningID().substring(0, objJobs.get(counter).getJobOpeningID().indexOf("B")+1);
	for(int count =0;count<sizec;count++)
	{
		xc=objcan.get(count).getJobOpeningID().substring(0, objcan.get(count).getJobOpeningID().indexOf("B")+1);
                boolean found=true;
                if((objcan.get(count).getApplicationStatus().compareToIgnoreCase("Applied")!=0)&&(objcan.get(count).getApplicationStatus().compareToIgnoreCase("Junk Canidate")!=0)&&(objcan.get(count).getApplicationStatus().compareToIgnoreCase("Unqualified")!=0))
                {
                    found=false;
                }
              
		if(xc.compareTo(xs)==0 && found==false)
		{
                      if(this.Branch==0)
                      {
                   objcan.get(count).setAccountManager(objJobs.get(counter).getAccountManager());
                      }
                  Row candidateRow = sheet.createRow(rowNum++);
                
                populateCandidateRow(candidateRow, objcan.get(count))    ;  
			
		}	
		
	}
    
        
        }
        }
        String desktopPath = System.getProperty("user.home") + "/Desktop/job_openings_with_candidates.xlsx";
        // Write the output to a file
        System.out.println(desktopPath);
        LocalDate c = LocalDate.now();
        if(this.Branch==0)
        {
           try (FileOutputStream fileOut = new FileOutputStream(c.toString()+"-CyberPro Vac Report-CapeTown.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }   
        }
        else
        {
        try (FileOutputStream fileOut = new FileOutputStream(c.toString()+"-CyberPro Vac Report-Gauteng.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Excel file created successfully with specified column headers!");

 
}//end 
}
