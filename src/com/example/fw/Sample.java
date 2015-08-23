package com.example.fw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Sample {
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		ApplicationManager app = new ApplicationManager(properties);
		/**
		 * JdbcHelper jdbc = new JdbcHelper(app,
		 * "jdbc:mysql://localhost/addressbook?user=root&password=");
		 * System.out.println(jdbc.listContacts());
		 * System.out.println(jdbc.listContacts());
		 **/
		//System.out.println(app.getHibernateHelper().listGroups());
		System.out.println(app.getHibernateHelper().listContacts());
	}
}
