package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import controller.ExceptionExists;
import controller.ExceptionLength;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import juego.Juego;

public class PantallaGameOver extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;

	public static void main(String[] args) {
		JuegoGrafica jg = new JuegoGrafica();
		PantallaGameOver pgo = new PantallaGameOver(true, jg);
		try {
			throw new ExceptionExists();
		} catch (ExceptionExists e) {
			JDialog cartel = new JDialog(pgo);
			cartel.setLayout(null);
			cartel.setModal(true);
			cartel.setBounds(0, 0, 300, 100);
			cartel.setLocationRelativeTo(pgo);
			JLabel lblAdv = new JLabel("El nombre ya se encuentra en el top 5.");
			lblAdv.setBounds(0, 0, 300, 50);
			lblAdv.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdv.setVerticalAlignment(SwingConstants.CENTER);
			
			
			JButton button = new JButton("Nuevo Nombre");
			JButton button2 = new JButton("Reemplazar");
	
			cartel.add(button);
			cartel.add(button2);
			cartel.add(lblAdv);
			cartel.setVisible(true);
			e.printStackTrace();
		}
		pgo.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public PantallaGameOver(boolean record, JuegoGrafica jg) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(jg.frame);
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT,
					getClass().getResourceAsStream("/res/fuente/VCR_OSD_MONO_1.001.ttf"));
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
		contentPane.setLayout(null);

		if (record) {
			this.setFocusable(true);
			JLabel lblNewLabel_1 = new JLabel("¡FELICITACIONES!");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(font.deriveFont(Font.PLAIN, 50f));
			lblNewLabel_1.setBounds(59, 50, 480, 177);
			getContentPane().add(lblNewLabel_1);

			textField = new JTextField();
			textField.setBounds(148, 214, 230, 38);
			contentPane.add(textField);
			textField.setColumns(10);

			JLabel label_1 = new JLabel(""); // BOTON PUNTAJE Y ORDENA LISTA
			label_1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int[] index = new int[1];
					try {
						if (textField.getText().length() > 20)
							throw new ExceptionLength(20);
						else if (textField.getText().length() < 2)
							throw new ExceptionLength(2);
						if (Controller.getInstance().BuscarCoincidencia(textField.getText(),index))
							throw new ExceptionExists();
						Controller.getInstance().ActualizarLista(textField.getText(),
								Juego.getInstance().getPuntosJugadorActual());
						PantallaPrincipal.getInstance().setLocationRelativeTo(PantallaGameOver.this);
						setVisible(false);
						PantallaPrincipal.getInstance().setVisible(true);
					} catch (ExceptionLength e1) {
						JDialog cartel = new JDialog(PantallaGameOver.this);
						cartel.setLayout(null);
						cartel.setModal(true);
						cartel.setBounds(0, 0, 300, 100);
						cartel.setLocationRelativeTo(PantallaGameOver.this);
						JLabel lblAdv = new JLabel(ExceptionLength.getMensaje());
						lblAdv.setBounds(0, 0, 300, 50);
						lblAdv.setHorizontalAlignment(SwingConstants.CENTER);
						lblAdv.setVerticalAlignment(SwingConstants.CENTER);
						
						JButton button = new JButton("Aceptar");
						button.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								cartel.dispose();
							}
						});
						button.setBounds(100, 50, 100, 25);
						cartel.add(button);
						cartel.add(lblAdv);
						cartel.setVisible(true);
					}catch (ExceptionExists e1) {
						JDialog cartel = new JDialog(PantallaGameOver.this);
						cartel.setLayout(null);
						cartel.setModal(true);
						cartel.setBounds(0, 0, 300, 100);
						cartel.setLocationRelativeTo(PantallaGameOver.this);
						JLabel lblAdv = new JLabel("El nombre ya se encuentra en el top 5.");
						lblAdv.setBounds(0, 0, 300, 50);
						lblAdv.setHorizontalAlignment(SwingConstants.CENTER);
						lblAdv.setVerticalAlignment(SwingConstants.CENTER);
						
						
						JButton button = new JButton("Nuevo nombre");
						button.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								textField.setText("");
								cartel.dispose();
							}
						});
						JButton button2 = new JButton("Reemplazar");
						button2.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									Controller.getInstance().ActualizarListaReemplazando(textField.getText(), Juego.getInstance().getPuntosJugadorActual(), index[0]);
									PantallaPrincipal.getInstance().setLocationRelativeTo(PantallaGameOver.this);
									dispose();
									PantallaGameOver.this.setVisible(false);
									PantallaPrincipal.getInstance().setVisible(true);
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								cartel.dispose();
							}
						});
						button.setBounds(5, 50, 125, 25);
						button2.setBounds(195, 50, 100, 25);
						cartel.add(button);
						cartel.add(button2);
						cartel.add(lblAdv);
						cartel.setVisible(true);
					
				}catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});

			label_1.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}
			});
			label_1.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/flecha_adelante.png")));
			label_1.setBounds(390, 197, 52, 69);
			contentPane.add(label_1);

		}

		if (!record) {
			JLabel label_1 = new JLabel(""); // Boton atras
			label_1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					PantallaPrincipal.getInstance().setLocationRelativeTo(PantallaGameOver.this);
					setVisible(false);
					PantallaPrincipal.getInstance().setVisible(true);

				}
			});
			label_1.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/flecha_final.png")));
			label_1.setBounds(16, 17, 52, 52);
			getContentPane().add(label_1);

			JLabel lblNewLabel_1 = new JLabel("GAME OVER");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(font.deriveFont(Font.PLAIN, 50f));
			lblNewLabel_1.setBounds(0, 0, 490, 432);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setVerticalAlignment(SwingConstants.CENTER);
			getContentPane().add(lblNewLabel_1);
		}

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CambioSeccion.class.getResource("/res/fondo puntaje.jpg")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 590, 438);
		contentPane.add(lblNewLabel);

	}
}
