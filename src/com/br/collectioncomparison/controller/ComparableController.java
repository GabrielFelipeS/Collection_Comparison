package com.br.collectioncomparison.controller;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.br.collectioncomparison.model.domain.DataFile;
import com.br.collectioncomparison.model.domain.PerformaceResults;
import com.br.collectioncomparison.model.domain.TestObject;

public class ComparableController {
	private DefaultTableModel tableContent;
	private PerformanceTesterController controller;
	
	public ComparableController(DefaultTableModel tableContent, PerformanceTesterController controller) {
		this.tableContent = tableContent;
		this.controller = controller;
	}

	public void testAll(DataFile dataFile, JComboBox<TestObject> choiceOfActions) {
		int size = choiceOfActions.getItemCount();
		
		for(int index = 0; index < size; index++) {
			TestObject test = choiceOfActions.getItemAt(index);
			updateTableByTest(dataFile, test);
		}
	}
	
	public void updateTableByTest(DataFile dataFile, TestObject testObject) {
		PerformaceResults pr = controller.test(dataFile, testObject);
		updateTable(pr);
	}

	private void updateTable(PerformaceResults pr) {
		tableContent.addRow(new Object[] { pr.testTitle(), pr.fileName(), pr.runtime()});
	}

	public void cleanTable() {
		tableContent.getDataVector().clear();
		tableContent.fireTableDataChanged();
	}

	public void deleteBy(int row) {
		tableContent.removeRow(row);
	}

}
