package grafica;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
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
import juego.MainJuego;

import com.sun.scenario.effect.Blend.Mode;

import controller.Controller;
import juego.Puntaje;
import juego.Puntaje;
public class PantallaPuntaje extends JFrame {
	private JTable table;
	
	public PantallaPuntaje(PantallaPrincipal pp) {
		setBounds(100, 100, 590, 432);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		JLabel label_1 = new JLabel(""); // Boton atras
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				pp.setLocationRelativeTo(PantallaPuntaje.this);
				setVisible(false);
				pp.setVisible(true);

			}
		});
		label_1.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/flecha_final.png")));
		label_1.setBounds(16, 17, 52, 52);
		getContentPane().add(label_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 99, 448, 197);
		getContentPane().add(scrollPane);
		Object[][] datos = new Object[MainJuego.getTopFive().size()][2];
		for(int i=0; i<MainJuego.getTopFive().size(); i++){
			datos[i][0] = MainJuego.getTopFive().get(i).getNombre();
			datos[i][1]	= MainJuego.getTopFive().get(i).getPuntos();
		}
		
		String[] columnas = {"Nombre", "Puntaje"};
		DefaultTableModel dtm = new DefaultTableModel(datos, columnas);
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaPuntaje.class.getResource("/res/fondo puntaje.jpg")));
		lblNewLabel.setBounds(0, 0, 590, 410);
		getContentPane().add(lblNewLabel);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	
	}

    	   


			