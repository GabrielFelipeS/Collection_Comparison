package com.br.collectioncomparison.patterns.strategy;

import com.br.collectioncomparison.model.enums.DataFile;

public class DataFileStrategy {
	public static String getFilePathBy(String fileTitle) {
		String titleEnum = fileTitle.replaceAll(" ", "").toUpperCase();
		return DataFile.valueOf(titleEnum).getFileName();
	}
}
