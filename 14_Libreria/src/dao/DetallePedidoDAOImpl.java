package dao;

import java.util.List;

import beans.DetallePedido;

public class DetallePedidoDAOImpl extends Generico<DetallePedido, String> {

	@Override
	public DetallePedido findByID(String clavePk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetallePedido> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(DetallePedido sentencia) {
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
	public int upadte(DetallePedido sentencia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DetallePedido sentencia) {
		// TODO Auto-generated method stub
		return 0;
	}

}
