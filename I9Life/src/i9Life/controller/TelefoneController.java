package i9Life.controller;

import javax.persistence.PersistenceException;

import i9Life.dao.GenericJPA_DAO;
import i9Life.model.Telefone;

public class TelefoneController {
	public static void cadastra(int idTell, String ddd, String numero) {

		Telefone newTell = new Telefone(0, ddd, numero);

		try {
			if (!(newTell.equals(null))) {
				GenericJPA_DAO<Telefone> genericDAO = new GenericJPA_DAO<Telefone>();

				genericDAO.persist(newTell);
				genericDAO.close();
			} else {
				System.out.println("Erro ao cadastrar Telefone.");

			}
		} catch (IllegalStateException | PersistenceException e) {
			e.printStackTrace();
		}

	}

}
