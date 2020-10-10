package i9Life.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import i9Life.dao.GenericJPA_DAO;
import i9Life.model.Administrador;
import i9Life.util.Criptografia;

public class AdministradorController {

	// Ok
	public static Administrador cadastraAdm(String nome, String email, String senha) {

		Administrador newAdm = Administrador.criar(email, nome, senha);

		try {
			if (!(newAdm.equals(null))) {
				GenericJPA_DAO<Administrador> genericDAO = new GenericJPA_DAO<Administrador>();

				genericDAO.persist(newAdm);
				genericDAO.close();

				return newAdm;
			} else {
				System.out.println("Erro ao cadastrar Administrador.");

				return null;
			}
		} catch (IllegalStateException | PersistenceException e) {
			System.out.println("Erro ao realizar cadastro.");
			JOptionPane.showMessageDialog(null,
					"Erro ao realizar login. Verique se email e senha informados estão corretos.", "alerta",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}

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

		} catch (NoResultException | NonUniqueResultException | IllegalArgumentException | NullPointerException e) {
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

	// Ok
	public static Administrador login(String email, String senha) {
		try {
			Administrador admAux = Administrador.logar(email, senha);

			if (!(admAux.equals(null))) {
				return admAux;
			} else {
				System.out.println("Erro ao realizar login.");
				return null;
			}
		} catch (NullPointerException e) {
			System.out.println("Erro ao realizar login.");
			return null;
		}
	}

}
