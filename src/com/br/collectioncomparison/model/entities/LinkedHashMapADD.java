package com.br.collectioncomparison.model.entities;

import java.util.LinkedHashMap;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class LinkedHashMapADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
		LinkedHashMap<Integer, Employee> list = new LinkedHashMap<>();

		long start = getMilliseconds();

		for (Employee e : employees) {
			list.put(e.getId(), e);
		}

		long end = getMilliseconds();

		return end - start;

	}
	public String toString() {
		return "Adicionar elementos no LinkedHashMap";
	}
}
