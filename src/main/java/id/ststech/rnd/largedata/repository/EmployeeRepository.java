package id.ststech.rnd.largedata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.ststech.rnd.largedata.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
