package planetpayment;

import java.util.*;
import java.io.*;

public class MainClass{
  private static List<Employee> processInputFile(String inputFileName) {
	BufferedReader buff = null;
	String line = null;
	int fileType;
	List<Employee> l = new ArrayList<Employee>();
	try {
		buff = new BufferedReader(new FileReader(inputFileName));
		line = buff.readLine();
		fileType = Integer.valueOf(line.trim());
		ReaderInterface ri = null;
		switch(fileType) {
			case  1: ri = new Type1Reader();break;
			case  2: ri = new Type2Reader();break;
			default: System.out.println("file type not supported");
				 System.exit(-1);

		}
		Employee e = null;
		while((line=buff.readLine())!=null){
			e = ri.parseLine(line);
			if (e!=null)
				l.add(ri.parseLine(line));
		}
	}catch(Exception ex){
	  ex.printStackTrace();
	}finally{
	 if(buff!=null)
		try{
			buff.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}		
	}
	return l;
  }

  private static void sortRecords (List<Employee> employees, int sortOrder) {
	Comparator comp = null;
	switch(sortOrder) {
		case 0: comp = new NameComparator(); break;
		case 1: comp = new DateComparator(); break;
		default:
			System.out.println("valid values for the sort parameter are 0 for sorting by firstName, lastName; 1 for sorting by start date");
			System.out.println("The records will be written to the output file in the same order as they appear in the input file");		
	}
	if(comp!=null)
		Collections.sort(employees,comp);
	int i = 1;
	for (Employee e : employees)
		e.setIndex(i++);
  }

  private static void writeToFile(String outputFileName, List<Employee> employees){		 
	BufferedWriter buff=null;
	try {
		buff= new BufferedWriter(new FileWriter(outputFileName));
		for (Employee e : employees){
			buff.write(e.toString());
			buff.newLine();
		}
		buff.flush();		
	} catch (Exception ex){
		ex.printStackTrace();
	} finally{
		if(buff!=null)
			try{
				buff.close();
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}	


  
  public static void main (String[] args){
	int len = args.length;
	if (len < 3) {
		System.out.println("The program takes 3 arguments in this order, inputFileName,outputFileName and sort order indicator");
		System.out.println(" sort indicator can have the values 0 for last name, first name order, 1 for start date order");
		System.exit(-1);
	}
	String inputFileName	= args[0];
	String outputFileName	= args[1];
	int sortOrder		= -1;
	try {
		sortOrder = Integer.valueOf(args[2]);
	}catch (java.lang.NumberFormatException ex){
		System.out.println("Invalid sort order parameter");
		System.out.println("The records will be written to the output file in the same order as they appear in the input file");
	}
	List<Employee> employees= processInputFile(inputFileName);
	sortRecords(employees, sortOrder);
	writeToFile(outputFileName,employees);
	
    }//End of main
}//End MainClass

class NameComparator implements Comparator<Employee> {
	public int compare(Employee e1, Employee e2) {
    		int res = e1.getLastName().compareTo(e2.getLastName());
		return res == 0 ? e1.getFirstName().compareTo(e2.getFirstName()) : res; 
    	} 
} 

class DateComparator implements Comparator<Employee> {
	public int compare(Employee e1, Employee e2) {
    		return e1.getStartDate().compareTo(e2.getStartDate());		 
    	} 
} 