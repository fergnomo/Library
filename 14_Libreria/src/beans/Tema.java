package beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEMAS database table.
 * 
 */
@Entity
@Table(name="TEMAS")
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TEMA")
	private long idTema;

	private String abreviatura;

	@Column(name="DESC_TEMA")
	private String descTema;

	public Tema() {
	}

	public long getIdTema() {
		return this.idTema;
	}

	public void setIdTema(long idTema) {
		this.idTema = idTema;
	}

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getDescTema() {
		return this.descTema;
	}

	public void setDescTema(String descTema) {
		this.descTema = descTema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idTema ^ (idTema >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		if (idTema != other.idTema)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tema [idTema=" + idTema + ", abreviatura=" + abreviatura + ", descTema=" + descTema + "]";
	}

}