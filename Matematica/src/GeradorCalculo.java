import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GeradorCalculo {

	public GeradorCalculo(int qtdadeNumCalculos, int qtdadeCalculos) {

		int acertos = 0;
		int erros = 0;
		int resultado = 0;

		Calculo calculo = new Adicao();
		ArrayList<Integer> calc = new ArrayList<Integer>();
		String enunciado = "";

		for (int x = 1; x <= qtdadeCalculos; x++) {

			calc = calculo.getCalculo(qtdadeNumCalculos);

			resultado = calculo.getResultado(calc);

			enunciado = calculo.getCalculoEnunciado(calc);

			int result = Integer.parseInt(JOptionPane.showInputDialog(null,
					enunciado, x + "º Calculo. Acertos: " + acertos
							+ ". Erros: " + erros + ".",
					JOptionPane.PLAIN_MESSAGE));
			
			if (result == resultado)
				acertos++;
			else {
				erros++;
				JOptionPane.showMessageDialog(null, "Resultado correto: " + resultado);
			}
				

		}

		JOptionPane.showMessageDialog(null, "De " + qtdadeCalculos
				+ " calculos, você acertou " + acertos + " e errou " + erros);

	}
}
