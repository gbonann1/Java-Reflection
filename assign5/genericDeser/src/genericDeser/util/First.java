package genericDeser.util;

public class First {

	private int intValue;
	private String stringValue;
	private float floatValue;
	private short shortValue;
	
	public First(){
		intValue = 0;
		stringValue = "";
		floatValue = 0;
		shortValue = 0;
	}
	
	public void setIntValue(int intIn){
		intValue = intIn;
	}
	
	public void setStringValue(String stringIn){
		stringValue = stringIn;
	}
	
	public void setFloatValue(float floatIn){
		floatValue = floatIn;
	}
	
	public void setShortValue(short shortIn){
		shortValue = shortIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(floatValue);
		result = prime * result + intValue;
		result = prime * result + shortValue;
		result = prime * result
				+ ((stringValue == null) ? 0 : stringValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o){
		boolean retVal = false;
		if (o instanceof First){
			First f = (First)o;
			retVal = (f.intValue == intValue) &&
					(f.stringValue.equals(stringValue)) &&
					(f.floatValue == floatValue) &&
					(f.shortValue == shortValue);
		}
		return retVal;
	}
	

	
	
}
