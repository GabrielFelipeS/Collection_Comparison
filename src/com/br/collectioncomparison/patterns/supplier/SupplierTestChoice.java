package com.br.collectioncomparison.patterns.supplier;

import java.util.function.Supplier;

import com.br.collectioncomparison.model.HashSetTestADD;
import com.br.collectioncomparison.model.LinkedListAddFirstTestADD;
import com.br.collectioncomparison.model.LinkedListAddLastTestADD;
import com.br.collectioncomparison.model.LinkedListAddTestADD;
import com.br.collectioncomparison.model.OrderArrayListTestADD;
import com.br.collectioncomparison.model.OrderEAdicionarArrayListTestADD;
import com.br.collectioncomparison.model.TreeSetTestADD;
import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.model.entities.ArrayListTestADD;

public class SupplierTestChoice implements Supplier<TestObject[]>  {

    private static final TestObject[] titles = new TestObject[]{
            new TestObject("Adicionar elementos no ArrayList", new ArrayListTestADD()),
            new TestObject("Adicionar elementos no HashSet", new HashSetTestADD()),
            new TestObject("Adicionar elementos no TreeSet", new TreeSetTestADD()),
            new TestObject("Adicionar elementos no LinkedList usando add", new LinkedListAddTestADD()),
            new TestObject("Adicionar elementos no LinkedList usando addFirst", new LinkedListAddFirstTestADD()),
            new TestObject("Adicionar elementos no LinkedList usando addLast", new LinkedListAddLastTestADD()),
            new TestObject("Adicionar e ordenar elementos no ArrayList", new OrderEAdicionarArrayListTestADD()),
            new TestObject("Ordenar elementos no ArrayList", new OrderArrayListTestADD())
    };

    @Override
    public TestObject[] get() {
        return titles;
    }
}
