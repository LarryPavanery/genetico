package genetico.model;

import java.util.List;

public class Pessoa {
	private List caracteristicas;
	private boolean emReproducao;
	
	public Pessoa(List caracteristicas){
		this.caracteristicas = caracteristicas;
		this.emReproducao = false;
	}
	
	public List getCaracterisicasList() {
		return caracteristicas;
	}
	
	public void setEmReproducao(boolean emReproducao) {
		this.emReproducao = emReproducao;
	}
	
	public boolean getEmReproducao() {
		return emReproducao;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pessoa) {
			for (Object o : ((Pessoa) obj).getCaracterisicasList()) {
					if (this.getCaracterisicasList().indexOf(o) == -1) {
						return false;
					}
			}
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return caracteristicas.toString();
	}
}
