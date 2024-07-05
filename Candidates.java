/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cyperbrotest;

/**
 *
 * @author KhayelihleMalimba
 */
public class Candidates {
  private String CompanyName;
	private String JobOpeningID;
	private String CandidateName;
	private String PostingTitle;
	private String JobOpeningStatus;
	private String ApplicationID;
	private String CandidateID;
	private String FirstName;
	private String LastName;
	private String CandidateOwner;
	private String ApplicationStatus;
        private String AccountManager;

    public String getAccountManager() {
        return AccountManager;
    }

    public void setAccountManager(String AccountManager) {
        this.AccountManager = AccountManager;
    }
	
	public Candidates(String companyName, String jobOpeningID, String candidateName, String postingTitle,
			String jobOpeningStatus, String applicationID, String candidateID, String firstName, String lastName,
			String candidateOwner, String applicationStatus) {
		super();
		CompanyName = companyName;
		JobOpeningID = jobOpeningID;
		CandidateName = candidateName;
		PostingTitle = postingTitle;
		JobOpeningStatus = jobOpeningStatus;
		ApplicationID = applicationID;
		CandidateID = candidateID;
		FirstName = firstName;
		LastName = lastName;
		CandidateOwner = candidateOwner;
		ApplicationStatus = applicationStatus;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getJobOpeningID() {
		return JobOpeningID;
	}

	public void setJobOpeningID(String jobOpeningID) {
		JobOpeningID = jobOpeningID;
	}

	public String getCandidateName() {
		return CandidateName;
	}

	public void setCandidateName(String candidateName) {
		CandidateName = candidateName;
	}

	public String getPostingTitle() {
		return PostingTitle;
	}

	public void setPostingTitle(String postingTitle) {
		PostingTitle = postingTitle;
	}

	public String getJobOpeningStatus() {
		return JobOpeningStatus;
	}

	public void setJobOpeningStatus(String jobOpeningStatus) {
		JobOpeningStatus = jobOpeningStatus;
	}

	public String getApplicationID() {
		return ApplicationID;
	}

	public void setApplicationID(String applicationID) {
		ApplicationID = applicationID;
	}

	public String getCandidateID() {
		return CandidateID;
	}

	public void setCandidateID(String candidateID) {
		CandidateID = candidateID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCandidateOwner() {
		return CandidateOwner;
	}

	public void setCandidateOwner(String candidateOwner) {
		CandidateOwner = candidateOwner;
	}

	public String getApplicationStatus() {
		return ApplicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		ApplicationStatus = applicationStatus;
	}

	@Override
	public String toString() {
		return "Candidates [CompanyName=" + CompanyName + ", JobOpeningID=" + JobOpeningID + ", CandidateName="
				+ CandidateName + ", PostingTitle=" + PostingTitle + ", JobOpeningStatus=" + JobOpeningStatus
				+ ", ApplicationID=" + ApplicationID + ", CandidateID=" + CandidateID + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", CandidateOwner=" + CandidateOwner + ", ApplicationStatus="
				+ ApplicationStatus + "]";
	}
	
	
	
	
  
}
