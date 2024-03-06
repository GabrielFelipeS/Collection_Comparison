package com.br.collectioncomparison.model.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class OrderEAdicionarArrayListTestADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
		List<Employee> list = new ArrayList<>();

		long start = getMilliseconds();

		for (Employee e : employees) {
			list.add(e);
		}
		
		Collections.sort(list);

		long end = getMilliseconds();

		return end - start;
	}

}
