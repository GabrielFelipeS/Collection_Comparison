package com.br.collectioncomparison.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

import com.br.collectioncomparison.controller.ComparableController;
import com.br.collectioncomparison.controller.PerformanceTesterController;
import com.br.collectioncomparison.model.domain.DataFile;
import com.br.collectioncomparison.model.domain.TestObject;
import com.br.collectioncomparison.model.interfaces.CollectionTest;
import com.br.collectioncomparison.patterns.supplier.SupplierDataFiles;
import com.br.collectioncomparison.patterns.supplier.SupplierCollectionTest;

@SuppressWarnings("serial")
public class ComparableView extends JFrame {
	private JComboBox<DataFile> fileNames = new JComboBox<>();
	private JComboBox<CollectionTest> choiceOfActions = new JComboBox<>();
	private JTable table = new JTable();
	private DefaultTableModel model = (DefaultTableModel) table.getModel();
	private JProgressBar progressBar;
	private JTextField tf;

	private ComparableController controller = new ComparableController(model, new PerformanceTesterController());

	public static void main(String[] args) {
		ComparableView b = new ComparableView();
		b.setVisible(true);
	}

	public ComparableView() {
		UIManagetSet(new NimbusLookAndFeel());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Container container = getContentPane();
		setLayout(null);

		tf = new JTextField(10);

		tf.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if(tf.getText().isBlank()) {
					tf.setText("Insira a quantidade de dados que gostaria de testar");
					tf.setForeground(Color.GRAY);
				} else if(!tf.getText().matches("^[0-9]+$")){
					String replace = tf.getText().replaceAll("[^0-9]", "");
					tf.setText(replace);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if(tf.getText().equals("Insira a quantidade de dados que gostaria de testar")) {
					tf.setText("");
					tf.setForeground(Color.BLACK);

				}
			}
		});


		tf.setBounds(20, 40, 300, 27);

		fileNames.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DataFile data = (DataFile) fileNames.getSelectedItem();
				if(data.getTitle().equals("Personalizado")) {
					add(tf);
					tf.setVisible(true);
					tf.setText("Insira a quantidade de dados que gostaria de testar");
					tf.setForeground(Color.GRAY);

					choiceOfActions.setBounds(20, 70, 300, 20);

				} else {
					tf.setText("");
					tf.setVisible(false);
					choiceOfActions.setBounds(20, 60, 300, 20);
					remove(tf);
				}
			}
		});

		model.addColumn("Titulo do teste");
		model.addColumn("Arquivo de dados");
		model.addColumn("Tempo de execução (Millisegundos)");
		model.addTableModelListener(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 100, 961, 350);
		container.add(scrollPane);

		addFiles(fileNames);
		fileNames.setBounds(20, 20, 300, 20);
		container.add(fileNames);

		addChoideActions(choiceOfActions);
		choiceOfActions.setBounds(20, 60, 300, 20);
		container.add(choiceOfActions);

		JButton jbClear = new JButton("Limpar tabela");
		jbClear.setBounds(690, 10, 250, 30);
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
		jbDelete.setBounds(690, 40, 250, 30);
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

		Icon testar = new ImageIcon("files/images/alert1.png");
		JButton jbTest = new JButton("Testar", testar);
		jbTest.setBounds(400, 10, 250, 30);
		jbTest.setBackground(new Color(34, 139, 34));
		jbTest.setFont(new Font("Roboto", Font.PLAIN, 15));
		jbTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jbTest.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				jbTest.setFont(new Font("Roboto", Font.BOLD, 15));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbTest.setFont(new Font("Roboto", Font.PLAIN, 15));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				test();
			}

		});

		add(jbTest);

		Icon cuidado = new ImageIcon("files/images/cuidado.png");
		JButton jbUseAllTests = new JButton("Todos os testes", cuidado);
		jbUseAllTests.setBounds(400, 40, 250, 30);
		jbUseAllTests.setBackground(new Color(206, 176, 23));
		// jbTestAll.setBorder(BorderFactory.createLineBorder(Color.red));
		jbUseAllTests.setFont(new Font("Roboto", Font.PLAIN, 15));
		jbUseAllTests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jbUseAllTests.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				// jbUseAllTests.setBackground(new Color(186, 176, 23));
				jbUseAllTests.setFont(new Font("Roboto", Font.BOLD, 15));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbUseAllTests.setBackground(new Color(206, 176, 23));
				jbUseAllTests.setFont(new Font("Roboto", Font.PLAIN, 15));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				useAllTests();
			}

		});

		add(jbUseAllTests);

		Icon atencao = new ImageIcon("files/images/atencao.png");
		JButton jbTestAll = new JButton("Todas as combinações", atencao);
		jbTestAll.setBounds(400, 70, 250, 30);
		jbTestAll.setBackground(new Color(165, 5, 44));
		// jbTestAll.setBorder(BorderFactory.createLineBorder(Color.red));
		jbTestAll.setFont(new Font("Roboto", Font.PLAIN, 15));
		jbTestAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jbTestAll.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				jbTestAll.setBackground(new Color(180, 5, 44));
				jbTestAll.setFont(new Font("Roboto", Font.BOLD, 15));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbTestAll.setBackground(new Color(165, 5, 44));
				jbTestAll.setFont(new Font("Roboto", Font.PLAIN, 15));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				useAllCombinations();
			}

		});
		add(jbTestAll);

		progressBar = new JProgressBar();
		progressBar.setBounds(10, 460, 961, 25);

		add(progressBar);

		setSize(1000, 530);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	private void UIManagetSet(LookAndFeel lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	protected void deleteBy() {
		try {
			int row = table.getSelectedRow();
			controller.deleteBy(row);
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para apagar", "Alerta", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void clear() {
		controller.cleanTable();
	}


	private boolean isSizeNotPersonalized() {
		return !tf.isVisible();
	}


	private void test() {
		if(isSizeNotPersonalized() || insertSize()) {
			DataFile dataFile = (DataFile) fileNames.getSelectedItem();
			CollectionTest testObject =  (CollectionTest) choiceOfActions.getSelectedItem();
			controller.updateTableByTest(dataFile, testObject);
		} else {
			JOptionPane.showConfirmDialog(null,
					"Por favor insira um tamanho padrão ou um tamanho valido", "Aviso", JOptionPane.YES_NO_OPTION);
		}
	}

	private boolean insertSize() {
		String text = tf.getText();
		if(text.replaceAll("[^0-9]", "").isBlank()) return false;

		DataFile dataFile = (DataFile) fileNames.getSelectedItem();
		dataFile.setFileName(text);

		return true;
	}

	private void useAllTests() {
		DataFile dataFile = (DataFile) fileNames.getSelectedItem();
		controller.useAllTests(dataFile ,choiceOfActions);
	}

	private void useAllCombinations() {

		if(messageYesNoOption("Essa opção leva alguns minutos\nGostaria de continuar?") == JOptionPane.YES_OPTION &&
			messageYesNoOption("Você tem certeza que quer continuar?") == JOptionPane.YES_OPTION
			) {

			controller.useAllCombinations(fileNames, choiceOfActions);

		}
	}

	private int messageYesNoOption(String message) {
		return messageYesNoOption(message, "Aviso");
	}

	private int messageYesNoOption(String message, String title) {
		return  JOptionPane.showConfirmDialog(null,
				message, title, JOptionPane.YES_NO_OPTION);
	}

	private void addChoideActions(JComboBox<CollectionTest> choiceOfActions) {
		for (CollectionTest testObject : new SupplierCollectionTest().get()) {
			choiceOfActions.addItem(testObject);
		}
	}

	private void addFiles(JComboBox<DataFile> fileNames) {
		for (DataFile df : new SupplierDataFiles().get()) {
			fileNames.addItem(df);
		}
	}
}

