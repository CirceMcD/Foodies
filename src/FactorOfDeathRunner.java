// DESCRIPTION: Look at how factors in the USDA dataset correlate with health outcomes.
import java.io.FileNotFoundException;
import java.util.HashMap;
	
/**
 * This class extracts Top 10 highest correlated variable based Peason calculation with Cause_of Death ( year, disease name)
 * Although the our data analysis method is too simple to answer the question, it will present possibility. 
 * 
 *
 */
public class FactorOfDeathRunner {

	// Try to find main factors for the highest Correlation for Cause of Death
		
	public static void main(String[] args) throws FileNotFoundException, Exception {
		
		Comparison test= new Comparison("DataDownload.xls");
	
		//	1. YEAR ; 2005- 2015
		//	2. Cause of Death  ; Cancer, Stroke,Unintentional Injury,Chronic Lower Respiratory Disease,Heart Disease
		
		String year="2009";
		String Cause_of_Death="Heart Disease";
		
		HashMap<String, Double> temp_factors = new HashMap<>();
		HashMap<String, Double> factors_top = new HashMap<>();
		HashMap<String, Double> factors_bottom = new HashMap<>();
			
		for (String var : test.variableNames.keySet()) {
			double cP=test.calculatePearson(test.stateValuesMapForVariable(var), test.stateValuesMapForVariable("PCT_OBESE_ADULTS08")); 
			if(!Double.isNaN(cP)) {
				temp_factors.put(var, cP);
			}
		}
		
		factors_top=test.topRankedState(temp_factors);
		System.out.println("The highest factors correlate with Mortality of" +Cause_of_Death + " in "+ year );
		
		for(String key: factors_top.keySet()) {
			System.out.println(test.variableNames.get(key) + " :  " +  factors_top.get(key));
		}
		System.out.println(factors_bottom);
		
		for(String key: factors_bottom.keySet()) {
			System.out.println(test.variableNames.get(key) + " :  " +  factors_bottom.get(key));
			
		}
	}
}