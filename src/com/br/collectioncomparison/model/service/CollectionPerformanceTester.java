package com.br.collectioncomparison.model.service;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

// TODO validar se precisa dessa classe
public class CollectionPerformanceTester {

	public static long test(CollectionTest ct, Employee[] employees) {
		return ct.test(employees);
	}
}
