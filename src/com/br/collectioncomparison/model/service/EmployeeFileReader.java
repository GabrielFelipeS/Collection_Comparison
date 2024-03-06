package com.br.collectioncomparison.model.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.patterns.factory.FactoryEmployee;

public class EmployeeFileReader {

	public static Employee[] read(String fileName) {
		List<Employee> list = new ArrayList<>();

		File file = new File(fileName);
		try (FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr); ) {
			br.readLine();
			String line;
			while((line = br.readLine()) != null) {
				Employee employee = FactoryEmployee.createByLine(line);
				list.add(employee);
			}

		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

		return list.toArray(new Employee[0]);
	}
}
