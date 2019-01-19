package id.ststech.rnd.largedata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ststech.rnd.largedata.model.Employee;
import id.ststech.rnd.largedata.repository.EmployeeRepository;
import id.ststech.rnd.largedata.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> findAll() {
		List<Employee> cities = (List<Employee>) repository.findAll();
		return cities;
	}
}
