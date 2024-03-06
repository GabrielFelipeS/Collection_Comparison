package com.br.collectioncomparison.model.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
	//private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Integer id;
	private String name;
	private Date dateOfBonth;
	private String company;
	private String departament;
	private Double salary;

	public Employee(Integer id, String name, Date dateOfBonth, String company, String departament, Double salary) {
		this.id = id;
		this.name = name;
		this.dateOfBonth = dateOfBonth;
		this.company = company;
		this.departament = departament;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

//	@Override
//	public String toString() {
//		return String.format("%d;%s;%s;%s;%s;%.2f", id, name, sdf.format(dateOfBonth), company, departament, salary);
//	}


	public String getName() {
		return name;
	}

	public Date getDateOfBonth() {
		return dateOfBonth;
	}

	public String getCompany() {
		return company;
	}

	public String getDepartament() {
		return departament;
	}

	public Double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		Locale.setDefault(Locale.US);
		return String.format("(%d, '%s','%s','%s','%s',%.2f)", id, name, sdf.format(dateOfBonth), company, departament, salary);
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int compareTo(Employee e) {
		return this.id - e.id;
	}

}
