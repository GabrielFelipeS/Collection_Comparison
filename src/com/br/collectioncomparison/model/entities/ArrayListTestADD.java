package com.br.collectioncomparison.model.entities;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class ArrayListTestADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
		ArrayList<Employee> list = new ArrayList<>();

		long start = getMilliseconds();

		for (Employee e : employees) {
			list.add(e);
		}
		
		long end = getMilliseconds();
		
		return end - start;
	}
	
}
