package com.br.collectioncomparison.patterns.strategy;

import java.util.Map;

import com.br.collectioncomparison.model.entities.ArrayListTestADD;
import com.br.collectioncomparison.model.interfaces.CollectionTest;


// TODO tentando entender a diferença
public class CollectionTestMap {
	private static Map<String, CollectionTest> map = Map.of(
			"Adicionar elementos no arrayList", new ArrayListTestADD(),
			"abacate", new ArrayListTestADD()
		);

	public static CollectionTest getCollectionTest(String title) {
		return map.get(title);
	}

}
