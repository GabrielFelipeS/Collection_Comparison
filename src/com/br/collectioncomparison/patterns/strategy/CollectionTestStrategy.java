package com.br.collectioncomparison.patterns.strategy;

import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class CollectionTestStrategy {
//	public static CollectionTest getFunctionTestOf(String testTitle) {
//		String titleToEnum = testTitle.replaceAll(" ", "").toUpperCase();
//		return CollectionTestEnum.valueOf(titleToEnum).getCollectionTest();
//	}
	
	public static CollectionTest getFunctionTestOf(String testTitle) {
		return CollectionTestMap.getCollectionTest(testTitle);
	}
	
}
