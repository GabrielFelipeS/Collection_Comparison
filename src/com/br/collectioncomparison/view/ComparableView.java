package com.br.collectioncomparison.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.br.collectioncomparison.controller.ComparableController;
import com.br.collectioncomparison.controller.PerformanceTesterController;
import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.model.enums.DataFile;
import com.br.collectioncomparison.patterns.supplier.SupplierDataFiles;
import com.br.collectioncomparison.patterns.supplier.SupplierTestChoice;

public class ComparableView extends JFrame {
	private JComboBox<DataFile> fileNames = new JComboBox<>();
	private JComboBox<TestObject> choiceOfActions = new JComboBox<>();
	private JTable table = new JTable();
	private DefaultTableModel model = (DefaultTableModel) table.getModel();

	private ComparableController controller = new ComparableController(model, new PerformanceTesterController());

	public static void main(String[] args) {
		ComparableView b = new ComparableView();
		b.setVisible(true);
	}

	public ComparableView() {
		Container container = getContentPane();
		setLayout(null);

		model.addColumn("Titulo do teste");
		model.addColumn("Arquivo de dados");
		model.addColumn("Tempo de execução (Millisegundos)");

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 100, 760, 350);

		container.add(scrollPane);

		addFiles(fileNames);
		fileNames.setBounds(20, 20, 300, 20);
		container.add(fileNames);

		addChoideActions(choiceOfActions);
		choiceOfActions.setBounds(20, 60, 300, 20);
		container.add(choiceOfActions);

		JButton jbClear = new JButton("Limpar tabela");
		jbClear.setBounds(400, 20, 250, 20);
		jbClear.setFont(new Font("Roboto", Font.PLAIN, 15));
		jbClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jbClear.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
			}

		});

		add(jbClear);

		JButton jbDelete = new JButton("Apagar");
		jbDelete.setBounds(400, 40, 250, 20);
		jbDelete.setFont(new Font("Roboto", Font.PLAIN, 15));
		jbDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jbDelete.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				deleteBy();
			}

		});

		add(jbDelete);

		JButton jbTest = new JButton("Testar");
		jbTest.setBounds(400, 60, 250, 20);
		jbTest.setFont(new Font("Roboto", Font.PLAIN, 15));
		jbTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jbTest.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				test();
			}

		});

		add(jbTest);

		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	protected void deleteBy() {
		try {
			int row = table.getSelectedRow();
			controller.deleteBy(row);
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para pagar", "Alerta", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void clear() {
		controller.cleanTable();
	}

	private void test() {
		DataFile dataFile = (DataFile) fileNames.getSelectedItem();
		TestObject testObject = (TestObject) choiceOfActions.getSelectedItem();
		controller.updateTableByTest(dataFile, testObject);
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
