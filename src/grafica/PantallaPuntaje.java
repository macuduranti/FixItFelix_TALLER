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
import java.io.IOException;
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
		
		
		
		
	
		String[] columnas = {"NOMBRE", "PUNTAJE"};
		Object[][] data = {
				//{juego.Juego.v[0].getPuntaje(), juego.Juego.v[].getNombre()}   PREGUNTAR COMO HACER CON EL VECTOR
				{"hola", "chau"}
		};
		final JTable table = new JTable(data, columnas);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		


	


		
		
		/*JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PantallaPuntaje.class.getResource("/res/fondo puntaje.jpg")));
		label.setBounds(0, 0, 660, 423);
		contentPane.add(label);*/
		
	}
}
