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
		setBounds(100, 100, 590, 432);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		getContentPane().setLayout(null);
		Vector<Puntaje> v = new Vector<Puntaje>();
		
		ObjectInputStream entrada;
		try {
			entrada = new ObjectInputStream(new FileInputStream("puntajes.dat"));
			v = (Vector) entrada.readObject();
		} catch (FileNotFoundException e) {
			Puntaje p1 = new Puntaje();
			v.addElement(p1);
			v.elementAt(0).setPuntos(100);
			v.elementAt(0).setNombre("Santi Pellegrino");
			Puntaje p2 = new Puntaje();
			v.addElement(p2);
			v.elementAt(1).setPuntos(80);
			v.elementAt(1).setNombre("Agus Galizia");
			Puntaje p5 = new Puntaje();
			v.addElement(p5);
			v.elementAt(2).setPuntos(70);
			v.elementAt(2).setNombre("Macu Duranti");
			Puntaje p3 = new Puntaje();
			v.addElement(p3);
			v.elementAt(3).setPuntos(50);
			v.elementAt(3).setNombre("Steve Jobs");
			Puntaje p4 = new Puntaje();
			v.addElement(p4);
			v.elementAt(4).setPuntos(35);
			v.elementAt(4).setNombre("DIOS");  // ;)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 99, 448, 197);
		getContentPane().add(scrollPane);
		Object[][] datos = new Object[5][2];
		for(int i=0; i<5; i++){
			datos[i][0] = v.get(i).getNombre();
			datos[i][1]	= v.get(i).getPuntos();
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

    	   


			