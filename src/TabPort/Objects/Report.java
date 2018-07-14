package TabPort.Objects;

public class Report {

	public final Integer queueID;
	public final String departmentID;
	public final String status;
	public final String runTime;
	
	
	public Report (Integer queueID, String departmentID ,String status, String runTime) {
        this.queueID = queueID;
        this.departmentID = departmentID;
        this.status = status;
        this.runTime = runTime;
	}

	public Integer getQueueID() {
		return queueID;
	}

	public String getdepartmentID() {
		return departmentID;
}

}
