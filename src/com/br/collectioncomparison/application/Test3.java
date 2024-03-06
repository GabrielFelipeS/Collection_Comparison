package com.br.collectioncomparison.application;

import java.util.List;

import com.br.collectioncomparison.model.entities.ArrayListTestADD;
import com.br.collectioncomparison.model.interfaces.CollectionTest;
import com.br.collectioncomparison.util.FindClassesByInterface;

public class Test3 {
	public static void main(String[] args) {
		FindClassesByInterface<CollectionTest> find = new FindClassesByInterface<CollectionTest>(ArrayListTestADD.class, CollectionTest.class);
		List<CollectionTest> a = find.find();
		a.forEach(System.out::println);
	}
}
