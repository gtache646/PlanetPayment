1. File List
------------
MainClass.class		main program; to be invoked with 3 arguments fileInputName, outputFileName and sort order indicator
Employee.class		class containing the attributes of an employee object and behavior when written to an output file;
			each line of the provided input file (except for the 1st line) will be converted into an instance of this class
ReaderInterface.class	describes the behavior expected from an object parsing an input file; MainClass will decide what implemenation of this interface will be used
			based on the type of the input file
Type1Reader.class	implementation of ReaderInterface for type 1 files
Type2Reader.class	implementation of ReaderInterface for type 2 files
DateComparator.class	sorts the employees in ascending order by start date
NameComparator.class	sorts the employees in ascending order by last name; if same last name then it will sort further by first name

2. How to run
-------------
Assumptions:
	DIR 		directory where planetpayment.jar is copied
	INPUT_DIR	directory where the input files are located
	OUTPUT_DIR	directory where the output files are generated
	INPUT_FILENAME	name of the input file to be processed
	OUTPUT_FILENAME	name of the generated output file 
	SORT_ORDER	argument controlling the order the records are written in the output file; valid values are 0 and 1 for sorting in ascending order
			by last name, first name and start date respectively 	

Command:
	java -classpath <DIR>planetpayment.jar planetpayment.MainClass <INPUT_DIR><INPUT_FILENAME>  <OUTPUT_DIR><OUTPUT_FILENAME> <SORT_ORDER>

Example (Windows environment):
	DIR 		= "c:\temp"
	INPUT_DIR	= "c:\temp\input"
	OUTPUT_DIR	= "c:\temp\output"
	INPUT_FILENAME	= "input.txt"
	OUTPUT_FILENAME	= "output.txt"
	SORT_ORDER	= 0
	>java -classpath c:\temp\planetpayment.jar planetpayment.MainClass c:\temp\input\input.txt c:\temp\output\output.txt 0

What to expect:
	- If given less than 3 arguments, the program will display the message "The program takes 3 arguments in this order, inputFileName,outputFileName and sort order indicator"
	  and it will exit;
	- If the SORT_ORDER argument has a value other than 0 and 1, the program will run, but the output will contain the records in the same order they apper in the input file;
	- If the input file does not have a valid file format (meaning 1 or 2) in the first line, the program will exit with the message "file type not supported" 
	  and it will exit;