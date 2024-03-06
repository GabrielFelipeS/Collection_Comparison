package com.br.collectioncomparison.patterns.supplier;

import java.util.function.Supplier;

import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.model.entities.ArrayListTestADD;
import com.br.collectioncomparison.model.entities.DequeAddFirstTestADD;
import com.br.collectioncomparison.model.entities.DequeAddLastTestADD;
import com.br.collectioncomparison.model.entities.DequeAddTestADD;
import com.br.collectioncomparison.model.entities.HashMapADD;
import com.br.collectioncomparison.model.entities.HashSetTestADD;
import com.br.collectioncomparison.model.entities.LinkedHashMapADD;
import com.br.collectioncomparison.model.entities.LinkedListAddFirstTestADD;
import com.br.collectioncomparison.model.entities.LinkedListAddLastTestADD;
import com.br.collectioncomparison.model.entities.LinkedListAddTestADD;
import com.br.collectioncomparison.model.entities.OrderArrayListTestADD;
import com.br.collectioncomparison.model.entities.OrderEAdicionarArrayListTestADD;
import com.br.collectioncomparison.model.entities.PriorityQueueADD;
import com.br.collectioncomparison.model.entities.QueueADD;
import com.br.collectioncomparison.model.entities.TreeMapADD;
import com.br.collectioncomparison.model.entities.TreeSetTestADD;

public class SupplierTestChoice implements Supplier<TestObject[]>  {
    
    private static final TestObject[] titles = new TestObject[]{
            new TestObject("Adicionar elementos no ArrayList", new ArrayListTestADD()),
            new TestObject("Adicionar elementos no Queue", new QueueADD()),
            new TestObject("Adicionar elementos no PriorityQueue", new PriorityQueueADD()),
            new TestObject("Adicionar elementos no Deque usando add", new DequeAddTestADD()),
            new TestObject("Adicionar elementos no Deque usando addFirst", new DequeAddFirstTestADD()),
            new TestObject("Adicionar elementos no Deque  usando addLast", new DequeAddLastTestADD()),
            new TestObject("Adicionar elementos no HashMap", new HashMapADD()),
            new TestObject("Adicionar elementos no LinkedHashMap", new LinkedHashMapADD()),
            new TestObject("Adicionar elementos no TreeMap", new TreeMapADD()),
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
