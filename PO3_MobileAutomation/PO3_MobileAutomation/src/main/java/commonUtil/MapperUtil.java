package commonUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MapperUtil {
    
    Map<String, Map<String, String>> mapper = new HashMap<String, Map<String, String>>();
    public static final String ROW_KEY = "ROW_";
    private int currentRow = 1;
        
    public void addRow(String rowKey, Map<String, String> row) {
        mapper.put(rowKey, row);
    } 
    
    public void createMapper(List<List<String>> lstDataTable){
        List<String> keyParameters = lstDataTable.get(0);
        int countHeaders = keyParameters.size();
        for(int row = 1;row < lstDataTable.size(); row++) {
            String rowKey =  ROW_KEY + row;
            Map<String, String> rowValues = new HashMap<String, String>();
            for(int key = 0; key < keyParameters.size(); key++ ){
                rowValues.put(keyParameters.get(key), lstDataTable.get(row).get(key));
            }
            addRow(rowKey, rowValues);
        }
    }
    public String getParameterValue(String keyParameter) {
		String result = null;
		String row = ROW_KEY + currentRow;
		Map<String, String> cellValue = mapper.get(row); 
		result = cellValue.get(keyParameter);
		return result;
	}
	
	public void nextRow() {
		currentRow++;
	}
}




