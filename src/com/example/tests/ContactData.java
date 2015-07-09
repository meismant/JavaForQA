package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String name="";
	public String lastname="";
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String new_group;
	public String address2;
	public String phone2;

	public ContactData() {	
	}

	public ContactData(String firstname, String lastname, String address,
			String home, String mobile, String work, String email,
			String email2, String bday, String bmonth, String byear,
			String new_group, String address2, String phone2) {
		this.name = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.new_group = new_group;
		this.address2 = address2;
		this.phone2 = phone2;
	}

	@Override
	public String toString() {
		return "ContactData [name=" + name + ", lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result	+ ((lastname == null) ? 0 : lastname.hashCode());
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {		
		 int last = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	        return last == 0 ? this.name.toLowerCase().compareTo(other.name.toLowerCase()) : last;
	/*	 int last = this.lastname.compareTo(other.lastname);
	        return last == 0 ? this.name.compareTo(other.name) : last;*/
	}
	
	
}
