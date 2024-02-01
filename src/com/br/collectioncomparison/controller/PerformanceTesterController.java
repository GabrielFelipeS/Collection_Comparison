package com.br.collectioncomparison.controller;

import java.time.LocalDateTime;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.domain.PerformaceResults;
import com.br.collectioncomparison.model.entities.TestObject;
import com.br.collectioncomparison.model.interfaces.CollectionTest;
import com.br.collectioncomparison.model.service.EmployeeFileReader;
import com.br.collectioncomparison.patterns.strategy.DataFileStrategy;

public class PerformanceTesterController {
	public PerformaceResults test(String titleFile, TestObject testObject) {
		String filePath = getFileBy(titleFile);
		Employee[] employees = readFile(filePath);
		Long runtime = testObject.getCollectionTest().test(employees);
		
		return new PerformaceResults(testObject.getTitle(), filePath, runtime, LocalDateTime.now());
	}
	
	private Employee[] readFile(String nameFile) {
		return EmployeeFileReader.read(nameFile);
	}
	
	private String getFileBy(String fileTitle) {
		return DataFileStrategy.getFilePathBy(fileTitle);
	}
}
