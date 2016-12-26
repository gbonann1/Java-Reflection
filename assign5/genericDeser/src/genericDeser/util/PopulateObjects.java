package genericDeser.util;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.HashMap;

import genericDeser.fileOperations.FileProcessor;

public class PopulateObjects {
	
	private FileProcessor fp;
	private HashMap<First, Integer> firstMap;
	private HashMap<Second, Integer> secondMap;
	
	public PopulateObjects(){
		firstMap = new HashMap<First, Integer>();
		secondMap = new HashMap<Second, Integer>();
	}
	
	public void deserObjects() throws IOException{
		String nextLine = fp.readLine();
		String clsName = "";
		Class cls = null;
		Class[] signature = new Class[1];
		String methodName = null;
		Method meth = null;
		Object obj = null;
		Object[] params = new Object[1];
		Object result = null;
		String type = null;
		
		while(nextLine != null){
			String[] tokens = nextLine.split("\\s+");
			for (int i = 0; i < tokens.length; i++){
				if (tokens[i].contains("fqn:")){
					if (clsName.contains("First")){
						this.insert((First)obj);
					}
					else if (clsName.contains("Second")){
						this.insert((Second)obj);
					}
					clsName = tokens[i].substring(4);
					try {
						cls = Class.forName(clsName);
						obj = cls.newInstance();						
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (Throwable e){
						e.printStackTrace();
					}
				}
				else if (tokens[i].contains("type=")){
					String temp = tokens[i].substring(5, tokens[i].length() - 1);
					if (temp.equals("int")){
						signature[0] = Integer.TYPE;
						type = "int";
					}
					else if (temp.equals("float")){
						signature[0] = Float.TYPE;
						type = "float";
					}
					else if (temp.equals("short")){
						signature[0] = Short.TYPE;
						type = "short";
					}
					else if (temp.equals("String")){
						signature[0] = String.class;
						type = "string";
					}
					else if (temp.equals("double")){
						signature[0] = Double.TYPE;
						type = "double";
					}
					else if (temp.equals("boolean")){
						signature[0] = Boolean.TYPE;
						type = "boolean";
					}
					
				}
				else if (tokens[i].contains("var=")){
					String temp = tokens[i].substring(4, tokens[i].length() - 1);
					methodName = "set" + temp;
					//System.out.println(methodName);
					try {
						meth = cls.getMethod(methodName, signature);
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
				}
				else if (tokens[i].contains("value=")){
					String temp = tokens[i].substring(6);
					if (type.equals("int")){
						params[0] = new Integer(temp);
					}
					else if(type.equals("float")){
						params[0] = new Float(temp);
					}
					else if(type.equals("short")){
						params[0] = new Short(temp);
					}
					else if(type.equals("string")){
						params[0] = temp;
					}
					else if(type.equals("double")){
						params[0] = new Double(temp);
					}
					else if(type.equals("boolean")){
						params[0] = new Boolean(temp);
					}
					try {
						result = meth.invoke(obj, params);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				}
				
			}
			nextLine = fp.readLine();
		
		}
	}
	
	public void setFp(FileProcessor fpIn){
		fp = fpIn;
	}
	
	public void insert(First fIn){
		if (firstMap.containsKey(fIn)){
			Integer temp = firstMap.get(fIn);
			firstMap.put(fIn, temp + 1);
			//System.out.println(firstMap.get(fIn));
		}
		else{
			firstMap.put(fIn, new Integer(1));
			//System.out.println(firstMap.get(fIn));
		}
		
	}
	
	public void insert(Second sIn){
		if (secondMap.containsKey(sIn)){
			Integer temp = secondMap.get(sIn);
			secondMap.put(sIn, temp + 1);
		}
		else{
			secondMap.put(sIn, new Integer(1));
			//System.out.println(secondMap.get(sIn));
		}
	}
	
	public int getUniqueFirst(){
		int retVal = 0;
		for (First key : firstMap.keySet()){
			retVal++;
		}
		return retVal;
	}
	
	public int getTotalFirst(){
		int retVal = 0;
		for (First key : firstMap.keySet()){
			//System.out.println(firstMap.get(key));
			retVal+= firstMap.get(key).intValue();
		}
		return retVal;
	}
	
	public int getUniqueSecond(){
		int retVal = 0;
		for (Second key : secondMap.keySet()){
			retVal++;
		}
		return retVal;
	}
	
	public int getTotalSecond(){
		int retVal = 0;
		for (Second key : secondMap.keySet()){
			retVal+= secondMap.get(key).intValue();
		}
		return retVal;
	}
	
}
