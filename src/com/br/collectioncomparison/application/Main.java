package com.br.collectioncomparison.application;

import java.awt.EventQueue;

import com.br.collectioncomparison.view.ComparableView;

public class Main {
    public static void main(String[] args) {
    	   EventQueue.invokeLater(() ->  new ComparableView().setVisible(true));
    }
}