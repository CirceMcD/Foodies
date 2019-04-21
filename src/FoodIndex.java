public class FoodIndex {
	/*
	 * column required 
	 * Access and Proximity to Grocery Store 
	 *col_f 6 : ACCESS Overall,Population, low access to store (% change), 2010 -15, PCH_LACCESS_POP_10_15
	 *col_p 16 : ACCESS, Households, no car & low access to store (% change), 2010 - 15, PCH_LACCESS_HHNV_10_15
	 * 
	 * Store Availability 
	 * col_i 9:Grocery stores/1,000 pop (% change), 2009-14,PCH_GROCPTH_09_14
	 * col_o 15:Supercenters & club stores/1,000 pop (% change), 2007-14 PCH_SUPERCPTH_09_14
	 * 
	 * Restaurant Availability and Expenditures 
	 *col_f 6 :Fast-food restaurants (% change), 2009-14, PCH_FFR_09_14 
	 *col_l 12 :Full-service restaurants (% change), 2009-14, PCH_FSR_09_14
	 * 
	 * 
	 */

	String state;
	
	String lowAccess_over_10_15;
	String lowAccess_hh_10_15;
	
	String grocery_09_14;
	String superCenter_09_14;
	
	String fastFood_09_14;
	String fullService_09_14;
	
	public FoodIndex(String state, String lowAccess_over_10_15, String lowAccess_hh_10_15, String grocery_09_14,
			String superCenter_09_14, String fastFood_09_14, String fullService_09_14) {
		
		this.state = state;
		this.lowAccess_over_10_15 = lowAccess_over_10_15;
		this.lowAccess_hh_10_15 = lowAccess_hh_10_15;
		this.grocery_09_14 = grocery_09_14;
		this.superCenter_09_14 = superCenter_09_14;
		this.fastFood_09_14 = fastFood_09_14;
		this.fullService_09_14 = fullService_09_14;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLowAccess_over_10_15() {
		return lowAccess_over_10_15;
	}

	public void setLowAccess_over_10_15(String lowAccess_over_10_15) {
		this.lowAccess_over_10_15 = lowAccess_over_10_15;
	}

	public String getLowAccess_hh_10_15() {
		return lowAccess_hh_10_15;
	}

	public void setLowAccess_hh_10_15(String lowAccess_hh_10_15) {
		this.lowAccess_hh_10_15 = lowAccess_hh_10_15;
	}

	public String getGrocery_09_14() {
		return grocery_09_14;
	}

	public void setGrocery_09_14(String grocery_09_14) {
		this.grocery_09_14 = grocery_09_14;
	}

	public String getSuperCenter_09_14() {
		return superCenter_09_14;
	}

	public void setSuperCenter_09_14(String superCenter_09_14) {
		this.superCenter_09_14 = superCenter_09_14;
	}

	public String getFastFood_09_14() {
		return fastFood_09_14;
	}

	public void setFastFood_09_14(String fastFood_09_14) {
		this.fastFood_09_14 = fastFood_09_14;
	}

	public String getFullService_09_14() {
		return fullService_09_14;
	}

	public void setFullService_09_14(String fullService_09_14) {
		this.fullService_09_14 = fullService_09_14;
	}
	
	

}
