package com.br.collectioncomparison.model.enums;

public enum DataFile {
	ARQUIVOCOM1499FUNCIONARIOS("Arquivo com 1499 funcionarios", "files/massaDados.csv");

	
	private String title;
	private String fileName;
	
	private DataFile(String title, String fileName) {
		this.title = title;
		this.fileName = fileName;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getFileName() {
		return fileName;
	}
}
