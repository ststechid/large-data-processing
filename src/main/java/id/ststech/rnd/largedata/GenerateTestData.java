package id.ststech.rnd.largedata;

import com.github.javafaker.Faker;

public class GenerateTestData {

	public static void main(String[] args) {

		Faker faker = new Faker();
		
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String profession = faker.company().profession();
		int workingSince = faker.number().numberBetween(1999, 2018);
		String streetAddress = faker.address().streetAddress();
		String city = faker.address().city();
		String country = faker.address().country();
		Long annualSalary = new Long(faker.number().numberBetween(6, 25) * 10000);
		
		StringBuilder builder = new StringBuilder();
		builder.append(firstName);
		builder.append(",");
		builder.append(lastName);
		builder.append(",");
		builder.append(profession);
		builder.append(",");
		builder.append(workingSince);
		builder.append(",");
		builder.append(streetAddress);
		builder.append(",");
		builder.append(city);
		builder.append(",");
		builder.append(country);
		builder.append(",");
		builder.append("$ ").append(annualSalary);
		
		System.out.println(builder.toString());
	}

}
