package com.br.collectioncomparison.model.entities;

import java.util.ArrayDeque;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class DequeAddTestADD implements CollectionTest {

	@Override
	public long test(Employee[] employees) {
		ArrayDeque<Employee> list = new ArrayDeque<>();

		long start = getMilliseconds();

		for (Employee e : employees) {
			list.add(e);
		}

		long end = getMilliseconds();

		return end - start;
	}

	@Override
	public String toString() {
		return "Adicionar elementos no Deque usando add";
	}
}
