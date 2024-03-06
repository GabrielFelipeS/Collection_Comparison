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
import com.br.collectioncomparison.model.entities.AdicionarEOrdenarArrayListTestADD;
import com.br.collectioncomparison.model.entities.PriorityQueueADD;
import com.br.collectioncomparison.model.entities.QueueADD;
import com.br.collectioncomparison.model.entities.TreeMapADD;
import com.br.collectioncomparison.model.entities.TreeSetTestADD;
import com.br.collectioncomparison.model.interfaces.CollectionTest;
import com.br.collectioncomparison.util.FindClassesByInterface;

public class SupplierCollectionTest implements Supplier<CollectionTest[]>  {
	   private static final CollectionTest[] titles;
	    
	    static {
	    	FindClassesByInterface<CollectionTest> clazz = 
	    			new FindClassesByInterface<CollectionTest>("com.br.collectioncomparison.model.entities", CollectionTest.class);
	    	titles = clazz.find().toArray(new CollectionTest[0]);
	    }
	    


	    @Override
	    public CollectionTest[] get() {
	        return titles;
	    }


}
