package com.br.collectioncomparison.model.entities;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class ArrayListTestADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
		System.out.println("funciona");
		return 0;
	}

}
