package com.br.collectioncomparison.patterns.supplier.testObjects;

import java.util.Arrays;
import java.util.function.Supplier;

import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.model.entities.ArrayListTestADD;

public class SupplierOptionsRemoved implements Supplier<TestObject[]> {
	 private static final TestObject[] titles = Arrays.asList(
		new TestObject("Adicionar elementos no ArrayList", new ArrayListTestADD()),
		new TestObject("Adicionar elementos no ArrayList", new ArrayListTestADD())
	).toArray(new TestObject[0]);
	
	@Override
	public TestObject[] get() {
		return titles;
	}

}
