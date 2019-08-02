import java.util.ArrayList;

public interface Calculo {

	public abstract ArrayList<Integer> getCalculo(int qtdadeNumCalculo);

	public abstract String getCalculoEnunciado(ArrayList<Integer> calculo);

	public abstract int getResultado(ArrayList<Integer> calculo);
	
	public abstract int random(int min, int max);

}
