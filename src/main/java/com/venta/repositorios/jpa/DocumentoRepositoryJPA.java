package com.venta.repositorios.jpa;

import org.springframework.stereotype.Repository;

import com.venta.proy.Documento;
import com.venta.repositorios.DocumentoRepository;

@Repository
public class DocumentoRepositoryJPA extends GenericRepositoryJPA<Documento,Integer> implements DocumentoRepository {

	public DocumentoRepositoryJPA() {
		super(Documento.class);
		// TODO Auto-generated constructor stub
	}
	
}


