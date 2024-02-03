package com.br.collectioncomparison.model.entities;

import java.util.ArrayList;
import java.util.List;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class ArrayListTestADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
		List<Employee> list = new ArrayList<>();
		
		long start = getMilliseconds();
		//System.out.println(start);
		
		for (Employee e : employees) {
			list.add(e);
		}
		
		long end = getMilliseconds();
		//System.out.println(end);
		
		return end - start;
	}

}
