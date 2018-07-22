package TabPort.GUI;

import TabPort.Objects.Request;
import TabPort.GUI.CommonTableColumn;

public class RequestReportTableModelColumn extends CommonTableColumn {
	
	/**
	 * The Lambda interface object
	 */
	private final SampleGetValueAtOperation operation;
	
	public RequestReportTableModelColumn(String description, String title, Class<?> columnClass, SampleGetValueAtOperation operation) {
		super(description, title, columnClass);
		this.operation = operation;
	}
	
	/**
	 * Lambda expression function
	 */
	public Object getValue(Request request){
		return operation.getValue(request);
	}
	
	/**
	 * Lambda expression interface
	 *
	 */
	public interface SampleGetValueAtOperation{
		Object getValue(Request request);
}

}
