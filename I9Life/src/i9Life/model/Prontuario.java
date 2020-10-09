package i9Life.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	@OneToOne(cascade = CascadeType.ALL)
	private Consulta consulta;

	public Prontuario() {
	}

	public Prontuario(int idProntuario, String observacoes, String diagnostico, Cliente cliente, Medico medico,
			Consulta consulta) {
		this.idProntuario = idProntuario;
		this.observacoes = observacoes;
		this.diagnostico = diagnostico;
		this.cliente = cliente;
		this.medico = medico;
		this.consulta = consulta;
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

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public static Prontuario cria(int idProntuario, String observacoes, String diagnostico, Cliente cliente,
			Medico medico, Consulta consulta) {
		Prontuario newProntuario = new Prontuario(0, observacoes, diagnostico, cliente, medico, consulta);

		return newProntuario;
	}

	@Override
	public String toString() {
		return "Prontuario [idProntuario=" + idProntuario + ", observacoes=" + observacoes + ", diagnostico="
				+ diagnostico + ", cliente=" + cliente + ", medico=" + medico + ", consulta=" + consulta + "]";
	}

}
