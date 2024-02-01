package com.br.collectioncomparison.patterns.supplier;

import java.util.function.Supplier;

import com.br.collectioncomparison.model.enums.DataFile;

public class SupplierDataFiles implements Supplier<DataFile[]> {
	private static final DataFile[] files = new DataFile[] {
			new DataFile("Arquivo com 1499 funcionarios", "files/massaDados.csv")	
	};

	@Override
	public DataFile[] get() {
		return files;
	}
	
	
}
