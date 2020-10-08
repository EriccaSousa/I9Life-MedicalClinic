package i9Life.model;

import java.util.Date;

public class Consulta {
	private int id;
	private Medico medico;
	private Cliente paciente;
	private Date data;
	private String observacoes;
	private Prontuario prontuario;

	public Consulta() {

	}

	public Consulta(int id, Medico medico, Cliente paciente, Date data, String observacoes, Prontuario prontuario) {
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
		this.observacoes = observacoes;
		this.prontuario = prontuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Cliente getPaciente() {
		return paciente;
	}

	public void setPaciente(Cliente paciente) {
		this.paciente = paciente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", medico=" + medico + ", paciente=" + paciente + ", data=" + data
				+ ", observacoes=" + observacoes + ", prontuario=" + prontuario + "]";
	}

}
