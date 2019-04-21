import java.util.ArrayList;
import java.util.HashMap;

public class CompareRunner {
	
public static void main(String[] args) {
		
		HealthReader hr=new HealthReader();
		Health_Statistic hs=new Health_Statistic();
		CompareTopRanked ctr= new CompareTopRanked();
		
		try {
			ArrayList<HealthIndex> result= hr.readHealth("health.csv");
			HashMap<String, Double> average1=hs.ComputeStatistic_diabetesRateChange(result);
			HashMap<String, Double> average2=hs.ComputeStatistic_obesityRateChange(result);
			HashMap<String, Double> average3=hs.ComputeStatistic_RecFac_09_14(result);
		
		
			System.out.println(average1);
			System.out.println(average2);
			System.out.println(average3);
			
			
		HashMap<String, Double>  map1= ctr.topRankedState(average1);
		HashMap<String, Double>  map2= ctr.topRankedState(average2);
		HashMap<String, Double>  map3= ctr.topRankedState(average3);
		
		HashMap<String, Double>  map11= ctr.bottomRankedState(average1);
		HashMap<String, Double>  map22= ctr.bottomRankedState(average2);
		HashMap<String, Double>  map33= ctr.bottomRankedState(average3);
//		
//		System.out.println(map1);
//		System.out.println(map11);
		
		
		System.out.println("Common States for topRanked diabetes and obesity  :"+ ctr.commonTopRankedState(map1, map2));
		System.out.println("Common States for topRanked obesity and recreation Facility   :"+ ctr.commonTopRankedState(map2, map33));
		System.out.println("Common States for topRanked diabetes and recreation Facility   :"+ ctr.commonTopRankedState(map1, map33));
		
		
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	
}
}
	
}
