package i9Life.controller;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import i9Life.dao.GenericJPA_DAO;
import i9Life.model.Cliente;
import i9Life.model.Endereco;
import i9Life.model.Responsavel;
import i9Life.model.Telefone;

public class ClienteController {

	// Ok
	public static void cadastra(int idCliente, String nome, String cpf, Date dataNasc, String email, String observacoes,
			String nomeResp, String parentesco, String emailResp, String cep, String bairro, String numeroEnd,
			String complemento, String cidade, String ddd, String numeroTell) {

		Responsavel newResponsavel = new Responsavel(0, nomeResp, parentesco, emailResp);
		Telefone newTelefone = new Telefone(0, ddd, numeroTell);
		Endereco newEndereco = new Endereco(0, cep, bairro, numeroEnd, complemento, cidade);

		Cliente newCliente = new Cliente(idCliente, nome, cpf, dataNasc, email, newTelefone, newEndereco,
				newResponsavel, observacoes, null);
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

	// Ok
	public static Cliente findByEmail(String email) {

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();

			Query query = em.createNamedQuery("Cliente.findByEmail");

			query.setParameter(1, email);

			return (Cliente) query.getSingleResult();

		} catch (NoResultException | NonUniqueResultException | IllegalArgumentException e) {
			System.out.println("Erro ao realizar pesquisa.");
			return null;
		}

	}
}