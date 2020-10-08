package i9Life.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEndereco;
	private String cep;
	private String bairro;
	private String numero;
	private String complemento;
	private String cidade;

	public Endereco() {

	}

	public Endereco(int idEndereco, String cep, String bairro, String numero, String complemento, String cidade) {
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "/nEndereco [idEndereco=" + idEndereco + ", cep=" + cep + ", bairro=" + bairro + ", numero=" + numero
				+ ", complemento=" + complemento + ", cidade=" + cidade + "]";
	}

}
