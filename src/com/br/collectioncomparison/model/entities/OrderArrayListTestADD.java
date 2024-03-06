package com.br.collectioncomparison.model.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class OrderArrayListTestADD implements CollectionTest {
//double deltaT = (tempo_final.tv_sec + tempo_final.tv_usec/1000000.0) - (tempo_inicial.tv_sec + tempo_inicial.tv_usec/1000000.0);

	@Override
	public long test(Employee[] employees) {
		List<Employee> list = new ArrayList<>();

		for (Employee e : employees) {
			list.add(e);
		}

		long start = getMilliseconds();

		Collections.sort(list);

		long end = getMilliseconds();

		return end - start;
	}
	@Override
	public String toString() {
		return "Ordenar elementos no ArrayList";
	}
}
