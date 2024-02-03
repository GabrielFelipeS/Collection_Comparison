package com.br.collectioncomparison.patterns.supplier;

import java.util.function.Supplier;

import com.br.collectioncomparison.model.enums.DataFile;

public class SupplierDataFiles implements Supplier<DataFile[]> {
	private static final DataFile[] files = new DataFile[] {
			new DataFile("Arquivo com 500 funcionarios", "files/MOCK_DATA500.csv"),	
			new DataFile("Arquivo com 1.000 funcionarios", "files/MOCK_DATA1000.csv"),	
			new DataFile("Arquivo com 5.000 funcionarios", "files/MOCK_DATA5000.csv"),	
			new DataFile("Arquivo com 10.000 funcionarios", "files/MOCK_DATA10000.csv"),	
			new DataFile("Arquivo com 50.000 funcionarios", "files/MOCK_DATA50000.csv"),	
			new DataFile("Arquivo com 100.000 funcionarios", "files/MOCK_DATA100000.csv"),	
			new DataFile("Arquivo com 500.000 funcionarios", "files/MOCK_DATA500000.csv"),	
			new DataFile("Arquivo com 1.000.000 funcionarios", "files/MOCK_DATA1000000.csv"),	
			new DataFile("Arquivo com 2.147.483.646 funcionarios", "files/MOCK_DATA2147483646.csv"),	
			
	};

	@Override
	public DataFile[] get() {
		return files;
	}
	
	
}
