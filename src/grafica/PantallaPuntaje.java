package grafica;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.Date;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

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
	
	public PantallaPuntaje() {
		setBounds(100, 100, 590, 432);
		this.setLocationRelativeTo(PantallaPrincipal.getInstance());
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		JLabel label_1 = new JLabel(""); // Boton atras
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal.getInstance().setLocationRelativeTo(PantallaPuntaje.this);
				setVisible(false);
				PantallaPrincipal.getInstance().setVisible(true);

			}
		});
		
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass()
					.getResourceAsStream("/res/fuente/VCR_OSD_MONO_1.001.ttf"));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		genv.registerFont(font);
		font = font.deriveFont(12f);
		
		label_1.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/flecha_final.png")));
		label_1.setBounds(16, 17, 52, 52);
		getContentPane().add(label_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createMatteBorder(2 , 2, 2, 2, Color.BLACK ));
		scrollPane.setBounds(81, 82, 450, 231);
		getContentPane().add(scrollPane);
		
		
		
		Object[][] datos = new Object[MainJuego.getTopFive().size()][2];
		for(int i=0; i<MainJuego.getTopFive().size(); i++){
			datos[i][0] = MainJuego.getTopFive().get(i).getNombre();
			datos[i][1]	= MainJuego.getTopFive().get(i).getPuntos();
			
		}

		
		String[] columnas = {"NOMBRE", " PUNTAJE"};
		
		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer(); 
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableModel dtm = new DefaultTableModel(datos, columnas);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		scrollPane.setBackground(Color.black);
		
		table.setBackground(Color.black);
		table.getTableHeader().setFont(font.deriveFont(Font.PLAIN, 40f));
		table.getTableHeader().setForeground(Color.YELLOW);
		table.getTableHeader().setBackground(Color.BLACK);
		table.setRowHeight(37);
		table.setFont(font.deriveFont(Font.PLAIN, 23f));
		table.setBorder(null);
		table.setForeground(Color.WHITE);
		table.setShowGrid(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		table.setFocusable(false);
		table.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaPuntaje.class.getResource("/res/fondo puntaje.jpg")));
		lblNewLabel.setBounds(0, 0, 590, 410);
		getContentPane().add(lblNewLabel);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	
	}

    	   


			