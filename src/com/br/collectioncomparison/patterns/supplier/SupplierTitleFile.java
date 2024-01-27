package com.br.collectioncomparison.patterns.supplier;

import java.util.function.Supplier;

import com.br.collectioncomparison.model.enums.DataFile;

public class SupplierTitleFile implements Supplier<String[]>{

	@Override
	public String[] get() {
		DataFile[] dataFiles = DataFile.values();
		String[] titles = new String[dataFiles.length];
		
		for(int i = 0;i < dataFiles.length; i++) {
			titles[i] = dataFiles[i].getTitle();
		}
	
		return titles;
	}

}
