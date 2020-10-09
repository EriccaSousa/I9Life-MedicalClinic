package i9Life.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Consulta.findAll", query = "from Consulta"),
		@NamedQuery(name = "Consulta.findById", query = "from Consulta a where a.id = ?1") })
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "idMedico")
	private Medico medico;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	private String observacoes;

	public Consulta() {

	}

	public Consulta(int id, Medico medico, Cliente cliente, Date data, String observacoes) {
		this.id = id;
		this.medico = medico;
		this.cliente = cliente;
		this.data = data;
		this.observacoes = observacoes;
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
		return cliente;
	}

	public void setPaciente(Cliente cliente) {
		this.cliente = cliente;
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

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", medico=" + medico + ", paciente=" + cliente + ", data=" + data
				+ ", observacoes=" + observacoes + "]";
	}

}
