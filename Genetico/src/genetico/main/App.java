package genetico.main;

import genetico.model.Pessoa;
import genetico.model.Populacao;
import genetico.util.Caracteristica;
import genetico.util.Reproducao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
	public static final int QUANTIDADE_POPULACAO = 2;
	public static final int QUANTIDADE_CARACTERISTICA_POR_PESSOA = 6;
	public static final int ESPACO_NUMERICO = 60;
	private static final Populacao POPULACAO = new Populacao(QUANTIDADE_CARACTERISTICA_POR_PESSOA);
	private static final int QUANTIDADE_REPRODUCAO = 5000; 
	
	public static void main(String[] args) {
		App.POPULACAO.criar(QUANTIDADE_POPULACAO);
		reproduzirPopulacao(QUANTIDADE_REPRODUCAO, POPULACAO.getPopulacao());
		saida();
	}

	private static void saida() {
		int soma = 0;
		int maior = 0;
		for (Object obj : POPULACAO.getPopulacao()) {
			soma = App.sum(((Pessoa)obj).getCaracterisicasList());
			List saida = ((Pessoa)obj).getCaracterisicasList();
			Collections.sort(saida);
			if (soma > maior) maior = soma;
			System.out.print("sum(" + saida + ") = " + soma);
			if (soma == QUANTIDADE_CARACTERISTICA_POR_PESSOA*ESPACO_NUMERICO) {
				System.out.print(" - Evolução total!\n" );
			} else {
				System.out.println();
			}
		}
		System.out.println("Maior:"+maior);
	}

	private static void reproduzirPopulacao(int quantidadeReproducao, List populacao) {
		for (int i = 0; i < quantidadeReproducao; i++) {
			new Reproducao().iniciar(populacao);
		}
	}

	private static int sum(List caracterisicas) {
		int soma = 0;
		for (Object obj : caracterisicas) {
			String num = (String) obj;
			soma += Integer.parseInt(num);
		}
		return soma;
	}
}
