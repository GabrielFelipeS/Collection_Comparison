package com.br.collectioncomparison.model.interfaces;

import java.util.Date;

import com.br.collectioncomparison.model.domain.Employee;

public interface CollectionTest {
	default long getMilliseconds() {
		long milliseconds = new Date().getTime();
		System.out.println("Date: " + milliseconds);
		System.out.println("System: " + System.currentTimeMillis());
		
		return milliseconds;
	}
	
	long test(Employee[] employees);
}
