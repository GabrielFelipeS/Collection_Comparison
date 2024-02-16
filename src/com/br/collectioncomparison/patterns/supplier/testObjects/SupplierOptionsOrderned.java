package com.br.collectioncomparison.patterns.supplier.testObjects;

import java.util.function.Supplier;

import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.model.entities.OrderArrayListTestADD;

public class SupplierOptionsOrderned implements Supplier<TestObject[]> {
	 private static final TestObject[] titles = new TestObject[] {
			 new TestObject("Ordenar elementos no ArrayList", new OrderArrayListTestADD())
	 };
	
	@Override
	public TestObject[] get() {
		return titles;
	}

}
