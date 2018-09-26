package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import beans.Pedido;

public class PedidoDAOImpl extends Generico<Pedido, Long> implements PedidoDAO {

	@Override
	public List<Pedido> pedidosFecha(Date date) {
		tx.begin();
		jpql = "select p from Pedido p where p.fechaAlta >= :fecha";
		Query query = em.createQuery(jpql);
		query.setParameter("fecha", date);
		List<Pedido> lista = query.getResultList();
		tx.commit();
		return lista;
	}

	@Override
	public Pedido findByID(Long clavePk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Pedido sentencia) {
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
	public int upadte(Pedido sentencia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Pedido sentencia) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object[] findPedidosByUsuario(String idUsuario){
		tx.begin();
		String jpql = "select count (p), count (distinct lp.libro.tema), sum (lp.cantidad*lp.precioVenta) "
				+ "from Pedido p join DetallePedido lp on p=lp.pedido where p.usuario.idUsuario = ?1";
		query = em.createQuery(jpql).setParameter(1, idUsuario);
		tx.commit();
		return (Object[]) query.getSingleResult();
	}
	
	public List<Pedido> findPedidos(String idUsuario){
		tx.begin();
		String jpql = "select p from Pedido p where p.usuario.idUsuario = ?1";
		query = em.createQuery(jpql).setParameter(1, idUsuario);
		tx.commit();
		return (List<Pedido>) query.getResultList();
	}
}
