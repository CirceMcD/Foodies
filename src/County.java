import java.util.HashMap;
import java.util.Map;

//The county class is intended to hold country specific information and 
public class County {
	String State;
	String FIPS; 
	String County; 
	Map<String, Integer> stats;

//Files will need to be iterated through to add each county. 
	public County(String State, String FIPS, String County) {
		this.State = State;
		this.FIPS = FIPS; 
		this.County = County;
//Note that stats will need to be added in another function, likely under descriptive statistics. 
		this.stats = new HashMap<>();
	}
}
