package i9Life.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import i9Life.dao.GenericJPA_DAO;
import i9Life.model.Administrador;
import i9Life.model.Cliente;
import i9Life.model.Endereco;
import i9Life.model.Responsavel;
import i9Life.model.Telefone;
import i9Life.util.Criptografia;

public class ClienteController {

	// Ok
	public static void cadastra(int idCliente, String nome, String cpf, Date dataNasc, String email, String observacoes,
			String nomeResp, String parentesco, String emailResp, String cep, String bairro, String numeroEnd,
			String complemento, String cidade, String ddd, String numeroTell) {

		Responsavel newResponsavel = new Responsavel(0, nomeResp, parentesco, emailResp);
		Telefone newTelefone = new Telefone(0, ddd, numeroTell);
		Endereco newEndereco = new Endereco(0, cep, bairro, numeroEnd, complemento, cidade);

		Cliente newCliente = new Cliente(idCliente, nomeResp, cpf, dataNasc, emailResp, newTelefone, newEndereco,
				newResponsavel, observacoes);
		try {
			if (!(newCliente.equals(null))) {
				GenericJPA_DAO<Cliente> genericDAO = new GenericJPA_DAO<Cliente>();

				genericDAO.persist(newCliente);
				genericDAO.close();

			} else {
				System.out.println("Erro ao cadastrar Cliente.");

			}
		} catch (IllegalStateException | PersistenceException e) {
			e.printStackTrace();
		}

	}
}