package com.venta.repositorios.jpa;

import org.springframework.stereotype.Repository;

import com.venta.proy.Factura;
import com.venta.repositorios.FacturaRepository;

@Repository
public class FacturaRepositoryJPA extends GenericRepositoryJPA<Factura,Integer> implements FacturaRepository {

	public FacturaRepositoryJPA() {
		super(Factura.class);
		// TODO Auto-generated constructor stub
	}
	
}


