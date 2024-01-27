package com.br.collectioncomparison.patterns.factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.br.collectioncomparison.model.domain.Employee;

public class FactoryEmployee {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static Employee createByLine(String line) {
		try {
			String[] params = line.split(";");
			
			Integer id = Integer.parseInt(params[0]);		
			String name = params[1];
			Date data = sdf.parse(params[2]);
			String company = params[3];
			String departament = params[4];
			Double salary = Double.parseDouble(params[5].replace(",", "."));

			Employee employee = new Employee(id, name, data, company, departament, salary);
			return employee;
			
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
}
