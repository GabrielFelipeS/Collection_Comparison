package com.br.collectioncomparison.model.domain;

import java.time.LocalDateTime;

public record PerformaceResults(
		String testTitle, 
		String fileName, 
		Long runtime,
		LocalDateTime dataHora) {

}
