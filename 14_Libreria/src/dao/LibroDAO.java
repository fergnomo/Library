package dao;

import java.util.List;

import beans.Libro;

public interface LibroDAO {

	abstract List<Libro> librosTema(long id);
}
