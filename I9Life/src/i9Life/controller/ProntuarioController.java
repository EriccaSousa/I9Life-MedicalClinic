package i9Life.controller;

import javax.persistence.PersistenceException;

import i9Life.dao.GenericJPA_DAO;
import i9Life.model.Cliente;
import i9Life.model.Prontuario;

public class ProntuarioController {

	// Ok
	public static void cadastra(int idProntuario, String observacoes, String diagnostico, Cliente cliente) {

		Prontuario newProntuario = new Prontuario(idProntuario, observacoes, diagnostico, cliente);

		try {
			if (!(newProntuario.equals(null))) {
				GenericJPA_DAO<Prontuario> genericDAO = new GenericJPA_DAO<Prontuario>();

				genericDAO.persist(newProntuario);
				genericDAO.close();
			} else {
				System.out.println("Erro ao cadastrar Prontuario.");

			}
		} catch (IllegalStateException | PersistenceException e) {
			e.printStackTrace();
		}

	}
}