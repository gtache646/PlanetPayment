package planetpayment;

public class Type2Reader implements ReaderInterface{
	public Employee parseLine(String line) {
		Employee emp = new Employee();
		String[] empInfo = line.split(",");		
		/*
		only first name, last name and start date are mandatory so a line like the following one
			"Jon,Abner,20150607,,,,,," when split by "," will give an array with length 3
		"Jon,Abner,20150607,Street,Apt,City,State,,12345".split(",") has length 9
		"Jon,Abner,2015,Street,Apt,City,State,USA,".split(",") has length 8
		"Jon,Abner,20150607,Street,Apt,City,State,,".split(",") has length 7	
		*/
		emp.setFirstName(empInfo[0]);
		emp.setLastName(empInfo[1]);
		emp.setStartDate(empInfo[2]);
		try {
			emp.setAddress1(empInfo[3]);
			emp.setAddress2(empInfo[4]);
			emp.setCity(empInfo[5]);
			emp.setState(empInfo[6]);
			emp.setCountry(empInfo[7]);
			emp.setZip(empInfo[8]);
		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
			//ignore
		}
		return emp;
	}  

	
}