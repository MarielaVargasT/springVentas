package com.venta.test;

import org.junit.Before;

import com.venta.repositorios.jpa.CategoriaRepositoryJPA;
import com.venta.repositorios.jpa.ProductoRepositoryJPA;
import com.venta.servicios.jpa.ServicioVentaJPA;

public class ServicioProducto {
	ProductoRepositoryJPA repoprod;
	CategoriaRepositoryJPA repocat;
	ServicioVentaJPA servprod;
		
		@Before
		public void setup() {
			
			repoprod= new ProductoRepositoryJPA();
			repocat= new CategoriaRepositoryJPA();
			servprod= new ServicioVentaJPA();
		}
					
}
		


