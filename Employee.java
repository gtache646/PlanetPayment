package planetpayment;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Employee {
	public static final String SPACE 	= " ";
	public static final String TAB	 	= "\t";
	public static final String LEFT_PAR 	= "(";
	public static final String RIGHT_PAR 	= ")";
	public static final String COMMA	= ",";
	public static final String DFLT_STATE	= "CA";
	public static final String DFLT_COUNTRY	= "USA";	
	public static final String LINE_SEP	= System.lineSeparator();
	public static final SimpleDateFormat inputDateFmt  = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat outputDateFmt = new SimpleDateFormat("MMMMM dd, yyyy");

	public Employee () {}
	private int    index;
	private String firstName;
	private String lastName;
	private String startDate;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zip;

	public String toString() {
	    	StringBuffer sb = new StringBuffer();
	    	sb.append(getIndex());
	    	sb.append(LINE_SEP).append(TAB);
	    	sb.append(getFirstName()).append(SPACE).append(getLastName());
	    	sb.append(COMMA).append(SPACE);
		sb.append(LEFT_PAR).append(getFormattedStartDate()).append(RIGHT_PAR);
		sb.append(LINE_SEP).append(TAB);
		boolean b = false;
		// if address1 or address2 is not empty write LINE_SEP after the address line
		if (!(emptyString(getAddress1()))) {
			sb.append(getAddress1()).append(COMMA).append(SPACE);
			b = true;
		}
		if(!(emptyString(getAddress2()))){
			sb.append(getAddress2()).append(COMMA);
			b=true;
		}
		if(b)
			sb.append(LINE_SEP).append(TAB);
		if(!(emptyString(getCity())))
			sb.append(getCity()).append(COMMA);
		sb.append(getState()).append(COMMA);
		sb.append(LINE_SEP).append(TAB);
		sb.append(getCountry());
		if (!(emptyString(getZip())))
			sb.append(COMMA).append(getZip());		
	    	return sb.toString();

	}

	public int getIndex(){
		return index;
	}
	public void setIndex(int index){
		this.index = index;
	}

	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}	
	// used for sorting by start date
	public String getStartDate(){
		return startDate;
	}
	// used for writing to output file
	public String getFormattedStartDate() {
		try {
			return outputDateFmt.format(inputDateFmt.parse(startDate));
		} catch(ParseException ex){
			return startDate;
		}
	}
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	public String getAddress1(){
		return address1;
	}
	public void setAddress1(String address1){
		this.address1 = address1;
	}
	public String getAddress2(){
		return address2;
	}
	public void setAddress2(String address2){
		this.address2 = address2;
	}
	public String getCity(){
		return city;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getState(){
		return emptyString(state) ? DFLT_STATE : state;
	}
	public void setState(String state){
		this.state = state;
	}
	public String getCountry(){
		return emptyString(country) ? DFLT_COUNTRY : country;
	}
	public void setCountry(String country){
		this.country = country;
	}
	public String getZip(){
		return zip;
	}
	public void setZip(String zip){
		this.zip = zip;
	}
	private boolean emptyString(String s){
		return s==null || s.length()==0;
	}
}