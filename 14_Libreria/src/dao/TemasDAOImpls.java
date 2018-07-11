package dao;

import java.util.List;

import javax.persistence.Query;

import beans.Tema;

public class TemasDAOImpls extends Generico<Tema,Long> {

	@Override
	public Tema findByID(Long clavePk) {
		tx.begin();
		Tema tema = em.find(Tema.class, clavePk); 
		tx.commit();
		return tema;
	}

	@Override
	public List<Tema> findAll() {
		tx.begin();
		Query query = em.createNamedQuery("Tema.findAll");
		List<Tema> lista = query.getResultList();
		tx.commit();
		return lista;
	}

	@Override
	public int insert(Tema sentencia) {
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
	public int upadte(Tema sentencia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Tema sentencia) {
		// TODO Auto-generated method stub
		return 0;
	}

}
