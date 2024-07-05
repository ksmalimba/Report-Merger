/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cyperbrotest;

/**
 *
 * @author KhayelihleMalimba
 */
public class Jobs {
 private String companyName;
    private String jobOpeningID;
    private String jobCustomerContact;
    private String customerJobID;
    private String postingTitle;
    private String jobNotes;
    private String jobOpeningStatus;
    private String jobType;
    private String accountManager;
    private String numberOfPositions;
    private String dateOpened;
    
    private String Candidates;
    
    private Candidates[] candidates;
    private int sizecandidate;
    
    public void setSizecan(int x)
    {
        this.sizecandidate=x;
    }
    
    public int getsizecan()
    {
        return this.sizecandidate;
    }
    
    
    public Candidates[] getcandidates(){
        return this.candidates;
    }
    public void setcandidates(Candidates[] x)
    {
       this.candidates=x; 
    }
    
	public String getCandidates() {
		return Candidates;
	}
	public void setCandidates(String candidates) {
		Candidates = candidates;
	}
	public Jobs(String companyName, String jobOpeningID, String jobCustomerContact, String customerJobID,
			String postingTitle, String jobNotes, String jobOpeningStatus, String jobType, String accountManager,
			String numberOfPositions, String dateOpened) {
		super();
		this.companyName = companyName;
		this.jobOpeningID = jobOpeningID;
		this.jobCustomerContact = jobCustomerContact;
		this.customerJobID = customerJobID;
		this.postingTitle = postingTitle;
		this.jobNotes = jobNotes;
		this.jobOpeningStatus = jobOpeningStatus;
		this.jobType = jobType;
		this.accountManager = accountManager;
		this.numberOfPositions = numberOfPositions;
		this.dateOpened = dateOpened;
		this.Candidates="No Candidates";
		
	}
	
	@Override
	public String toString() {
		return "Jobs [companyName=" + companyName + ", jobOpeningID=" + jobOpeningID + ", jobCustomerContact="
				+ jobCustomerContact + ", customerJobID=" + customerJobID + ", postingTitle=" + postingTitle
				+ ", jobNotes=" + jobNotes + ", jobOpeningStatus=" + jobOpeningStatus + ", jobType=" + jobType
				+ ", accountManager=" + accountManager + ", numberOfPositions=" + numberOfPositions + ", dateOpened="
				+ dateOpened + "\n Candidates \n" + Candidates + "]";
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobOpeningID() {
		return jobOpeningID;
	}
	public void setJobOpeningID(String jobOpeningID) {
		this.jobOpeningID = jobOpeningID;
	}
	public String getJobCustomerContact() {
		return jobCustomerContact;
	}
	public void setJobCustomerContact(String jobCustomerContact) {
		this.jobCustomerContact = jobCustomerContact;
	}
	public String getCustomerJobID() {
		return customerJobID;
	}
	public void setCustomerJobID(String customerJobID) {
		this.customerJobID = customerJobID;
	}
	public String getPostingTitle() {
		return postingTitle;
	}
	public void setPostingTitle(String postingTitle) {
		this.postingTitle = postingTitle;
	}
	public String getJobNotes() {
		return jobNotes;
	}
	public void setJobNotes(String jobNotes) {
		this.jobNotes = jobNotes;
	}
	public String getJobOpeningStatus() {
		return jobOpeningStatus;
	}
	public void setJobOpeningStatus(String jobOpeningStatus) {
		this.jobOpeningStatus = jobOpeningStatus;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getAccountManager() {
		return accountManager;
	}
	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}
	public String getNumberOfPositions() {
		return numberOfPositions;
	}
	public void setNumberOfPositions(String numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}
	public String getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}
    
       
}
