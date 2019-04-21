package FoodEnvironmentData;

public class HealthIndex {
	
	/*
	 * column description
	 
	1. FIPS
	2. State
	3. County
	4.Adult diabetes rate, 2008	PCT_DIABETES_ADULTS08
	5. Adult diabetes rate, 2013	PCT_DIABETES_ADULTS13
	6. Adult obesity rate, 2008	PCT_OBESE_ADULTS08
	7. Adult obesity rate, 2013	PCT_OBESE_ADULTS13
	8. High schoolers physically active (%), 2015*	PCT_HSPA15
	9. Recreation & fitness facilities, 2009	RECFAC09
	10. Recreation & fitness facilities, 2014	RECFAC14
	11. Recreation & fitness facilities (% change), 2009-14	PCH_RECFAC_09_14
	12. Recreation & fitness facilities/1,000 pop, 2009	RECFACPTH09
	13. Recreation & fitness facilities/1,000 pop, 2014	RECFACPTH14
	14. Recreation & fitness facilities/1,000 pop (% change), 2009-14	PCH_RECFACPTH_09_14
	
	*/
	
	String countyCode;
	String state;
	String countyName;
	String diabetesRate2008;
	String diabetesRate2013;
	String obesityRate2008;
	String obesityRate2013;
	String highSchoolPhyAct2015;
	String fitnessFac2009;
	String fitnessFac2014;
	String fitnessFac2009_2014;
	String fitnessFac2009_pop;
	String fitnessFac2014_pop;
	String fitnessFac2009_2014_pop;
	
	
	public HealthIndex(String countyCode, String state, String countyName, String diabetesRate2008,
			String diabetesRate2013, String obesityRate2008, String obesityRate2013, String highSchoolPhyAct2015,
			String fitnessFac2009, String fitnessFac2014, String fitnessFac2009_2014, String fitnessFac2009_pop,
			String fitnessFac2014_pop, String fitnessFac2009_2014_pop) {
		
		this.countyCode = countyCode;
		this.state = state;
		this.countyName = countyName;
		this.diabetesRate2008 = diabetesRate2008;
		this.diabetesRate2013 = diabetesRate2013;
		this.obesityRate2008 = obesityRate2008;
		this.obesityRate2013 = obesityRate2013;
		this.highSchoolPhyAct2015 = highSchoolPhyAct2015;
		this.fitnessFac2009 = fitnessFac2009;
		this.fitnessFac2014 = fitnessFac2014;
		this.fitnessFac2009_2014 = fitnessFac2009_2014;
		this.fitnessFac2009_pop = fitnessFac2009_pop;
		this.fitnessFac2014_pop = fitnessFac2014_pop;
		this.fitnessFac2009_2014_pop = fitnessFac2009_2014_pop;
	}


	public String getCountyCode() {
		return countyCode;
	}


	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountyName() {
		return countyName;
	}


	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}


	public String getDiabetesRate2008() {
		return diabetesRate2008;
	}


	public void setDiabetesRate2008(String diabetesRate2008) {
		this.diabetesRate2008 = diabetesRate2008;
	}


	public String getDiabetesRate2013() {
		return diabetesRate2013;
	}


	public void setDiabetesRate2013(String diabetesRate2013) {
		this.diabetesRate2013 = diabetesRate2013;
	}


	public String getObesityRate2008() {
		return obesityRate2008;
	}


	public void setObesityRate2008(String obesityRate2008) {
		this.obesityRate2008 = obesityRate2008;
	}


	public String getObesityRate2013() {
		return obesityRate2013;
	}


	public void setObesityRate2013(String obesityRate2013) {
		this.obesityRate2013 = obesityRate2013;
	}


	public String getHighSchoolPhyAct2015() {
		return highSchoolPhyAct2015;
	}


	public void setHighSchoolPhyAct2015(String highSchoolPhyAct2015) {
		this.highSchoolPhyAct2015 = highSchoolPhyAct2015;
	}


	public String getFitnessFac2009() {
		return fitnessFac2009;
	}


	public void setFitnessFac2009(String fitnessFac2009) {
		this.fitnessFac2009 = fitnessFac2009;
	}


	public String getFitnessFac2014() {
		return fitnessFac2014;
	}


	public void setFitnessFac2014(String fitnessFac2014) {
		this.fitnessFac2014 = fitnessFac2014;
	}


	public String getFitnessFac2009_2014() {
		return fitnessFac2009_2014;
	}


	public void setFitnessFac2009_2014(String fitnessFac2009_2014) {
		this.fitnessFac2009_2014 = fitnessFac2009_2014;
	}


	public String getFitnessFac2009_pop() {
		return fitnessFac2009_pop;
	}


	public void setFitnessFac2009_pop(String fitnessFac2009_pop) {
		this.fitnessFac2009_pop = fitnessFac2009_pop;
	}


	public String getFitnessFac2014_pop() {
		return fitnessFac2014_pop;
	}


	public void setFitnessFac2014_pop(String fitnessFac2014_pop) {
		this.fitnessFac2014_pop = fitnessFac2014_pop;
	}


	public String getFitnessFac2009_2014_pop() {
		return fitnessFac2009_2014_pop;
	}


	public void setFitnessFac2009_2014_pop(String fitnessFac2009_2014_pop) {
		this.fitnessFac2009_2014_pop = fitnessFac2009_2014_pop;
	}
	
	
	
	
}
