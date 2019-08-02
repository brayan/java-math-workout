import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Sistema extends JFrame {

	private JButton buttonIniciar;
	private JLabel labelqtdadeCalc;
	private JLabel labelqtdadeNumCalc;
	private JTextField textFieldQtdadeCalc;
	private JTextField textFieldQtdadeNumCalc;

	
	public Sistema() {
		setTitle("Desafio Matemática");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		buttonIniciar = new JButton("Iniciar");
		labelqtdadeCalc = new JLabel("Quantidade de calculos:");
		labelqtdadeNumCalc = new JLabel("Quantidade de números por calculo:");
		textFieldQtdadeCalc = new JTextField(10);
		textFieldQtdadeNumCalc = new JTextField(10);
		
		
		
		getContentPane().add(labelqtdadeCalc);
		getContentPane().add(textFieldQtdadeCalc);
		getContentPane().add(labelqtdadeNumCalc);
		getContentPane().add(textFieldQtdadeNumCalc);
		getContentPane().add(buttonIniciar);
		
		labelqtdadeCalc.setBounds(10, 0, 200, 50);
		labelqtdadeNumCalc.setBounds(10, 20, 205, 50);
		textFieldQtdadeCalc.setBounds(220, 10, 50, 20);
		textFieldQtdadeNumCalc.setBounds(220, 40, 50, 20);
		buttonIniciar.setBounds(100, 100, 100, 30);
		
		buttonIniciar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					new GeradorCalculo(Integer.parseInt( textFieldQtdadeNumCalc.getText() ), Integer.parseInt( textFieldQtdadeCalc.getText() ));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"Digite valores válidos");
				}
				
			}
		});
		
		
	}

	public static void main(String[] args) {
		new Sistema().setVisible(true);
	}

}
