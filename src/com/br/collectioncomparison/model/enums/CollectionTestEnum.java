package com.br.collectioncomparison.model.enums;

import com.br.collectioncomparison.model.entities.ArrayListTestADD;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public enum CollectionTestEnum {
	ADICIONARELEMENTOSNOARRAYLIST("Adicionar elementos no arrayList", new ArrayListTestADD()),
	exemplo("Adicionar elementos no arrayList", new ArrayListTestADD());

	private String titleTest;
	private CollectionTest collectionTest;

	private CollectionTestEnum(String titleTest, CollectionTest collectionTest) {
		this.titleTest = titleTest;
		this.collectionTest = collectionTest;
	}

	public String getTitleTest() {
		return titleTest;
	}

	public CollectionTest getCollectionTest() {
		return collectionTest;
	}
}
