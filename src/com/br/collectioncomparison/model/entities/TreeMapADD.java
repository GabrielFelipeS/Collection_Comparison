package com.br.collectioncomparison.model.entities;

import java.util.TreeMap;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class TreeMapADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
		TreeMap<Integer, Employee> list = new TreeMap<>();

		long start = getMilliseconds();

		for (Employee e : employees) {
			list.put(e.getId(), e);
		}
		
		long end = getMilliseconds();
		
		return end - start;
	}

}
