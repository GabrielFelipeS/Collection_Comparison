package com.br.collectioncomparison.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.br.collectioncomparison.model.entities.TestObject;
import com.br.collectioncomparison.model.enums.DataFile;
import com.br.collectioncomparison.patterns.supplier.SupplierDataFiles;
import com.br.collectioncomparison.patterns.supplier.SupplierTestChoice;

public class ComparableView extends JFrame {
	private JComboBox<TestObject> choiceOfActions = new JComboBox<>();
	private JComboBox<DataFile> fileNames = new JComboBox<>();
	private JTable table;
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

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 100, 760, 350);

		container.add(scrollPane);

		addFiles(fileNames);
		fileNames.setBounds(20, 20, 250, 20);
		container.add(fileNames);

		addChoideActions(choiceOfActions);
		choiceOfActions.setBounds(20, 60, 250, 20);
		container.add(choiceOfActions);

		JPanel btnTest = new JPanel();
		btnTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnTest.setBounds(400, 60, 250, 20);
		btnTest.setLayout(null);
		btnTest.setBackground(Color.BLUE);
		btnTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblTestar = new JLabel("Testar");
		lblTestar.setBounds(0, 0, 250, 20);
		btnTest.add(lblTestar);
		lblTestar.setForeground(SystemColor.controlHighlight);
		//lblTestar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTestar.setFont(new Font("Roboto", Font.PLAIN, 18));

		add(btnTest);
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	
	private void test() {
		
	}

	private void addChoideActions(JComboBox<TestObject> choiceOfActions) {
		for (TestObject testObject : new SupplierTestChoice().get()) {
			choiceOfActions.addItem(testObject);
		}
	}

	private void addFiles(JComboBox<DataFile> fileNames) {
		for (DataFile df : new SupplierDataFiles().get()) {
			fileNames.addItem(df);
		}
	}
}
