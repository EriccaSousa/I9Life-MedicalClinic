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

	public Prontuario() {
	}

	public Prontuario(int idProntuario, String observacoes, String diagnostico, Cliente cliente) {
		this.idProntuario = idProntuario;
		this.observacoes = observacoes;
		this.diagnostico = diagnostico;
		this.cliente = cliente;
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

	public static Prontuario cria(int idProntuario, String observacoes, String diagnostico, Cliente cliente) {
		Prontuario newProntuario = new Prontuario(0, observacoes, diagnostico, cliente);

		return newProntuario;
	}

	@Override
	public String toString() {
		return "/nProntuario [idProntuario=" + idProntuario + ", observacoes=" + observacoes + ", diagnostico="
				+ diagnostico + ", cliente=" + cliente + "]";
	}

}
