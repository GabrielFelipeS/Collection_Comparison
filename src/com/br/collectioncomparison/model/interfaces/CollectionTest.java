package com.br.collectioncomparison.model.interfaces;

import java.time.Instant;
import java.util.Date;

import com.br.collectioncomparison.model.domain.Employee;

public interface CollectionTest {
	default long getMilliseconds() {
		long milliseconds = new Date().getTime();
		return milliseconds;
	}
	
	default Instant getInstant() {
		return Instant.now();
	}
	
	long test(Employee[] employees);
}
