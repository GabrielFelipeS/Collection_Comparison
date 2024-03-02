package com.br.collectioncomparison.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

public class ProgressWithSwingWorker extends JFrame {

    private JButton btnChecar;
    private JProgressBar progressBar;
    private JScrollPane ScrollPane;
    private JTable tabela;

    public ProgressWithSwingWorker() {
        initComponents();
    }

    private void initComponents() {

        ScrollPane = new JScrollPane();
        btnChecar = new JButton();
        progressBar = new JProgressBar();

        String[] columns = {"coluna 1", "coluna 2", "coluna 3", "coluna 4"};
        Object[][] data = new Object[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return Boolean.class;
                } else {
                    return super.getColumnClass(columnIndex);
                }
            }
        };

        tabela = new JTable(model);

        ScrollPane.setViewportView(tabela);
        btnChecar.setText("Checar");
        //A "mágica" acontece na classe ChecarComSwingWorker
       // btnChecar.addActionListener(new ChecarComSwingWorker());

        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(ScrollPane, BorderLayout.NORTH);
        this.add(btnChecar, BorderLayout.CENTER);
        this.add(progressBar, BorderLayout.SOUTH);

        pack();
    }

    public static void main(String args[]) {

        EventQueue.invokeLater(() -> new ProgressWithSwingWorker().setVisible(true));
    }

   
}