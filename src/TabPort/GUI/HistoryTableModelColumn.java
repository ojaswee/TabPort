package TabPort.GUI;

import TabPort.Objects.Request;

public class HistoryTableModelColumn extends CommonTableColumn{
private final SampleGetValueAtOperation operation;
	
	public HistoryTableModelColumn(String description, String title, Class<?> columnClass, SampleGetValueAtOperation operation) {
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