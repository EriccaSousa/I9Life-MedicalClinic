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
import i9Life.model.Medico;
import i9Life.util.Criptografia;

public class MedicoController {

	// Ok
	public static void cadastra(int id, String nome, String cpf, String email, String crm, String especialidade) {

		Medico newMedico = Medico.criarMedico(id, nome, cpf, email, crm, especialidade);

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
}
