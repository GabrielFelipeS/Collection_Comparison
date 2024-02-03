package com.br.collectioncomparison.application;

import javax.swing.JOptionPane;

import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.patterns.supplier.SupplierTestChoice;

public class TestSuppliers {

	public static void main(String[] args) {
//	
//		String s = JOptionPane.showInputDialog(null, "Melhor mensagem para descrever","Test options" ,
//				JOptionPane.PLAIN_MESSAGE , null ,new SupplierTitleTest().get(),"").toString();
//		
//		CollectionTest c = new CollectionTestStrategy().getFunctionTestOf(s);
//		c.test(null);
		
		  TestObject selecionado = (TestObject) JOptionPane.showInputDialog(null, "Melhor mensagem para descrever", "Test options",
	                JOptionPane.PLAIN_MESSAGE, null, new SupplierTestChoice().get(), "");

	        // Roda o teste
	        selecionado.getCollectionTest().test(null);
	}

}
