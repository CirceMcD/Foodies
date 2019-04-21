import java.util.*;
import java.util.stream.Collectors;

public class CompareTopRanked {
	// Sort top 10 ranked state
	/**
	 * 
	 * @param oneGroup
	 * @return
	 */
	
	public HashMap<String, Double> topRankedState (HashMap<String, Double> inputMap) {
		// sort by value  
		HashMap<String, Double> sortedInput =new HashMap<>();
		sortedInput = inputMap.entrySet().stream()
	    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	    .limit(10)
	    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                              (e1, e2) -> e1, LinkedHashMap::new));
		

		return sortedInput;
	}
	
	// sort Bottom 10 ranked states
	
	public HashMap<String, Double> bottomRankedState (HashMap<String, Double> inputMap) {
		
		// sort by value  
			
		HashMap<String, Double> sortedInput =new HashMap<>();
		
		sortedInput = inputMap.entrySet().stream()
	    .sorted(Map.Entry.comparingByValue())
	    .limit(10)
	    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                              (e1, e2) -> e1, LinkedHashMap::new));
		

		return sortedInput;
	}
	/**
	 * 
	 * @param oneGroup
	 * @param anotherGroup
	 * @return
	 */
	public ArrayList <String> commonTopRankedState (HashMap<String, Double> oneGroup, HashMap<String, Double> anotherGroup) {
		// Array top 10 numbered state in one (Health) group and another Group
		ArrayList<String> commonState= new ArrayList<>();
		for (String key: oneGroup.keySet()) {
			if(anotherGroup.keySet().contains(key)){
				commonState.add(key);
			}	
		}
		return commonState;
	}
}
