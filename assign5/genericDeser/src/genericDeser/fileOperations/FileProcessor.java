package genericDeser.fileOperations;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;



public class FileProcessor{
	private FileInputStream input = null;
	private BufferedReader buffer = null;
	
	/**
	 * Constructor - trys to create a new FileInputStream and a new BufferedReader
	 */
	public FileProcessor(String in)throws IOException{
		try {
				input = new FileInputStream(in);
				//change absolute path?
				buffer = new BufferedReader(new InputStreamReader(input));	
					
		}
		catch (FileNotFoundException e) {
			if (input != null) {
				input.close();
			}
			if (buffer != null){
				buffer.close();
			}
			System.out.println("File does not exist");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * readLine - reads in the next line from the file
	 */
	public synchronized String readLine()throws IOException{
		String thisLine;
		
		thisLine = buffer.readLine();
		return thisLine;
	}
	
	public void clean(){
		if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
		if (buffer != null){
				try {
					buffer.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
		}
		
	}
}
