package i9Life.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Cliente.findAll", query = "from Cliente"),
		@NamedQuery(name = "Cliente.findByNome", query = "from Cliente a where a.nome = ?1"),
		@NamedQuery(name = "Cliente.findByEmail", query = "from Cliente a where a.email = ?1"),
		@NamedQuery(name = "Cliente.delete", query = "from Cliente a where a.email = ?1") })
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String nome;
	private String cpf;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Telefone tell;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	@OneToOne(cascade = CascadeType.ALL)
	private Responsavel responsavel;
	private String observacoes;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Prontuario> prontuarios;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Consulta> consultas;

	public Cliente() {
	}

	public Cliente(int idCliente, String nome, String cpf, Date dataNasc, String email, Telefone tell,
			Endereco endereco, Responsavel responsavel, String observacoes, List<Prontuario> prontuarios,
			List<Consulta> consultas) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.email = email;
		this.responsavel = responsavel;
		this.observacoes = observacoes;
		this.endereco = endereco;
		this.tell = tell;
		this.prontuarios = prontuarios;
		this.consultas = consultas;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getTell() {
		return tell;
	}

	public void setTell(Telefone tell) {
		this.tell = tell;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public static Cliente cadastra(int idCliente, String nome, String cpf, Date dataNasc, String email, Telefone tell,
			Endereco endereco, Responsavel responsavel, String observacoes, List<Prontuario> prontuarios,
			List<Consulta> consultas) {

		Cliente newCliente = new Cliente(0, nome, cpf, dataNasc, email, tell, endereco, responsavel, observacoes,
				prontuarios, consultas);

		return newCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", dataNasc=" + dataNasc
				+ ", email=" + email + ", tell=" + tell + ", endereco=" + endereco + ", responsavel=" + responsavel
				+ ", observacoes=" + observacoes + ", prontuarios=" + prontuarios + ", consultas=" + consultas + "]";
	}

}
