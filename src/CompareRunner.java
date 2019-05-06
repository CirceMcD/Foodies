import java.util.HashMap;

public class CompareRunner {
	
	public static void main(String[] args) {
			
		CompareTopRanked ctr=new CompareTopRanked("DataDownload.xls");
		
		
		//hashMap diabetes difference between 2013-2008
		HashMap <String, Double> diabetesRateChange= ctr.computeDifference("PCT_DIABETES_ADULTS13", "PCT_DIABETES_ADULTS08");
		HashMap <String, Double> obeseRateChange=ctr.computeDifference("PCT_OBESE_ADULTS13", "PCT_OBESE_ADULTS08");
		HashMap <String, Double> farmersRateChange =ctr.getValuesForVariable("PCH_FMRKTPTH_09_16");
		
		HashMap<String, Double>  map1= ctr.topRankedState(diabetesRateChange);
		HashMap<String, Double>  map2= ctr.topRankedState(obeseRateChange);
		HashMap<String, Double>  map3= ctr.topRankedState(farmersRateChange);
		
		System.out.println(map1);
		
		System.out.println(map2);
		System.out.println(map3);
//		
//		System.out.println("Common States for topRanked diabetes and obesity  :"+ ctr.commonTopRankedState(map1, map2));
//		System.out.println("Common States for topRanked obesity and farmersMarketSale   :"+ ctr.commonTopRankedState(map2, map3));
//		System.out.println("Common States for topRanked diabetes and farmersMarketSale   :"+ ctr.commonTopRankedState(map1, map3));
//		
	
} 
	
}

	

