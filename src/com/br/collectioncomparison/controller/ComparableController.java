package com.br.collectioncomparison.controller;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import com.br.collectioncomparison.model.domain.DataFile;
import com.br.collectioncomparison.model.domain.PerformaceResults;
import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class ComparableController {
	private DefaultTableModel tableContent;
	private PerformanceTesterController controller;

	public ComparableController(DefaultTableModel tableContent, PerformanceTesterController controller) {
		this.tableContent = tableContent;
		this.controller = controller;
	}

	public void updateTableByTest(DataFile dataFile, CollectionTest testObject) {
		PerformaceResults pr = controller.test(dataFile, testObject);
		updateTable(pr);
	}

	public void useAllTests(DataFile dataFile, JComboBox<CollectionTest> choiceOfActions) {
		int size = choiceOfActions.getItemCount();

		for(int index = 0; index < size; index++) {
			CollectionTest test = choiceOfActions.getItemAt(index);
			updateTableByTest(dataFile, test);
		}
	}

	public void useAllCombinations(JComboBox<DataFile> fileNames, JComboBox<CollectionTest> choiceOfActions) {
		ComboBoxModel<DataFile> model = fileNames.getModel();
		int size = model.getSize();

		for(int i = 0;i < size; i++) {
			DataFile dataFile = model.getElementAt(i);
			useAllTests(dataFile, choiceOfActions);
			//if(i == 2) break;
		}

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


