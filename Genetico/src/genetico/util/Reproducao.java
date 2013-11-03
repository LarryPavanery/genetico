package genetico.util;

import genetico.model.Pessoa;

import java.util.List;
import java.util.Random;



public class Reproducao {

	public static void iniciar(List populacao) {
		Pessoa pai = (Pessoa) getPai(populacao);
		Pessoa mae = (Pessoa) getMae(populacao);
		Pessoa filho = fazerFilho(pai, mae);
		populacao.add(filho);
		finalizar(pai, mae);
	}

	private static void finalizar(Pessoa pai, Pessoa mae) {
		pai.setEmReproducao(false);
		mae.setEmReproducao(false);
	}

	private static Pessoa fazerFilho(Pessoa aPai, Pessoa aMae) {
		return Caracteristica.unir(aPai, aMae);
	}

	private static Object getPai(List populacao) {
		int posicao = new Random().nextInt(populacao.size());
		Pessoa pessoa = (Pessoa) populacao.get(posicao);
		if (!pessoa.getEmReproducao()) {
			pessoa.setEmReproducao(true);
			return pessoa;
		} else {
			return getPai(populacao);
		}
	}

	private static Object getMae(List populacao) {
		return getPai(populacao);
	}

}
