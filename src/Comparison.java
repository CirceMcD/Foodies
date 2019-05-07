import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;



public class Comparison {

	WorkbookClass myworkbook;

	ArrayList<Sheet> dataSheets;
	Map<String, County> counties;
	ArrayList<String> statesNames;
	Map<String, State> states;

	/**
	 * Constructor with Filename Constructor with no argument
	 * 
	 * @param filename
	 */

	public Comparison(String filename) {

		try {
			myworkbook = new WorkbookClass(filename);
			dataSheets = myworkbook.listDataSheets();
			counties = myworkbook.countyCreator();
			statesNames = myworkbook.listStates(counties);
			states = myworkbook.stateCreator(counties);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Comparison() {

	}

	
	/**
	 * This method extracts [key: State, value: mean value of input variable Sorted by key]
	 * (state) in alphabetical order
	 * 
	 * @param variable
	 * @return
	 */

	public HashMap<String, Double> stateValuesMapForVariable(String variable) {

		HashMap<String, Double> temp_states_values = new HashMap<>();
		HashMap<String, Double> states_values = new HashMap<>();

		for (String stateName : states.keySet()) {

			Double valueOfVariable = states.get(stateName).stats.get(variable).getMean();

			temp_states_values.put(stateName, valueOfVariable);

			// sort by key in alphabetically
			states_values = temp_states_values.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(
					Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		}
		return states_values;
	}

	// METHOD : get different type of parameter : String or HashMap
	/**
	 * This method extract only values in Array from HashMap [key: State, value: mean value ]
	 * 
	 * @param variable
	 * @return
	 */
	public double[] getValuesArrayforVariable(String variable) {

		double[] values = new double[stateValuesMapForVariable(variable).keySet().size()];
		int i = 0;
		for (String key : stateValuesMapForVariable(variable).keySet()) {

			values[i] = (double) (stateValuesMapForVariable(variable).get(key));
			i++;
		}

		return values;
	}

	/**
	 * The same method with getValueArrayForVariable with Map input
	 * @param inputMap
	 * @return
	 */
	public double[] getValuesArrayforVariable(HashMap<String, Double> inputMap) {

		double[] values = new double[inputMap.keySet().size()];
		int i = 0;
		for (String key : inputMap.keySet()) {

			values[i] = (double) (inputMap.get(key));
			i++;
		}

		return values;
	}	

	/**
	 * This method sorts Top 10 ranked states in particular variable
	 * 
	 * @param inputMap
	 * @return
	 */
	public HashMap<String, Double> topRankedState(HashMap<String, Double> inputMap) {
		// sort by value
		HashMap<String, Double> sortedInput = new HashMap<>();
		sortedInput = inputMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.limit(10)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		return sortedInput;
	}

	/**
	 * This method sorts Bottom 10 ranked states in particular variable
	 * 
	 * @param inputMap
	 * @return
	 */
	public HashMap<String, Double> bottomRankedState(HashMap<String, Double> inputMap) {

		// sort by value

		HashMap<String, Double> sortedInput = new HashMap<>();
		sortedInput = inputMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(10)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		return sortedInput;
	}

	/**
	 * This method return commonTopRankedState 
	 * @param variable1
	 * @param variable2
	 * @return
	 */
	public ArrayList<String> commonTopRankedState(String variable1, String variable2) {
		
		HashMap<String, Double> oneGroup=topRankedState(stateValuesMapForVariable(variable1));
		HashMap<String, Double> anotherGroup=topRankedState(stateValuesMapForVariable(variable2));
	
			
		// Array top 10 numbered state in one (Health) group and another Group
		ArrayList<String> commonState = new ArrayList<>();
		for (String key : oneGroup.keySet()) {
			if (anotherGroup.keySet().contains(key)) {
				commonState.add(key);
			}
		}
		return commonState;
	}
	
	/**
	 * 
	 * @param oneGroup
	 * @param anotherGroup
	 * @return
	 */
	public ArrayList <String> commonTopRankedState (HashMap<String, Double> one, HashMap<String, Double> another) {
		
		ArrayList<String> commonState1= new ArrayList<>();
		for (String key: one.keySet()) {
			if(another.keySet().contains(key)){
				commonState1.add(key);
			}	
		}
		return commonState1;
	}
	
	
	
	
	
	
	// UNUSED METHOD
	/**
	 * 
	 * This method computes the difference of mean value between variable 1 and
	 * variable 2 Generate HashMap < stateName, difference of value>
	 * 
	 * @param year1_variable
	 * @param year2_variable
	 * @return

	public HashMap<String, Double> computeDifference(String year1_variable, String year2_variable) {

		HashMap<String, Double> changeOfValue = new HashMap<>();

		for (String key : getValuesForVariable(year1_variable).keySet()) {

			double change = getValuesForVariable(year1_variable).get(key)
					- getValuesForVariable(year2_variable).get(key);

			changeOfValue.put(key, change);
		}
		return changeOfValue;
	}
	
		 */
	
}
