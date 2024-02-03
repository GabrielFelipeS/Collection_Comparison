package com.br.collectioncomparison.model;

import java.util.Set;
import java.util.TreeSet;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class TreeSetTestADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
		Set<Employee> list = new TreeSet<>();
		
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
