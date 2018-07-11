package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class Generico<E, K> {
	
	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected EntityTransaction tx;
	protected Query query;
	protected String jpql;
	
	
	public Generico() {		
		super();
		emf = Persistence.createEntityManagerFactory("14_Libreria");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	public abstract E findByID(K clavePk);
	public abstract List<E> findAll();
	public abstract int insert(E sentencia);
	public abstract int upadte(E sentencia);
	public abstract int delete(E sentencia);
	

}
