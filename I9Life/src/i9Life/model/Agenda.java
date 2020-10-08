package i9Life.model;

import java.util.List;

public class Agenda {
	
	private List<Consulta> consultas;

	public Agenda() {
	}

	public Agenda(List<Consulta> consultas) {
		super();
		this.consultas = consultas;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public String toString() {
		return "Agenda [consultas=" + consultas + "]";
	}

}
