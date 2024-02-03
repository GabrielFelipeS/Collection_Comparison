package com.br.collectioncomparison.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class OrderArrayListTestADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
List<Employee> list = new ArrayList<>();
		
		for (Employee e : employees) {
			list.add(e);
		}

		long start = getMilliseconds();
		//System.out.println(start);
		
		Collections.sort(list);
		
		long end = getMilliseconds();
		//System.out.println(end);
		
		return end - start;
	}

}
