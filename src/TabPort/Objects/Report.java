package TabPort.Objects;

import java.sql.Date;

public class Report {

	public final Integer reportID;
	public final String reportName;
	public final Date startDate, endDate;
	public final String runTime;
	
	
	public Report (Integer reportID, String reportName ,Date startDate, Date endDate,String runTime) {
        this.reportID = reportID;
        this.reportName = reportName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.runTime = runTime;
	}

	public Integer getReportID() {
		return reportID;
	}

	public String getReportName() {
		return reportName;
}

}
