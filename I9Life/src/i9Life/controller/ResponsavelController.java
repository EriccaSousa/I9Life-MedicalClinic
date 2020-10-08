package i9Life.controller;

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
import i9Life.model.Agenda;
import i9Life.model.Cliente;
import i9Life.model.Medico;
import i9Life.model.Responsavel;
import i9Life.util.Criptografia;

public class ResponsavelController {

	
		
	// Ok
	@SuppressWarnings("unchecked")
	public static List<Administrador> findByNome(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("Administrador.findByNome");

		query.setParameter(1, nome);

		return query.getResultList();
	}

	// Ok
	public static Administrador findByEmail(String email) {

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();

			Query query = em.createNamedQuery("Administrador.findByEmail");

			query.setParameter(1, email);

			return (Administrador) query.getSingleResult();

		} catch (NoResultException | NonUniqueResultException | IllegalArgumentException e) {
			System.out.println("Erro ao realizar pesquisa.");
			return null;
		}

	}

	// Ok
	@SuppressWarnings("unchecked")
	public static List<Administrador> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("Administrador.findAll");

		return query.getResultList();
	}

	// Ok
	public static void updateNome(String newNome, String email) {
		GenericJPA_DAO<Administrador> genericDao = new GenericJPA_DAO<Administrador>();

		Administrador admAux = findByEmail(email);

		if (admAux.getEmail().equals(email)) {
			admAux.setNome(newNome);

			genericDao.update(admAux);
		}

	}

	// Ok
	public static void updateEmail(String newEmail, String email) {
		GenericJPA_DAO<Administrador> genericDao = new GenericJPA_DAO<Administrador>();

		Administrador admAux = findByEmail(email);

		if (admAux.getEmail().equals(email)) {
			admAux.setEmail(newEmail);

			genericDao.update(admAux);

		}
	}

	// Ok
	public static void updateSenha(String newSenha, String email) {
		GenericJPA_DAO<Administrador> genericDao = new GenericJPA_DAO<Administrador>();

		Administrador admAux = findByEmail(email);

		if (admAux.getEmail().equals(email)) {
			String senhaCriptografada = Criptografia.criptografa(newSenha);
			admAux.setSenha(senhaCriptografada);

			genericDao.update(admAux);
		}
	}

	// Não ta funcionando
	public static void delete(String email) {
		GenericJPA_DAO<Administrador> genericDAO = new GenericJPA_DAO<Administrador>();

		genericDAO.delete(email);

	}

	public static Administrador login(String email, String senha) {
		if (Administrador.logar(email, senha) == true) {
			Administrador admAux = findByEmail(email);

			return admAux;
		} else {
			return null;
		}
	}

}
