package i9Life.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String crm;
	private String especialidade;

	public Medico() {
	}

	public Medico(int id, String nome, String cpf, String email, String crm, String especialidade) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public static Medico criarMedico(int id, String nome, String cpf, String email, String crm, String especialidade) {

		Medico newMedico = new Medico(0, nome, cpf, email, crm, especialidade);

		return newMedico;

	}

	@Override
	public String toString() {
		return "/nMedico [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", crm=" + crm
				+ ", especialidade=" + especialidade + "]";
	}

}
