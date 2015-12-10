package grafica;


import java.io.File;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import juego.Puntaje;
import juego.Juego;

import com.sun.scenario.effect.Blend.Mode;

import controller.Controller;
import juego.Puntaje;
import juego.Puntaje;
public class PantallaPuntaje extends JFrame {
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPuntaje frame = new PantallaPuntaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PantallaPuntaje() {
		getContentPane().setLayout(null);
		Arrays<Puntaje>[] v = Juego.getInstance().getTopFive();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 33, 328, 197);
		getContentPane().add(scrollPane);
		Object[][] datos = {};
		String[] columnas = {"Nombre", "Puntaje"};
		DefaultTableModel dtm = new DefaultTableModel(datos, columnas);
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		this.setVisible(true);
		
	}
	
	}

    	   


			