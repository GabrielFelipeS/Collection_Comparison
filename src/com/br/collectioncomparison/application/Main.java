//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package com.br.collectioncomparison.application;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.service.EmployeeFileReader;
import com.br.collectioncomparison.patterns.strategy.DataFileStrategy;

public class Main {
    public static void main(String[] args) {
     var s = "Arquivo com 1499 funcionarios".replaceAll(" ", "").toUpperCase();
     System.out.println(s);
     //Employee[] es = EmployeeFileReader.read(DataFileStrategy.getFilePathBy("Arquivo com 1499 funcionarios"));
    
    }
}