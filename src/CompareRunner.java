import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.HashMap;

public class CompareRunner {
	
	public static void main(String[] args) throws FileNotFoundException, Exception {
		Comparison test= new Comparison("DataDownload.xls");
		String variable1="PCT_OBESE_ADULTS08";
		String variable2="PCT_DIABETES_ADULTS08";
		
		//calculate Correlation Pearson between two variables in FoodEnviroment Data
		System.out.println("Correlation Pearson between " + variable1 +" and "+ variable2 +" : ");
		System.out.println(test.calculatePearson("PCT_OBESE_ADULTS08", "PCT_DIABETES_ADULTS08"));
	
		//Extract common State in Top10 states from  two variables in FoodEnviroment Data
		System.out.println("\nCommon States for " + variable1 +" and " + variable2 + " : ");
		System.out.println(test.commonTopRankedState("PCT_OBESE_ADULTS08", "PCT_DIABETES_ADULTS08"));
		
		
		//Make comparison between FoodEnviroment Data and Causes_of_Death Data
		DeathCodeReader dcr=new DeathCodeReader("NCHS_Causes_of_Death.csv");
		
				//	1. YEAR ; 2005- 2015
				//	2. Cause of Death  ; Cancer, Stroke,Unintentional Injury,Chronic Lower Respiratory Disease,Heart Disease
		
		String year="2008";
		String Cause_of_Death="Cancer";
		String variable3="PCT_OBESE_ADULTS08";
	
		//Extract Map for 'YEAR' and 'Cause of Death'
			//	System.out.println(dcr.computeAvgDeath(year, Cause_of_Death));
			
		//calculate Correlation Pearson between one variable from FoodEnviroment Data and another from Causes_of_Death Data
		System.out.println("\nCorrelation Pearson between " + variable3 +" and "+ Cause_of_Death +" : ");
		System.out.println(test.calculatePearson(test.stateValuesMapForVariable(variable3),dcr.computeAvgDeath(year, Cause_of_Death)));
		
		//Extract common State in Top10 states from  two variables in FoodEnviroment Data
		System.out.println("\nCommon States for " + variable3 +" and Death of" + Cause_of_Death + " : ");
		System.out.println(test.commonTopRankedState(test.topRankedState(test.stateValuesMapForVariable(variable3)), test.topRankedState(dcr.computeAvgDeath(year, Cause_of_Death))));
	}
}
