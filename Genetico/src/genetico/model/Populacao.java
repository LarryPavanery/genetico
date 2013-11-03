package genetico.model;

import genetico.util.Caracteristica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Populacao {

	private final String id;
	private int caracteristicaQtd;
	private List tipos;
	List populacao;
	
	public Populacao(int caracteristicaQtd){
		id = getId();
		populacao = new ArrayList();
		tipos = new ArrayList();
		this.caracteristicaQtd = caracteristicaQtd;
	}

	private String getId() {
		return Long.toString(new Random().nextLong());
	}
	
	public void criar(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			addTipo(Pessoa.class);
			populacao.add(new Pessoa(Caracteristica.getCaracteristicas(caracteristicaQtd)));
		}
	}
	
	public void add(Object obj) {
		populacao.add(obj);
	}
	
	private void addTipo(Class<?> tipo) {
		if (!tipos.contains(tipo)) {
			tipos.add(tipo);
		}
	}

	public List getPopulacao() {
		return populacao;
	}
	
	public List getTipos() {
		return tipos;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("[Id:").append(id).append(" - Qtd. Caracteristica(s):").append(caracteristicaQtd).append("]").toString();
	}
}
