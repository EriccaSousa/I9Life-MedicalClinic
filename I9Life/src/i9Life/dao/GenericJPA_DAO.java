package i9Life.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class GenericJPA_DAO<T> implements GenericDAO<T> {
	private EntityTransaction transaction;
	private EntityManager entityManager;

	private Class<T> persistenceClass;

	// Funcionando:
	public GenericJPA_DAO() {
		this.persistenceClass = persistenceClass;
		this.entityManager = i9Life.util.JPAUtil.getEntityManager();
		this.transaction = entityManager.getTransaction();
	}

	// Funcionando;
	public boolean persist(T entity) {
		try {
			transaction.begin();

			entityManager.persist(entity);

			transaction.commit();

			return true;
		} catch (PersistenceException e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			entityManager.close();
		}
	}

	// Funcionando
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNome(String nome) {
		Query query = entityManager.createNamedQuery("T.findByNome");

		query.setParameter(1, nome);

		return query.getResultList();
	}

	// Funcionando
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByEmail(String email) {
		Query query = entityManager.createNamedQuery("T.findByEmail");

		query.setParameter(1, email);

		return query.getResultList();
	}

	// Funcionando
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Query query = entityManager.createNamedQuery("T.findAll");

		return query.getResultList();
	}

	@Override
	public boolean update(T entity) {
		try {
			transaction.begin();

			entityManager.merge(entity);

			transaction.commit();

			return true;
		} catch (PersistenceException e) {
			transaction.rollback();

			e.printStackTrace();
			return false;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public T delete(String email) {
		try {
			transaction.begin();

			Query query = entityManager.createQuery("T.delete");

			query.setParameter(1, email);

			transaction.commit();
		} catch (PersistenceException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public void close() {
		i9Life.util.JPAUtil.getEntityManager();
	}

}
