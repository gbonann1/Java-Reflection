CS442 Design Patterns
Fall 2016
PROJECT 5 README FILE

Due Date: Tuesday, December 13, 2016
Submission Date: Monday, December 12, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 1 Days
Author(s): Gianluca Bonanno
e-mail(s): gbonanno1@binghamton.edu


PURPOSE:

	This assignment creates objects from an input file using Java reflection

PERCENT COMPLETE:

	I believe that I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

	All features as required by this project are complete.

BUGS:

	N/A.

FILES:

	Included with this project are 10 files:
	
	- Driver.java, the file which drives the program and contains the main function
	- FileProcessor.java, sets up file I/O for reading
	- First.java, Object with data members int String float short
	- Second.java, Object with data members int double boolean
	- Logger.java, Logger 
	- PopulateObjects.java, Class with 2 hashmaps to store First and Second objects
	- input.txt, small sample input file
	- input2.txt large sample input file
	- build.xml, the ANT compilation file
	- README, the text file you are presently reading

SAMPLE OUTPUT:

	Number of unique First objects: 361940
	Total number of First objects: 498623
	Number of unique Second objects: 100643
	Total number of Second objects: 501376

TO COMPILE:

	Extract the files from the tar.gz. Navigate to the created folder
	bonanno_gianluca_assign5\genericDeser\src\ and run
	the command "ant all".
	
TO RUN:

	Navigate to the created folder
	bonanno_gianluca_assign5\genericDeser\src\ and run
	the command "ant run -Darg0=input.txt -Darg1=0".
	
	requires 2 arguments

DATA STRUCTURES AND ALGORITHMS/COMPLEXITY:
	
	PopulateObjects has two hashMaps as data members.
	The first hashMap "firstMap" stores First objects
	the second hashMap "secondMap" stores Second objects
	Each hashmap uses the First/Second object as a key and an Integer as the value
	Inserting into the hashmap is complexity O(n) (put)
	Accessing an element in the hashmap is complexity O(1) (get)
	
EXTRA CREDIT:

	N/A

BIBLIOGRAPHY:

	N/A

ACKNOWLEDGEMENT:

	N/A
