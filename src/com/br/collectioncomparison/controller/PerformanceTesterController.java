package com.br.collectioncomparison.controller;

import java.time.LocalDateTime;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.domain.PerformaceResults;
import com.br.collectioncomparison.model.interfaces.CollectionTest;
import com.br.collectioncomparison.model.service.CollectionPerformanceTester;
import com.br.collectioncomparison.model.service.EmployeeFileReader;
import com.br.collectioncomparison.patterns.strategy.CollectionTestStrategy;
import com.br.collectioncomparison.patterns.strategy.DataFileStrategy;

public class PerformanceTesterController {
	public PerformaceResults test(String titleFile, String testTitle) {
		String filePath = getFileBy(titleFile);
		Employee[] employees = readFile(filePath);
		Long runtime = getFunctionOf(testTitle).test(employees);
		
		return new PerformaceResults(testTitle, filePath, runtime, LocalDateTime.now());
	}
	
	private Employee[] readFile(String nameFile) {
		return EmployeeFileReader.read(nameFile);
	}
	
	private String getFileBy(String fileTitle) {
		return DataFileStrategy.getFilePathBy(fileTitle);
	}
	
	private CollectionTest getFunctionOf(String testTitle) {
		return CollectionTestStrategy.getFunctionTestOf(testTitle);
	}
}
