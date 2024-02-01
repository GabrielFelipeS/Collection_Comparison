package com.br.collectioncomparison.model.enums;

public class DataFile {
	private String title;
	private String fileName;
	
	public DataFile(String title, String fileName) {
		this.title = title;
		this.fileName = fileName;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	
	@Override
	public String toString() {
		return title;
	}
}
