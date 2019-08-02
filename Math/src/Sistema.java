import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Sistema extends JDialog {

	JLabel lbQtdadeCalcs;
	JLabel lbQtdadeNums;
	JLabel lbDe;
	JLabel lbAte;
	
	JTextField tfQtdadeCalcs;
	JTextField tfQtdadeNums;
	JTextField tfDe;
	JTextField tfAte;
	
	JButton btIniciar;
	
	Random random;
	
	public Sistema() {
		setTitle("Math");
		setSize(300, 250);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		initComponents();
	}
	
	private void initComponents() {
		random = new Random();
		
		lbQtdadeCalcs = new JLabel("Quantidade de Cálculos:");
		lbQtdadeNums = new JLabel("Quantidade de Números:");
		lbDe = new JLabel("De");
		lbAte = new JLabel("até");
		
		tfQtdadeCalcs = new JTextField();
		tfQtdadeNums = new JTextField();
		tfDe = new JTextField();
		tfAte = new JTextField();
		
		btIniciar = new JButton("Iniciar");
		
		lbQtdadeCalcs.setBounds(10, 20, 140, 10);
		lbQtdadeNums.setBounds(10, 50, 140, 10);
		lbDe.setBounds(40, 100, 20, 10);
		lbAte.setBounds(110, 100, 30, 10);
		
		tfQtdadeCalcs.setBounds(155, 15, 100, 20);
		tfQtdadeNums.setBounds(155, 50, 100, 20);
		tfDe.setBounds(65, 96, 40, 20);
		tfAte.setBounds(135, 96, 40, 20);
		
		btIniciar.setBounds(100, 150, 80, 30);
		
		//lb
		getContentPane().add(lbQtdadeCalcs);
		getContentPane().add(lbQtdadeNums);
		getContentPane().add(lbDe);
		getContentPane().add(lbAte);
		//tf
		getContentPane().add(tfQtdadeCalcs);
		getContentPane().add(tfQtdadeNums);
		getContentPane().add(tfDe);
		getContentPane().add(tfAte);
		
		getContentPane().add(btIniciar);
		
		btIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int qtdadeNums = Integer.parseInt(tfQtdadeNums.getText());
				int qtdadeCalcs = Integer.parseInt(tfQtdadeCalcs.getText());
				int de = Integer.parseInt(tfDe.getText());
				int ate = Integer.parseInt(tfAte.getText());
				
				int acomulador = 0;
				int numero = 0;
				int acertos = 0;
				int erros = 0;
				String problema = "";
				
				for (int i = 0; i < qtdadeCalcs; i++) {
					for (int x = 0; x < qtdadeNums; x++) {
						
						do {
							numero = random.nextInt(ate + 1);
						} while (numero < de || numero > ate);
						
							acomulador += numero;
						if ((x + 1) >= qtdadeNums)
							problema += "" + numero ;
						else	
							problema += numero + " + " ;
					}
					
					
					int resposta = Integer.parseInt(JOptionPane.showInputDialog(null, problema, "Acertos: " + acertos + "    Erros: " + erros, JOptionPane.PLAIN_MESSAGE));
					
					problema = "";
					
					if (resposta == acomulador)
						acertos++;
					else {
						erros++;
						JOptionPane.showMessageDialog(null, "Resposta certa: " + acomulador, "Errou!", JOptionPane.ERROR_MESSAGE);
					}
						
					
					acomulador = 0;
					numero = 0;
				
				}
				
				JOptionPane.showMessageDialog(null, "Acertos: " + acertos + "\nErros: " + erros, "Resultado Final", JOptionPane.PLAIN_MESSAGE);
				
			}
		});
	}
	
	public static void main(String[] args) {
		new Sistema().setVisible(true);
	}
}
