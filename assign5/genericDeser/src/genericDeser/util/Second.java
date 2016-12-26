package genericDeser.util;

public class Second {
	
	private int intValue;
	private double doubleValue;
	private boolean boolValue;
	
	public Second(){
		intValue = 0;
		doubleValue = 0;
		boolValue = false;
	}
	
	public void setIntValue(int intIn){
		intValue = intIn;
	}
	
	public void setDoubleValue(double doubleIn){
		doubleValue = doubleIn;
	}
	
	public void setBooleanValue(boolean boolIn){
		boolValue = boolIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (boolValue ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(doubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + intValue;
		return result;
	}

	@Override
	public boolean equals(Object o){
		boolean retVal = false;
		if (o instanceof Second){
			Second f = (Second)o;
			retVal = (f.intValue == intValue) &&
					(f.doubleValue == doubleValue) &&
					(f.boolValue == boolValue);
		}
		return retVal;
	}
	
	

}
