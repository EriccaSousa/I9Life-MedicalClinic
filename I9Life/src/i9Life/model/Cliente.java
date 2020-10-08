package i9Life.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente {
	@Id
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
	@OneToMany(mappedBy = "Cliente", targetEntity = Prontuario.class, cascade = CascadeType.ALL)
	private List<Prontuario> prontuarios;

	public Cliente() {
	}

	public Cliente(int idCliente, String nome, String cpf, Date dataNasc, String email, Telefone tell,
			Endereco endereco, Responsavel responsavel, String observacoes) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.email = email;
		this.responsavel = responsavel;
		this.observacoes = observacoes;
		this.endereco = endereco;
		this.tell = tell;
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

	public static Cliente cadastra(int idCliente, String nome, String cpf, Date dataNasc, String email, Telefone tell,
			Endereco endereco, Responsavel responsavel, String observacoes) {

		Cliente newCliente = new Cliente(0, nome, cpf, dataNasc, email, tell, endereco, responsavel, observacoes);

		return newCliente;
	}

	@Override
	public String toString() {
		return "/nCliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", dataNasc=" + dataNasc
				+ ", email=" + email + ", tell=" + tell + ", endereco=" + endereco + ", responsavel=" + responsavel
				+ ", observacoes=" + observacoes + "]";
	}

}
