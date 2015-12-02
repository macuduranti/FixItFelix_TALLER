package grafica;

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

import juego.Puntaje;
public class PantallaPuntaje extends JFrame {

	private JPanel contentPane;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 432);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal JframePrincipal;
				try {
					JframePrincipal = new PantallaPrincipal();
					JframePrincipal.setVisible(true);
					setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		label_1.setIcon(new ImageIcon(PantallaPuntaje.class.getResource("/res/flecha_final.png")));
		label_1.setBounds(16, 17, 52, 52);
		contentPane.add(label_1);
		
		
		
		
		Vector<Puntaje> vector = Juego.getInstance().getTopFive();
		
		
		
		String[] columnas = {"NOMBRE", "PUNTAJE"};;
		Object[][] data = {
				{"prueba", "prueba2"}  
		};
		DefaultTableModel dtm= new DefaultTableModel(data, columnas);
		
		final JTable table = new JTable(dtm);
		
		
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));

		//Creamos un scrollpanel y se lo agregamos a la tabla 
		JScrollPane scrollpane = new JScrollPane(table);

		//Agregamos el scrollpanel al contenedor 
		getContentPane().add(scrollpane, BorderLayout.CENTER);

		//manejamos la salida 
		addWindowListener(new WindowAdapter() {

		public void windowClosing(WindowEvent e) { 
		System.exit(0); 
		} 
		}); 
		

	
		
		
		
		
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		table.setBounds(100,100,1,1);
		


	


		
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon(PantallaPuntaje.class.getResource("/res/fondo puntaje.jpg")));
		label.setBounds(0, 0, 660, 423);
		contentPane.add(label);
		
	}
}
