//This will hold all the related counties.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class State {
	String State; 
	ArrayList<County> Counties;
	Map<String, Integer> stats;
	
	public State(String State, ArrayList<County> Counties ) {
		this.State = State;
		this.Counties = Counties;
		//State specific states will need to be agregated using HashMap key from all county stats. 
		this.stats = new HashMap<>();
	}
}
