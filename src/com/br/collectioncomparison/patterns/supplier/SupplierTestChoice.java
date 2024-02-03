package com.br.collectioncomparison.patterns.supplier;

import java.util.function.Supplier;

import com.br.collectioncomparison.model.OrderArrayListTestADD;
import com.br.collectioncomparison.model.TreeSetTestADD;
import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.model.entities.ArrayListTestADD;

public class SupplierTestChoice implements Supplier<TestObject[]>  {

    private static final TestObject[] titles = new TestObject[]{
            new TestObject("Adicionar elementos no ArrayList", new ArrayListTestADD()),
            new TestObject("Ordenar elementos no ArrayList", new OrderArrayListTestADD()),
            new TestObject("Adicionar elementos no TreeSet", new TreeSetTestADD())
    };

    @Override
    public TestObject[] get() {
        return titles;
    }
}
