package dao;

import java.util.List;

import javax.persistence.Query;

import beans.Tema;
import beans.Usuario;

public class UsuarioDAOImpl extends Generico<Usuario, String> {
	
	public UsuarioDAOImpl() {
		super();
	}

	@Override
	public Usuario findByID(String clavePk) {
		tx.begin();
		Usuario user = em.find(Usuario.class, clavePk);
		tx.commit();
		return user;
	}

	@Override
	public List<Usuario> findAll() {
		tx.begin();
		Query query = em.createNamedQuery("Usuario.findAll");
		List<Usuario> lista = query.getResultList();
		tx.commit();
		return lista;
	}

	@Override
	public int insert(Usuario sentencia) {
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
	public int upadte(Usuario sentencia) {
		return 0;
	}

	@Override
	public int delete(Usuario sentencia) {
		tx.begin();
		try {
		em.remove(sentencia);		
		tx.commit();
		}catch(Exception e){
			return -1;
		}
		return 1;
	}
}
