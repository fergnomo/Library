package dao;

import java.util.List;

import javax.persistence.Query;

import beans.Libro;
import beans.Tema;

public class LibrosDAOImpl extends Generico<Libro, String> implements LibroDAO{

	@Override
	public List<Libro> librosTema(long id) {
		tx.begin();
		jpql = "select l from Libro l where l.tema.idTema = :tema";
		Query query = em.createQuery(jpql);
		query.setParameter("tema", id);
		List<Libro> lista = query.getResultList();
		tx.commit();
		return lista;
	}

	@Override
	public Libro findByID(String clavePk) {
		tx.begin();
		Libro libro = em.find(Libro.class, clavePk); 
		tx.commit();
		return libro;
	}

	@Override
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Libro sentencia) {
		tx.begin();
		try {
		em.persist(sentencia);		
		tx.commit();
		}catch(Exception e){
			return -1;
		}
		return 1;
	}

	@Override
	public int upadte(Libro sentencia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Libro sentencia) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
