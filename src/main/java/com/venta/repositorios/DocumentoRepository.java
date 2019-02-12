package com.venta.repositorios;
import com.venta.proy.Documento;

public interface DocumentoRepository {
	
	public Documento findOne(Integer id);
	public Iterable<Documento> findAll();
	public void save(Documento documento);
	public void update(Documento documento);
	public void delete(Documento documento);
}

