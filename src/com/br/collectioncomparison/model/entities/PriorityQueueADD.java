package com.br.collectioncomparison.model.entities;

import java.util.PriorityQueue;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class PriorityQueueADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
		PriorityQueue<Employee> list = new PriorityQueue<>();

		long start = getMilliseconds();

		for (Employee e : employees) {
			list.add(e);
		}

		long end = getMilliseconds();

		return end - start;
	}

	@Override
	public String toString() {
		return "Adicionar elementos no PriorityQueue";
	}
}
