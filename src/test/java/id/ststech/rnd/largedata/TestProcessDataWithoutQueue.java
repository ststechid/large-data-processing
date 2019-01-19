package id.ststech.rnd.largedata;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import id.ststech.rnd.largedata.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestProcessDataWithoutQueue {

	private final static String FILE_PATH = "src/test/resources/largefile.txt";

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void processFile() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);

		ProcessFileWithLoopThread process = new ProcessFileWithLoopThread(employeeRepository, "thread1", FILE_PATH);

		process.run();
	}

	// Uncomment this line if you want try parallel testing
	/*
	@Test
	public void processFile2() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);

		ProcessFileWithLoopThread process = new ProcessFileWithLoopThread(employeeRepository, "thread2", FILE_PATH);

		process.run();
	}*/

}
