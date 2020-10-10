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
import i9Life.model.Cliente;
import i9Life.model.Responsavel;

public class ResponsavelController {
	// Ok
	public static void cadastra(int idResponsavel, String nome, String parentesco, String email) {

		Responsavel newResponsavel = new Responsavel(0, nome, parentesco, email);

		try {
			if (!(newResponsavel.equals(null))) {
				GenericJPA_DAO<Responsavel> genericDAO = new GenericJPA_DAO<Responsavel>();

				genericDAO.persist(newResponsavel);
				genericDAO.close();
			} else {
				System.out.println("Erro ao cadastrar Responsavel.");

			}
		} catch (IllegalStateException | PersistenceException e) {
			e.printStackTrace();
		}

	}

	// Ok
	@SuppressWarnings("unchecked")
	public static List<Responsavel> findByNome(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("Responsavel.findByNome");

		query.setParameter(1, nome);

		return query.getResultList();
	}

	// Ok
	public static Responsavel findByEmail(String email) {

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();

			Query query = em.createNamedQuery("Responsavel.findByEmail");

			query.setParameter(1, email);

			return (Responsavel) query.getSingleResult();

		} catch (NoResultException | NonUniqueResultException | IllegalArgumentException e) {
			System.out.println("Erro ao realizar pesquisa.");
			return null;
		}

	}

	// Ok
	@SuppressWarnings("unchecked")
	public static List<Responsavel> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("Responsavel.findAll");

		return query.getResultList();
	}

	// Ok
	public static void updateNome(String newNome, String email) {
		GenericJPA_DAO<Responsavel> genericDao = new GenericJPA_DAO<Responsavel>();

		Responsavel respAux = findByEmail(email);

		if (respAux.getEmail().equals(email)) {
			respAux.setNome(newNome);

			genericDao.update(respAux);
		}

	}

	// Ok
	public static void updateEmail(String newEmail, String email) {
		GenericJPA_DAO<Responsavel> genericDao = new GenericJPA_DAO<Responsavel>();

		Responsavel respAux = findByEmail(email);

		if (respAux.getEmail().equals(email)) {
			respAux.setEmail(newEmail);

			genericDao.update(respAux);

		}
	}

	// Não ta funcionando
	public static void delete(String email) {
		GenericJPA_DAO<Responsavel> genericDAO = new GenericJPA_DAO<Responsavel>();

		genericDAO.delete(email);

	}

}
