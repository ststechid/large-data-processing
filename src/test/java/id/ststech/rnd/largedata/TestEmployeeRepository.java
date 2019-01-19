package id.ststech.rnd.largedata;

import static org.junit.Assert.assertEquals;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import id.ststech.rnd.largedata.model.Employee;
import id.ststech.rnd.largedata.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestEmployeeRepository {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void it_can_find_the_contact_after_save_it() {

		Employee employee = new Employee();
		employee.setFirstName("Ali");
		employee.setLastName("Irawan");
		employee.setProfession("CTO");
		employee.setWorkingSince(2003);
		employee.setStreetAddress("Jl KH TAISIR");
		employee.setCity("JAKARTA");
		employee.setCountry("INDONESIA");
		employee.setAnnualSalary(200000L);
		employee.setPhoneNumber("081287731111");
		employee.setEmployeeCode("RG-89822");
		employee.setAvatar("https://some.com/ali.png");

		Employee savedEmployee = employeeRepository.save(employee);

		Optional<Employee> findEmployee = employeeRepository.findById(savedEmployee.getId());
		
		assertEquals(true, findEmployee.isPresent());
		
		Employee databaseEmployee = findEmployee.get();
		assertEquals("Ali", databaseEmployee.getFirstName());
		assertEquals("Irawan", databaseEmployee.getLastName());
		assertEquals("CTO", databaseEmployee.getProfession());
		assertEquals(2003, databaseEmployee.getWorkingSince());
		assertEquals("Jl KH TAISIR", databaseEmployee.getStreetAddress());
		assertEquals("JAKARTA", databaseEmployee.getCity());
		assertEquals("INDONESIA", databaseEmployee.getCountry());
		assertEquals(200000L, databaseEmployee.getAnnualSalary().longValue());
		assertEquals("081287731111", databaseEmployee.getPhoneNumber());
		assertEquals("RG-89822", databaseEmployee.getEmployeeCode());
		assertEquals("https://some.com/ali.png", databaseEmployee.getAvatar());
	}
}
