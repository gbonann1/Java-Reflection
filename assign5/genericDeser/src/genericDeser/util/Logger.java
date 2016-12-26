package genericDeser.util;

public class Logger{


    public static enum DebugLevel {  RESULTS
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
		switch (levelIn) {
		  case 0: debugLevel = DebugLevel.RESULTS; break;
		}
    }

    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    }

   
    public static void writeMessage (String message,
                                     DebugLevel levelIn ) {
		if (levelIn == debugLevel)
		    System.out.println(message);
    }

    public String toString() {
    	return "Debug Level is " + debugLevel;
    }
}

