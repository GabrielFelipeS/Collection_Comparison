package com.br.collectioncomparison.view;

import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.br.collectioncomparison.model.entities.TestObject;
import com.br.collectioncomparison.model.enums.DataFile;
import com.br.collectioncomparison.patterns.supplier.SupplierDataFiles;
import com.br.collectioncomparison.patterns.supplier.SupplierTestChoice;

public class ComparableView extends JFrame {
	private JComboBox<TestObject> choiceOfActions =  new JComboBox<>();
	private JTable table;
	private JComboBox<DataFile> fileNames =  new JComboBox<>();
	private DefaultTableModel model;
	
	public static void main(String[] args) {
		ComparableView b = new ComparableView();
		b.setVisible(true);
	}
	
	public ComparableView() {
		Container container = getContentPane();
		setLayout(null);
		
		table = new JTable();
		model = (DefaultTableModel) table.getModel();

		model.addColumn("Identificador do Produto");
		model.addColumn("Nome do Produto");
		model.addColumn("Descrição do Produto");
		
//		table.setBounds(10, 185, 760, 300);
		JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 100, 760, 350);

		container.add(scrollPane);
		
		
		addFiles(fileNames);
		fileNames.setBounds(20, 20, 250, 20);
		container.add(fileNames);
		
		addChoideActions(choiceOfActions);
		choiceOfActions.setBounds(20, 60, 250, 20);
		container.add(choiceOfActions);
		
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void addChoideActions(JComboBox<TestObject> choiceOfActions) {
		for(TestObject testObject: new SupplierTestChoice().get()) {
			choiceOfActions.addItem(testObject);
		}
	}

	private void addFiles(JComboBox<DataFile> fileNames) {
		for(DataFile df: new SupplierDataFiles().get()) {
			fileNames.addItem(df);
		}
	}
}
