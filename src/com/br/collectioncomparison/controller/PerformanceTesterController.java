package com.br.collectioncomparison.controller;

import java.time.LocalDateTime;

import com.br.collectioncomparison.model.domain.DataFile;
import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.domain.PerformaceResults;
import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.model.service.EmployeeFileReader;

public class PerformanceTesterController {
	public PerformaceResults test(DataFile dataFile, TestObject testObject) {
		Employee[] employees = readFile(dataFile.getFileName());
		Long runtime = testObject.getCollectionTest().test(employees);
		
		return new PerformaceResults(testObject.getTitle(), dataFile.getTitle(), runtime, LocalDateTime.now());
	}
	
	private Employee[] readFile(String nameFile) {
		return EmployeeFileReader.read(nameFile);
	}
}
