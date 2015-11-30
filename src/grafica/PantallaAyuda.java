package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaAyuda extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAyuda frame = new PantallaAyuda();
					frame.setVisible(true);	//Creacion de la pantalla ayuda
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PantallaAyuda() { //Constructor de Ayuda
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 432);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel label_1 = new JLabel(""); //Boton atras
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal JframePrincipal;
				try {
					JframePrincipal = new PantallaPrincipal();
					JframePrincipal.setVisible(true);
					setVisible(false);
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		label_1.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/flecha_final.png")));
		label_1.setBounds(16, 17, 52, 52);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/pajaro3gif.gif")));
		label_3.setBounds(423, 167, 72, 52);
		contentPane.add(label_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/teclas.png")));
		label_6.setBounds(72, 176, 85, 72);
		contentPane.add(label_6);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/spacegif.gif")));
		label_5.setBounds(162, 69, 102, 89);
		contentPane.add(label_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/ladrillogif.gif")));
		label_4.setBounds(507, 146, 46, 102);
		contentPane.add(label_4);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/pastel2.gif")));
		label_2.setBounds(265, 330, 61, 52);
		contentPane.add(label_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/fondo ayuda.png")));
		label.setBounds(0, -41, 600, 450);
		contentPane.add(label);
	}
}
