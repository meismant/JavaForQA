package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out
					.println("Please specify parameters: <amount test data> <file> <format>");
			return;
		}

		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];

		if (file.exists()) {
			System.out
					.println("File exists, plese remove it manually: " + file);
			return;
		}

		List<ContactData> contacts = generateRandomContacts(amount);
		if (format.equals("csv")) {
			saveContactsToCsvFile(contacts, file);
		} else
		if (format.equals("xml")) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format " + format);
			return;
		}
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData();
			if (amount > 0) {
				contact.withName(nameRand()).withLastname(surnameRand())
						.withAddress(addressRand()).withHome(phoneRand())
						.withMobile(phoneRand()).withWork(phoneRand())
						.withEmail(emailRand()).withEmail2(emailRand())
						.withBday(bdayRand()).withBmonth(bmonthRand())
						.withByear(byearRand()).withNew_group(new_groupRand())
						.withAddress2(addressRand()).withPhone2(phoneRand());
			}
			list.add(contact);
		}
		return list;
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getName()+","+
						contact.getLastname()+","+
						contact.getAddress()+","+
						contact.getAddress2()+","+
						contact.getBday()+","+
						contact.getBmonth()+","+
						contact.getByear()+","+
						contact.getMobile()+","+
						contact.getHome()+","+
						contact.getWork()+","+
						contact.getPhone2()+","+
						contact.getEmail()+","+
						contact.getEmail2()+","+
						contact.getNew_group()
						+",!"+"\n");
		}
		writer.close();		
	}

	public static List<ContactData> loadContactsFromCsvFile(File file)
			throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferReader = new BufferedReader(reader);
		String line = bufferReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withName(part[1])
			.withLastname(part[2])
			.withAddress(part[3])
			.withAddress2(part[4])
			.withBday(part[5])
			.withBmonth(part[6])
			.withByear(part[7])
			.withMobile(part[8])
			.withHome(part[9])
			.withWork(part[10])
			.withPhone2(part[11])
			.withEmail(part[12])
			.withEmail2(part[13])
			.withNew_group(part[14]);
			list.add(contact);
			line = bufferReader.readLine();		
		}	
		bufferReader.close();
		reader.close();
		return list;
	}
	
	private static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) {
		// TODO Auto-generated method stub

	}

	private static String nameRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			String[] names = new String[] { "Kate", "Mike", "John", "Marybet",
					"Billy", "Bob", "Henry", "Stu" };
			int index = rnd.nextInt(names.length);
			return names[index];
		}
	}

	private static String surnameRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			String[] surnames = new String[] { "Goran", "Limiter", "Chan",
					"West", "Forest", "Woods", "George", "Jhonson", "Black" };
			int index = rnd.nextInt(surnames.length);
			return surnames[index];
		}
	}

	private static String addressRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			String[] address = new String[] { "221B Baker St.",
					"1313 Mockingbird Lane", "0001 Cemetery Lane",
					"4222 Clinton Way", "12 Grimmauld Place",
					"112 1/2 Beacon St.", "742 Evergreen Terrace" };
			int index = rnd.nextInt(address.length);
			return address[index];
		}
	}

	private static String emailRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			String futureEmail = "";
			int index;
			int size = rnd.nextInt(20);
			for (int i = 0; i < size; i++) {
				index = rnd.nextInt(122 - 97) + 97;
				futureEmail += (char) index;
			}
			futureEmail += "@test.com";
			return futureEmail;
		}
	}

	private static String bdayRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "-";
		} else {
			String bday = "-";
			bday = Integer.toString(rnd.nextInt(30) + 1);
			return bday;
		}
	}

	private static String bmonthRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "-";
		} else {
			String bmonth = "-";
			String[] address = new String[] { "January", "February", "March",
					"April", "May", "June", "July", "August", "September",
					"October", "November", "December" };
			int index = rnd.nextInt(12);
			bmonth = address[index];
			return bmonth;
		}
	}

	private static String byearRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			String byear = "";
			java.util.Calendar calendar = java.util.Calendar.getInstance(
					java.util.TimeZone.getDefault(),
					java.util.Locale.getDefault());
			calendar.setTime(new java.util.Date());
			int year = rnd
					.nextInt(calendar.get(java.util.Calendar.YEAR) - 1900);
			year += 1900;
			byear = Integer.toString(year);
			return byear;
		}
	}

	private static String new_groupRand() {
		String group = "[none]";
		// WebElement element = app.driver.findElement(By.name("new_group"));

		// Select select = new Select(element);
		// Random rnd = new Random();
		// int index = rnd.nextInt(select.getOptions().size() - 1);

		// group = select.getOptions().get(index + 1).getText();

		return group;
	}

	private static String phoneRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			int phone = rnd.nextInt();
			if (phone < 0)
				phone *= -1;
			return Integer.toString(phone);
		}
	}

}
