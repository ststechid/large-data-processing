package id.ststech.rnd.largedata.util;

import id.ststech.rnd.largedata.model.Employee;

public class ParseHelper {

	public static void parseLineToEmployee( Employee employee, String lineData ) {
		String[] splits = lineData.split(",");
		
		employee.setEmployeeCode(splits[0]);
		employee.setAvatar(splits[1]);
		employee.setFirstName(splits[2]);
		employee.setLastName(splits[3]);
		employee.setProfession(splits[4]);
		employee.setWorkingSince(Integer.parseInt(splits[5]));
		employee.setPhoneNumber(splits[6]);
		employee.setStreetAddress(splits[7]);
		employee.setCity(splits[8]);
		employee.setCountry(splits[9]);
		
		// Removing the '$ ' prefix
		employee.setAnnualSalary(Long.valueOf(splits[10].substring(2)));
	}
}
