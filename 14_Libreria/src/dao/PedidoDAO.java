package dao;

import java.util.Date;
import java.util.List;

import beans.Pedido;

public interface PedidoDAO{
	abstract List<Pedido> pedidosFecha(Date date);
	
}
