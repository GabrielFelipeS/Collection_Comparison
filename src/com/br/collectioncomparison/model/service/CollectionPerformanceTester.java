package com.br.collectioncomparison.model.service;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class CollectionPerformanceTester {
	private int numberOfExecutions;

	public CollectionPerformanceTester(int numberOfExecutions) {
		this.numberOfExecutions = numberOfExecutions;
	}

	public long test(CollectionTest ct, Employee[] employees) {
		long sum = 0;
		//System.err.println("AQUI: ");
		for (int i = 0; i < numberOfExecutions; i++) {
			sum += ct.test(employees);
			//System.out.println(sum);
		}
		//System.out.println();
		return sum / numberOfExecutions;
	}
}
