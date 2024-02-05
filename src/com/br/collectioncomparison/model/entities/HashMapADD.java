package com.br.collectioncomparison.model.entities;

import java.util.HashMap;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class HashMapADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
		HashMap<Integer, Employee> list = new HashMap<>();

		long start = getMilliseconds();

		for (Employee e : employees) {
			list.put(e.getId(), e);
		}
		
		long end = getMilliseconds();
		
		return end - start;
	}

}
