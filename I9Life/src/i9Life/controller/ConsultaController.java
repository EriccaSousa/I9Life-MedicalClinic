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
import i9Life.model.Consulta;
import i9Life.model.Medico;
import i9Life.model.Prontuario;

public class ConsultaController {

	// Ok
	public static void cadastra(int id, Medico medico, Cliente cliente, Date data, String observacoes,
			Prontuario prontuario) {

		Consulta newConsulta = new Consulta(id, medico, cliente, data, observacoes);

		try {
			if (!(newConsulta.equals(null))) {
				GenericJPA_DAO<Consulta> genericDAO = new GenericJPA_DAO<Consulta>();

				genericDAO.persist(newConsulta);
				genericDAO.close();
			} else {
				System.out.println("Erro ao cadastrar Prontuario.");

			}
		} catch (IllegalStateException | PersistenceException e) {
			e.printStackTrace();
		}

	}

	// Ok
	public static Consulta findById(int id) {

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();

			Query query = em.createNamedQuery("Consulta.findById");

			query.setParameter(1, id);

			return (Consulta) query.getSingleResult();

		} catch (NoResultException | NonUniqueResultException | IllegalArgumentException e) {
			System.out.println("Erro ao realizar pesquisa.");
			return null;
		}

	}
}