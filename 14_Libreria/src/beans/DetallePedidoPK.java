package beans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DETALLE_PEDIDOS database table.
 * 
 */
@Embeddable
public class DetallePedidoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_PEDIDO", insertable=false, updatable=false)
	private long idPedido;

	@Column(insertable=false, updatable=false)
	private String isbn;

	public DetallePedidoPK() {
	}
	public long getIdPedido() {
		return this.idPedido;
	}
	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallePedidoPK)) {
			return false;
		}
		DetallePedidoPK castOther = (DetallePedidoPK)other;
		return 
			(this.idPedido == castOther.idPedido)
			&& this.isbn.equals(castOther.isbn);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idPedido ^ (this.idPedido >>> 32)));
		hash = hash * prime + this.isbn.hashCode();
		
		return hash;
	}
}