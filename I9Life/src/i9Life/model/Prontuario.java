package i9Life.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Prontuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProntuario;
	private String observacoes;
	private String diagnostico;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "idMedico")
	private Medico medico;

	public Prontuario() {
	}

	public Prontuario(int idProntuario, String observacoes, String diagnostico, Cliente cliente, Medico medico) {
		this.idProntuario = idProntuario;
		this.observacoes = observacoes;
		this.diagnostico = diagnostico;
		this.cliente = cliente;
		this.medico = medico;
	}

	public int getIdProntuario() {
		return idProntuario;
	}

	public void setIdProntuario(int idProntuario) {
		this.idProntuario = idProntuario;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public static Prontuario cria(int idProntuario, String observacoes, String diagnostico, Cliente cliente,
			Medico medico) {
		Prontuario newProntuario = new Prontuario(0, observacoes, diagnostico, cliente, medico);

		return newProntuario;
	}

	@Override
	public String toString() {
		return "Prontuario [idProntuario=" + idProntuario + ", observacoes=" + observacoes + ", diagnostico="
				+ diagnostico + ", cliente=" + cliente + ", medico=" + medico + "]";
	}

}
