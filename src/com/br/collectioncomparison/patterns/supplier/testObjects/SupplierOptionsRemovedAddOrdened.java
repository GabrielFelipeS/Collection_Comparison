package com.br.collectioncomparison.patterns.supplier.testObjects;

import java.util.Arrays;
import java.util.function.Supplier;

import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.model.entities.OrderArrayListTestADD;

public class SupplierOptionsRemovedAddOrdened implements Supplier<TestObject[]> {
	 private static final TestObject[] titles = Arrays.asList(
			 new TestObject("Ordenar elementos no ArrayList", new OrderArrayListTestADD())	
    ).toArray(new TestObject[0]);
	
	@Override
	public TestObject[] get() {
		return titles;
	}

}
