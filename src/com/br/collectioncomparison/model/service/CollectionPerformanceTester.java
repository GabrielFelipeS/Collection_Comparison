package com.br.collectioncomparison.model.service;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

// TODO validar se precisa dessa classe
public class CollectionPerformanceTester {
	private int numberOfExecutions;
	
	public CollectionPerformanceTester(int numberOfExecutions) {
		this.numberOfExecutions = numberOfExecutions;
	}

	public long test(CollectionTest ct, Employee[] employees) {
		long sum = 0;
		for(int i = 0;i < numberOfExecutions; i++) {
			sum += ct.test(employees);
			System.out.println(sum);
		}
		System.out.println(sum / numberOfExecutions);
		return  sum / numberOfExecutions;
	}
}
