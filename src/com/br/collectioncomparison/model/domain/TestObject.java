package com.br.collectioncomparison.model.domain;

import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class TestObject {
	private String title;
    private CollectionTest collectionTest;

    public TestObject(String title, CollectionTest collectionTest) {
        this.title = title;
        this.collectionTest = collectionTest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CollectionTest getCollectionTest() {
        return collectionTest;
    }

    @Override
    public String toString() {
        return title;
    }
}
