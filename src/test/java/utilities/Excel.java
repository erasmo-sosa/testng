
 
package utilities;


import java.util.ArrayList;

public class Excel {
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		int rowCount = -1;
		String FileName = "DataProviderExample";
		String GlobalFixturesPath = "src/test/resources";
		String FilePath = System.getProperty("user.dir") + "/" 
				+ GlobalFixturesPath 
				+ FileName;
		
		ArrayList<Object[]> excelDataArrayList = new ArrayList<Object[]>();
		
		try {
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < rowCount; i++) {
			
		}
		
		return excelDataArrayList;
	}
}

