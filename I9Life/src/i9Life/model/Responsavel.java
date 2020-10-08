package i9Life.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Responsavel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResponsavel;
	private String nome;
	private String parentesco;
	private String email;

	public Responsavel() {
	}

	public Responsavel(int idResponsavel, String nome, String parentesco, String email) {
		this.idResponsavel = idResponsavel;
		this.nome = nome;
		this.parentesco = parentesco;
		this.email = email;

	}

	public int getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "/nResponsavel [idResponsavel=" + idResponsavel + ", nome=" + nome + ", parentesco=" + parentesco
				+ ", email=" + email + "]";
	}

}
