package com.br.collectioncomparison.patterns.supplier;

import java.util.function.Supplier;

import com.br.collectioncomparison.model.entities.ArrayListTestADD;
import com.br.collectioncomparison.model.entities.TestObject;

public class SupplierTestChoice implements Supplier<TestObject[]>  {

    private static final TestObject[] titles = new TestObject[]{
            new TestObject("Elemento 1", new ArrayListTestADD()),
            new TestObject("Elemento 2", new ArrayListTestADD())
    };

    @Override
    public TestObject[] get() {
        return titles;
    }
}
