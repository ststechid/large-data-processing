package id.ststech.rnd.largedata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import id.ststech.rnd.largedata.model.Employee;
import id.ststech.rnd.largedata.repository.EmployeeRepository;
import id.ststech.rnd.largedata.util.ParseHelper;

public class ProcessFileWithLoopThread implements Runnable {

	private String fileToRead;
	private String threadName;

	private EmployeeRepository employeeRepository;

	public ProcessFileWithLoopThread(EmployeeRepository employeeRepository, String threadName, String fileToRead) {
		this.employeeRepository = employeeRepository;
		this.threadName = threadName;
		this.fileToRead = fileToRead;
	}

	@Override
	public void run() {

		// Read the files
		long freeMemoryBeforeProcess = Runtime.getRuntime().freeMemory();
		System.out.println("Before [" + threadName + "] Free Memory: " + freeMemoryBeforeProcess);

		File file = new File(fileToRead);
		FileInputStream fis = null;
		BufferedReader reader = null;
		try {
			fis = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(fis));

			String line = reader.readLine();
			
			while (line != null) {
				
				// Insert into database
				Employee employee = new Employee();
				ParseHelper.parseLineToEmployee(employee, line);
				employeeRepository.save(employee);
				
				line = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		long freeMemoryAfterProcess = Runtime.getRuntime().freeMemory();
		System.out.println("After [" + threadName + "] Free Memory: " + freeMemoryAfterProcess);
	}

}
