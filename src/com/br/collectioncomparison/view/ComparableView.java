package com.br.collectioncomparison.view;

import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ComparableView extends JFrame {
	private JComboBox<String> choiceOfActions =  new JComboBox<>();
	private JTable table;
	private JComboBox fileNames;
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
		
		table.setBounds(10, 185, 760, 300);
		JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 185, 760, 350);

		container.add(scrollPane);

		
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	//- fileNames: JComboBox
}
