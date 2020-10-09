package i9Life.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Medico.findAll", query = "from Medico"),
		@NamedQuery(name = "Medico.findByNome", query = "from Medico a where a.nome = ?1"),
		@NamedQuery(name = "Medico.findByEmail", query = "from Medico a where a.email = ?1"),
		@NamedQuery(name = "Medico.delete", query = "from Medico a where a.email = ?1") })
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;
	private String nome;
	private String cpf;
	private String email;
	private String crm;
	private String especialidade;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Prontuario> prontuarios;

	public Medico() {
	}

	public Medico(int idMedico, String nome, String cpf, String email, String crm, String especialidade,
			List<Prontuario> prontuarios) {
		this.idMedico = idMedico;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.crm = crm;
		this.especialidade = especialidade;
		this.prontuarios = prontuarios;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
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

	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}

	public static Medico criarMedico(int id, String nome, String cpf, String email, String crm, String especialidade,
			List<Prontuario> prontuarios) {

		Medico newMedico = new Medico(0, nome, cpf, email, crm, especialidade, prontuarios);

		return newMedico;

	}

	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", crm=" + crm
				+ ", especialidade=" + especialidade + ", prontuarios=" + prontuarios + "]";
	}

}
