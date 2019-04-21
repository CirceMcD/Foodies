package FoodEnvironmentData;
import java.util.ArrayList;
import java.util.HashMap;

public class Health_Statistic {

	public HashMap<String, Double> ComputeStatistic_diabetesRateChange (ArrayList<HealthIndex> healthData) {
	
		HashMap<String, Double> average = new HashMap<>();
		HashMap<String, Double> standardDeviation = new HashMap<>();
	
		Double sum=0.0;
		Double keyNum=0.0;
		Double sd=0.0;
		
		for(HealthIndex index: healthData) {
			
			// Get required columns: state and diabetesRate
			// get increased diabetes between 2008-2013
			
						String state = index.getState(); 
						String diabetesRate2008 = index.getDiabetesRate2008();
						String diabetesRate2013 = index.getDiabetesRate2013();
						
						// Exclude empty data
						// To update existing Key, and compute the number of the same state
						// HashMap with state: average
						
			if(!state.equals("") && !diabetesRate2008.equals("")&& !diabetesRate2013.equals("")) {
				
				double diabetesRate2008_2013=0.0;
				if (average.containsKey(state)) {
					keyNum=keyNum+1;
					diabetesRate2008_2013=Double.parseDouble(diabetesRate2013)-Double.parseDouble(diabetesRate2008);
					sum=	average.get(state)+ diabetesRate2008_2013; 
					average.put(state, sum/keyNum);
					
					sd+=Math.pow(diabetesRate2008_2013-(sum/keyNum),2);
					standardDeviation.put(state, Math.sqrt(sd));
				
				}
				
				else {
					keyNum=keyNum+1;
					average.put(state,(diabetesRate2008_2013)/keyNum);
					
					
					sd+=Math.pow(diabetesRate2008_2013-(sum/keyNum),2);
					standardDeviation.put(state, Math.sqrt(sd));
					
				}				
		}	
	}	
		return average;	
	}
	
	public HashMap<String, Double> ComputeStatistic_obesityRateChange (ArrayList<HealthIndex> healthdata) {
		
		HashMap<String, Double> average = new HashMap<>();
	
	
		double sum=0.0;
		double keyNum=0.0;
		
		for(HealthIndex index: healthdata) {
			
			// get increased obesityRate between 2008-2013
			
						String state = index.getState(); 
						String obesityRate2008 = index.getObesityRate2008();
						String obesityRate2013 = index.getObesityRate2013();
						
						
			if(!state.equals("") && !obesityRate2008.equals("")&& !obesityRate2013.equals("")) {
				
				
				if (average.containsKey(state)) {
					keyNum=keyNum+1;
					sum=	average.get(state)+ (Double.parseDouble(obesityRate2013)-Double.parseDouble(obesityRate2008)); 
					average.put(state, sum/keyNum);
				
				}
				
				else {
					keyNum=keyNum+1;
					average.put(state,(Double.parseDouble(obesityRate2013)-Double.parseDouble(obesityRate2008))/keyNum);
				}
				
				
						
		}
		
	}	
		return average;	
	}
	
	
public HashMap<String, Double> ComputeStatistic_RecFac_09_14 (ArrayList<HealthIndex> healthdata) {
		
		HashMap<String, Double> average = new HashMap<>();
	
	
		Double sum=0.0;
		Double keyNum=0.0;
		
		for(HealthIndex index: healthdata) {
			
		
			
						String state = index.getState(); 
						String recFac_09_14 = index.getFitnessFac2009_2014_pop();
				
					
						
			if(!state.equals("") && !recFac_09_14.equals("")) {
				
				
				if (average.containsKey(state)) {
					keyNum=keyNum+1;
					sum=	average.get(state)+ (Double.parseDouble(recFac_09_14)); 
					average.put(state, sum/keyNum);
				
				}
				
				else {
					keyNum=keyNum+1;
					average.put(state,(Double.parseDouble(recFac_09_14)/keyNum));
				}
						
		}
		
	}	
		return average;	
	}
	
}
