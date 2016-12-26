package genericDeser.driver;

import java.io.IOException;

import genericDeser.util.Logger;
import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.PopulateObjects;

public class Driver {
	
	public static void main(String[] args) throws IOException{
		
		
		String in = null;
		int debugValue = -1;
		if (args.length == 2){
			in = args[0];
			try {
				debugValue = Integer.valueOf(args[1]);
			}
			catch (NumberFormatException e){
				System.out.println("Invalid arguments");
				//e.printStackTrace();
				System.exit(0);
			}
		}
		else  {
			System.out.println("Please provide 2 args");
			System.exit(0);
		}
		Logger myLogger = new Logger();
		myLogger.setDebugValue(debugValue);
		PopulateObjects test = null;
		FileProcessor myFp = new FileProcessor(in);
		test = new PopulateObjects();
		test.setFp(myFp);
		test.deserObjects();
		
		if(debugValue >= 0){
			System.out.println("Number of unique First objects: " + test.getUniqueFirst());
			System.out.println("Total number of First objects: " + test.getTotalFirst());
			System.out.println("Number of unique Second objects: " + test.getUniqueSecond());
			System.out.println("Total number of Second objects: " + test.getTotalSecond());	
		}
		
		myFp.clean();
		
	}
}
