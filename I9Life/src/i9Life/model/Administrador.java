package i9Life.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import i9Life.controller.AdministradorController;
import i9Life.util.Criptografia;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NamedQueries({ @NamedQuery(name = "Administrador.findAll", query = "from Administrador"),
		@NamedQuery(name = "Administrador.findByNome", query = "from Administrador a where a.nome = ?1"),
		@NamedQuery(name = "Administrador.findByEmail", query = "from Administrador a where a.email = ?1"),
		@NamedQuery(name = "Administrador.delete", query = "from Administrador a where a.email = ?1") })
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "administrador_id")
	private int id;
	private String email;
	private String nome;
	private String senha;

	public Administrador() {
	}

	public Administrador(int id, String email, String nome, String senha) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// Ok
	public static Administrador criar(String email, String nome, String senha) {

		if (email.equals("") || nome.equals("") || senha.equals("")) {
			return null;
		} else {
			if (senha.length() == 8) {
				String senhaCriptografada = Criptografia.criptografa(senha);

				Administrador newAdm = new Administrador(0, email, nome, senhaCriptografada);

				return newAdm;
			} else {
				return null;
			}
		}

	}

	public static Administrador logar(String email, String senha) {

		Administrador admAux = AdministradorController.findByEmail(email);

		if (!(admAux.equals(null))) {
			if (Criptografia.descriptografa(admAux.getSenha()).equals(senha)) {
				return admAux;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "\nAdministrador [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

}
