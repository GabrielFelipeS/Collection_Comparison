package com.br.collectioncomparison.patterns.supplier;

import java.util.function.Supplier;

import com.br.collectioncomparison.model.enums.CollectionTestEnum;
import com.br.collectioncomparison.model.enums.DataFile;

public class SupplierTitleTest implements Supplier<String[]>{

	@Override
	public String[] get() {
		CollectionTestEnum[] collectionTestEnums = CollectionTestEnum.values();
		String[] titles = new String[collectionTestEnums.length];
		
		for(int i = 0;i < collectionTestEnums.length; i++) {
			titles[i] = collectionTestEnums[i].getTitleTest();
		}
	
		return titles;
	}

}
