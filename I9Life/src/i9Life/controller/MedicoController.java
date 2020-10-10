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
import i9Life.model.Cliente;
import i9Life.model.Medico;

public class MedicoController {

	// Ok
	public static void cadastra(int id, String nome, String cpf, String email, String crm, String especialidade) {

		Medico newMedico = Medico.criarMedico(id, nome, cpf, email, crm, especialidade, null, null);

		try {
			if (!(newMedico.equals(null))) {
				GenericJPA_DAO<Medico> genericDAO = new GenericJPA_DAO<Medico>();

				genericDAO.persist(newMedico);
				genericDAO.close();

			} else {
				System.out.println("Erro ao cadastrar Cliente.");

			}
		} catch (IllegalStateException | PersistenceException e) {
			e.printStackTrace();
		}

	}

	// Ok
	public static Medico findByEmail(String email) {

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();

			Query query = em.createNamedQuery("Medico.findByEmail");

			query.setParameter(1, email);

			return (Medico) query.getSingleResult();

		} catch (NoResultException | NonUniqueResultException | IllegalArgumentException e) {
			System.out.println("Erro ao realizar pesquisa.");
			return null;
		}

	}

	// Ok
	@SuppressWarnings("unchecked")
	public static List<Medico> findByNome(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("Medico.findByNome");

		query.setParameter(1, nome);

		return query.getResultList();
	}

	// Ok
	@SuppressWarnings("unchecked")
	public static List<Medico> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("Medico.findAll");

		return query.getResultList();
	}

	// Ok
	public static void updateNome(String newNome, String email) {
		GenericJPA_DAO<Medico> genericDao = new GenericJPA_DAO<Medico>();

		Medico medicoAux = findByEmail(email);

		if (medicoAux.getEmail().equals(email)) {
			medicoAux.setNome(newNome);

			genericDao.update(medicoAux);
		}

	}

	// Ok
	public static void updateEmail(String newEmail, String email) {
		GenericJPA_DAO<Medico> genericDao = new GenericJPA_DAO<Medico>();

		Medico medicoAux = findByEmail(email);

		if (medicoAux.getEmail().equals(email)) {
			medicoAux.setEmail(newEmail);

			genericDao.update(medicoAux);

		}
	}

	// Não ta funcionando
	public static void delete(String email) {
		GenericJPA_DAO<Medico> genericDAO = new GenericJPA_DAO<Medico>();

		genericDAO.delete(email);

	}

}
