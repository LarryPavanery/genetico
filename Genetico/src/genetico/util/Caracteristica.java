package genetico.util;

import genetico.main.App;
import genetico.model.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;




public class Caracteristica {

	public static List getCaracteristicas(int quantidade) {
		List caracteristicas = new ArrayList();
		for (int i = 0; i < quantidade; i++) {
			caracteristicas.add(newCaracteristica());
		}
		return caracteristicas;
	}
	
	private static String newCaracteristica() {
		return ajustaZeroEsquerda(new Random().nextInt(App.ESPACO_NUMERICO) + 1);
	}
	
	private static String ajustaZeroEsquerda(int valor) {
		return valor < 10 ? new StringBuilder().append("0").append(valor).toString() : Integer.toString(valor); 
	}
	
	public static Pessoa unir(Object aPai, Object aMae) {
		Pessoa pai = (Pessoa) aPai;
		Pessoa mae = (Pessoa) aMae;
		return new Pessoa(combinarCaracteristicas(pai.getCaracterisicasList(), mae.getCaracterisicasList()));
	}

	private static List combinarCaracteristicas(List caracterisicasList,
			List caracterisicasList2) {
		List<Object> caracteristicas = getCaracteristicas(App.QUANTIDADE_CARACTERISTICA_POR_PESSOA);
		int rand = new Random().nextInt(caracterisicasList.size());
		int randPai = 0;
		int randMae = 0;
		Object caracteristicaPai = null;
		Object caracteristicaMae = null;
		Object caracteristicaFilho = null;
		for (int i = 0; i < rand; i++) {
			randPai = new Random().nextInt(caracterisicasList.size());
			randMae = new Random().nextInt(caracterisicasList2.size());
			caracteristicaPai = caracterisicasList.get(randPai);
			caracteristicaMae = caracterisicasList2.get(randMae);
			caracteristicaFilho =  resolveParaUm(caracteristicaPai, caracteristicaMae);
			if (caracteristicaFilho.equals(caracteristicaPai)) {
				caracteristicas.set(randPai, caracteristicaFilho);
			} else {
				caracteristicas.set(randMae, caracteristicaFilho);
			}
		}
		return mutacao(caracteristicas);
	}

	private static List mutacao(List caracteristicas) {
		float rand = new Random().nextFloat();
		int randCaracteristica = new Random().nextInt(caracteristicas.size());
		List caracteristicasTmp = caracteristicas;
		if (rand <= 0.5) {
			caracteristicasTmp.set(randCaracteristica, newCaracteristica());
		} 
		return caracteristicasTmp;
	}

	private static Object resolveParaUm(Object caracteristicaPai,
			Object caracteristicaMae) {
		float rand = new Random().nextFloat();
		if (rand <= 0.5) {
			return caracteristicaPai;
		} else {
			return caracteristicaMae;
		}
	}
}
