
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;


public class CorrelationPearson {
	
	Comparison ctr;
	
	public CorrelationPearson(String filename) {
		ctr = new Comparison(filename);
		
	}
	

	public double calculatePearson (String variable1, String variable2) {
		
		double [] values1 = ctr.getValuesArrayforVariable(variable1);
		double [] values2 = ctr.getValuesArrayforVariable(variable2);
		
		double cor=0;
		try{
			if(values1.length==values2.length) {
	
			 PearsonsCorrelation pCorrelation=new PearsonsCorrelation();
			 cor=pCorrelation.correlation(values1, values2);
			 
		}
		}
		catch(Exception e) {
		System.out.println("Their sizes are different");
		}
		return cor;
	}
	
public double calculatePearson (HashMap<String, Double> one, HashMap<String, Double> another) {
		
		double [] values1 = ctr.getValuesArrayforVariable(one);
		double [] values2 = ctr.getValuesArrayforVariable(another);
		
		double cor=0;
		try{
			if(values1.length==values2.length) {
	
			 PearsonsCorrelation pCorrelation=new PearsonsCorrelation();
			 cor=pCorrelation.correlation(values1, values2);
			 
		}
		}
		catch(Exception e) {
		System.out.println("Their sizes are different");
		}
		return cor;
	}

}
