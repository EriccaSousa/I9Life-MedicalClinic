package i9Life.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Telefone {
	@Id
	private int idTell;
	private String ddd;
	private String numero;

	public Telefone() {
	}

	public Telefone(int idTell, String ddd, String numero) {
		this.idTell = idTell;
		this.ddd = ddd;
		this.numero = numero;
	}

	public int getIdTell() {
		return idTell;
	}

	public void setIdTell(int idTell) {
		this.idTell = idTell;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "/nTelefone [idTell=" + idTell + ", ddd=" + ddd + ", numero=" + numero + "]";
	}

}
