package id.ststech.rnd.largedata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.github.javafaker.Faker;

public class GenerateTestData {

	public static void main(String[] args) throws IOException {

		Faker faker = new Faker();

		File file = new File("src/test/resources/largefile.txt");
		FileOutputStream fos = new FileOutputStream(file);

		for (int i = 0; i < 100; i++) {

			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String profession = faker.company().profession();
			int workingSince = faker.number().numberBetween(1999, 2018);
			String streetAddress = faker.address().streetAddress();
			String city = faker.address().city();
			String country = faker.address().countryCode();
			Long annualSalary = new Long(faker.number().numberBetween(6, 25) * 10000);
			String phoneNumber = faker.phoneNumber().cellPhone();
			String employeeCode = faker.bothify("??-#####", true);
			String avatar = faker.avatar().image();

			StringBuilder builder = new StringBuilder();
			builder.append(employeeCode);
			builder.append(",");
			builder.append(avatar);
			builder.append(",");
			builder.append(firstName);
			builder.append(",");
			builder.append(lastName);
			builder.append(",");
			builder.append(profession);
			builder.append(",");
			builder.append(workingSince);
			builder.append(",");
			builder.append(phoneNumber);
			builder.append(",");
			builder.append(streetAddress);
			builder.append(",");
			builder.append(city);
			builder.append(",");
			builder.append(country);
			builder.append(",");
			builder.append("$ ").append(annualSalary);

			// System.out.println(builder.toString());
			String testData = builder.toString();
			fos.write(testData.getBytes());
			fos.write('\n');
		}

		fos.flush();
		fos.close();
	}

}
