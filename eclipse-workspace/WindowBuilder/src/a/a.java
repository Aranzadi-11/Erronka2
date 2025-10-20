package a;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class a extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a frame = new a();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public a() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel hasieraPantaila = new JLabel("Kaixo Mundua");
		hasieraPantaila.setBounds(67, 73, 73, 53);
		contentPane.add(hasieraPantaila);
		
		JButton Ezabatu = new JButton("Ezabatu");
		Ezabatu.setBounds(268, 91, 85, 21);
		contentPane.add(Ezabatu);
		
		JTextPane erabiltzaileTextua = new JTextPane();
		erabiltzaileTextua.setBounds(77, 136, 85, 21);
		contentPane.add(erabiltzaileTextua);
		
		
		JButton Sarrera = new JButton("Sarrera");
		Sarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mezua = erabiltzaileTextua.getText();
				hasieraPantaila.setText(mezua);
			}
		});
		
		Sarrera.setBounds(172, 89, 85, 21);
		contentPane.add(Sarrera);
	}
}