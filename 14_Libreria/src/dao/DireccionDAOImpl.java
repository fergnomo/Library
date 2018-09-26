package dao;

import java.util.List;

import beans.Direccion;

public class DireccionDAOImpl extends Generico<Direccion, Long> implements DireccionDAO {

	@Override
	public Direccion findByID(Long clavePk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Direccion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Direccion sentencia) {
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
	public int upadte(Direccion sentencia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Direccion sentencia) {
		// TODO Auto-generated method stub
		return 0;
	}

}
