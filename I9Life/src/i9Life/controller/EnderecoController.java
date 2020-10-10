package i9Life.controller;

import javax.persistence.PersistenceException;

import i9Life.dao.GenericJPA_DAO;
import i9Life.model.Endereco;

public class EnderecoController {

	public static void cadastra(int idEndereco, String cep, String bairro, String numero, String complemento,
			String cidade) {

		Endereco newEndereco = new Endereco(0, cep, bairro, numero, complemento, cidade);
		try {
			if (!(newEndereco.equals(null))) {
				GenericJPA_DAO<Endereco> genericDAO = new GenericJPA_DAO<Endereco>();

				genericDAO.persist(newEndereco);
				genericDAO.close();
			} else {
				System.out.println("Erro ao cadastrar Cliente.");

			}
		} catch (IllegalStateException | PersistenceException e) {
			e.printStackTrace();
		}

	}
}
