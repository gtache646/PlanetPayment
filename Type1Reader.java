package planetpayment;

public class Type1Reader implements ReaderInterface{
	public Employee parseLine(String line) {
		if (line.length()==80){
			Employee emp = new Employee();
			emp.setFirstName(line.substring(0,10).trim());
			emp.setLastName(line.substring(10,27).trim());
			emp.setStartDate(line.substring(27,35).trim());
			emp.setAddress1(line.substring(35,45).trim());
			emp.setAddress2(line.substring(45,55).trim());
			emp.setCity(line.substring(55,65).trim());
			emp.setState(line.substring(65,67).trim());
			emp.setCountry(line.substring(67,70).trim());
			emp.setZip(line.substring(70,80).trim());
			return emp;
		}
		return null;		
	}  
}